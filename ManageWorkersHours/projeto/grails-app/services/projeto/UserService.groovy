package projeto

import grails.gorm.DetachedCriteria
import grails.transaction.Transactional
import user.User

@Transactional
class UserService {

    User findByLoginAndPass(String login, String pass) {
        DetachedCriteria<User> query = User.where {
            userEmail == login
            password == pass
        }

        return query.find()
    }
}
