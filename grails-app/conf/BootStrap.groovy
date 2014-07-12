
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
        
        def address1 = new Address(street: "7800 Spring Creek", city: "N. Chas", state: "SC", zipCode: "29418").save(failOnError: true);
        
        def employer1 = new Employer(shortName: "SRC", longName: "Scientific Research Corporation", address: address1).save(failOnError: true);
        def employer2 = new Employer(shortName: "SPAWAR-LANT", longName: "Space and Naval Warfare Command - Atlantic", address: address1).save(failOnError: true);     
        
        def bwPerson = new Person(firstName: "Byron", lastName: "Wright", email: "bwright@scires.com",
            job: "Program Manager", phoneNumber: "404-234-5913",
            employer: employer1).save(failOnError: true);
        def tsPerson = new Person(firstName: "Terry", lastName: "Shatzer", email: "tshatzer@scires.com",
            job: "Director", phoneNumber: "843-345-1252",
            employer: employer2).save(failOnError: true);
        def tcPerson = new Person(firstName: "Townsend", lastName: "Clarkson", email: "tclarkson@scires.com",
            job: "Project Manager", phoneNumber: "404-234-5913",
            employer: employer1).save(failOnError: true);
        def jrPerson = new Person(firstName: "Jared", lastName: "Rupprecht", email: "jrupprecht@scires.com",
            job: "Project Manager", phoneNumber: "404-234-5913",
            employer: employer1).save(failOnError: true);
        def mhPerson = new Person(firstName: "Mark", lastName: "Hipps", email: "mhipps@scires.com",
            job: "Project Manager", phoneNumber: "404-234-5913",
            employer: employer2).save(failOnError: true);
        def jlPerson = new Person(firstName: "Jim", lastName: "Langolotti", email: "jlangolotti@scires.com",
            job: "Project Manager", phoneNumber: "404-234-5913",
            employer: employer2).save(failOnError: true);
        
        def salary1 = new Salary(employee: employee1, salary: "150000", from_date: new Date().clearTime() - 30, to_date: new Date().clearTime()).save(failOnError: true);
        
        def employee1 = new Employee(firstName: "John", lastName: "Employee", email: "bwright@scires.com",
            phoneNumber: "404-234-5913", birthdate: new Date().clearTime() - 50, 
            employer: employer1, jobTitle: jobTitle1, salary: salary1).save(failOnError: true);
                
        // def salary1 = new Salary(employee: employee1, salary: "150000", from_date: new Date().clearTime() - 30, to_date: new Date().clearTime()).save(failOnError: true);
        
        def contract3820 = new Contract(
                name: "C4I Software Integration Services",
                contractNumber: "N65326-08-3820",
                ceiling: 4500000,
                startDate: new Date().clearTime() - 30,
                endDate: new Date().clearTime() + 30,
                commonName: "OPS C2").save(failOnError: true)
        def contract2 = new Contract(
                name: "Software Defined Radio (SDR)",
                contractNumber: "N65326-08-5803",
                ceiling: 4500000,
                startDate: new Date().clearTime() - 30,
                endDate: new Date().clearTime() + 30,
                commonName: "Software Defined Radio").save(failOnError: true) 
                    
        def project1 = new TaskOrder(
                name: "GCCS-TCO/JTCW Software Integration",
                jobCode: "D210",
                contract: contract3820,
                ceiling: 971028.59, cor: bwPerson,
                popStart: new Date().clearTime(),
                popEnd: new Date().clearTime(),
                fundedAmt: 648000.43).save(failOnError: true)
        
        def project2 = new TaskOrder(
                name: "TacMobile Software Integration",
                jobCode: "D211",
                contract: contract2,
                popStart: new Date().clearTime(),
                popEnd: new Date().clearTime(),
                ceiling: 971028.59, cor: bwPerson,
                fundedAmt: 648000.43).save(failOnError: true)
            
        def project3 = new TaskOrder(
                name: "Digital Integration Facility",
                jobCode: "D214",
                contract: contract2,
                popStart: new Date().clearTime(),
                popEnd: new Date().clearTime(),
                ceiling: 971028.59, cor: bwPerson,
                fundedAmt: 356000.43).save(failOnError: true)
    }
    def destroy = {
    }
}
