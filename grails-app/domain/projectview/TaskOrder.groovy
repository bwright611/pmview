package projectview

class TaskOrder {
    
    String name
    String jobCode              
    Date popStart, popEnd       
    BigDecimal ceiling, fundedAmt   
    Contract contract          
    Employee projectManager      
    Person cor
    Date dateCreated, lastUpdated
    
    static belongsTo = [contract: Contract]
    
    String toString() { return name }
    
    static constraints = {
        name blank: false
        jobCode blank: false, unique: true
        contract blank: false
        projectManager blank: false
        popStart nullable: true
        popEnd nullable: true
        ceiling nullable: true
        fundedAmt nullable: true 
    }
    
}