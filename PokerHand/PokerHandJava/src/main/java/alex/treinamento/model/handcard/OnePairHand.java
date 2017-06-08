package alex.treinamento.model.handcard;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class OnePairHand extends BaseNoHigherHand {

    private List<Pair> mPairs;

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        List<Pair> pairs = specHand.retrievePairs();
        if (pairs == null || pairs.isEmpty() || pairs.size() > 1){
            return null;
        }
        mPairs = pairs;

        return this;
    }

    @Override
    public HandType getType() {
        return HandType.ONE_PAIR;
    }
}
