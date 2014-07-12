package projectview

class Salary {
    Employee employee
    BigDecimal salary
    Date from_date
    Date to_date
    BigDecimal hourlyRate
    
    static mapping = {
        hourlyRate formula: 'SALARY / 2080'
    }
    
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date lastUpdated // Predefined names by Grails will be filled automatically
    
    static belongsTo = [employee: Employee]
    
    String toString() {
        salary
    }

    static constraints = {
        employee (blank: false, nullable: false)
        
    }
}
