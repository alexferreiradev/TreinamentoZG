package data.model.handcard

import data.model.Card
import data.model.ComparableModel
import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class Pair implements ComparableModel<Pair> {
    static int MIN_SIZE = 2
    Card card

  Pair(Card card) {
        this.card = card
    }

  Card getCard() {
        return card
    }

    @Override
  boolean isHigherThan(Pair comparable) {
        return card.isHigherThan(comparable.getCard())
    }

    @Override
  boolean isSameThan(Pair comparable) {
        return card.isSameThan(comparable.getCard())
    }

    @Override
  boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false

        Pair pair = (Pair) o

        return card != null ? card.equals(pair.card) : pair.card == null
    }

    @Override
  int hashCode() {
        return card != null ? card.hashCode() : 0
    }

    @Override
  String toString() {
        return "Pair{" +
                "card=" + card +
                '}'
    }
}
