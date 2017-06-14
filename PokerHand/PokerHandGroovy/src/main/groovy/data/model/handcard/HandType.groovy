package data.model.handcard

import data.model.ComparableModel
import data.model.handcard.hand.FlushHand
import data.model.handcard.hand.FourKindHand
import data.model.handcard.hand.FullHouse
import data.model.handcard.hand.HighHand
import data.model.handcard.hand.OnePairHand
import data.model.handcard.hand.RoyalFlushHand
import data.model.handcard.hand.SequenceHand
import data.model.handcard.hand.StraightFlushNoHigherHand
import data.model.handcard.hand.ThreeKindNoHigherHand
import data.model.handcard.hand.TwoPairHand

/**
 * Created by alexferreira on 13/06/17.
 */
enum HandType implements ComparableModel<HandType> {
    HIGH_CARD,
    ONE_PAIR,
    TWO_PAIR,
    THREE_KIND,
    SEQUENCE,
    FLUSH,
    FULL_HOUSE,
    FOUR_KIND,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH,


    @Override
   boolean isHigherThan(HandType handType) {
        return this.ordinal() > handType.ordinal()
    }

    @Override
   boolean isSameThan(HandType handType) {return this == handType; }

   HandCard getHandCard(HandSpecification spec) {
        switch (this){
            case ROYAL_FLUSH:
                return new RoyalFlushHand(spec)
            case STRAIGHT_FLUSH:
                return new StraightFlushNoHigherHand(spec)
            case FOUR_KIND:
                return new FourKindHand(spec)
            case FULL_HOUSE:
                return new FullHouse(spec)
            case FLUSH:
                return new FlushHand(spec)
            case SEQUENCE:
                return new SequenceHand(spec)
            case THREE_KIND:
                return new ThreeKindNoHigherHand(spec)
            case TWO_PAIR:
                return new TwoPairHand(spec)
            case ONE_PAIR:
                return new OnePairHand(spec)
            case HIGH_CARD:
                return new HighHand(spec)
        }

        return null
    }

}