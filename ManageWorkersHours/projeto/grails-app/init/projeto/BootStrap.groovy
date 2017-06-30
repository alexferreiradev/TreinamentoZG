package projeto

import user.Manager
import user.RoleType
import user.SecRole
import user.SecUserSecRole

class BootStrap {

    def init = { servletContext ->
        SecRole.findByAuthority(RoleType.ROLE_EMPYEE) ?: new SecRole(authority: RoleType.ROLE_EMPYEE).save(failOnError: true)
        SecRole adminRole = SecRole.findByAuthority(RoleType.ROLE_ADM) ?: new SecRole(authority: RoleType.ROLE_ADM).save(failOnError: true)

        def adminUser = Manager.findByUsername('admin') ?: new Manager(
                username: 'admin',
                password: 'admin',
                enabled: true,
                name: "ADM",
                userEmail: "arf92liv.omc",
                enterprise: "ZG solucoes",
        )

        adminUser.validate()
        adminUser.save(failOnError: true)
//        Manager manager = new Manager(
//                name: "ADM",
//                userEmail: "arf92liv.omc",
//                username: 'admin',
//                password: 'admin',
//                enabled: true,
//                enterprise: "ZG solucoes"
//        )
//        manager.save()

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
    }

    def destroy = {
    }
}
