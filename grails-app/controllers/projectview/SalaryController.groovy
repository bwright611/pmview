package projectview



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SalaryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Salary.list(params), model:[salaryInstanceCount: Salary.count()]
    }

    def show(Salary salaryInstance) {
        respond salaryInstance
    }

    def create() {
        respond new Salary(params)
    }

    @Transactional
    def save(Salary salaryInstance) {
        if (salaryInstance == null) {
            notFound()
            return
        }

        if (salaryInstance.hasErrors()) {
            respond salaryInstance.errors, view:'create'
            return
        }

        salaryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'salary.label', default: 'Salary'), salaryInstance.id])
                redirect salaryInstance
            }
            '*' { respond salaryInstance, [status: CREATED] }
        }
    }

    def edit(Salary salaryInstance) {
        respond salaryInstance
    }

    @Transactional
    def update(Salary salaryInstance) {
        if (salaryInstance == null) {
            notFound()
            return
        }

        if (salaryInstance.hasErrors()) {
            respond salaryInstance.errors, view:'edit'
            return
        }

        salaryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Salary.label', default: 'Salary'), salaryInstance.id])
                redirect salaryInstance
            }
            '*'{ respond salaryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Salary salaryInstance) {

        if (salaryInstance == null) {
            notFound()
            return
        }

        salaryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Salary.label', default: 'Salary'), salaryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'salary.label', default: 'Salary'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
