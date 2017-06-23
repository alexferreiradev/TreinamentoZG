package projeto

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Configuration {

    public static final int WEEK_SELECT_MON_FRI = 45
    public static final int WEEK_SELECT_MON_SAT = 64

    int registerEndDay
    int workWeekDays
    int minHourPerDay
    Date dateCreated
    Date lastUpdate

    static constraints = {
    }
}
