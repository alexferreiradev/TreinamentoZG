package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {
    String name
    String lastName
    String cpf
    String userEmail
    String password
    String address
    String job
    int permission
    float salary

    static constraints = {
    }
}
