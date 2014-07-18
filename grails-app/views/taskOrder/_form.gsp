<%@ page import="projectview.TaskOrder" %>



<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="taskOrder.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${taskOrderInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'jobCode', 'error')} required">
	<label for="jobCode">
		<g:message code="taskOrder.jobCode.label" default="Job Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="jobCode" required="" value="${taskOrderInstance?.jobCode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'contract', 'error')} required">
	<label for="contract">
		<g:message code="taskOrder.contract.label" default="Contract" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contract" name="contract.id" from="${projectview.Contract.list()}" optionKey="id" required="" value="${taskOrderInstance?.contract?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'projectManager', 'error')} ">
	<label for="projectManager">
		<g:message code="taskOrder.projectManager.label" default="Project Manager" />
		
	</label>
	<g:select id="projectManager" name="projectManager.id" from="${projectview.Employee.list()}" optionKey="id" value="${taskOrderInstance?.projectManager?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'popStart', 'error')} ">
	<label for="popStart">
		<g:message code="taskOrder.popStart.label" default="Pop Start" />
		
	</label>
	<g:datePicker name="popStart" precision="day"  value="${taskOrderInstance?.popStart}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'popEnd', 'error')} ">
	<label for="popEnd">
		<g:message code="taskOrder.popEnd.label" default="Pop End" />
		
	</label>
	<g:datePicker name="popEnd" precision="day"  value="${taskOrderInstance?.popEnd}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'ceiling', 'error')} required">
	<label for="ceiling">
		<g:message code="taskOrder.ceiling.label" default="Ceiling" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ceiling" value="${fieldValue(bean: taskOrderInstance, field: 'ceiling')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'fundedAmt', 'error')} required">
	<label for="fundedAmt">
		<g:message code="taskOrder.fundedAmt.label" default="Funded Amt" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="fundedAmt" value="${fieldValue(bean: taskOrderInstance, field: 'fundedAmt')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'charges', 'error')} ">
	<label for="charges">
		<g:message code="taskOrder.charges.label" default="Charges" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${taskOrderInstance?.charges?}" var="c">
    <li><g:link controller="charge" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="charge" action="create" params="['taskOrder.id': taskOrderInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'charge.label', default: 'Charge')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: taskOrderInstance, field: 'cor', 'error')} required">
	<label for="cor">
		<g:message code="taskOrder.cor.label" default="Cor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cor" name="cor.id" from="${projectview.Person.list()}" optionKey="id" required="" value="${taskOrderInstance?.cor?.id}" class="many-to-one"/>

</div>

