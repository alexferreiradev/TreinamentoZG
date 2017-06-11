package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.handcard.BaseNoHigherHand;
import alex.treinamento.model.handcard.HandCard;
import alex.treinamento.model.handcard.HandSpecification;
import alex.treinamento.model.handcard.HandType;

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
