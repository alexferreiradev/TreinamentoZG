package projeto

import grails.gorm.DetachedCriteria
import grails.transaction.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria
import user.User

@Transactional
class ManagerService {

//    listPontosRequisitados
//    aprovar ponto
//    rejeitar ponto
//    listPontosByDay
//    filtrarPontosByFunc
//    listPontosByFunc
//    getListTotalHoursByDay
//    getTotalHorasTrabalhadasByPeriodo
//    getSalarioFuncionário
//    edita_config


    List<HourRegister> findAllRegistersRequested() {
        DetachedCriteria<HourRegister> query = HourRegister.where {
            status == 0
        }

        return query.findAll()
    }

    HourRegister approveRegister(User manager, HourRegister register) {
        setRegisterStatus(manager, register, HourRegister.APPROVED_STATUS)
        return register.save()
    }

    HourRegister rejectRegister(User manager, HourRegister register) {
        setRegisterStatus(manager, register, HourRegister.REJECTED_STATUS)
        return register.save()
    }

    List<HourRegister> listHourRegisters(User employer, Date date) {
        DetachedCriteria<HourRegister> query = HourRegister.where {
            employer == employer
            dateTime == date
        }

        return query.findAll()
    }

    List<HourRegister> listRegistersByInterval(Configuration configuration) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault())
        int currentMonth = calendar.get(Calendar.MONTH)
        return HourRegister.findAllByDateTimeLike("")
    }

    Float calcEmployerSalary(User employer, Configuration configuration) {
        // TODO calcular horas trabalhadas pelo func
        int workWeekDays = configuration.workWeekDays
        int totalDays = 0;
        if (workWeekDays == Configuration.WEEK_SELECT_MON_FRI) {
            totalDays = 5
        } else {
            totalDays = 6
        }

        float salaryPerHour = salary / (totalDays * 4 * configuration.minHourPerDay)
        // TODO multiplicar horas pelo salario/hora do func

        return 0
    }

    Configuration setConfig(Configuration configuration) {
        return configuration.save()
    }

    private void setRegisterStatus(User manager, HourRegister register, int status) {
        register.manager = manager
        register.manageTime = new Date()
        register.status = status
    }

}
