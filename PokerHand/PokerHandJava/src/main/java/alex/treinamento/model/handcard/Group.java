package alex.treinamento.model.handcard;

import alex.treinamento.model.Card;
import alex.treinamento.model.CardValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Group {

    private CardValue value;
    private int length;
    private List<Card> cards;

    public Group(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.");
        }

        this.cards = new ArrayList<>(cards);
        this.value = null;
        this.length = 0;
    }

    /**
     * Remove as cartas que nao formam grupo.
     *
     * @return - cartas que não formam grupo.
     */
    public List<Card> retrieveGroup(){
        List<Card> withoutGroup = new ArrayList<>();
        Stack<Card> groupStack = new Stack<>();
        Stack<Card> auxStack = new Stack<>();
        auxStack.addAll(cards);
        while (!auxStack.isEmpty()){
            if (groupStack.isEmpty()){
                groupStack.add(auxStack.pop());
                continue;
            }

            Card pop = auxStack.pop();
            if (pop.getValueType() == groupStack.peek().getValueType()){
                groupStack.add(pop);
            } else if (groupStack.size() > 2){
                withoutGroup.add(pop);
            } else {
                withoutGroup.addAll(groupStack);
                groupStack.clear();
                groupStack.add(pop);
            }
        }

        cards.clear();
        if (groupStack.size() > 2){
            cards.addAll(groupStack);
        } else{
            withoutGroup.addAll(groupStack);
        }
        length = cards.size();

        return withoutGroup;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (length != group.length) return false;
        if (value != group.value) return false;
        return cards != null ? cards.equals(group.cards) : group.cards == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "value=" + value +
                ", length=" + length +
                ", cards=" + cards +
                '}';
    }
}
