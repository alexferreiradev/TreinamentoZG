package alex.treinamento.model;

/**
 * Created by alexferreira on 06/06/17.
 */
public enum SuitCard {

    HEART ("H"),
    SPADES ("S"),
    DIAMOND ("D"),
    CLUBS ("C"),
    ;

    private String value;

    SuitCard(String value) {
        this.value = value;
    }

    public static SuitCard getSuit(String value){
        for (SuitCard suitCard : SuitCard.values()) {
            if (suitCard.getValue().equalsIgnoreCase(value)){
                return suitCard;
            }
        }

        return null;
    }

    public boolean isHigherThan(SuitCard suitCard){
        return this.ordinal() > suitCard.ordinal() ? true : false;
    }

    public String getValue() {
        return value;
    }
}
