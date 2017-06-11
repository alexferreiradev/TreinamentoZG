package alex.treinamento.model.handcard;

import alex.treinamento.model.ComparableModel;
import alex.treinamento.model.handcard.hand.*;

/**
 * Created by alexferreira on 07/06/17.
 */
public enum HandType implements ComparableModel<HandType>{
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
    ;

    @Override
    public boolean isHigherThan(HandType handType){
        return this.ordinal() > handType.ordinal();
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
