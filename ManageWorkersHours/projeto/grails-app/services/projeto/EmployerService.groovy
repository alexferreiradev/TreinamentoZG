package projeto

import grails.gorm.DetachedCriteria
import grails.transaction.Transactional
import org.h2.util.DateTimeUtils
import user.Employer

import javax.transaction.NotSupportedException

@Transactional
class EmployerService {

    /**
     *  Calcula o balanço de horas feitas pelo funcionário até o dia atual.
     *
     * @param configuration
     * @param employer
     * @return - balanço, negativo para caso o funcionário está devendo horas, caso contrário, positivo
     *
     */
    float getCurrentBalance(Configuration configuration, Employer employer) {
        // Todo find all do periodo atual até dia atual
        List<HourRegister> registers = null

        return getHoursBalance(configuration, employer, var)
    }

    /**
     * Soma todas horas feitas pelo funcionário e
     *  confronta com o total de horas esperadas de acordo com a carga
     *  horária do funcionário.
     * @param configuration
     * @param employer
     * @param registers
     * @return
     */
    float getHoursBalance(Configuration configuration, Employer employer, List<HourRegister> registers){
        // todo extrair intervalos

        // todo iterar entre intervalos e somar horas

        return 0;
    }

    /**
     * Adiciona uma requisição de ponto atrasado.
     *
     * @param user - usuário
     * @param register
     * @throws NotSupportedException - caso a data do ponto seja no futuro.
     */
    void addLateRegister(HourRegister register) throws NotSupportedException {
        if (!register?.reason?.isEmpty()){
            // todo add validacao de justificativa
            addRegister(register)
        }
    }

    /**
     *  Adiciona um registro de ponto para um funcionário.
     *
     * @param register - registro
     */
    void addRegister(HourRegister register) {
        register.save()
    }

    /**
     * Calcula o salário do funcionário do período fechado, de acordo com as horas trabalhadas atual e carga
     * horária do funcionário.
     * @param configuration
     * @param user
     */
    float getSalary(Configuration configuration, Employer employer, int month) {
        List<HourRegister> registers = getHourByInterval(configuration, employer, month)
        float balance = getHoursBalance(configuration, employer, registers)

        if (balance == 0){
            return employer.salary
        }

        if (balance > 0){
            // todo calcular salario/hora
            // todo calcular adicional
        } else {
            // todo verificar se tem dia que ele faltou
            // todo calcular salario/hora
            // todo calcular redução
        }
    }

    /**
     * Horas trabalhadas por um funcionário durante um certo período fechado
     *
     * @param configuration
     * @param employer
     * @param month - periodo
     * @param offset
     * @return - lista de registros do funcionário
     */
    List<HourRegister> getHourByInterval(Configuration configuration, Employer employer, int month, int offset=1) {
        DetachedCriteria<HourRegister> query = HourRegister.where {
            employer == employer
            DateTimeUtils.getDatePart(dateTime, Calendar.MONTH) == month
        }
        query.findAll()

        // todo testar busca entre dia de fechamento do mes anterior com do mes atual
        Calendar currentDate = Calendar.getInstance(Locale.getDefault())
        int endDay = configuration.registerEndDay
        currentDate.set(Calendar.MONTH, month)
        currentDate.set(Calendar.DATE, endDay)

        Calendar startDate = currentDate.clone()
        startDate.roll(Calendar.MONTH, -1)
        Date finalDate = new Date(startDate)
        Date endDate = new Date(currentDate)

        return HourRegister.findAllByEmployerAndManageTimeBetween(employer, finalDate, endDate, [offset: offset, max: 10])
    }
}
