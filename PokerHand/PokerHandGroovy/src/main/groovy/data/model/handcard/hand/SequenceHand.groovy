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
class SequenceHand extends BaseNoHigherHand {
    SequenceHand(HandSpecification specification) {
        super(specification)
    }

    @Override
    HandType getType() {
        return HandType.SEQUENCE
    }

    @Override
    boolean winInDrawFrom(HandCard hand) {
        // Maior sequencia ganha
        return specification.getSequence().isHigherThan(hand.getSpecification().getSequence())
    }
}