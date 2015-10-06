<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>This is Test page</title>
	<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>
<body>
<h1>
	Test
</h1>

<P>  The time on the server MIKKO is ${serverTime}. </P>
<a href="${webappRoot}">Home</a>
</body>
</html>