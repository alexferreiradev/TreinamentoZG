package data.model.handcard;

import data.model.Card;

import java.util.List;

/**
 * Created by Alex on 10/06/2017.
 */
public interface HandSpecification {

    boolean hasGroup();

    boolean hasSequence();

    boolean hasPairs();

    boolean isAllCardsSameSuit();

    Sequence getSequence();

    Group getGroup();

    List<Pair> getPairs();

    Kicker getKicker();

    List<Card> getCards();

}
