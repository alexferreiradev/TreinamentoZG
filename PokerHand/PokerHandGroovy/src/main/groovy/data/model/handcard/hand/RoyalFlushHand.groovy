package data.model.handcard.hand

import data.model.handcard.HandCard
import groovy.transform.EqualsAndHashCode
import data.model.handcard.HandSpecification
import data.model.handcard.HandType

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class RoyalFlushHand implements HandCard {
    HandSpecification spec

    RoyalFlushHand(HandSpecification spec) {
        this.spec = spec
    }

    @Override
    boolean isHigherThan(HandCard hand) {
        return getType().isHigherThan(hand.getType())
    }

    @Override
    boolean isSameThan(HandCard comparable) {
        return getType() == comparable.getType()
    }

    @Override
    HandType getType() {
        return HandType.ROYAL_FLUSH
    }

    @Override
    HandSpecification getSpecification() {
        return spec
    }
}
