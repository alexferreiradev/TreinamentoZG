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
public class StraightFlushNoHigherHand extends BaseNoHigherHand {

    public StraightFlushNoHigherHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.STRAIGHT_FLUSH;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // Maior carta recursiva ganha
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(specification.getCards());
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(hand.getSpecification().getCards());

        return HandUtil.isHigherModel(baseComparatives, comparableModels);
    }
}
