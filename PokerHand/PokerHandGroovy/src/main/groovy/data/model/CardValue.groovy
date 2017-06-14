package data.model

/**
 * Created by alexferreira on 13/06/17.
 */
enum CardValue implements ComparableModel<CardValue> {

    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    TEN ("T"),
    J ("J"),
    Q ("Q"),
    K ("K"),
    A ("A"),


    private String value

    CardValue(String value) {
        this.value = value
    }

   static CardValue getCardValue(String value) {
        for (CardValue cardValue : CardValue.values()) {
            if (cardValue.getValue().equalsIgnoreCase(value)){
                return cardValue
            }
        }
        return null
    }

    @Override
   boolean isHigherThan(CardValue cardValue) {
        return this.ordinal() > cardValue.ordinal() ? true : false
    }

    @Override
  boolean isSameThan(CardValue comparable) {
        return this == comparable
    }

  String getValue() {
        return value
    }
}
