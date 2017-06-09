package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.handcard.util.HandUtil;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FlushHand extends BaseNoHigherHand {

    private Sequence sequence;

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        List<Card> cards = specHand.getCards();
        sequence = specHand.retrieveSequence();
        if (sequence != null && sequence.isComplete() || !HandUtil.isSameSuit(cards)){
            return null;
        }

        higherCard = HandUtil.getLastCard(specHand.getCards());

        return this;
    }

    @Override
    public HandType getType() {
        return HandType.FLUSH;
    }

}
