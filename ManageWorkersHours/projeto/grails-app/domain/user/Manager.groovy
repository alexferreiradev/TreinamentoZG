package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Manager extends SecUser{

    String enterprise

    static constraints = {
        enterprise nullable: false
    }

    static mapping = {
        autoTimestamp false
    }
}
