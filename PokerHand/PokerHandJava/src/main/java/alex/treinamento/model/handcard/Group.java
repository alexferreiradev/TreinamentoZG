package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;
import alex.treinamento.model.ComparableModel;

import java.util.*;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Group implements ComparableModel<Group>, ValidSpecification {

    public static final int MIN_GROUP_SIZE = 3;

    private CardValue value;
    private int length;
    private List<Card> cards;

    public Group(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.");
        }

        this.cards = new ArrayList<>(cards);
        this.length = cards.size();
        if (isValid()){
            value = cards.get(0).getValueType();
        }
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

    @Override
    public boolean isHigherThan(Group comparable) {
        return value.isHigherThan(comparable.getValue());
    }

    @Override
    public boolean isSameThan(Group comparable) {
        return value == comparable.getValue() && length == comparable.getLength() ? true : false;
    }

    @Override
    public boolean isValid() {
        return length >= MIN_GROUP_SIZE;
    }
}
