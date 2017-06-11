package alex.treinamento.model.handcard;

/**
 * Created by alexferreira on 08/06/17.
 */
public abstract class BaseNoHigherHand implements NoHigherHand{

    protected HandSpecification specification;

    public BaseNoHigherHand(HandSpecification specification) {
        this.specification = specification;
    }

    @Override
    public boolean isHigherThan(HandCard hand) {
        if (isSameThan(hand)){
            return winInDrawFrom(hand);
        }
        
        return getType().isHigherThan(hand.getType());
    }

    @Override
    public boolean isSameThan(HandCard handCard) {
        return handCard.getType().isSameThan(handCard.getType());
    }

    @Override
    public HandSpecification getSpecification() {
        return specification;
    }
}
