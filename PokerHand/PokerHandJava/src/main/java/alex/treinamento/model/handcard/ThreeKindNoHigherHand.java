package alex.treinamento.model.handcard;

import alex.treinamento.model.handcard.util.HandUtil;

/**
 * Created by alexferreira on 06/06/17.
 */
public class ThreeKindNoHigherHand extends BaseNoHigherHand {

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Group group = specHand.retrieveGroup();
        if (group != null && group.getLength() == 3){
            higherCard = HandUtil.getLastCard(specHand.getCards());
            return this;
        }
        return null;
    }

    @Override
    public HandType getType() {
        return HandType.THREE_KIND;
    }

}
