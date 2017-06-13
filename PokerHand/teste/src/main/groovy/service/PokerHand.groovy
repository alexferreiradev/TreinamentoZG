package service

import data.model.handcard.HandCard

/**
 * Created by alexferreira on 13/06/17.
 */
class PokerHand {
    String hand
    List<data.model.Card> cards
    HandCard handCard

  PokerHand(String hand) {
        this.hand = hand
        extractHand()
    }

    private void extractHand() {
        StringTokenizer tokenizer = new StringTokenizer(hand, " ")
        cards = new ArrayList<>()
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken()
            data.model.CardValue value = data.model.CardValue.getCardValue(String.valueOf(token.charAt(0)))
            data.model.SuitCard suitType = data.model.SuitCard.getSuit(String.valueOf(token.charAt(1)))
            data.model.Card card = new data.model.Card(suitType, value)

            cards.add(card)
        }

        data.model.handcard.HandFactory handFactory = new data.model.handcard.HandFactory()
        handCard = handFactory.build(new data.model.handcard.SpecHand(cards))
    }

    data.model.ResultHand compareWith(PokerHand hand){
        if (this.handCard.isHigherThan(hand.handCard)){
            return data.model.ResultHand.WIN
        }

        return data.model.ResultHand.LOSS
    }
}
