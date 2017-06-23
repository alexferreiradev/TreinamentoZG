import grails.test.mixin.TestFor
import org.mockito.Mock
import projeto.EmployerService
import projeto.HourRegister
import spock.lang.Specification
import spock.lang.Unroll
import user.Employer

/**
 * Created by alexferreira on 23/06/17.
 */
class EmployerServiceSpec extends Specification{

    @Mock Employer employer
    @Mock EmployerService service

    @Unroll
    def "testar bater ponto"() {
        given:
        def register = new HourRegister(employer: employer, status: HourRegister.REQUESTED_STATUS, dateTime: new Date(year, month, day))

        when:
        service.addRegister(employer, register)
        noExceptionThrown()

        where:
        year | month | day
        2017 | 01 | 01
        2017 | 01 | 02
        2017 | 01 | 03
        2017 | 01 | 04
        2017 | 01 | 05
        2017 | 01 | 06
        2017 | 01 | 07
    }

    @Unroll
    def "testar bater ponto atrasado"() {
        given:
        def register = new HourRegister(employer: employer, status: HourRegister.REQUESTED_STATUS, dateTime: new Date(year, month, day))
        when:
        service.addLateRegister(employer, register)
        noExceptionThrown()

        where:
        year | month | day
        2017 | 01 | 01
        2017 | 01 | 02
        2017 | 01 | 03
        2017 | 01 | 04
        2017 | 01 | 05
        2017 | 01 | 06
        2017 | 01 | 07
    }


}
