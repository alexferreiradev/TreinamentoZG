import data.model.ResultHand
import service.PokerHand
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by alexferreira on 12/06/17.
 */
class TestHello extends Specification{

    @Unroll
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
        "9C TC JC QC KC" | "9C 9H 5C 5H AC" || ResultHand.WIN
        "TC TH 5C 5H KH" | "9C 9H 5C 5H AC" || ResultHand.WIN
        "TS TD KC JC 7C" | "JS JC AS KC TD" || ResultHand.LOSS
        "7H 7C QC JS TS" | "7D 7C JS TS 6D" || ResultHand.WIN
        "5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS" || ResultHand.LOSS
        "AS AD KD 7C 3D" | "AD AH KD 7C 4S" || ResultHand.LOSS
        "TS JS QS KS AS" | "AC AH AS AS KS" || ResultHand.WIN
        "TS JS QS KS AS" | "TC JS QC KS AC" || ResultHand.WIN
        "TS JS QS KS AS" | "QH QS QC AS 8H" || ResultHand.WIN
        "AC AH AS AS KS" | "TC JS QC KS AC" || ResultHand.WIN
        "AC AH AS AS KS" | "QH QS QC AS 8H" || ResultHand.WIN
        "TC JS QC KS AC" | "QH QS QC AS 8H" || ResultHand.WIN
        "7H 8H 9H TH JH" | "JH JC JS JD TH" || ResultHand.WIN
        "7H 8H 9H TH JH" | "4H 5H 9H TH JH" || ResultHand.WIN
        "7H 8H 9H TH JH" | "7C 8S 9H TH JH" || ResultHand.WIN
        "7H 8H 9H TH JH" | "TS TH TD JH JD" || ResultHand.WIN
        "7H 8H 9H TH JH" | "JH JD TH TC 4C" || ResultHand.WIN
        "JH JC JS JD TH" | "4H 5H 9H TH JH" || ResultHand.WIN
        "JH JC JS JD TH" | "7C 8S 9H TH JH" || ResultHand.WIN
        "JH JC JS JD TH" | "TS TH TD JH JD" || ResultHand.WIN
        "JH JC JS JD TH" | "JH JD TH TC 4C" || ResultHand.WIN
        "4H 5H 9H TH JH" | "7C 8S 9H TH JH" || ResultHand.WIN
        "4H 5H 9H TH JH" | "TS TH TD JH JD" || ResultHand.LOSS
        "4H 5H 9H TH JH" | "JH JD TH TC 4C" || ResultHand.WIN
        "7C 8S 9H TH JH" | "TS TH TD JH JD" || ResultHand.LOSS
        "7C 8S 9H TH JH" | "JH JD TH TC 4C" || ResultHand.WIN
        "TS TH TD JH JD" | "JH JD TH TC 4C" || ResultHand.WIN
        //testes adicionais
        "2S 3H 4D 5H 6D" | "5H 6D 7H 8C 9C" || ResultHand.LOSS
//        "2S 3H 4D 5H 6D" | "2S 3H 4D 5H 6D" || ResultHand.DRAW
        "2H 3H 4H 5H 7H" | "2D 3D 4D 5D 8D" || ResultHand.LOSS
        "2S 2H 2D 5H 6D" | "5H 5D 5H 8C 9C" || ResultHand.LOSS
        "2H 3H 4H 5H 6H" | "5H 6H 7H 8H 9H" || ResultHand.LOSS
//        "TH JH QH KH AH" | "TC JC QC KC AC" || ResultHand.DRAW
        "TH TH TH TH AS" | "9C 9C 9C 9C 2S" || ResultHand.WIN
        "TH TH TH AH AS" | "9C 9C 9C 2C 2S" || ResultHand.WIN
        "2H 4H 6H 8H AS" | "3C 5C 6C 8C JS" || ResultHand.LOSS
        "2H 2H 2H AH AS" | "2C 2C 2C JC JS" || ResultHand.WIN
        "2H 2H 5H AH AS" | "2C 2C 6C AC AS" || ResultHand.LOSS

    }
}
