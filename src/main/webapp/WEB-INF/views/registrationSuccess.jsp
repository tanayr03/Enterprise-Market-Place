<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet"> 

</head>

<body>
<header>
        <jsp:include page="/WEB-INF/views/header/header.jsp"/>
 </header><br>

<div class="container">
<div align="center">

<h2>
<a href="<c:url value="home" />">
<span class="header_logo glyphicon glyphicon-fire " ></span><br>Kudize
</a>
</h2>
</div>

<%-- <form:errors path="user.*"></form:errors> --%>

    <h2>Success</h2>
    <p>Welcome ${username}</p>
    

</div>
<!-- /container -->
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
<script src="resources/js/tanay.js"></script>
</body>
</html>