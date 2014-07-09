package projectview

class Contract {
    
    Date startDate         
    Date endDate           
    String name            
    String commonName      
    String contractNumber  
    double ceiling         
    Employee contractManager 
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [taskorder: TaskOrder]
    
    String toString() { return contractNumber }
    
    static constraints = {
        name blank: false
        contractNumber blank: false, unique: true
        ceiling blank: false
        contractManager blank: false
        endDate: nullable: false
        startDate: nullable: false 
        commonName: nullable: false
    }
    
}
