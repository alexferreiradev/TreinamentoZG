package alex.treinamento.service;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;
import alex.treinamento.model.ResultHand;
import alex.treinamento.model.SuitCard;
import alex.treinamento.model.handcard.HandCard;
import alex.treinamento.model.handcard.HandFactory;
import alex.treinamento.model.handcard.SpecHand;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by alexferreira on 06/06/17.
 */
public class PokerHand {

    private String hand;
    private List<Card> cards;
    private HandCard handCard;

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

    public ResultHand compareWith(PokerHand hand){
        if (this.handCard.isHigherThan(hand.getHandCard())){
            return ResultHand.WIN;
        }

        return ResultHand.LOSS;
    }

    public HandCard getHandCard() {
        return handCard;
    }
}
