package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.handcard.BaseNoHigherHand;
import alex.treinamento.model.handcard.HandCard;
import alex.treinamento.model.handcard.HandSpecification;
import alex.treinamento.model.handcard.HandType;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FullHouse extends BaseNoHigherHand {

    public FullHouse(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.FULL_HOUSE;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // maior grupo
        if (specification.getGroup().isHigherThan(hand.getSpecification().getGroup())){
            return true;
        }

        return false;
    }
}
