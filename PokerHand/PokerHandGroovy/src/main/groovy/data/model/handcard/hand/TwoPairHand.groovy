package data.model.handcard.hand

import data.model.ComparableModel
import data.model.handcard.BaseNoHigherHand
import data.model.handcard.util.HandUtil
import groovy.transform.EqualsAndHashCode

import data.model.handcard.HandCard
import data.model.handcard.HandSpecification
import data.model.handcard.HandType

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class TwoPairHand extends BaseNoHigherHand {
    public static final int PAIR_SIZE = 2

    TwoPairHand(HandSpecification specification) {
        super(specification)
    }

    @Override
  HandType getType() {
        return HandType.TWO_PAIR
    }

    @Override
  boolean winInDrawFrom(HandCard hand) {
        // maior par, maior kicker

        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(specification.getPairs())
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(hand.getSpecification().getPairs())
        if (HandUtil.isHigherModel(baseComparatives, comparableModels)){
            return true
        }

        return specification.getKicker().isHigherThan(hand.getSpecification().getKicker())
    }
}