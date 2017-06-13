package data.model;

/**
 * Created by alexferreira on 06/06/17.
 */
public enum SuitCard implements ComparableModel<SuitCard> {

    DIAMOND ("D"),
    SPADES ("S"),
    CLUBS ("C"),
    HEART ("H"),
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

    @Override
    public boolean isHigherThan(SuitCard suitCard){
        return this.ordinal() > suitCard.ordinal() ? true : false;
    }

    @Override
    public boolean isSameThan(SuitCard comparable) {
        return this == comparable ? true : false;
    }


    public String getValue() {
        return value;
    }
}
