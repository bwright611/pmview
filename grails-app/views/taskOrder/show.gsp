
<%@ page import="projectview.TaskOrder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'taskOrder.label', default: 'TaskOrder')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-taskOrder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-taskOrder" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list taskOrder">
			
				<g:if test="${taskOrderInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="taskOrder.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${taskOrderInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.jobCode}">
				<li class="fieldcontain">
					<span id="jobCode-label" class="property-label"><g:message code="taskOrder.jobCode.label" default="Job Code" /></span>
					
						<span class="property-value" aria-labelledby="jobCode-label"><g:fieldValue bean="${taskOrderInstance}" field="jobCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.contract}">
				<li class="fieldcontain">
					<span id="contract-label" class="property-label"><g:message code="taskOrder.contract.label" default="Contract" /></span>
					
						<span class="property-value" aria-labelledby="contract-label"><g:link controller="contract" action="show" id="${taskOrderInstance?.contract?.id}">${taskOrderInstance?.contract?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.projectManager}">
				<li class="fieldcontain">
					<span id="projectManager-label" class="property-label"><g:message code="taskOrder.projectManager.label" default="Project Manager" /></span>
					
						<span class="property-value" aria-labelledby="projectManager-label"><g:link controller="employee" action="show" id="${taskOrderInstance?.projectManager?.id}">${taskOrderInstance?.projectManager?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.popStart}">
				<li class="fieldcontain">
					<span id="popStart-label" class="property-label"><g:message code="taskOrder.popStart.label" default="Pop Start" /></span>
					
						<span class="property-value" aria-labelledby="popStart-label"><g:formatDate date="${taskOrderInstance?.popStart}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.popEnd}">
				<li class="fieldcontain">
					<span id="popEnd-label" class="property-label"><g:message code="taskOrder.popEnd.label" default="Pop End" /></span>
					
						<span class="property-value" aria-labelledby="popEnd-label"><g:formatDate date="${taskOrderInstance?.popEnd}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.ceiling}">
				<li class="fieldcontain">
					<span id="ceiling-label" class="property-label"><g:message code="taskOrder.ceiling.label" default="Ceiling" /></span>
					
						<span class="property-value" aria-labelledby="ceiling-label"><g:fieldValue bean="${taskOrderInstance}" field="ceiling"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.fundedAmt}">
				<li class="fieldcontain">
					<span id="fundedAmt-label" class="property-label"><g:message code="taskOrder.fundedAmt.label" default="Funded Amt" /></span>
					
						<span class="property-value" aria-labelledby="fundedAmt-label"><g:fieldValue bean="${taskOrderInstance}" field="fundedAmt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.charges}">
				<li class="fieldcontain">
					<span id="charges-label" class="property-label"><g:message code="taskOrder.charges.label" default="Charges" /></span>
					
						<g:each in="${taskOrderInstance.charges}" var="c">
						<span class="property-value" aria-labelledby="charges-label"><g:link controller="charge" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.cor}">
				<li class="fieldcontain">
					<span id="cor-label" class="property-label"><g:message code="taskOrder.cor.label" default="Cor" /></span>
					
						<span class="property-value" aria-labelledby="cor-label"><g:link controller="person" action="show" id="${taskOrderInstance?.cor?.id}">${taskOrderInstance?.cor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="taskOrder.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${taskOrderInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${taskOrderInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="taskOrder.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${taskOrderInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:taskOrderInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${taskOrderInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
