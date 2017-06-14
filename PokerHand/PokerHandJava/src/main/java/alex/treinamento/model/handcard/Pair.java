package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.ComparableModel;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Pair implements ComparableModel<Pair>{

    public static final int MIN_SIZE = 2;

    private Card card;

    public Pair(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(Pair comparable) {
        return card.isHigherThan(comparable.getCard());
    }

    @Override
    public boolean isSameThan(Pair comparable) {
        return card.isSameThan(comparable.getCard());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return card != null ? card.equals(pair.card) : pair.card == null;
    }

    @Override
    public int hashCode() {
        return card != null ? card.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "card=" + card +
                '}';
    }
}
