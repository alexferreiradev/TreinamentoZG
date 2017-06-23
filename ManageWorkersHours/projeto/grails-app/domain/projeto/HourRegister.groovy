package projeto

import data.HourRegisterStatus
import groovy.transform.EqualsAndHashCode
import user.Employer
import user.Manager
import user.User

@EqualsAndHashCode
class HourRegister {

    Employer employer
    Manager manager

    HourRegisterStatus status
    Date manageTime
    String reason

    static constraints = {
    }

}
