package projeto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HourRegisterController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond HourRegister.list(params), model:[hourRegisterCount: HourRegister.count()]
    }

    def show(HourRegister hourRegister) {
        respond hourRegister
    }

    def create() {
        respond new HourRegister(params)
    }

    @Transactional
    def save(HourRegister hourRegister) {
        if (hourRegister == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (hourRegister.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond hourRegister.errors, view:'create'
            return
        }

        hourRegister.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hourRegister.label', default: 'HourRegister'), hourRegister.id])
                redirect hourRegister
            }
            '*' { respond hourRegister, [status: CREATED] }
        }
    }

    def edit(HourRegister hourRegister) {
        respond hourRegister
    }

    @Transactional
    def update(HourRegister hourRegister) {
        if (hourRegister == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (hourRegister.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond hourRegister.errors, view:'edit'
            return
        }

        hourRegister.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hourRegister.label', default: 'HourRegister'), hourRegister.id])
                redirect hourRegister
            }
            '*'{ respond hourRegister, [status: OK] }
        }
    }

    @Transactional
    def delete(HourRegister hourRegister) {

        if (hourRegister == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        hourRegister.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hourRegister.label', default: 'HourRegister'), hourRegister.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hourRegister.label', default: 'HourRegister'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
