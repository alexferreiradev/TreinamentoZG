package projeto

import user.Employer
import user.Manager
import user.User

class BootStrap {

    def init = { servletContext ->
        new Manager(name: "Adm", userEmail: "arf92@live.com", password: "adm123", department: "Administração").save()
        new Employer(name: "TesteFunc", lastName: "LastName", userEmail: "arf92@live.com", password: "123", workHours: "8", salary: "3000", job: "Desenvolvedor" ).save()
    }

    def destroy = {
    }
}
