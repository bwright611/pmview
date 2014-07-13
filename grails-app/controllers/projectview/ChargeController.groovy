package projectview



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ChargeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Charge.list(params), model:[chargeInstanceCount: Charge.count()]
    }

    def show(Charge chargeInstance) {
        respond chargeInstance
    }

    def create() {
        respond new Charge(params)
    }

    @Transactional
    def save(Charge chargeInstance) {
        if (chargeInstance == null) {
            notFound()
            return
        }

        if (chargeInstance.hasErrors()) {
            respond chargeInstance.errors, view:'create'
            return
        }

        chargeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'charge.label', default: 'Charge'), chargeInstance.id])
                redirect chargeInstance
            }
            '*' { respond chargeInstance, [status: CREATED] }
        }
    }

    def edit(Charge chargeInstance) {
        respond chargeInstance
    }

    @Transactional
    def update(Charge chargeInstance) {
        if (chargeInstance == null) {
            notFound()
            return
        }

        if (chargeInstance.hasErrors()) {
            respond chargeInstance.errors, view:'edit'
            return
        }

        chargeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Charge.label', default: 'Charge'), chargeInstance.id])
                redirect chargeInstance
            }
            '*'{ respond chargeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Charge chargeInstance) {

        if (chargeInstance == null) {
            notFound()
            return
        }

        chargeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Charge.label', default: 'Charge'), chargeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'charge.label', default: 'Charge'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
