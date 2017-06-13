package data.model.handcard.hand;

import data.model.handcard.BaseNoHigherHand;
import data.model.handcard.HandCard;
import data.model.handcard.HandSpecification;
import data.model.handcard.HandType;

/**
 * Created by alexferreira on 06/06/17.
 */
public class SequenceHand extends BaseNoHigherHand {

    public SequenceHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.SEQUENCE;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // Maior sequencia ganha
        return specification.getSequence().isHigherThan(hand.getSpecification().getSequence());
    }
}
