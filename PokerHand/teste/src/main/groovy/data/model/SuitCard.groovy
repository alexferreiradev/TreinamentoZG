package data.model

/**
 * Created by alexferreira on 13/06/17.
 */
enum SuitCard implements ComparableModel<SuitCard> {

    DIAMOND ("D"),
    SPADES ("S"),
    CLUBS ("C"),
    HEART ("H"),


    private String value

    SuitCard(String value) {
        this.value = value
    }

    static SuitCard getSuit(String value){
        for (SuitCard suitCard : SuitCard.values()) {
            if (suitCard.getValue().equalsIgnoreCase(value)){
                return suitCard
            }
        }

        return null
    }

    @Override
    boolean isHigherThan(SuitCard suitCard){
        return this.ordinal() > suitCard.ordinal() ? true : false
    }

    @Override
    boolean isSameThan(SuitCard comparable) {
        return this == comparable ? true : false
    }


    String getValue() {
        return value
    }
}
