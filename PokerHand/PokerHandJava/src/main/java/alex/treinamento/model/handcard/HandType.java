package alex.treinamento.model.handcard;

/**
 * Created by alexferreira on 07/06/17.
 */
public enum HandType {
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

    public boolean isHigherThan(HandType handType){
        return this.ordinal() > handType.ordinal() ? true : false;
    }

    public HandCard getHandCard(){
        switch (this){
            case ROYAL_FLUSH:
                return new RoyalFlushHand();
            case STRAIGHT_FLUSH:
                return new StraightFlushNoHigherHand();
            case FOUR_KIND:
                return new FourKindHand();
            case FULL_HOUSE:
                return new FullHouse();
            case FLUSH:
                return new FlushHand();
            case SEQUENCE:
                return new SequenceHand();
            case THREE_KIND:
                return new ThreeKindNoHigherHand();
            case TWO_PAIR:
                return new TwoPairHand();
            case ONE_PAIR:
                return new OnePairHand();
            case HIGH_CARD:
                return new HighHand();
        }

        return null;
    }

}
