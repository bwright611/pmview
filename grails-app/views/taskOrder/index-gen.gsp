
<%@ page import="projectview.TaskOrder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'taskOrder.label', default: 'TaskOrder')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-taskOrder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-taskOrder" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'taskOrder.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="jobCode" title="${message(code: 'taskOrder.jobCode.label', default: 'Job Code')}" />
					
						<th><g:message code="taskOrder.contract.label" default="Contract" /></th>
					
						<th><g:message code="taskOrder.projectManager.label" default="Project Manager" /></th>
					
						<g:sortableColumn property="popStart" title="${message(code: 'taskOrder.popStart.label', default: 'Pop Start')}" />
					
						<g:sortableColumn property="popEnd" title="${message(code: 'taskOrder.popEnd.label', default: 'Pop End')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${taskOrderInstanceList}" status="i" var="taskOrderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${taskOrderInstance.id}">${fieldValue(bean: taskOrderInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: taskOrderInstance, field: "jobCode")}</td>
					
						<td>${fieldValue(bean: taskOrderInstance, field: "contract")}</td>
					
						<td>${fieldValue(bean: taskOrderInstance, field: "projectManager")}</td>
					
						<td><g:formatDate date="${taskOrderInstance.popStart}" /></td>
					
						<td><g:formatDate date="${taskOrderInstance.popEnd}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${taskOrderInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
