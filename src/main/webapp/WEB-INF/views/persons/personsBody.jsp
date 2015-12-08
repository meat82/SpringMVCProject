<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<div id="content">
	<table id="person" class="display" style="width: 100%;">
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
        	<c:forEach var="user" items="${persons}">
        		<tr>
        			<td>${user.userName}</td>
        			<td>${user.firstName}</td>
        			<td>${user.lastName}</td>
					<td>${user.eMail}</td>
					<td>${user.phone}</td>
					<td>${user.status}</td>
        		</tr>
        	</c:forEach>
		</tbody>
	</table>				
</div>
