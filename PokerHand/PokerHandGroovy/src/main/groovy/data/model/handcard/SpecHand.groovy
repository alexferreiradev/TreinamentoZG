package data.model.handcard

import data.model.Card
import data.model.handcard.util.HandUtil
import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class SpecHand implements HandSpecification{

    Sequence sequence;
    Group group;
    Kicker kicker;
    List<Pair> pairs;
    List<Card> cards;
    boolean isSameSuit;

    SpecHand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
        sequence = new Sequence(this.cards);
        isSameSuit = sequence.isAllSameSuit();
        pairs = new ArrayList<>();
        processKicker();
    }

    @Override
    boolean hasGroup() {
        return group.isValid();
    }

    @Override
    boolean hasSequence() {
        return sequence.isValid();
    }

    @Override
    boolean hasPairs() {
        return pairs.size() > 0 ? true : false;
    }

    @Override
    boolean isAllCardsSameSuit() {
        return isSameSuit;
    }

    @Override
    Sequence getSequence(){
        return sequence;
    }

    @Override
    Group getGroup(){
        if (group == null){
            processKicker();
        }
        return group;
    }

    @Override
    List<Pair> getPairs(){
        return pairs;
    }

    @Override
    Kicker getKicker(){
        return kicker;
    }

    /**
     * Cria grupos, par e kickers de uma lista de cartas
     *
     */
    private void processKicker() {
        Queue<Card> withoutGroup = extractGroup();
        List<Card> kickers = extractPairs(withoutGroup);
        kicker = new Kicker(kickers);
    }

    /**
     * Extrai pares de lista de cartas que não formaram grupos.
     *
     * @param withoutGroup - lista de cartas que nao forma grupo
     * @return lista de cartas kickers
     */
    private List<Card> extractPairs(Queue<Card> withoutGroup) {
        List<Card> kickers = new ArrayList<>();
        pairs = new ArrayList<>();
        while(!withoutGroup.isEmpty() && withoutGroup.size() >= Pair.MIN_SIZE){
            Card poll = withoutGroup.poll();
            if (poll.isSameThan(withoutGroup.peek())){
                pairs.add(new Pair(withoutGroup.poll()));
            } else {
                kickers.add(poll);
            }
        }

        kickers.addAll(withoutGroup);
        return kickers;
    }

    /**
     * Remove as cartas que nao formam grupo.
     *
     * @return - cartas que não formam grupo ordenadas de maior para menor.
     */
    private Queue<Card> extractGroup(){
        Queue<Card> withoutGroupQueue = new ArrayDeque<>();
        Stack<Card> groupStack = new Stack<>();

        Stack<Card> auxStack = new Stack<>();
        auxStack.addAll(cards);
        while (!auxStack.isEmpty()){
            if (groupStack.isEmpty()){
                groupStack.add(auxStack.pop());
                continue;
            }

            Card currentCard = auxStack.pop();
            Card groupTopCard = groupStack.peek();
            if (currentCard.getValueType().isSameThan(groupTopCard.getValueType()) == false){
                if (groupStack.size() >= Group.MIN_GROUP_SIZE){
                    withoutGroupQueue.add(currentCard);
                    continue;
                } else {
                    withoutGroupQueue.addAll(groupStack);
                    groupStack.clear();
                }
            }

            groupStack.add(currentCard);
        }

        group = new Group(groupStack);
        if (!group.isValid()){
            withoutGroupQueue.addAll(groupStack);
        }

        return withoutGroupQueue;
    }

    @Override
    String toString() {
        return "SpecHand{" +
                "sequence=" + sequence +
                ", group=" + group +
                ", kicker=" + kicker +
                ", pairs=" + pairs +
                ", cards=" + cards +
                '}';
    }
}
