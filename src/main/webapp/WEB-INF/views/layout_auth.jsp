<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
 	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<!-- Be carefull to add jQuery before datatables *.js -->
	<script src="<c:url value="external/jquery/jquery.js" />"></script>
	<script src="<c:url value="jquery-ui.js" />"></script>
	<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
	<script src="https://cdn.datatables.net/select/1.2.2/js/dataTables.select.min.js"></script>
	<script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js"></script>
	<script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
	<script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
	<script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
	<script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <tiles:insertAttribute name="commonStylecss" />
    <tiles:insertAttribute name="customCss" />
    <script type="text/javascript"><tiles:insertAttribute name="headJS" /></script>
</head>
	<body>
		<div class="layout_header">
			<tiles:insertAttribute name="header" />
		</div>
        <div class="layout_body_auth">  
        	<tiles:insertAttribute name="body" />
        </div>
        <div class="layout_footer">
        	<tiles:insertAttribute name="footer" />
        </div>
		<tiles:insertAttribute name="scriptjsp" />
	</body>
</html>