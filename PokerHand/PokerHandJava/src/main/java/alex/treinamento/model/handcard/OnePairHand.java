package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class OnePairHand extends BaseNoHigherHand {

    private Pair mPair;
    private Card higherCard;

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        List<Pair> pairs = specHand.retrievePairs();
        if (pairs == null || pairs.isEmpty() || pairs.size() > 1){
            return null;
        }

        mPair = pairs.get(0);
        higherCard = mPair.getCard1();
        if (mPair.getCard2().isHigherThan(higherCard)){
            higherCard = mPair.getCard1();
        }

        return this;
    }

    @Override
    public HandType getType() {
        return HandType.ONE_PAIR;
    }

}