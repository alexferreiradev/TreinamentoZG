package projeto

import data.HourRegisterStatus
import grails.gorm.DetachedCriteria
import grails.transaction.Transactional
import user.Employer
import user.Manager

@Transactional
class ManagerService {

    EmployerService employerService

    /**
     * Filtra todos registros de pontos com estado de requisitado
     *
     * @return
     */
    List<HourRegister> findAllRegistersRequested() {
        DetachedCriteria<HourRegister> query = HourRegister.where {
            status == HourRegisterStatus.REQUESTED
        }

        return query.findAll()
    }

    /**
     * Marca como aprovado um registro de ponto
     *
     * @param manager
     * @param register
     * @return
     */
    HourRegister approveRegister(Manager manager, HourRegister register) {
        setRegisterStatus(manager, register, HourRegister.APPROVED_STATUS)
        return register.save()
    }

    /**
     * Marca como rejeitado um registro de ponto
     * @param manager
     * @param register
     * @return
     */
    HourRegister rejectRegister(Manager manager, HourRegister register) {
        setRegisterStatus(manager, register, HourRegister.REJECTED_STATUS)
        return register.save()
    }

    /**
     * Lista todos registros de pontos de um funcionário
     *
     * @param employer
     * @param date
     * @return
     */
    List<HourRegister> listHourRegisters(Employer employer) {
        return HourRegister.findAllByEmployer(employer)
    }

    /**
     * Lista todos registros de pontos do mês
     *
     * @param configuration
     * @return
     */
    List<HourRegister> listRegistersByMonth(Configuration configuration) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault())
        int currentMonth = calendar.get(Calendar.MONTH)
        return HourRegister.findAllByDateTimeLike("")
    }

    /**
     * Altera alguma configuração do sistema
     *
     * @param configuration
     * @return
     */
    Configuration setConfig(Configuration configuration) {
        return configuration.save()
    }

    private void setRegisterStatus(Manager manager, HourRegister register, int status) {
        register.manager = manager
        register.manageTime = new Date()
        register.status = status
    }

}
