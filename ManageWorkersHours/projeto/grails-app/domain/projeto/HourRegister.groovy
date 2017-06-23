package projeto

import groovy.transform.EqualsAndHashCode
import user.Employer
import user.Manager
import user.User

@EqualsAndHashCode
class HourRegister {

    public static final int REQUESTED_STATUS = 0
    public static final int APPROVED_STATUS = 1
    public static final int REJECTED_STATUS = 2

    Employer employer
    Manager manager

    int status
    Date manageTime
    String reason

    static constraints = {
    }

}
