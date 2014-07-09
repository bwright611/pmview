<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="admin"/>
		<title>Task Order Bottom Line Sheet</title>
	</head>
	<body>
		<!--
                <p>Hello World</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                
                <g:each in="${(1..10)}" var="number">
                    ${number}<br/>
                </g:each>
                -->
                <table class="table table-hover">
                    <tr>
                        <th>Job Code</th>
                        <th>Title</th>
                        <th>POP Start</th>
                        <th>POP End</th>
                        <th>Funded</th>
                        <th>Expended</th>
                        <th>Balance</th>
                        <th>Projected End Date</th>
                        <th>% Used</th>
                        <th>% Hours</th>
                        <th>Burn Rate (per mth)</th>
                        <th>Status</th>
                    </tr>
                                        
                    <g:each in="${taskorderList}" var="task">
                        <g:set var="balance" value="${0l}" />
                        <g:set var="balance" value="${task.fundedAmt - expended}" />
                        <g:set var="percUsed" value="${expended/task.fundedAmt}" />
                        <tr>
                            <td><g:link action="show" id="${task.id}">${task.jobCode}</g:link></td>
                            <td><g:link action="show" id="${task.id}">${task.name}</g:link></td>
                            <td><g:formatDate date="${task.popStart}" type="date" style="SHORT"/></td>
                            <td><g:formatDate date="${task.popEnd}" type="date" style="SHORT"/></td>
                            <td><g:formatNumber number="${task.fundedAmt}" type="currency" currencyCode="USD" /></td>
                            <td><g:formatNumber number="${expended}" type="currency" currencyCode="USD" /></td>
                            <td><g:formatNumber number="${balance}" type="currency" currencyCode="USD" /></td>
                            <td><g:formatDate date="${task.popStart + 30}" type="date" style="SHORT"/></td>
                            <td><g:formatNumber number="${percUsed}" type="percent" minFractionDigits="2" /></td>
                            <td><g:formatNumber number="${1}" type="percent" /></td>
                            <td><g:formatNumber number="${15034}" type="currency" currencyCode="USD" /></td>
                            <td><span class="label label-success">Approved</span></td>
                        </tr>
                    </g:each>        
                </table>
	</body>
</html>
