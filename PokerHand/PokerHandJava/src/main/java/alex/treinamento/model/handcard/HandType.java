package alex.treinamento.model.handcard;

import alex.treinamento.model.ComparableModel;
import alex.treinamento.model.handcard.hand.*;

/**
 * Created by alexferreira on 07/06/17.
 */
public enum HandType implements ComparableModel<HandType>{
    ROYAL_FLUSH,
    STRAIGHT_FLUSH,
    FOUR_KIND,
    FULL_HOUSE,
    FLUSH,
    SEQUENCE,
    THREE_KIND,
    TWO_PAIR,
    ONE_PAIR,
    HIGH_CARD,
    ;

    @Override
    public boolean isHigherThan(HandType handType){
        return this.ordinal() > handType.ordinal() ? true : false;
    }

    @Override
    public boolean isSameThan(HandType handType){return this == handType ? true : false; }

    public HandCard getHandCard(HandSpecification spec){
        switch (this){
            case ROYAL_FLUSH:
                return new RoyalFlushHand(spec);
            case STRAIGHT_FLUSH:
                return new StraightFlushNoHigherHand(spec);
            case FOUR_KIND:
                return new FourKindHand(spec);
            case FULL_HOUSE:
                return new FullHouse(spec);
            case FLUSH:
                return new FlushHand(spec);
            case SEQUENCE:
                return new SequenceHand(spec);
            case THREE_KIND:
                return new ThreeKindNoHigherHand(spec);
            case TWO_PAIR:
                return new TwoPairHand(spec);
            case ONE_PAIR:
                return new OnePairHand(spec);
            case HIGH_CARD:
                return new HighHand(spec);
        }

        return null;
    }

}
