package user

class ManagerController {

    def index() {
        respond Manager.findAll()
    }
}
