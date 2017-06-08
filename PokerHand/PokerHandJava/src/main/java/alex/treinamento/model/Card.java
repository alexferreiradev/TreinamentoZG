package alex.treinamento.model;

/**
 * Created by alexferreira on 06/06/17.
 */
public class Card implements Comparable{

    private SuitCard suitType;
    private CardValue valueType;

    public Card(SuitCard suitType, CardValue valueType) {
        this.suitType = suitType;
        this.valueType = valueType;
    }

    public SuitCard getSuitType() {
        return suitType;
    }

    public void setSuitType(SuitCard suitType) {
        this.suitType = suitType;
    }

    public CardValue getValueType() {
        return valueType;
    }

    public void setValueType(CardValue valueType) {
        this.valueType = valueType;
    }

    public boolean isHigherThan(Card card){
        return this.getValueType().isHigherThan(card.getValueType()) ? true : false;
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
    public int compareTo(Object o) {
        Card comparingCard = null;
        if (o.getClass() == Card.class){
            comparingCard = (Card) o;
        }

        boolean higherThan = this.valueType.isHigherThan(comparingCard.getValueType());
        if (this.valueType == comparingCard.getValueType()){
            return 0;
        } else if (!higherThan){
            return -1;
        }

        return 1;
    }
}
