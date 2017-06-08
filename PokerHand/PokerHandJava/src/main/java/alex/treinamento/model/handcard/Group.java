package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;
import alex.treinamento.model.handcard.util.HandUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Group {

    private CardValue value;
    private int length;
    private List<Card> cards;

    public Group(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.");
        }

        this.cards = new ArrayList<>(cards);
        this.value = cards.get(0).getValueType();
        this.length = cards.size();
    }

    /**
     * Remove as cartas que nao formam grupo.
     *
     * @return - cartas que não formam grupo.
     */
    public List<Card> retrieveGroup(){
        Collection<Card> withoutGroup = new ArrayList<>();
        List<Card> cardsAux = new ArrayList<>(this.cards);
        boolean hasPair = false;
        Card lastCard = null;
        cards.clear();
        for (Card card:cardsAux) {
            if (lastCard ==  null){
                lastCard = card;
                continue;
            }

            if (lastCard.getValueType() == card.getValueType()){
                hasPair = true;
                this.cards.add(lastCard);
            } else{
                withoutGroup.addAll(cards);
                if (hasPair){
                    hasPair = false;
                    this.cards.clear();
                }
            }

            lastCard = card;
        }

        lastCard = HandUtil.getLastCard(cardsAux);
        if (hasPair){
            cards.add(lastCard);
        }else{
            withoutGroup.add(lastCard);
        }

        return (List<Card>) withoutGroup;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (length != group.length) return false;
        if (value != group.value) return false;
        return cards != null ? cards.equals(group.cards) : group.cards == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "value=" + value +
                ", length=" + length +
                ", cards=" + cards +
                '}';
    }
}
