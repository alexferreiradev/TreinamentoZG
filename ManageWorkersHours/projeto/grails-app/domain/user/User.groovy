package user

abstract class User extends SecUser{

    String name
    String lastName
    String cpf
    String userEmail
    String address
    Date dateCreated
    Date lastUpdated

    static constraints = {
        lastName nullable: true
        cpf nullable: true
        userEmail nullable: true
        address nullable: true
        lastUpdated nullable: true
        dateCreated nullable: true
    }

    static mapping = {
//        tablePerHierarchy false  // avoid creating the base_domain table
//        tablePerConcreteClass true
    }
}
