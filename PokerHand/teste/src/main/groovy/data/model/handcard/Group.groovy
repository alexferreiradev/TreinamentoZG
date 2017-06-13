package data.model.handcard

import data.model.Card
import data.model.CardValue
import data.model.ComparableModel
import groovy.transform.EqualsAndHashCode

/**
 * Created by alexferreira on 13/06/17.
 */
@EqualsAndHashCode(includeFields=true)
class Group implements ComparableModel<Group>, ValidSpecification {

    public static final int MIN_GROUP_SIZE = 2

    CardValue value
    int length
    List<Card> cards

  Group(List<Card> cards) {
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException("Cartas é nula ou vazia.")
        }

        this.cards = new ArrayList<>(cards)
        this.value = null
        this.length = 0
    }

    /**
     * Remove as cartas que nao formam grupo.
     *
     * @return - cartas que não formam grupo ordenadas de maior para menor.
     */
   Queue<Card> retrieveGroup() {
        Queue<Card> withoutGroup = new ArrayDeque<>()
        Stack<Card> withoutGroupStack = new Stack<>()
        Stack<Card> groupStack = new Stack<>()
        Stack<Card> auxStack = new Stack<>()
        auxStack.addAll(cards)
        while (!auxStack.isEmpty()){
            if (groupStack.isEmpty()){
                groupStack.add(auxStack.pop())
                continue
            }

            Card pop = auxStack.pop()
            if (pop.getValueType() == groupStack.peek().getValueType()){
                groupStack.add(pop)
            } else if (groupStack.size() > MIN_GROUP_SIZE){
                withoutGroupStack.add(pop)
            } else {
                withoutGroupStack.addAll(groupStack)
                groupStack.clear()
                groupStack.add(pop)
            }
        }

        cards.clear()
        if (groupStack.size() > MIN_GROUP_SIZE){
            cards.addAll(groupStack)
            value = groupStack.peek().getValueType()
        } else{
            withoutGroupStack.addAll(groupStack)
        }
        length = cards.size()

        withoutGroup.addAll(withoutGroupStack)
        return withoutGroup
    }

  CardValue getValue() {
        return value
    }

  void setValue(CardValue value) {
        this.value = value
    }

  int getLength() {
        return length
    }

  void setLength(int length) {
        this.length = length
    }

  List<Card> getCards() {
        return cards
    }

  void setCards(List<Card> cards) {
        this.cards = cards
    }

    @Override
  boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false

        Group group = (Group) o

        if (length != group.length) return false
        if (value != group.value) return false
        return cards != null ? cards.equals(group.cards) : group.cards == null
    }

    @Override
  int hashCode() {
        int result = value != null ? value.hashCode() : 0
        result = 31 * result + length
        result = 31 * result + (cards != null ? cards.hashCode() : 0)
        return result
    }

    @Override
  String toString() {
        return "Group{" +
                "value=" + value +
                ", length=" + length +
                ", cards=" + cards +
                '}'
    }

    @Override
  boolean isHigherThan(Group comparable) {
        return value.isHigherThan(comparable.getValue())
    }

    @Override
  boolean isSameThan(Group comparable) {
        return value == comparable.getValue() && length == comparable.getLength()
    }

    @Override
  boolean isValid() {
        return length > MIN_GROUP_SIZE
    }
}