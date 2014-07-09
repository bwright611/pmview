package projectview

import projectview.Person

class Employee extends Person {
    Date birthdate
    SRCJobTitle jobTitle  
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically

    static hasMany = [salary: Salary]
    
    String toString() {
        def name = firstName + " " + lastName
        name 
    }

    static constraints = {
        birthdate (blank: false, nullable: false)
    }
}
