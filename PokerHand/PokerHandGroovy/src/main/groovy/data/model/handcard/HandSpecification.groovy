package data.model.handcard

import data.model.Card

/**
 * Created by alexferreira on 13/06/17.
 */
interface HandSpecification {

    boolean hasGroup()

    boolean hasSequence()

    boolean hasPairs()

    boolean isAllCardsSameSuit()

    Sequence getSequence()

    Group getGroup()

    List<Pair> getPairs()

    Kicker getKicker()

    List<Card> getCards()

}