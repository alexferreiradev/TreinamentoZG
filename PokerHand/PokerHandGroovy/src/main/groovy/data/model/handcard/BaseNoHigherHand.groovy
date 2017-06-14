package data.model.handcard

import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
abstract class BaseNoHigherHand implements NoHigherHand{

    protected HandSpecification specification

  BaseNoHigherHand(HandSpecification specification) {
        this.specification = specification
    }

    @Override
  boolean isHigherThan(HandCard hand) {
        if (isSameThan(hand)){
            return winInDrawFrom(hand)
        }

        return getType().isHigherThan(hand.getType())
    }

    @Override
  boolean isSameThan(HandCard handCard) {
        return getType().isSameThan(handCard.getType())
    }

    @Override
  HandSpecification getSpecification() {
        return specification
    }
}