package user

import grails.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.transaction.interceptor.TransactionAspectSupport

import static org.springframework.http.HttpStatus.*

class ManagerController {

    def index() {
        String username = SecurityContextHolder.context.authentication.principal.username
        Manager manager = Manager.findByUsername(username)
        if (!manager){
            flash.message = "Login foi alterado, fazendo logoff"
            return redirect (controller: "logoff")
        }
        render model: [managerAdm: manager], view: "home"
    }

    def list() {
        render view: "index",
                model:[managerCount: Manager.count(),
                       managerList: Manager.list(params)]
    }

    def show(Manager manager) {
        render model: [managerAdm: manager], view: "home"
    }

    def create() {
        respond new Manager()
    }

    def edit(Manager manager) {
        respond manager
    }

    @Transactional
    def save(Manager manager) {
        if (manager == null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
            notFound()
            return
        }

        if (manager.hasErrors()) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
            respond manager.errors, view:'create'
            return
        }

        manager.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'manager.label', default: 'Configuration'), manager.id])
                redirect manager
            }
            '*' { respond manager, [status: CREATED] }
        }
    }

    @Transactional
    def update(Manager manager) {
        if (manager == null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
            notFound()
            return
        }

        if (manager.hasErrors()) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
            respond manager.errors, view:'edit'
            return
        }

        manager.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'manager.label', default: 'Configuration'), manager.id])
                redirect manager
            }
            '*'{ respond manager, [status: OK] }
        }
    }

    @Transactional
    def delete(Manager manager) {

        if (manager == null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
            notFound()
            return
        }

        manager.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'manager.label', default: 'Configuration'), manager.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'configuration.label', default: 'Configuration'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
