package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.handcard.*;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FullHouse extends BaseNoHigherHand {

    public FullHouse(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.FULL_HOUSE;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // maior grupo, maior par
        if (specification.getGroup().isHigherThan(hand.getSpecification().getGroup())){
            return true;
        } else {
            for (Pair pair : specification.getPairs()) {
                if (isHigherPair(hand, pair)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isHigherPair(HandCard hand, Pair pair) {
        for (Pair otherPar : hand.getSpecification().getPairs()) {
            if (pair.isHigherThan(otherPar)){
                return true;
            }
        }
        return false;
    }
}
