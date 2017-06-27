package projeto

import data.WorkInterval
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
        if (registers == null){
            registers = HourRegister.findAllByEmployer(employer)
        }

        if (registers.size() % 2 != 0){
            // TODO tratar a quantidade de registros invalida
        }

        List<WorkInterval> intervals = new ArrayList<>()
        Iterator<HourRegister> iterator = registers.iterator()
        while (iterator.hasNext()){
            HourRegister register = iterator.next()
            if (iterator.hasNext()){
                WorkInterval interval = new WorkInterval(startWork: register, stopWork: iterator.next())
                intervals.add(interval)
            }
        }

        int workHours = employer.workHours
        intervals.forEach {
            workHours -= it.calcTotalWorkHour()
        }


        return workHours;
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
            addRegister(register)
        } else {
            throw new NotSupportedException("Não há justificativa para tentativa de salvar um ponto atrasado")
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
        int hourPerMonth = employer.workHours * 20
        float hourValue = employer.salary / hourPerMonth
        float extraHourValue = hourValue + (hourValue * 0.2) // salario/hora para hora extra (apos 8h e nao noturno)
        float nightHourValue = extraHourValue + (extraHourValue * 0.5) // salario/hora para hora noturna (somente apos 22 e antes das 5)
        float weekendExtraHourValue = hourValue * 2 // salario/hora para hora extra (dos finais de semana)
        float finalSalary = 0

        Float totalHours = getTotalNormalHours()
        float totalWeekendHours = getTotalWeekendHours()
        float totalNightHours = getTotalNightHours()

        if (totalWeekendHours > 0) {
            totalHours -= totalWeekendHours
            finalSalary += (totalWeekendHours * weekendExtraHourValue)
        }

        finalSalary = addNightExtraSalary(totalNightHours, finalSalary, nightHourValue)

        if (totalHours > hourPerMonth){ // extras sem levar consideracao feriado e fds
            finalSalary += hourPerMonth * hourValue
            finalSalary += (totalHours - hourPerMonth) * extraHourValue
        } else {
            finalSalary += totalHours * hourValue
        }

        return finalSalary
    }

    private float addNightExtraSalary(float totalNightHours, float finalSalary, float nightHourValue) {
        if (totalNightHours > 0) {
            finalSalary += (totalNightHours * nightHourValue)
        }
        return finalSalary
    }

    private float getTotalNightHours() {
        List<Float> nightHoursPerCurrentMonth = getTotalDayNightHoursPerCurrentMonth()
        float totalNightHours = 0
        nightHoursPerCurrentMonth.each {
            totalNightHours += it
        }
        return totalNightHours
    }

    private float getTotalWeekendHours() {
        List<Float> weekendHours = getTotalDayWeekendHoursPerCurrentMonth()
        float totalWeekendHours = 0
        weekendHours.each {
            totalWeekendHours += it
        }
        return totalWeekendHours
    }

    private float getTotalNormalHours() {
        List<Float> totalDayHours = getTotalNormalHours()
        float totalHours = 0
        totalDayHours.each {
            totalHours += it
        }
        return totalHours
    }

    /**
     * Horas trabalhadas em finais de semana
     * @return
     */
    private List<Float> getTotalDayWeekendHoursPerCurrentMonth() {
        null
    }

    List<Float> getTotalDayNightHoursPerCurrentMonth() {
        return null
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

    /**
     * Recupera o total de horas normais feitas por dia, no mes atual
     *
     * @param employer
     * @return
     */
    List<Float> getTotalDayHoursPerCurrentMonth(Employer employer) {

        return null
    }
}
