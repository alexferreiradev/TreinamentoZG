package projeto

import user.Manager
import user.User

class BootStrap {

    def init = { servletContext ->
        new Manager(name: "Adm", userEmail: "arf92@live.com", password: "adm123", department: "Administração").save()
    }
    def destroy = {
    }
}
