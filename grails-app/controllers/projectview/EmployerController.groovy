package projectview



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Employer.list(params), model:[employerInstanceCount: Employer.count()]
    }

    def show(Employer employerInstance) {
        respond employerInstance
    }

    def create() {
        respond new Employer(params)
    }

    @Transactional
    def save(Employer employerInstance) {
        if (employerInstance == null) {
            notFound()
            return
        }

        if (employerInstance.hasErrors()) {
            respond employerInstance.errors, view:'create'
            return
        }

        employerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employer.label', default: 'Employer'), employerInstance.id])
                redirect employerInstance
            }
            '*' { respond employerInstance, [status: CREATED] }
        }
    }

    def edit(Employer employerInstance) {
        respond employerInstance
    }

    @Transactional
    def update(Employer employerInstance) {
        if (employerInstance == null) {
            notFound()
            return
        }

        if (employerInstance.hasErrors()) {
            respond employerInstance.errors, view:'edit'
            return
        }

        employerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Employer.label', default: 'Employer'), employerInstance.id])
                redirect employerInstance
            }
            '*'{ respond employerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Employer employerInstance) {

        if (employerInstance == null) {
            notFound()
            return
        }

        employerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Employer.label', default: 'Employer'), employerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employer.label', default: 'Employer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
