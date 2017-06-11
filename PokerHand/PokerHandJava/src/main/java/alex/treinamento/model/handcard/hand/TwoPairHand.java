package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.ComparableModel;
import alex.treinamento.model.handcard.*;
import alex.treinamento.model.handcard.util.HandUtil;

import java.util.*;

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
