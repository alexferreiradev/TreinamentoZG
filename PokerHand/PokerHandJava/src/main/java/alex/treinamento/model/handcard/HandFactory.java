package alex.treinamento.model.handcard;

import alex.treinamento.model.CardValue;
import alex.treinamento.model.handcard.hand.FourKindHand;
import alex.treinamento.model.handcard.hand.TwoPairHand;

import java.util.List;

/**
 * Created by alexferreira on 07/06/17.
 */
public class HandFactory {

    public HandCard build(HandSpecification specification){

        if (specification.hasSequence()){
            Sequence sequence = specification.getSequence();
            if (sequence.isAllSameSuit()){
                if (sequence.getInitValue().isSameThan(CardValue.TEN)){
                    return HandType.ROYAL_FLUSH.getHandCard(specification);
                }

                return HandType.STRAIGHT_FLUSH.getHandCard(specification);
            }

            return HandType.SEQUENCE.getHandCard(specification);
        } else if (specification.hasGroup()){
            Group group = specification.getGroup();
            if (group.getLength() == FourKindHand.GROUP_LENGTH){
                return HandType.FOUR_KIND.getHandCard(specification);
            } else if (group.isValid()){
                if (specification.hasPairs()){
                    return HandType.FULL_HOUSE.getHandCard(specification);
                }
                return HandType.THREE_KIND.getHandCard(specification);
            }
        } else if (specification.hasPairs()){
            List<Pair> pairs = specification.getPairs();
            if (pairs.size() == TwoPairHand.PAIR_LENGTH){
                return HandType.TWO_PAIR.getHandCard(specification);
            }

            return HandType.ONE_PAIR.getHandCard(specification);
        } else if (specification.isAllCardsSameSuit()){
            return HandType.FLUSH.getHandCard(specification);
        }

        return HandType.HIGH_CARD.getHandCard(specification);
    }
}
