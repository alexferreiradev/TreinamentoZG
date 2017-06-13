package data.model.handcard.hand;

import data.model.handcard.*;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by alexferreira on 06/06/17.
 */
public class OnePairHand extends BaseNoHigherHand {

    public OnePairHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.ONE_PAIR;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        Queue<Pair> mPairs = new ArrayDeque<>(specification.getPairs());
        Kicker mKicker = specification.getKicker();
        HandSpecification otherSpec = hand.getSpecification();
        Queue<Pair> pairs = new ArrayDeque<>(otherSpec.getPairs());
        Kicker kicker = otherSpec.getKicker();

        // Maior par, maior kicker
        Pair pair = mPairs.peek();
        if (pair.isSameThan(pairs.peek())){
            return mKicker.isHigherThan(kicker);
        } else if (pair.isHigherThan(pairs.peek())){
            return true;
        }

        return false;
    }
}