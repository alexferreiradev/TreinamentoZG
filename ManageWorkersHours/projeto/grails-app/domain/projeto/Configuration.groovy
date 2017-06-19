package projeto

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Configuration {

    public static final int WEEK_SELECT_MON_FRI = 45
    public static final int WEEK_SELECT_MON_SAT = 64

    int registerDate
    int workWeekDays
    int minHourPerDay

    static constraints = {
    }
}
