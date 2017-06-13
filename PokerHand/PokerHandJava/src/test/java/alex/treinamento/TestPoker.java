package alex.treinamento;

import alex.treinamento.service.PokerHand;
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

        assertEquals(new PokerHand("TC TH 5C 5H KH").compareWith(new PokerHand("9C 9H 5C 5H AC")), ResultHand.WIN);       // Par1 sendo maior que par 2);
        assertEquals(new PokerHand("2S 3D 4C 5S 6H").compareWith(new PokerHand("2S 3S 4S 5S 6S")), ResultHand.LOSS);      //);
        assertEquals(new PokerHand("TS TD KC JC 7C").compareWith(new PokerHand("JS JC AS KC TD")), ResultHand.LOSS);
        assertEquals(new PokerHand("9C TC JC QC KC").compareWith(new PokerHand("9C 9H 5C 5H AC")), ResultHand.WIN);
        assertEquals(new PokerHand("TC TH 5C 5H KH").compareWith(new PokerHand("9C 9H 5C 5H AC")), ResultHand.WIN);
        assertEquals(new PokerHand("TS TD KC JC 7C").compareWith(new PokerHand("JS JC AS KC TD")), ResultHand.LOSS);
        assertEquals(new PokerHand("7H 7C QC JS TS").compareWith(new PokerHand("7D 7C JS TS 6D")), ResultHand.WIN);
        assertEquals(new PokerHand("5S 5D 8C 7S 6H").compareWith(new PokerHand("7D 7S 5S 5D JS")), ResultHand.LOSS);
        assertEquals(new PokerHand("AS AD KD 7C 3D").compareWith(new PokerHand("AD AH KD 7C 4S")), ResultHand.LOSS);
        assertEquals(new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("AC AH AS AS KS")), ResultHand.WIN);
        assertEquals(new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("TC JS QC KS AC")), ResultHand.WIN);
        assertEquals(new PokerHand("TS JS QS KS AS").compareWith(new PokerHand("QH QS QC AS 8H")), ResultHand.WIN);
        assertEquals(new PokerHand("AC AH AS AS KS").compareWith(new PokerHand("TC JS QC KS AC")), ResultHand.WIN);
        assertEquals(new PokerHand("AC AH AS AS KS").compareWith(new PokerHand("QH QS QC AS 8H")), ResultHand.WIN);
        assertEquals(new PokerHand("TC JS QC KS AC").compareWith(new PokerHand("QH QS QC AS 8H")), ResultHand.WIN);
        assertEquals(new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("JH JC JS JD TH")), ResultHand.WIN);
        assertEquals(new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("4H 5H 9H TH JH")), ResultHand.WIN);
        assertEquals(new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("7C 8S 9H TH JH")), ResultHand.WIN);
        assertEquals(new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("TS TH TD JH JD")), ResultHand.WIN);
        assertEquals(new PokerHand("7H 8H 9H TH JH").compareWith(new PokerHand("JH JD TH TC 4C")), ResultHand.WIN);
        assertEquals(new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("4H 5H 9H TH JH")), ResultHand.WIN);
        assertEquals(new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("7C 8S 9H TH JH")), ResultHand.WIN);
        assertEquals(new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("TS TH TD JH JD")), ResultHand.WIN);
        assertEquals(new PokerHand("JH JC JS JD TH").compareWith(new PokerHand("JH JD TH TC 4C")), ResultHand.WIN);
        assertEquals(new PokerHand("4H 5H 9H TH JH").compareWith(new PokerHand("7C 8S 9H TH JH")), ResultHand.WIN);
        assertEquals(new PokerHand("4H 5H 9H TH JH").compareWith(new PokerHand("TS TH TD JH JD")), ResultHand.LOSS);
        assertEquals(new PokerHand("4H 5H 9H TH JH").compareWith(new PokerHand("JH JD TH TC 4C")), ResultHand.WIN);
        assertEquals(new PokerHand("7C 8S 9H TH JH").compareWith(new PokerHand("TS TH TD JH JD")), ResultHand.LOSS);
        assertEquals(new PokerHand("7C 8S 9H TH JH").compareWith(new PokerHand("JH JD TH TC 4C")), ResultHand.WIN);
        assertEquals(new PokerHand("TS TH TD JH JD").compareWith(new PokerHand("JH JD TH TC 4C")), ResultHand.WIN);
        //testes adicionais
        assertEquals(new PokerHand("2S 3H 4D 5H 6D").compareWith(new PokerHand("5H 6D 7H 8C 9C")), ResultHand.LOSS);
        assertEquals(new PokerHand("2H 3H 4H 5H 7H").compareWith(new PokerHand("2D 3D 4D 5D 8D")), ResultHand.LOSS);
        assertEquals(new PokerHand("2S 2H 2D 5H 6D").compareWith(new PokerHand("5H 5D 5H 8C 9C")), ResultHand.LOSS);
        assertEquals(new PokerHand("2H 3H 4H 5H 6H").compareWith(new PokerHand("5H 6H 7H 8H 9H")), ResultHand.LOSS);
        assertEquals(new PokerHand("TH TH TH TH AS").compareWith(new PokerHand("9C 9C 9C 9C 2S")), ResultHand.WIN);
        assertEquals(new PokerHand("TH TH TH AH AS").compareWith(new PokerHand("9C 9C 9C 2C 2S")), ResultHand.WIN);
        assertEquals(new PokerHand("2H 4H 6H 8H AS").compareWith(new PokerHand("3C 5C 6C 8C JS")), ResultHand.LOSS);
//        assertEquals(new PokerHand("2H 2H 2H AH AS").compareWith(new PokerHand("2C 2C 2C JC JS")), ResultHand.WIN);
        assertEquals(new PokerHand("2H 2H 5H AH AS").compareWith(new PokerHand("2C 2C 6C AC AS") ), ResultHand.LOSS);
    }
}
