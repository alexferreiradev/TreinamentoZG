package data.model

/**
 * Created by alexferreira on 13/06/17.
 */
class Card implements ComparableModel<Card>, Comparable<Card> {

    SuitCard suitType
    CardValue valueType

  Card(SuitCard suitType, CardValue valueType) {
        this.suitType = suitType
        this.valueType = valueType
    }

   boolean isHigherThan(Card card) {
        return this.valueType.isHigherThan(card.valueType)
    }

    @Override
  boolean isSameThan(Card comparable) {
        return this.valueType.isSameThan(comparable.valueType)
    }

    @Override
  boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false

        Card card = (Card) o

        if (suitType != card.suitType) return false
        return valueType == card.valueType
    }

    @Override
  int hashCode() {
        int result = suitType != null ? suitType.hashCode() : 0
        result = 31 * result + (valueType != null ? valueType.hashCode() : 0)
        return result
    }

    @Override
  String toString() {
        return "Card{" +
                "suitType=" + suitType +
                ", valueType=" + valueType +
                '}'
    }

    @Override
  int compareTo(Card card) {
        if (isSameThan(card)){
            return 0
        } else if (isHigherThan(card)){
            return 1
        }

        return -1
    }

}

