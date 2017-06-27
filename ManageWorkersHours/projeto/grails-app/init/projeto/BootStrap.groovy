package projeto

import grails.plugin.springsecurity.SpringSecurityService
import user.Manager
import user.SecRole
import user.SecUserSecRole

class BootStrap {

    SpringSecurityService springSecurityService

    def init = { servletContext ->
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = Manager.findByUsername('admin') ?: new Manager(
                name: "ADM",
//                userEmail: "arf92liv.omc",
                username: 'admin',
                password: springSecurityService.encodePassword('admin'),
                enabled: true,
                enterprise: "ZG solucoes"
        )
        adminUser.validate()
        adminUser.save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
    }

    def destroy = {
    }
}
