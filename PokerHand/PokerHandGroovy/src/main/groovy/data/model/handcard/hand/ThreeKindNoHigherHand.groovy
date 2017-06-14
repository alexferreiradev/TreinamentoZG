package data.model.handcard.hand

import data.model.handcard.BaseNoHigherHand
import data.model.handcard.Group
import groovy.transform.EqualsAndHashCode

import data.model.handcard.HandCard
import data.model.handcard.HandSpecification
import data.model.handcard.HandType
import data.model.handcard.Kicker

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class ThreeKindNoHigherHand extends BaseNoHigherHand {
  ThreeKindNoHigherHand(HandSpecification specification) {
        super(specification)
    }

    @Override
  HandType getType() {
        return HandType.THREE_KIND
    }

    @Override
  boolean winInDrawFrom(HandCard hand) {
        // Maior grupo, maior kicker
        Kicker mKicker = specification.getKicker()
        Group mGroup = specification.getGroup()
        Kicker kicker = hand.getSpecification().getKicker()
        if (mGroup.isSameThan(hand.getSpecification().getGroup())){
            return mKicker.isHigherThan(kicker)
        }

        return mGroup.isHigherThan(hand.getSpecification().getGroup())
    }
}