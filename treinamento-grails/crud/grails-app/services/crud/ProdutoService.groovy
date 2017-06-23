package crud

import grails.transaction.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Transactional
class ProdutoService {

    def getAllProducts() {
        BuildableCriteria criteria = Produto.createCriteria()
        criteria {

        }
        return
    }
}
