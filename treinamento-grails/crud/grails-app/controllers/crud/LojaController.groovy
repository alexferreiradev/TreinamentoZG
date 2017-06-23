package crud

import org.hibernate.service.spi.InjectService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LojaController {

    ProdutoService produtoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Loja.list(params), model:[lojaCount: Loja.count()]
    }

    def show(Loja loja) {
        List<Produto> products = produtoService.allProducts
        loja.produtos = products
        respond loja
    }

    def create() {

        respond new Loja(params)
    }

    @Transactional
    def save(Loja loja) {
        if (loja == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (loja.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond loja.errors, view:'create'
            return
        }

        loja.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'loja.label', default: 'Loja'), loja.id])
                redirect loja
            }
            '*' { respond loja, [status: CREATED] }
        }
    }

    def edit(Loja loja) {
        respond loja
    }

    @Transactional
    def update(Loja loja) {
        if (loja == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (loja.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond loja.errors, view:'edit'
            return
        }

        loja.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'loja.label', default: 'Loja'), loja.id])
                redirect loja
            }
            '*'{ respond loja, [status: OK] }
        }
    }

    @Transactional
    def delete(Loja loja) {

        if (loja == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        loja.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'loja.label', default: 'Loja'), loja.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'loja.label', default: 'Loja'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
