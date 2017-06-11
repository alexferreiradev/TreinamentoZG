package alex.treinamento.model.handcard;

/**
 * Created by alexferreira on 08/06/17.
 */
public interface NoHigherHand extends HandCard {

    boolean winInDrawFrom(HandCard hand);

}
