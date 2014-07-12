package projectview

class Charge {
    TaskOrder task
    Employee employee
    BigDecimal hours
    Date fromDate
    Date toDate
    
    String toString() {
        return "test"
    }
    
    static belongsTo = [taskOrder: TaskOrder]

    static constraints = {
        
    }
}
