package projectview

import projectview.Person

class Employee extends Person {
    Date birthdate
    SRCJobTitle jobTitle 
    Salary salary
      
    static hasMany = [salary: Salary]
    
    String toString() {
        def name = firstName + " " + lastName
        name 
    }

    static constraints = {
        birthdate (blank: false, nullable: false)
        jobTitle (blank: false, nullable: false)
    }
}
