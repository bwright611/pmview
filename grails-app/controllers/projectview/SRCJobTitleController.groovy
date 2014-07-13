package projectview



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SRCJobTitleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SRCJobTitle.list(params), model:[SRCJobTitleInstanceCount: SRCJobTitle.count()]
    }

    def show(SRCJobTitle SRCJobTitleInstance) {
        respond SRCJobTitleInstance
    }

    def create() {
        respond new SRCJobTitle(params)
    }

    @Transactional
    def save(SRCJobTitle SRCJobTitleInstance) {
        if (SRCJobTitleInstance == null) {
            notFound()
            return
        }

        if (SRCJobTitleInstance.hasErrors()) {
            respond SRCJobTitleInstance.errors, view:'create'
            return
        }

        SRCJobTitleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'SRCJobTitle.label', default: 'SRCJobTitle'), SRCJobTitleInstance.id])
                redirect SRCJobTitleInstance
            }
            '*' { respond SRCJobTitleInstance, [status: CREATED] }
        }
    }

    def edit(SRCJobTitle SRCJobTitleInstance) {
        respond SRCJobTitleInstance
    }

    @Transactional
    def update(SRCJobTitle SRCJobTitleInstance) {
        if (SRCJobTitleInstance == null) {
            notFound()
            return
        }

        if (SRCJobTitleInstance.hasErrors()) {
            respond SRCJobTitleInstance.errors, view:'edit'
            return
        }

        SRCJobTitleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SRCJobTitle.label', default: 'SRCJobTitle'), SRCJobTitleInstance.id])
                redirect SRCJobTitleInstance
            }
            '*'{ respond SRCJobTitleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SRCJobTitle SRCJobTitleInstance) {

        if (SRCJobTitleInstance == null) {
            notFound()
            return
        }

        SRCJobTitleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SRCJobTitle.label', default: 'SRCJobTitle'), SRCJobTitleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'SRCJobTitle.label', default: 'SRCJobTitle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
