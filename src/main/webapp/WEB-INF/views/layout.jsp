<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
 	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<!-- Be carefull to add jQuery before datatables *.js -->
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <tiles:insertAttribute name="commonStylecss" />
    <script type="text/javascript"><tiles:insertAttribute name="headJS" /></script>
</head>
	<body>
		<div>
			<tiles:insertAttribute name="header" />
		</div> 
        <div style="float:left;padding:10px;width:15%;">
        	<tiles:insertAttribute name="menu" />
        </div> 
        <div style="float:left;padding:10px;width:80%;border-left:1px solid pink;">  
        	<tiles:insertAttribute name="body" />
        </div>
        <div>
        	<tiles:insertAttribute name="footer" />
        </div>
		<tiles:insertAttribute name="scriptjsp" />
	</body>
</html>