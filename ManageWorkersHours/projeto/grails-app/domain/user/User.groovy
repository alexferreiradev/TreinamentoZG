package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
abstract class User {

    static mapping = {
        tablePerHierarchy false  // avoid creating the base_domain table
        tablePerConcreteClass true
    }

    String name
    String lastName
    String cpf
    String userEmail
    String password
    String address
    Date dateCreated
    Date lastUpdate

    static constraints = {
        lastName nullable: true
        cpf nullable: true
        userEmail nullable: true
        address nullable: true
    }
}
