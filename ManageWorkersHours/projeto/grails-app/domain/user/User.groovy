package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {

    public static final int ADM_PERMISSION = 0
    public static final int EMPLOYER_PERMISSION = 1

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
