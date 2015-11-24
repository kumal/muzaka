
<%@ page import="muzaka.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="box container">
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			
			
				<header>
				<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				</header>
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
				
				
				<table>
				<thead>
						<tr>
						
							<g:sortableColumn property="authorized" title="${message(code: 'user.authorized.label', default: 'Authorized')}" />
						
							<g:sortableColumn property="user" title="${message(code: 'user.user.label', default: 'User')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${userInstanceList}" status="i" var="userInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "authorized")}</g:link></td>
						
							<td>${fieldValue(bean: userInstance, field: "user")}</td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${userInstanceCount ?: 0}" />
				</div>
			</div>
		</div>
		
	</body>
</html>
