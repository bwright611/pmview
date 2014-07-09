package projectview

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaskOrderController {
    
    def scaffold = true
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    /* def index() {
        def expended = 324000.0
        // return [taskorders:TaskOrder.list(), testvar: expended]       
        [taskorderList: TaskOrder.list(), expended:expended]
        // respond TaskOrder.list(params), model:[taskInstanceCount: TaskOrder.count()]
    } */
    
    /*
    def show(TaskOrder taskOrderInstance) {
        // respond taskOrderInstance
        // [taskInstance: TaskOrder.get(params.id)]
        [taskorder : taskOrderInstance.get(params.id)]
    }

    def create() {
        respond new TaskOrder(params)
    }

    @Transactional
    def save(TaskOrder taskInstance) {
        if (taskInstance == null) {
            notFound()
            return
        }

        if (taskInstance.hasErrors()) {
            respond taskInstance.errors, view:'create'
            return
        }

        taskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'taskorder.label', default: 'TaskOrder'), taskInstance.id])
                redirect taskInstance
            }
            '*' { respond taskInstance, [status: CREATED] }
        }
    }

    def edit(TaskOrder taskInstance) {
        respond taskInstance
    }

    @Transactional
    def update(TaskOrder taskInstance) {
        if (taskInstance == null) {
            notFound()
            return
        }

        if (taskInstance.hasErrors()) {
            respond taskInstance.errors, view:'edit'
            return
        }

        taskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TaskOrder.label', default: 'TaskOrder'), taskInstance.id])
                redirect taskInstance
            }
            '*'{ respond taskInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TaskOrder taskInstance) {

        if (taskInstance == null) {
            notFound()
            return
        }

        taskInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TaskOrder.label', default: 'TaskOrder'), taskInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'TaskOrder.label', default: 'TaskOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    */

    
    
}
