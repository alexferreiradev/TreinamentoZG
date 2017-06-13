package data.model.handcard;

import data.model.Card;
import data.model.ComparableModel;
import data.model.handcard.util.HandUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Kicker implements ComparableModel<Kicker>{

    private List<Card> cards;

    public Kicker(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kicker kicker = (Kicker) o;

        return cards != null ? cards.equals(kicker.cards) : kicker.cards == null;
    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Kicker{" +
                "cards=" + cards +
                '}';
    }

    @Override
    public boolean isHigherThan(Kicker comparable) {
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(cards);
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(comparable.getCards());
        if (HandUtil.isHigherModel(baseComparatives, comparableModels)){
            return true;
        }

        return false;
    }

    @Override
    public boolean isSameThan(Kicker comparable) {
        Queue<? extends ComparableModel> baseComparatives = new ArrayDeque<>(cards);
        Queue<? extends ComparableModel> comparableModels = new ArrayDeque<>(comparable.getCards());

        return HandUtil.isSameModel(baseComparatives, comparableModels);
    }
}
