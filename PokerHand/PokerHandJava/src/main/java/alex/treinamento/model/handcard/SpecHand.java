package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexferreira on 08/06/17.
 */
public class SpecHand {

    private Sequence sequence;
    private Group group;
    private Kicker kicker;
    private List<Pair> pairs;
    private List<Card> cards;

    public SpecHand(List<Card> cards) {
        this.cards = cards;
        Collections.sort(cards);
    }

    public Sequence retrieveSequence(){
        this.sequence = new Sequence(cards);
        return this.sequence;
    }

    public Group retrieveGroup(){
        if (group == null){
            processKicker();
        }
        return this.group;
    }

    public List<Pair> retrievePairs(){
        if (pairs == null){
            processKicker();
        }
        return pairs;
    }

    public Kicker retrieveKicker(){
        if (kicker == null){
            processKicker();
        }

        return kicker;
    }

    /**
     * Cria grupos, par e kickers de uma lista de cartas
     *
     */
    private void processKicker() {
        List<Card> withoutGroup = new Group(this.cards).retrieveGroup();
        Card lastCard = null;
        List<Card> kickers = new ArrayList<>();
        pairs = new ArrayList<>();
        for (Card card:withoutGroup) {
            if (lastCard == null){
                lastCard = card;
                continue;
            }

            if (lastCard.getValueType() == card.getValueType()){
                pairs.add(new Pair(lastCard, card));
            } else {
                kickers.add(lastCard);
            }
        }

        kicker = new Kicker(withoutGroup);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setKicker(Kicker kicker) {
        this.kicker = kicker;
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
