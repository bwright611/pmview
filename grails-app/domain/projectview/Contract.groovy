package projectview

class Contract {
    Date startDate         
    Date endDate           
    String name            
    String commonName      
    String contractNumber  
    BigDecimal ceiling         
    Employee contractManager 
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [taskorder: TaskOrder]
    
    String toString() { 
        return contractNumber 
    }
    
    static constraints = {
        name blank: false
        contractNumber blank: false, unique: true
        ceiling blank: false
        contractManager blank: false, nullable: true
        endDate: nullable: false
        startDate: nullable: false 
        commonName: nullable: false
    }
    
}
