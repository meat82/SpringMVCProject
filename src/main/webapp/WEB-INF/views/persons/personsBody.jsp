<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>

<div id="nav-sidepanel" class="sidenav">
	<a href="javascript:void(0)" class="closebtn">&times;</a>
	<form:form action="formProcess" method="post" modelAttribute="person">
	    <div class="form-group">
	        <label for="userName">User Name</label>
	        <input name="userName" value="${person.userName}" id="userNameId"/>
	    </div>
		<div class="form-group">
		    <label for="firstName">First Name</label>
		    <input name="firstName" value="${person.firstName}" id="firstNameId"/>
		</div>
		<div class="form-group">
		    <label for="lastName">Last Name</label>
		    <input name="lastName" value="${person.lastName}" id="lastNameId"/>
		</div>
		<div class="form-group">
		    <label for="eMail">E-Mail</label>
		    <input name="email" value="${person.eMail}" id="emailId"/>
		</div>
		<div class="form-group">
		    <label  for="phone">Phone</label>
		    <input name="phone" value="${person.phone}" id="phoneId"/>
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
