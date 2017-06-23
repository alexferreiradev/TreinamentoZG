package user

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
    Date lastUpdated

    static constraints = {
        lastName nullable: true
        cpf nullable: true
        userEmail nullable: true
        address nullable: true
    }
}
