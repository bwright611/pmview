package projectview

class Address {

    String street, street2
    String city
    String state
    String zipCode
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically
    
    static belongsTo = Person

    static constraints = {
        street(nullable:false)
        street2(nullable: true)
        city(nullable:false)
        state(nullable:false)
        zipCode(nullable:false)
    }
}
