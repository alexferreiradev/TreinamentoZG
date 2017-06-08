package alex.treinamento.model.handcard;

import java.util.List;

/**
 * Created by alexferreira on 06/06/17.
 */
public class FullHouse extends BaseNoHigherHand {

    private Group mGroup;
    private List<Pair> mPairs;
    private Kicker mKicker;

    @Override
    public HandCard generateFromSpec(SpecHand specHand) {
        Group group = specHand.retrieveGroup();
        List<Pair> pairs = specHand.retrievePairs();
        if (group != null && group.getLength() == 3 && !pairs.isEmpty()){
            mGroup = group;
            mPairs = pairs;
            mKicker = specHand.retrieveKicker();
            return this;
        }

        return null;
    }

    @Override
    public HandType getType() {
        return HandType.FULL_HOUSE;
    }

    public Group getmGroup() {
        return mGroup;
    }

    public List<Pair> getmPairs() {
        return mPairs;
    }

    public Kicker getmKicker() {
        return mKicker;
    }
}
