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
class FourKindHand extends BaseNoHigherHand {
    public static final int GROUP_LENGTH = 4

  FourKindHand(HandSpecification specification) {
        super(specification)
    }

    @Override
  HandType getType() {
        return HandType.FOUR_KIND
    }



    @Override
  boolean winInDrawFrom(HandCard hand) {
        // maior grupo, maior kicker
        if (!specification.getGroup().isSameThan(hand.getSpecification().getGroup())){
            if (specification.getGroup().isHigherThan(hand.getSpecification().getGroup())){
                return true
            }
            return false
        }

        return specification.getKicker().isHigherThan(hand.getSpecification().getKicker())
    }
}
