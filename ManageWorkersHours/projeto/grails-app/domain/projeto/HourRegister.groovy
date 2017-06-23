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
    Date lastUpdated

    HourRegister(Employer employer, Date dateCreated) {
        this.employer = employer
        this.status = HourRegisterStatus.REQUESTED
        this.dateCreated = dateCreated
    }

    static mapping = {
        status enumType:"ordinal"
        autoTimestamp false
    }

    static constraints = {
        manageTime nullable: true
        manager  nullable: true
        employer nullable: false
        lastUpdated nullable: true
        reason nullable: true
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}
