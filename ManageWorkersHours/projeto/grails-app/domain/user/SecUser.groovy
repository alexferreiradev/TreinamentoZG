package user

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
abstract class SecUser implements Serializable {

    private static final long serialVersionUID = 1

    String name
    String lastName
    String email
    String cpf
    String address
    Date dateCreated
    Date lastUpdated

    // Padrao do Spring Security
    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<SecRole> getAuthorities() {
        (SecUserSecRole.findAllBySecUser(this) as List<SecUserSecRole>)*.secRole as Set<SecRole>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        accountExpired nullable: true
        accountLocked nullable: true
        passwordExpired nullable: true
        enabled nullable: true
        lastName nullable: true
        cpf nullable: true
        email nullable: true
        address nullable: true
        lastUpdated nullable: true
        dateCreated nullable: true
    }

    static mapping = {
	    password column: '`password`'
        autoTimestamp false
        tablePerHierarchy false  // avoid creating the base_domain table
        tablePerConcreteClass true
    }
}
