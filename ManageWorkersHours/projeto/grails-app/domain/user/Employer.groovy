package user

import projeto.HourRegister

class Employer extends User{

    String job
    float salary

    static hasMany = [registers: HourRegister]

    static constraints = {

    }

    static mapping = {

    }
}
