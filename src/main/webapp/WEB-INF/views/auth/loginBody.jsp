<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="auth_wrapper">
	<form:form action="loginProcess" method="post" cssClass="auth_form">
		<fieldset>
		    <div class="form-group">
		        <label for="userName">User Name*</label>
				<input type="text" class="form-control" id="username" required="required">
		    </div>
		    <div class="form-group">
		        <label for="password">Password*</label>
		        <input type="text" class="form-control" id="password" required="required">
		    </div>
		    <div>
		    	<button type="submit" class="btn btn-info">Submit</button>
		    </div>
	    </fieldset>
	</form:form>
</div>