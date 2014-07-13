package projectview

class Salary {
    Employee employee
    BigDecimal salary
    Date from_date
    Date to_date
    BigDecimal hourlyRate
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically
    
    String toString() {
        salary
    }

    static constraints = {
        employee (blank: false, nullable: false)
        
    }
}
