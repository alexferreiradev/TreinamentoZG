package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {

    static mapping = {
        tablePerHierarchy false
    }

    String name
    String lastName
    String cpf
    String userEmail
    String password
    String address

    static constraints = {
    }
}
