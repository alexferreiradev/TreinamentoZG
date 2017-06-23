package projeto

import data.HourRegisterStatus
import groovy.transform.EqualsAndHashCode
import user.Employer
import user.Manager
import user.User

import javax.persistence.EnumType
import javax.persistence.Enumerated

@EqualsAndHashCode
class HourRegister {

    Employer employer
    Manager manager

    @Enumerated(EnumType.ORDINAL)
    HourRegisterStatus status
    Date manageTime
    String reason
    Date dateCreated
    Date lastUpdate

    HourRegister(Employer employer, Date dateCreated) {
        this.employer = employer
        status = HourRegisterStatus.REQUESTED
        this.dateCreated = dateCreated
    }
    static mapping = {
        status enumType:"ordinal"
    }

    static constraints = {
        manageTime nullable: true
        manager  nullable: true
        employer nullable: false
        lastUpdate nullable: true
        reason nullable: true
    }

}
