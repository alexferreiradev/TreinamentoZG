package alex.treinamento.model.handcard;

import alex.treinamento.model.CardValue;
import alex.treinamento.model.handcard.util.HandUtil;

/**
 * Created by alexferreira on 06/06/17.
 */
public class SequenceHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Sequence sequence = specHand.retrieveSequence();
        if (sequence != null && sequence.isComplete() &&
                sequence.getInitValue() != CardValue.TEN &&
                !sequence.isAllSameSuit()){
            higherCard = HandUtil.getLastCard(specHand.getCards());
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.SEQUENCE;
    }
}
