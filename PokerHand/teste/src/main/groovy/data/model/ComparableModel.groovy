package data.model

/**
 * Created by alexferreira on 13/06/17.
 */
interface ComparableModel<ModelType> {

    boolean isHigherThan(ModelType comparable)

    boolean isSameThan(ModelType comparable)

}
