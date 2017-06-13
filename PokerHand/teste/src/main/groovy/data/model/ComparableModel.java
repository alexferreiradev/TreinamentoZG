package data.model;

/**
 * Created by Alex on 09/06/2017.
 */
interface ComparableModel<ModelType> {

    boolean isHigherThan(ModelType comparable);

    boolean isSameThan(ModelType comparable);

}
