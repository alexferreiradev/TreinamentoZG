package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Manager extends User{

    String enterprise

    static constraints = {
        enterprise nullable: false
    }

    static mapping = {

    }
}
