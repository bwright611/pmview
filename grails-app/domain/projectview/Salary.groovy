package projectview

class Salary {
    Employee employee
    double salary
    Date from_date
    Date to_date

    static constraints = {
        employee (blank: false, nullable: false)
        
    }
}
