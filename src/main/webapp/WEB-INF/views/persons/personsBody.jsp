<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>

<div id="nav-sidepanel" class="sidenav">
	<a href="javascript:void(0)" class="closebtn">&times;</a>
	<form:form action="formProcess" method="post" modelAttribute="person">
	    <div class="form-group">
	        <label for="userName">User Name</label>
	        <form:input path="userName" class="form-control" id="userNameId"/>
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
	</form:form>
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
            </tr>
        </tfoot>
        <tbody>
        	<c:forEach var="personObject" items="${persons}" varStatus="status">
        		<tr>
        			<c:set var="userIdIndex" value="person_${status.index}"/>
        			<td id="${userIdIndex}" class="userName">
        				<input type="hidden" name="id" id="${userIdIndex}_hidden" value="${personObject.userId}">
        				<a>${personObject.userName}</a>
        			</td> 
        			<td>${personObject.firstName}</td>
        			<td>${personObject.lastName}</td>
					<td>${personObject.eMail}</td>
					<td>${personObject.phone}</td>
					<td>${personObject.status}</td>
        		</tr>
        	</c:forEach>
		</tbody>
	</table>				
</div>
