package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Sequence {

    private List<Card> cards;
    private CardValue initValue;
    private int length;
    private boolean isAllSameSuit;

    public Sequence(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.");
        }

        this.cards = new ArrayList<>(cards);
        this.initValue = cards.get(0).getValueType();
        this.isAllSameSuit = true;
        this.length = 1;
    }

    private int extractPosSeq(List<Card> cards, int pos){
        Card card = cards.get(pos);
        Card nextCard = cards.get(pos);
        if (card.getValueType().ordinal() + 1 == nextCard.getValueType().ordinal()){
            if (isAllSameSuit && card.getSuitType() != nextCard.getSuitType() && pos == cards.size() - 1){
                isAllSameSuit = false;
            }

            return extractPosSeq(cards, pos + 1);
        } else {
            return pos;
        }
    }

    public CardValue getInitValue() {
        return initValue;
    }

    public void setInitValue(CardValue initValue) {
        this.initValue = initValue;
    }

    public int extractLength() {
        if (cards.size() < 2){
            return length;
        }

        length = extractPosSeq(cards, 1) + 1;

        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isAllSameSuit() {
        return isAllSameSuit;
    }

    public void setAllSameSuit(boolean allSameSuit) {
        isAllSameSuit = allSameSuit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence = (Sequence) o;

        if (length != sequence.length) return false;
        if (isAllSameSuit != sequence.isAllSameSuit) return false;
        return initValue == sequence.initValue;
    }

    @Override
    public int hashCode() {
        int result = initValue != null ? initValue.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + (isAllSameSuit ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "initValue=" + initValue +
                ", length=" + length +
                ", isAllSameSuit=" + isAllSameSuit +
                '}';
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean isComplete() {
        return extractLength() == 5 ? true : false;
    }
}
