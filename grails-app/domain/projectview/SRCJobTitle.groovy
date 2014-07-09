package projectview

class SRCJobTitle {
    
    String jobTitle
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically
    
    String toString() { return jobTitle }
    
    static constraints = {
        jobTitle (blank: false, nullable: false)
    }
}
