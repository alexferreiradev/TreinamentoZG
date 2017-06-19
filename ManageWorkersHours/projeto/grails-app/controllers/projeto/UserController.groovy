package projeto

import user.User

class UserController {

    EmployerService employerService
    UserService userService

    String log() {
        String login = params["login"]
        String password = params["password"]
        User userFound = userService.findByLoginAndPass(login, password)
        if (userFound != null){
            // TODO setar sessao de usuario
            return redirectToHomeView(userFound)
        } else {
            // TODO add mensagem de erro de login
        }
    }

    private String redirectToHomeView(User userFound) {
        if (userFound.permission == User.ADM_PERMISSION) {
            return "adm_home"
        } else if (userFound.permission == User.EMPLOYER_PERMISSION) {
            return "employer_home"
        }

        return "login"
    }
}
