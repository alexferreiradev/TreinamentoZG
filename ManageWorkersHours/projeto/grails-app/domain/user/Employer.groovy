package user

import projeto.HourRegister

class Employer extends User{

    String job
    float salary
    int workHours

    static hasMany = [registers: HourRegister]

    static constraints = {

    }

    static mapping = {

    }
}
