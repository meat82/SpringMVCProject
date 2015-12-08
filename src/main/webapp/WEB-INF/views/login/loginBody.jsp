<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content" style="width: 30%;">
	<form:form action="loginProcess" method="post" commandName="person">
	    <div class="form-group">
	        <label for="userName">User Name*</label>
	        <form:input path="userName" class="form-control" id="userName" required="required"/>
	    </div>
	    <div class="form-group">
	        <label for="password">Password*</label>
	        <form:input path="passWord" class="form-control" id="password" required="required"/>
	    </div>
	    <div>
	    	<button type="submit" class="btn btn-info">Submit</button>
	    </div>
	</form:form>
</div>