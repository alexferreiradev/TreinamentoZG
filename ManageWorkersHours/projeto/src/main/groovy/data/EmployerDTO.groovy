package data

import groovy.transform.EqualsAndHashCode
import projeto.HourRegister

/**
 * Created by alexferreira on 26/06/17.
 */
@EqualsAndHashCode
class EmployerDTO {
    long id
    String name
    String cpf
    String email
    float hourBalance
    List<Float> totalDayHourRegisters
}
