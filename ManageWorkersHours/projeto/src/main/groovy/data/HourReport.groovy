package data

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by alexferreira on 30/06/17.
 */
@EqualsAndHashCode
@ToString
class HourReport {

    String salaryTotal
    String expectedHour
    String hourTotal
    Map<Integer, String> hoursPerDay
}
