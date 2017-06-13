package data.model.handcard.hand;

import data.model.ComparableModel;
import data.model.handcard.BaseNoHigherHand;
import data.model.handcard.HandCard;
import data.model.handcard.HandSpecification;
import data.model.handcard.HandType;
import data.model.handcard.util.HandUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by alexferreira on 06/06/17.
 */
public class TwoPairHand extends BaseNoHigherHand {

    public static final int PAIR_LENGTH = 2;

    public TwoPairHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.TWO_PAIR;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // maior par, maior kicker

        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(specification.getPairs());
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(hand.getSpecification().getPairs());
        if (HandUtil.isHigherModel(baseComparatives, comparableModels)){
            return true;
        }

        return specification.getKicker().isHigherThan(hand.getSpecification().getKicker());
    }
}
