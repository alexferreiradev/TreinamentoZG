package data.model.handcard

import data.model.Card
import data.model.CardValue
import data.model.ComparableModel
import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class Sequence implements ComparableModel<Sequence>, ValidSpecification {
    List<Card> cards
    CardValue initValue
    int length
    boolean isAllSameSuit

  Sequence(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.")
        }

        this.cards = new ArrayList<>(cards)
        this.initValue = cards.get(0).getValueType()
        this.isAllSameSuit = true
        this.length = extractPosSeq(cards, 0) + 1
    }

    private int extractPosSeq(List<Card> cards, int pos){
        Card card = cards.get(pos)
        if (pos + 1 == cards.size()){
            return pos
        }
        Card nextCard = cards.get(pos + 1)
        if (card.getValueType().ordinal() + 1 == nextCard.getValueType().ordinal()){
            if (isAllSameSuit && !card.getSuitType().isSameThan(nextCard.getSuitType())){
                isAllSameSuit = false
            }

            return extractPosSeq(cards, pos + 1)
        } else {
            return pos
        }
    }

  CardValue getInitValue() {
        return initValue
    }

  int getLength() {
        return length
    }

  boolean isAllSameSuit() {
        return isAllSameSuit
    }

    @Override
  boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false

        Sequence sequence = (Sequence) o

        if (length != sequence.length) return false
        if (isAllSameSuit != sequence.isAllSameSuit) return false
        return initValue == sequence.initValue
    }

    @Override
  int hashCode() {
        int result = initValue != null ? initValue.hashCode() : 0
        result = 31 * result + length
        result = 31 * result + (isAllSameSuit ? 1 : 0)
        return result
    }

    @Override
  String toString() {
        return "Sequence{" +
                "initValue=" + initValue +
                ", length=" + length +
                ", isAllSameSuit=" + isAllSameSuit +
                '}'
    }

  List<Card> getCards() {
        return cards
    }

    @Override
  boolean isHigherThan(Sequence comparable) {
        return initValue.isHigherThan(comparable.getInitValue())
    }

    @Override
  boolean isSameThan(Sequence comparable) {
        return initValue.isSameThan(comparable.getInitValue())
    }

    @Override
  boolean isValid() {
        return length == 5
    }
}
