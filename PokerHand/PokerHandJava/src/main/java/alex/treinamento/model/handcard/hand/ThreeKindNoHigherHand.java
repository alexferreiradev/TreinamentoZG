package alex.treinamento.model.handcard.hand;

import alex.treinamento.model.handcard.*;

/**
 * Created by alexferreira on 06/06/17.
 */
public class ThreeKindNoHigherHand extends BaseNoHigherHand {

    public ThreeKindNoHigherHand(HandSpecification specification) {
        super(specification);
    }

    @Override
    public HandType getType() {
        return HandType.THREE_KIND;
    }

    @Override
    public boolean winInDrawFrom(HandCard hand) {
        // Maior grupo, maior kicker
        Kicker mKicker = specification.getKicker();
        Group mGroup = specification.getGroup();
        Kicker kicker = hand.getSpecification().getKicker();
        if (mGroup.isSameThan(hand.getSpecification().getGroup())){
            return mKicker.isHigherThan(kicker);
        }

        return mGroup.isHigherThan(hand.getSpecification().getGroup());
    }
}
