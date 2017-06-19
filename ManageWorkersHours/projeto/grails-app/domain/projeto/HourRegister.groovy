package projeto

import groovy.transform.EqualsAndHashCode
import user.User

@EqualsAndHashCode
class HourRegister {

    public static final int REQUESTED_STATUS = 0
    public static final int APPROVED_STATUS = 1
    public static final int REJECTED_STATUS = 2

    User employer
    Date dateTime
    int status
    User manager;
    Date manageTime
    String reason
    Date updateTime

    static constraints = {
    }
}
