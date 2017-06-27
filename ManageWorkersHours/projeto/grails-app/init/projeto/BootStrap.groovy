package projeto

import grails.plugin.springsecurity.SpringSecurityService
import user.Manager
import user.SecRole
import user.SecUser
import user.SecUserSecRole

class BootStrap {

    SpringSecurityService springSecurityService

    def init = { servletContext ->
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
                username: 'admin',
                password: 'admin',
                enabled: true,
        )

        adminUser.validate()
        adminUser.save(failOnError: true)
        Manager manager = new Manager(
                name: "ADM",
                userEmail: "arf92liv.omc",
                username: 'admin',
                password: 'admin',
                enabled: true,
                enterprise: "ZG solucoes"
        )
        manager.save()

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
    }

    def destroy = {
    }
}
