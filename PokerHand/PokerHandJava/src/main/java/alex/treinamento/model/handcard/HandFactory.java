package alex.treinamento.model.handcard;

/**
 * Created by alexferreira on 07/06/17.
 */
public class HandFactory {

    private SpecHand specHand;

    public HandFactory(SpecHand specHand) {
        this.specHand = specHand;
    }

    public HandCard build(){
        HandType[] handTypes = HandType.values();
        for (HandType handType : handTypes) {
            HandCard handCard = handType.getHandCard().generateFromSpec(specHand);
            if (handCard != null) {
                return handCard;
            }
        }

        return null;
    }
}
