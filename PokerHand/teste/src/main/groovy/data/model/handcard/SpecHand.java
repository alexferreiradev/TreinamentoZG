package data.model.handcard;

import data.model.Card;
import data.model.handcard.util.HandUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

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
        isSameSuit = HandUtil.isSameSuit(this.cards);
        sequence = new Sequence(this.cards);
        group = new Group(this.cards);
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
        return pairs.size() > 0;
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
        Queue<Card> withoutGroup = group.retrieveGroup();
        List<Card> kickers = new ArrayList<>();
        pairs = new ArrayList<>();
        while(!withoutGroup.isEmpty() && withoutGroup.size() > 1){
            Card poll = withoutGroup.poll();
            if (poll.isSameThan(withoutGroup.peek())){
                pairs.add(new Pair(withoutGroup.poll()));
            } else {
                kickers.add(poll);
            }
        }
        kickers.addAll(withoutGroup);

        kicker = new Kicker(kickers);
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
