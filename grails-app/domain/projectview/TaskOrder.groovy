package projectview

class TaskOrder {
    String name
    String jobCode              
    Date popStart, popEnd       
    double ceiling, fundedAmt   
    Contract contract          
    Employee projectManager      
    Person cor
    Date dateCreated, lastUpdated
    
    static belongsTo = [contract: Contract]
    static hasMany = [charges: Charge]
    
    String toString() { return name }
    
    static constraints = {
        name blank: false
        jobCode blank: false, unique: true
        contract blank: false
        projectManager blank: false, nullable: true
        popStart nullable: true
        popEnd nullable: true
        ceiling nullable: true
        fundedAmt nullable: true 
    }
    
}