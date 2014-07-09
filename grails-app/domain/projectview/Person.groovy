package projectview

class Person {
    String firstName, lastName
    String email
    String phoneNumber
    Employer employer
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically

    static mapping = {
        tablePerHierarchy false
    }
    
    String toString() {
        def name = firstName + " " + lastName
        name 
    }

    static constraints = {
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
        email email: true, blank: false, nullable: false
    }

}
