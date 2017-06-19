package projeto

import grails.transaction.Transactional
import user.User

@Transactional
class EmployerService {

    def getCurrentBalance(Configuration configuration, User user) {
        // todo calcular horas por dia e somar até dia atual
    }

    def addLateRegister(User user, HourRegister register) {
        // todo add validacao de justificativa
        register.employer = user;
        register.save()
    }

    def addRegister(User user, HourRegister register) {
        register.employer = user;
        register.save()
    }

    def getSalary(Configuration configuration, User user) {
        // TODO calcular horas por dia
    }

    List<HourRegister> getAllHourRegistersByInterval(Configuration configuration, User user, int offset) {
        return HourRegister.findAllByEmployer(user, offset: offset, max: 10)
    }

    /*
        CRUD
     */

    User add(User user) {
        return user.save();
    }

    User read(long id) {
        return User.get(id)
    }

    User update(User user) {
        return user.save()
    }

    void delete(User user) {
        user.delete()
    }
}
