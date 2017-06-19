package user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {
    String name;
    String lastName;
    String cpf;
    String email;
    String password;
    String address;
    String job;
    Date createDate;
    Date updateDate;
    int permission;

    static constraints = {
    }
}
