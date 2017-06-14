package data.model.handcard

import data.model.Card
import data.model.ComparableModel
import data.model.handcard.util.HandUtil
import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class Kicker implements ComparableModel<Kicker> {
    List<Card> cards

  Kicker(List<Card> cards) {
        this.cards = new ArrayList<>(cards)
    }

  List<Card> getCards() {
        return cards
    }

    @Override
  boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false

        Kicker kicker = (Kicker) o

        return cards != null ? cards.equals(kicker.cards) : kicker.cards == null
    }

    @Override
  int hashCode() {
        return cards != null ? cards.hashCode() : 0
    }

    @Override
  String toString() {
        return "Kicker{" +
                "cards=" + cards +
                '}'
    }

    @Override
  boolean isHigherThan(Kicker comparable) {
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(cards)
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(comparable.getCards())
        if (HandUtil.isHigherModel(baseComparatives, comparableModels)){
            return true
        }

        return false
    }

    @Override
  boolean isSameThan(Kicker comparable) {
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(cards)
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(comparable.getCards())

        return HandUtil.isSameModel(baseComparatives, comparableModels)
    }
}
