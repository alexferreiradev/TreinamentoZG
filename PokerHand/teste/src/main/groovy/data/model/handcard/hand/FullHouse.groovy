package data.model.handcard.hand

import data.model.handcard.BaseNoHigherHand
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
        // maior grupo
        if (specification.getGroup().isHigherThan(hand.getSpecification().getGroup())){
            return true
        }

        return false
    }
}
