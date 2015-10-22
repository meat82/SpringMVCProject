<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>User Management</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	<link href="<c:url value="/views/resources/css/common.css" />" rel="stylesheet">
  	<link href="<c:url value="/views/resources/css/footer.css" />" rel="stylesheet">
   	<!-- for FF, Chrome, Opera -->
  	<link rel="icon" type="image/png" href="<c:url value="/views/resources/images/blogmarks-icon-16x16.png" />" sizes="16x16">
  	<link rel="icon" type="image/png" href="<c:url value="/views/resources/images/blogmarks-icon-32x32.png" />" sizes="32x32">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div class="jumbotron">
				<h1>Mikko Torvinen</h1> 
			  	<p>Demo Enviroment</p>
			</div>
		</div>
		<div id="content">
			<div style="width:30%;" ng-hide="toggleAddUser">
		    	<form:form action="formProcess" method="post">
		            <div class="form-group">
		                <label for="firstName">First Name</label>
		                <form:input path="firstName" cssClass="form-control"/>
		            </div>
		            <div class="form-group">
		                <label for="lastName">Last Name</label>
		                <form:input path="lastName" cssClass="form-control"/>
		            </div>
		            <div class="form-group">
		                <label for="userId">User Id</label>
		                <form:input path="userId" cssClass="form-control"/>
		            </div>
		            <div class="form-group">
		                <label for="eMail">E-Mail</label>
		                <form:input path="eMail" cssClass="form-control"/>
		            </div>
		            <div class="form-group">
		                <label for="password">Password</label>
		                <form:input path="passWord" cssClass="form-control"/>
		            </div>
					<td><button type="submit">Submit</button></td>
		        </form:form>
		    </div>
	    </div>
		<footer  class="footer">
			<div class="container">
				<h2>Place footer text here</h2>
			</div><!-- .box -->
		</footer ><!-- #footer -->
    </div>
</body>
</html>