package alex.treinamento.model.handcard;

import alex.treinamento.model.handcard.util.HandUtil;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class TwoPairHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        List<Pair> pairs = specHand.retrievePairs();
        if (pairs != null && pairs.size() == 2){
            higherCard = HandUtil.getLastCard(specHand.retrieveKicker().getCards());
            return this;
        }
        return null;
    }

    @Override
    public HandType getType() {
        return HandType.TWO_PAIR;
    }
}
