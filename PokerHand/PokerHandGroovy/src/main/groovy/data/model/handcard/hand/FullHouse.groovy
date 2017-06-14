package data.model.handcard.hand

import data.model.handcard.BaseNoHigherHand
import data.model.handcard.Pair
import groovy.transform.EqualsAndHashCode
import data.model.handcard.HandCard
import data.model.handcard.HandSpecification
import data.model.handcard.HandType

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class FullHouse extends BaseNoHigherHand {
    FullHouse(HandSpecification specification) {
        super(specification)
    }

    @Override
    HandType getType() {
        return HandType.FULL_HOUSE
    }

    @Override
    boolean winInDrawFrom(HandCard hand) {
        // maior grupo, maior par
        if (specification.getGroup().isHigherThan(hand.getSpecification().getGroup())) {
            return true;
        } else {
            for (Pair pair : specification.getPairs()) {
                if (isHigherPair(hand, pair)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isHigherPair(HandCard hand, Pair pair) {
        for (Pair otherPar : hand.getSpecification().getPairs()) {
            if (pair.isHigherThan(otherPar)) {
                return true;
            }
        }
        return false;
    }
}
