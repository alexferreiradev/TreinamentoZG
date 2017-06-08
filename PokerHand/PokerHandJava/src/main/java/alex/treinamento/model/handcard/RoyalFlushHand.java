package alex.treinamento.model.handcard;

import alex.treinamento.model.CardValue;
import alex.treinamento.model.SuitCard;
import alex.treinamento.model.handcard.util.HandUtil;

/**
 * Created by alexferreira on 06/06/17.
 */
public class RoyalFlushHand implements HandCard {

    @Override
    public boolean isHigherThan(HandCard hand) {
        return getType().isHigherThan(hand.getType());
    }

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Sequence sequence = specHand.retrieveSequence();
        SuitCard sequenceSuitType = HandUtil.getLastCard(sequence.getCards()).getSuitType();
        if (sequence != null && sequence.getInitValue() == CardValue.TEN && sequence.extractLength() == 5 &&
                sequence.isAllSameSuit() && sequenceSuitType == SuitCard.HEART){
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.ROYAL_FLUSH;
    }
}
