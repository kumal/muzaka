<%@ page import="muzaka.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'authorized', 'error')} ">
	<label for="authorized">
		<g:message code="user.authorized.label" default="Authorized" />
		
	</label>
	<g:checkBox name="authorized" value="${userInstance?.authorized}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="user.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="user" required="" value="${userInstance?.user}"/>

</div>

