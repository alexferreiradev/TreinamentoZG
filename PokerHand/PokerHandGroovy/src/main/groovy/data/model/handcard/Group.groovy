package data.model.handcard

import data.model.Card
import data.model.CardValue
import data.model.ComparableModel
import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class Group implements ComparableModel<Group>, ValidSpecification {

    static final int MIN_GROUP_SIZE = 3

    CardValue value
    int length
    List<Card> cards

    Group(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.")
        }

        this.cards = new ArrayList<>(cards)
        this.length = cards.size()
        if (isValid()){
            value = cards.get(0).getValueType()
        }
    }

    @Override
    String toString() {
        return "Group{" +
                "value=" + value +
                ", length=" + length +
                ", cards=" + cards +
                '}'
    }

    @Override
    boolean isHigherThan(Group comparable) {
        return value.isHigherThan(comparable.getValue())
    }

    @Override
    boolean isSameThan(Group comparable) {
        return value == comparable.getValue() && length == comparable.getLength()
    }

    @Override
    boolean isValid() {
        return length >= MIN_GROUP_SIZE
    }
}