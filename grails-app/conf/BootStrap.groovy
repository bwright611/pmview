
import projectview.Person
import projectview.Address
import projectview.Contract
import projectview.TaskOrder
import projectview.Employer
import projectview.Employee
import projectview.SRCJobTitle
import projectview.Salary

class BootStrap {

    def init = { servletContext ->
        
        def jobTitle1 = new SRCJobTitle(jobTitle: "Program Manager").save(failOnError: true);
        
        def address1 = new Address(street: "101 Lucy Drive", city: "Bumhuck", state: "GA", zipCode: "99999").save(failOnError: true);
        
        def employer1 = new Employer(shortName: "SRC", longName: "Scientific Research Corporation", address: address1).save(failOnError: true);
        def employer2 = new Employer(shortName: "MyCorp", longName: "My Corporation", address: address1).save(failOnError: true);     
        
        def bwPerson = new Person(firstName: "John", lastName: "Doe", email: "jdoe@example.com",
            job: "Program Manager", phoneNumber: "404-555-5555",
            employer: employer1).save(failOnError: true);
        def tsPerson = new Person(firstName: "Jane", lastName: "Glover", email: "janedoe@example.com",
            job: "Director", phoneNumber: "404-555-5555",
            employer: employer2).save(failOnError: true);
        def tcPerson = new Person(firstName: "Barry", lastName: "Gordy", email: "bgordy@example.com",
            job: "Project Manager", phoneNumber: "555-555-5555",
            employer: employer1).save(failOnError: true);
        
        def employee1 = new Employee(firstName: "John", lastName: "Employee", email: "jmeploy@example.com",
            phoneNumber: "555-555-5555", birthdate: new Date().clearTime() - 50, 
            employer: employer1, jobTitle: jobTitle1, salary: 32043.34).save(failOnError: true);
                
        // def salary1 = new Salary(employee: employee1, salary: "150000", from_date: new Date().clearTime() - 30, to_date: new Date().clearTime()).save(failOnError: true);
        
        def contract3820 = new Contract(
                name: "Contract 2",
                contractNumber: "N65326-08-5555",
                ceiling: 4500000,
                startDate: new Date().clearTime() - 30,
                endDate: new Date().clearTime() + 30,
                commonName: "Contract2").save(failOnError: true)
        def contract2 = new Contract(
                name: "Contract 3",
                contractNumber: "N65326-08-5555",
                ceiling: 4500000,
                startDate: new Date().clearTime() - 30,
                endDate: new Date().clearTime() + 30,
                commonName: "Contract4").save(failOnError: true) 
                    
        def project1 = new TaskOrder(
                name: "Dev Ops",
                jobCode: "Z555",
                contract: contract3820,
                ceiling: 653000.98, cor: bwPerson,
                popStart: new Date().clearTime(),
                popEnd: new Date().clearTime(),
                fundedAmt: 648000.43).save(failOnError: true)
        
        def project2 = new TaskOrder(
                name: "Cyber",
                jobCode: "Z202",
                contract: contract2,
                popStart: new Date().clearTime(),
                popEnd: new Date().clearTime(),
                ceiling: 923421.12, cor: bwPerson,
                fundedAmt: 648000.43).save(failOnError: true)
            
        def project3 = new TaskOrder(
                name: "Integration",
                jobCode: "Z999",
                contract: contract2,
                popStart: new Date().clearTime(),
                popEnd: new Date().clearTime(),
                ceiling: 855555.59, cor: bwPerson,
                fundedAmt: 356000.43).save(failOnError: true)
    }
    def destroy = {
    }
}
