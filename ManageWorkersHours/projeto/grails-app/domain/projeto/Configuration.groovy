package projeto

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Configuration {

    int registerDate
    int workWeekDays
    Date createDate
    Date updateDate

    static constraints = {
    }
}
