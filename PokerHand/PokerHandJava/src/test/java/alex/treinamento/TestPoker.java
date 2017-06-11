package alex.treinamento;

import alex.treinamento.bussiness.PokerHand;
import alex.treinamento.model.ResultHand;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alexferreira on 08/06/17.
 */
public class TestPoker extends TestCase {

    @Test
    public void testFernando(){
        assertEquals(new PokerHand("TC TH 5C 5H KH").compareWith(new PokerHand("9C 9H 5C 5H AC")), ResultHand.WIN);
        assertEquals(new PokerHand("2S 3D 4C 5S 6H").compareWith(new PokerHand("2S 3S 4S 5S 6S")), ResultHand.LOSS);
        assertEquals(new PokerHand("TS TD KC JC 7C").compareWith(new PokerHand("JS JC AS KC TD")), ResultHand.LOSS);
        assertEquals(new PokerHand("7H 7C QC JS TS").compareWith(new PokerHand("7D 7C JS TS 6D")), ResultHand.WIN);
        assertEquals(new PokerHand("5S 5D 8C 7S 6H").compareWith(new PokerHand("7D 7S 5S 5D JS")), ResultHand.LOSS);
        assertEquals(new PokerHand("AS AD KD 7C 3D").compareWith(new PokerHand("AD AH KD 7C 4S")), ResultHand.LOSS);
        assertEquals(new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("AC AH AS AS KS")), ResultHand.WIN);
        assertEquals(new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("TC JS QC KS AC")), ResultHand.WIN);
        assertEquals(new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("QH QS QC AS 8H")), ResultHand.WIN);
    }
}
