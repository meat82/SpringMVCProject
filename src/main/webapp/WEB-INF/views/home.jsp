<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link href="<c:url value="/views/resources/css/common.css" />" rel="stylesheet">
  <link href="<c:url value="/views/resources/css/footer.css" />" rel="stylesheet">
  <!-- for FF, Chrome, Opera -->
  <link rel="icon" type="image/png" href="<c:url value="/views/resources/images/blogmarks-icon-16x16.png" />" sizes="16x16">
  <link rel="icon" type="image/png" href="<c:url value="/views/resources/images/blogmarks-icon-32x32.png" />" sizes="32x32">
  <title>Demo stuff</title>
</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div class="jumbotron">
			  		<h1>Mikko Torvinen</h1> 
			  		<p>Demo Environment</p>
				</div>
			</div>
			
			<div id="content">
			
				<div class="row"></div>
				
				<div class="col-md-4">
				  <h2><a href="angular">Angular.js Demo</a></h2>
				  <p>Web service demo using Angular JS</p>
				</div>
				
				<div class="col-md-4">
				  <h2><a href="form">Spring MVC</a></h2>
				  <p>Simple form demo using Spring MVC</p>
				</div>
				
				<div class="col-md-4">
				  <h2>About me!</h2>
				  <p>Click to see short description about me</p>
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