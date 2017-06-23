package user

import data.HourRegisterStatus
import projeto.HourRegister

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Employer.list(params), model:[employerCount: Employer.count()]
    }

    def show(Employer employer) {
        respond employer
    }

    def create() {
        respond new Employer(params)
    }

    def addRegister(Employer employer){
        Date currentDate = new Date()
        HourRegister register = new HourRegister(employer, currentDate)
        register.save()

        flash.message = message(code: 'default.created.message', default: 'Ponto batido as ', args: [currentDate])
        render view: "show", model: employer
    }

    @Transactional
    def save(Employer employer) {
        if (employer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (employer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond employer.errors, view:'create'
            return
        }

        employer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employer.label', default: 'Employer'), employer.id])
                redirect employer
            }
            '*' { respond employer, [status: CREATED] }
        }
    }

    def edit(Employer employer) {
        respond employer
    }

    @Transactional
    def update(Employer employer) {
        if (employer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (employer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond employer.errors, view:'edit'
            return
        }

        employer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'employer.label', default: 'Employer'), employer.id])
                redirect employer
            }
            '*'{ respond employer, [status: OK] }
        }
    }

    @Transactional
    def delete(Employer employer) {

        if (employer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        employer.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'employer.label', default: 'Employer'), employer.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employer.label', default: 'Employer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
