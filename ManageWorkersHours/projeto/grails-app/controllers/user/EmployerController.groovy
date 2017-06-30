package user

import data.EmployerDTO
import data.HourRegisterStatus
import projeto.Configuration
import projeto.ConfigurationService
import projeto.EmployerService
import projeto.HourRegister

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployerController {

    EmployerService employerService
    ConfigurationService confService
    private Configuration mConfig = confService.getCurrentConfig()

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Employer employer) {
        respond Employer.list(params), model:[employerCount: Employer.count()]
    }

    def home(){
        // todo add recuperacao de employer pela sessao
        EmployerDTO empDTO = new EmployerDTO()
        empDTO.id = employer.id
        empDTO.cpf = employer.cpf
        empDTO.name = employer.name
        empDTO.email = employer.email
        empDTO.hourBalance = employerService.getHoursBalance(mConfig, employer)
        empDTO.totalDayHourRegisters = employerService.getTotalDayHours(employer)

        respond model: [employerDTO: empDTO]
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
        register.save flush:true

        flash.message = message(code: 'add.register', default: 'Ponto batido as {0}', args: [currentDate])
        render(view: "show", model: employer)
    }

    def showAddLateRegister(Employer employer){
        redirect view: "add_late_register", model: employer
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
