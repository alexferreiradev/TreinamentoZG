package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;

import java.util.*;

/**
 * Created by alexferreira on 08/06/17.
 */
public class SpecHand implements HandSpecification{

    private Sequence sequence;
    private Group group;
    private Kicker kicker;
    private List<Pair> pairs;
    private List<Card> cards;
    private boolean isSameSuit;

    public SpecHand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
        sequence = new Sequence(this.cards);
        isSameSuit = sequence.isAllSameSuit();
        pairs = new ArrayList<>();
        processKicker();
    }

    @Override
    public boolean hasGroup() {
        return group.isValid();
    }

    @Override
    public boolean hasSequence() {
        return sequence.isValid();
    }

    @Override
    public boolean hasPairs() {
        return pairs.size() > 0 ? true : false;
    }

    @Override
    public boolean isAllCardsSameSuit() {
        return isSameSuit;
    }

    @Override
    public Sequence getSequence(){
        return sequence;
    }

    @Override
    public Group getGroup(){
        if (group == null){
            processKicker();
        }
        return group;
    }

    @Override
    public List<Pair> getPairs(){
        return pairs;
    }

    @Override
    public Kicker getKicker(){
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
        Queue<Card> withoutGroup = new ArrayDeque<>();
        Stack<Card> groupStack = new Stack<>();

        Stack<Card> auxStack = new Stack<>();
        auxStack.addAll(cards);
        while (!auxStack.isEmpty()){
            if (groupStack.isEmpty()){
                groupStack.add(auxStack.pop());
                continue;
            }

            Card pop = auxStack.pop();
            if (pop.getValueType().isSameThan(groupStack.peek().getValueType()) == false){
                if (groupStack.size() > Group.MIN_GROUP_SIZE){
                    withoutGroup.add(pop);
                } else {
                    withoutGroup.addAll(groupStack);
                    groupStack.clear();
                }
            }
            groupStack.add(pop);
        }

        group = new Group(groupStack);
        if (groupStack.size() < Group.MIN_GROUP_SIZE){
            withoutGroup.addAll(groupStack);
        }

        return withoutGroup;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecHand specHand = (SpecHand) o;

        if (sequence != null ? !sequence.equals(specHand.sequence) : specHand.sequence != null) return false;
        if (group != null ? !group.equals(specHand.group) : specHand.group != null) return false;
        if (kicker != null ? !kicker.equals(specHand.kicker) : specHand.kicker != null) return false;
        if (pairs != null ? !pairs.equals(specHand.pairs) : specHand.pairs != null) return false;
        return cards != null ? cards.equals(specHand.cards) : specHand.cards == null;
    }

    @Override
    public int hashCode() {
        int result = sequence != null ? sequence.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (kicker != null ? kicker.hashCode() : 0);
        result = 31 * result + (pairs != null ? pairs.hashCode() : 0);
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SpecHand{" +
                "sequence=" + sequence +
                ", group=" + group +
                ", kicker=" + kicker +
                ", pairs=" + pairs +
                ", cards=" + cards +
                '}';
    }
}
