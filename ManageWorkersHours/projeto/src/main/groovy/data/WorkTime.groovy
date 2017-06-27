package data
/**
 * Created by Alex on 27/06/2017.
 */
class WorkTime {

    String name
    List<WorkInterval> intervals
    Float totalHours = -1

    Float calcTotalHours(){
        float total = 0
        intervals.each {
            total += it.calcTotalWorkHour()
        }
        if (totalHours < 0){
            totalHours = total
        }

        return total
    }

}
