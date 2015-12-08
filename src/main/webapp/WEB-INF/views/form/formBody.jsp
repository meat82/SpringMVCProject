<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content" style="width: 30%;">
	<form:form action="formProcess" method="post" commandName="person">
	    <div class="form-group">
	        <label for="firstName">First Name*</label>
	        <form:input path="firstName" class="form-control" id="firstName" required="required"/>
	    </div>
	    <div class="form-group">
	        <label for="lastName">Last Name*</label>
	        <form:input path="lastName" class="form-control" id="lastName" required="required"/>
	    </div>
	    <div class="form-group">
	        <label for="eMail">E-Mail</label>
	        <form:input path="eMail" class="form-control" id="email"/>
	    </div>
	    <div class="form-group">
	        <label  for="phone">Phone</label>
	        <form:input path="phone" class="form-control" id="phone"/>
	    </div>
	    <div class="form-group">
	        <label for="password">Password*</label>
	        <form:input path="passWord" class="form-control" id="password" required="required"/>
	    </div>
	    <div>
	    	* Are mandatory fields
	    </div>
	    <div>
	    	<button type="submit" class="btn btn-info">Submit</button>
	    </div>
	</form:form>
</div>