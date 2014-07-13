package projectview

import projectview.Person

class Employee extends Person {
    Date birthdate
    SRCJobTitle jobTitle
    BigDecimal salary
    
    String getHourlyRate() { 
        return salary / 2080 
    }
    static transients = ['hourlyRate']
          
    String toString() {
        def name = firstName + " " + lastName
        name 
    }

    static constraints = {
        birthdate (blank: false, nullable: false)
        jobTitle (blank: false, nullable: false)
    }
}
