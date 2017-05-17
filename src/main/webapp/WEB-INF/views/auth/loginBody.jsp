<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="auth_wrapper">
	<form:form action="./auth" method="post" cssClass="auth_form">
		<fieldset>
		    <div class="form-group">
		        <label for="userName">User Name*</label>
				<input type="text" class="form-control" name="username" id="username" required="required">
		    </div>
		    <div class="form-group">
		        <label for="password">Password*</label>
		        <input type="text" class="form-control" name="password" id="password" required="required">
		    </div>
		    <div>
		    	<button name="submit" type="submit" value="submit" class="btn btn-info">Submit</button>
		    </div>
		    <c:if test="${not empty error}">
		        <div class="error">${error}</div>
		    </c:if>
		    <c:if test="${not empty msg}">
		        <div class="msg">${msg}</div>
		    </c:if>
	    </fieldset>
	</form:form>
</div>