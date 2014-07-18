package projectview

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaskOrderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TaskOrder.list(params), model:[taskOrderInstanceCount: TaskOrder.count()]
    }

    def show(TaskOrder taskOrderInstance) {
        respond taskOrderInstance
    }

    def create() {
        respond new TaskOrder(params)
    }

    @Transactional
    def save(TaskOrder taskOrderInstance) {
        if (taskOrderInstance == null) {
            notFound()
            return
        }

        if (taskOrderInstance.hasErrors()) {
            respond taskOrderInstance.errors, view:'create'
            return
        }

        taskOrderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'taskOrder.label', default: 'TaskOrder'), taskOrderInstance.id])
                redirect taskOrderInstance
            }
            '*' { respond taskOrderInstance, [status: CREATED] }
        }
    }

    def edit(TaskOrder taskOrderInstance) {
        respond taskOrderInstance
    }

    @Transactional
    def update(TaskOrder taskOrderInstance) {
        if (taskOrderInstance == null) {
            notFound()
            return
        }

        if (taskOrderInstance.hasErrors()) {
            respond taskOrderInstance.errors, view:'edit'
            return
        }

        taskOrderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TaskOrder.label', default: 'TaskOrder'), taskOrderInstance.id])
                redirect taskOrderInstance
            }
            '*'{ respond taskOrderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TaskOrder taskOrderInstance) {

        if (taskOrderInstance == null) {
            notFound()
            return
        }

        taskOrderInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TaskOrder.label', default: 'TaskOrder'), taskOrderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskOrder.label', default: 'TaskOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
