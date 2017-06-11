package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;
import alex.treinamento.model.ComparableModel;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Pair implements ComparableModel<Pair>{

    private final Card card1;
    private final Card card2;
    private CardValue value;

    public Pair(Card card1, Card card2) {
        this.card1 = card1;
        this.card2 = card2;
        this.value = card1.getValueType();
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (card1 != null ? !card1.equals(pair.card1) : pair.card1 != null) return false;
        if (card2 != null ? !card2.equals(pair.card2) : pair.card2 != null) return false;
        return value == pair.value;
    }

    @Override
    public int hashCode() {
        int result = card1 != null ? card1.hashCode() : 0;
        result = 31 * result + (card2 != null ? card2.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "card1=" + card1 +
                ", card2=" + card2 +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean isHigherThan(Pair comparable) {
        return value.isHigherThan(comparable.getValue());
    }

    @Override
    public boolean isSameThan(Pair comparable) {
        return value.isSameThan(comparable.getValue());
    }
}
