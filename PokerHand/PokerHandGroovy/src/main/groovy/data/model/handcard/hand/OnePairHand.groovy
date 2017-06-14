package data.model.handcard.hand

import data.model.handcard.BaseNoHigherHand
import groovy.transform.EqualsAndHashCode
import data.model.handcard.HandCard
import data.model.handcard.HandSpecification
import data.model.handcard.HandType
import data.model.handcard.Kicker
import data.model.handcard.Pair

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class OnePairHand extends BaseNoHigherHand {
    OnePairHand(HandSpecification specification) {
        super(specification)
    }

    @Override
    HandType getType() {
        return HandType.ONE_PAIR
    }

    @Override
    boolean winInDrawFrom(HandCard hand) {
        Queue<Pair> mPairs = new ArrayDeque<>(specification.getPairs())
        Kicker mKicker = specification.getKicker()
        HandSpecification otherSpec = hand.getSpecification()
        Queue<Pair> pairs = new ArrayDeque<>(otherSpec.getPairs())
        Kicker kicker = otherSpec.getKicker()

        // Maior par, maior kicker
        Pair pair = mPairs.peek()
        if (pair.isSameThan(pairs.peek())){
            return mKicker.isHigherThan(kicker)
        } else if (pair.isHigherThan(pairs.peek())){
            return true
        }

        return false
    }
}