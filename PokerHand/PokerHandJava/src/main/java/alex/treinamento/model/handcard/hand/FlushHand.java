package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.ComparableModel;
import alex.treinamento.model.handcard.BaseNoHigherHand;
import alex.treinamento.model.handcard.HandCard;
import alex.treinamento.model.handcard.HandSpecification;
import alex.treinamento.model.handcard.HandType;
import alex.treinamento.model.handcard.util.HandUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FlushHand extends BaseNoHigherHand {

    public FlushHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.FLUSH;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // Maior carta recursiva ganha
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(specification.getCards());
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(hand.getSpecification().getCards());
        if (HandUtil.isHigherModel(baseComparatives, comparableModels)){
            return true;
        }

        return false;
    }
}
