package user

import groovy.transform.EqualsAndHashCode
import projeto.HourRegister

@EqualsAndHashCode
class Employer extends User{

    String job
    float salary
    int workHours

    static hasMany = [registers: HourRegister]

    static constraints = {
        job nullable: true
        salary nullable: false
        workHours nullable: true
    }

    static mapping = {

    }
}
