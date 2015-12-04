<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css">
  <!-- Be carefull to add jQuery before datatables *.js -->
  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
  <link href="<c:url value="/views/resources/css/common.css" />" rel="stylesheet">
  <link href="<c:url value="/views/resources/css/footer.css" />" rel="stylesheet">
  <!-- for FF, Chrome, Opera -->
  <link rel="icon" type="image/png" href="<c:url value="/views/resources/images/blogmarks-icon-16x16.png" />" sizes="16x16">
  <link rel="icon" type="image/png" href="<c:url value="/views/resources/images/blogmarks-icon-32x32.png" />" sizes="32x32">
  <title>Demo stuff</title>
</head>
	<body>
		<script type="text/javascript">
			$(document).ready(function() {
			    $('#person').DataTable();
			} );
		</script>
		<div id="wrapper">
			<div id="header">
				<div class="jumbotron">
			  		<h1>Mikko Torvinen</h1> 
			  		<p>Demo Environment</p>
					<a href="home">Home</a>
				</div>
			</div>
			
			<div id="content">
			<table id="person" class="display" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>First Name</th>
		                <th>Last Name</th>
		                <th>Mail</th>
		                <th>Phone</th>
		                <th>Status</th>
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
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
			<footer  class="footer">
				<div class="container">
					<h2>Place footer text here</h2>
				</div><!-- .box -->
			</footer ><!-- #footer -->
		</div>
	</body>
</html>