package data.model.handcard;

import data.model.Card;
import data.model.CardValue;
import data.model.ComparableModel;

import java.util.*;

/**
 * Created by alexferreira on 07/06/17.
 */
public class Group implements ComparableModel<Group>, ValidSpecification {

    public static final int MIN_GROUP_SIZE = 2;

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
     * @return - cartas que não formam grupo ordenadas de maior para menor.
     */
    public Queue<Card> retrieveGroup(){
        Queue<Card> withoutGroup = new ArrayDeque<>();
        Stack<Card> withoutGroupStack = new Stack<>();
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
            } else if (groupStack.size() > MIN_GROUP_SIZE){
                withoutGroupStack.add(pop);
            } else {
                withoutGroupStack.addAll(groupStack);
                groupStack.clear();
                groupStack.add(pop);
            }
        }

        cards.clear();
        if (groupStack.size() > MIN_GROUP_SIZE){
            cards.addAll(groupStack);
            value = groupStack.peek().getValueType();
        } else{
            withoutGroupStack.addAll(groupStack);
        }
        length = cards.size();

        withoutGroup.addAll(withoutGroupStack);
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

    @Override
    public boolean isHigherThan(Group comparable) {
        return value.isHigherThan(comparable.getValue());
    }

    @Override
    public boolean isSameThan(Group comparable) {
        return value == comparable.getValue() && length == comparable.getLength();
    }

    @Override
    public boolean isValid() {
        return length > MIN_GROUP_SIZE;
    }
}
