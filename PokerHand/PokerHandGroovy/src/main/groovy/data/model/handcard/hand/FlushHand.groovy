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
class FlushHand extends BaseNoHigherHand {
  FlushHand(HandSpecification specification) {
        super(specification)
    }

    @Override
  HandType getType() {
        return HandType.FLUSH
    }

    @Override
  boolean winInDrawFrom(HandCard hand) {
        // Maior carta recursiva ganha
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(specification.getCards())
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(hand.getSpecification().getCards())
        if (HandUtil.isHigherModel(baseComparatives, comparableModels)){
            return true
        }

        return false
    }
}
