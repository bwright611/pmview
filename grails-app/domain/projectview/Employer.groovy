package projectview

class Employer {
    
    String shortName, longName
    Address corpAddress
    
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically
    
    String toString() { 
        return shortName
    }
    
    static hasOne = Address

    static constraints = {
        shortName blank: false, nullable: false
        longName blank: false, nullable: false
        corpAddress blank: false, nullable: true
    }
}
