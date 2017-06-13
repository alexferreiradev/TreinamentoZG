package data.model.handcard.hand;

import data.model.handcard.BaseNoHigherHand;
import data.model.handcard.HandCard;
import data.model.handcard.HandSpecification;
import data.model.handcard.HandType;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FourKindHand extends BaseNoHigherHand {

    public static final int GROUP_LENGTH = 4;

    public FourKindHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.FOUR_KIND;
    }



    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // maior grupo, maior kicker
        if (!specification.getGroup().isSameThan(hand.getSpecification().getGroup())){
            if (specification.getGroup().isHigherThan(hand.getSpecification().getGroup())){
                return true;
            }
            return false;
        }

        return specification.getKicker().isHigherThan(hand.getSpecification().getKicker());
    }
}
