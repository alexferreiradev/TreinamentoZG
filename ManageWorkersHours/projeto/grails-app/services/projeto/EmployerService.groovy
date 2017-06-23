package projeto

import grails.gorm.DetachedCriteria
import grails.transaction.Transactional
import org.h2.util.DateTimeUtils
import user.Employer
import user.User

@Transactional
class EmployerService {

    int getCurrentBalance(Configuration configuration, Employer employer) {
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

    List<HourRegister> getAllHourRegistersByInterval(Configuration configuration, Employer employer, int offset) {
        int month = Calendar.getInstance(Locale.getDefault()).get(Calendar.MONTH)

        DetachedCriteria<HourRegister> query = HourRegister.where {
            employer == employer
            DateTimeUtils.getDatePart(dateTime, Calendar.MONTH) == month
        }
        query.findAll()
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
