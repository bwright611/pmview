package projectview

class Charge {
    TaskOrder taskOrder
    Employee employee
    double hours
    Date fromDate
    Date toDate
    
    String toString() {
        return "test"
    }
    
    static belongsTo = [taskOrder: TaskOrder]

    static constraints = {
        
    }
}
