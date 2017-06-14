package data.model.handcard

import data.model.ComparableModel

/**
 * Created by alexferreira on 13/06/17.
 */
interface HandCard extends ComparableModel<HandCard> {

    /**
     * Gera uma mao de acordo com a specificação passada.
     *
     //     * @param specHand
     * @return - null caso a especificação não ser adequada para gerar.
     */
//    HandCard generateFromSpec(SpecHand specHand)

    HandType getType()

    HandSpecification getSpecification()

}