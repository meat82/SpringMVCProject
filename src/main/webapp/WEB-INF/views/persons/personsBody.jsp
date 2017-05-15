<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>

<div id="nav-sidepanel" class="sidenav">
	<a href="javascript:void(0)" class="closebtn">&times;</a>
	<form:form action="formProcessEdit" method="post" modelAttribute="person">
	    <div class="form-group">
	        <label for="userName">User Name</label>
	        <form:input path="userName" class="form-control" id="userNameId"/>
	        <form:hidden path="userId" class="form-control" id="userIdId"/>
	    </div>
		<div class="form-group">
		    <label for="firstName">First Name</label>
		    <form:input path="firstName" class="form-control" id="firstNameId"/>
		</div>
		<div class="form-group">
		    <label for="lastName">Last Name</label>
		    <form:input path="lastName" class="form-control" id="lastNameId"/>
		</div>
		<div class="form-group">
		    <label for="eMail">E-Mail</label>
		    <form:input path="eMail" class="form-control" id="emailId"/>
		</div>
		<div class="form-group">
		    <label  for="phone">Phone</label>
		    <form:input path="phone" class="form-control" id="phoneId"/>
		</div>
	    <div>
	    	<button type="submit" class="btn btn-info">Submit</button>
	    </div>
	</form:form>
</div>
<div id="dialog-confirm" title="Delete selected?">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>
</div>
<div id="content">
	<table id="personsTable" class="display" style="width: 100%;">
        <thead>
            <tr>
            	<th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mail</th>
                <th>Phone</th>
                <th>Status</th>
                <th>UserId</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mail</th>
                <th>Phone</th>
                <th>Status</th>
                <th>UserId</th>
            </tr>
        </tfoot>
	</table>				
</div>
