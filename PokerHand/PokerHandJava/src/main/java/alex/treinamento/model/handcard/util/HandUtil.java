package alex.treinamento.model.handcard.util;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;
import alex.treinamento.model.SuitCard;

import java.util.*;

/**
 * Created by alexferreira on 06/06/17.
 */
public class HandUtil {

    /**
     * Retorna o maior número de cartas criados com a lista de cards
     *
     * @param card - carta a ser utilizada para agrupar
     * @param cards - conjunto de cartas para encontrar grupos
     * @return - quantidade de cartas encontras iguais
     */
    public static int countSameCardValue(Card card, Enumeration<Card> cards){
        int count = 0;

        while (cards.hasMoreElements()){
            Card cardComparing = cards.nextElement();
            if (card.getValueType() == cardComparing.getValueType()){
                count ++;
            }
        }

        return count;
    }

    public static Map<CardValue, Integer> groupOfValues(List<Card> cards){
        Map<CardValue, Integer> groups = new HashMap<>();
        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        while (!cardStack.isEmpty()){
            Card card = cardStack.pop();
            groups.put(card.getValueType(), countSameCardValue(card, cardStack.elements()));
        }
        return groups;
    }

    public static Card getLastCard(List<Card> cards){
        if (cards != null && !cards.isEmpty()){
            return cards.get(cards.size() - 1);
        }
        return null;
    }

    public static boolean isSameSuit(List<Card> cards){
        SuitCard suitCard = null;
        for (Card card : cards) {
            if (suitCard == null){
                suitCard = card.getSuitType();
                continue;
            }

            if (suitCard != card.getSuitType()){
                return false;
            }
        }
        return true;
    }

    public static Card getNextCard(List<Card> cards, Card currentCard) {
        int currentIdx = cards.indexOf(currentCard);
        if (currentIdx == cards.size() - 1){
            return null;
        }
        return cards.get(currentIdx+1);
    }
}
