package alex.treinamento.model;

/**
 * Created by alexferreira on 06/06/17.
 */
public class Card implements ComparableModel<Card>, Comparable<Card> {

    private SuitCard suitType;
    private CardValue valueType;

    public Card(SuitCard suitType, CardValue valueType) {
        this.suitType = suitType;
        this.valueType = valueType;
    }

    public SuitCard getSuitType() {
        return suitType;
    }

    public CardValue getValueType() {
        return valueType;
    }

    public boolean isHigherThan(Card card){
        return this.getValueType().isHigherThan(card.getValueType());
    }

    @Override
    public boolean isSameThan(Card comparable) {
        return getValueType().isSameThan(comparable.getValueType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suitType != card.suitType) return false;
        return valueType == card.valueType;
    }

    @Override
    public int hashCode() {
        int result = suitType != null ? suitType.hashCode() : 0;
        result = 31 * result + (valueType != null ? valueType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suitType=" + suitType +
                ", valueType=" + valueType +
                '}';
    }

    @Override
    public int compareTo(Card card) {
        if (isSameThan(card)){
            return 0;
        } else if (isHigherThan(card)){
            return 1;
        }

        return -1;
    }

}
