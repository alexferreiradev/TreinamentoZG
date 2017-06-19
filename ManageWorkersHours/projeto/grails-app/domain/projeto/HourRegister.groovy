package projeto

import groovy.transform.EqualsAndHashCode
import user.User

@EqualsAndHashCode
class HourRegister {

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
