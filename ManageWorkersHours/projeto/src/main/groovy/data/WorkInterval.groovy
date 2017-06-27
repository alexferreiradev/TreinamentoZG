package data

import projeto.HourRegister

/**
 * Created by Alex on 27/06/2017.
 */
class WorkInterval {

    HourRegister startWork
    HourRegister stopWork

    Float calcTotalWorkHour(){
        Date dateDiff = stopWork.dateCreated.minus(startWork.dateCreated)

        return  dateDiff.getTime() * 3600000
    }
}
