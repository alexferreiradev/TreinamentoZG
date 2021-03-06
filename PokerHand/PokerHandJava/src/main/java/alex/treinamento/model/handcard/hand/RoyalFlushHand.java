package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.handcard.HandCard;
import alex.treinamento.model.handcard.HandSpecification;
import alex.treinamento.model.handcard.HandType;

/**
 * Created by alexferreira on 06/06/17.
 */
public class RoyalFlushHand implements HandCard {

    private HandSpecification spec;

    public RoyalFlushHand(HandSpecification spec) {
        this.spec = spec;
    }

    @Override
    public boolean isHigherThan(HandCard hand) {
        return getType().isHigherThan(hand.getType());
    }

    @Override
    public boolean isSameThan(HandCard comparable) {
        return getType() == comparable.getType();
    }

    @Override
    public HandType getType() {
        return HandType.ROYAL_FLUSH;
    }

    @Override
    public HandSpecification getSpecification() {
        return spec;
    }
}
