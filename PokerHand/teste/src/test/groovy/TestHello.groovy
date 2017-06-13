import data.model.ResultHand
import junit.framework.TestCase
import org.junit.Test
import service.PokerHand
import spock.lang.Specification

/**
 * Created by alexferreira on 12/06/17.
 */
class TestHello extends Specification{

    def "teste feito pelo Fernando"(){
        given:
        PokerHand hand1 = new PokerHand(mao1)
        PokerHand hand2 = new PokerHand(mao2)

        when:
        ResultHand resultHand = hand1.compareWith(hand2)

        then:
        resultHand == result

        where:
        mao1 | mao2 | result
        "TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || ResultHand.WIN       // Par1 sendo maior que par 2
        "2S 3D 4C 5S 6H" | "2S 3S 4S 5S 6S" || ResultHand.LOSS      //
        "TS TD KC JC 7C" | "JS JC AS KC TD" || ResultHand.LOSS
        "7H 7C QC JS TS" | "7D 7C JS TS 6D" || ResultHand.WIN
        "5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || ResultHand.LOSS
        "AS AD KD 7C 3D" | "AD AH KD 7C 4S" || ResultHand.LOSS
        "TS JS QS KS AS" | "AC AH AS AS KS" || ResultHand.WIN
        "TS JS QS KS AS" | "TC JS QC KS AC" || ResultHand.WIN
        "TS JS QS KS AS" | "QH QS QC AS 8H" || ResultHand.WIN
    }
}
