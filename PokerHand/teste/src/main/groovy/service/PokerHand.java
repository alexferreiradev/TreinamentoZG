package service;

import data.model.Card;
import data.model.CardValue;
import data.model.ResultHand;
import data.model.SuitCard;
import data.model.handcard.HandCard;
import data.model.handcard.HandFactory;
import data.model.handcard.SpecHand;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by alexferreira on 06/06/17.
 */
class PokerHand {

    String hand;
    List<Card> cards;
    HandCard handCard;

    public PokerHand(String hand) {
        this.hand = hand;
        extractHand();
    }

    private void extractHand() {
        StringTokenizer tokenizer = new StringTokenizer(hand, " ");
        cards = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            CardValue value = CardValue.getCardValue(String.valueOf(token.charAt(0)));
            SuitCard suitType = SuitCard.getSuit(String.valueOf(token.charAt(1)));
            Card card = new Card(suitType, value);

            cards.add(card);
        }

        HandFactory handFactory = new HandFactory();
        handCard = handFactory.build(new SpecHand(cards));
    }

    ResultHand compareWith(PokerHand hand){
        if (this.handCard.isHigherThan(hand.handCard)){
            return ResultHand.WIN;
        }

        return ResultHand.LOSS;
    }
}
