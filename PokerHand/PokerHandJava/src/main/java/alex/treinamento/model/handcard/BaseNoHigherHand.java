package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;

/**
 * Created by alexferreira on 08/06/17.
 */
public abstract class BaseNoHigherHand implements NoHigherHand{

    protected Card higherCard;

    @Override
    public boolean isHigherThan(HandCard hand) {
        NoHigherHand noHigherHand = null;
        if (hand instanceof NoHigherHand){
            noHigherHand = (NoHigherHand) hand;
        } else{
            return false;
        }

        if (isSameHand(noHigherHand)){
            return isHigherKicker(noHigherHand);
        }

        return getType().isHigherThan(hand.getType());
    }

    @Override
    public boolean isSameHand(NoHigherHand handCard) {
        return handCard.getType() == getType() ? true : false;
    }

    @Override
    public boolean isHigherKicker(NoHigherHand handCard) {
        return !handCard.getHigherCard().isHigherThan(higherCard);
    }

    @Override
    public Card getHigherCard() {
        return higherCard;
    }

}
