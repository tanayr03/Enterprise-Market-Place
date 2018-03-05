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

    <form:form method="POST" modelAttribute="user" action="register" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group">
                <form:input type="text" path="username" class="form-control" placeholder="Username*" autofocus="true"></form:input>
                <font color="red"><form:errors path="username"></form:errors></font> 
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group">
                <form:input type="password" path="password" class="form-control" placeholder="Password*"></form:input>
                <font color="red"><form:errors path="password"></form:errors></font> 
            </div>
        </spring:bind>
        
        <spring:bind path="email">
            <div class="form-group">
                <form:input type="email" path="email" class="form-control" placeholder="Email*"></form:input>
                <font color="red"><form:errors path="email"></form:errors></font> 
            </div>
        </spring:bind>
        
        <spring:bind path="firstname">
            <div class="form-group">
                <form:input type="text" path="firstname" class="form-control" placeholder="firstname"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="lastname">
            <div class="form-group">
                <form:input type="text" path="lastname" class="form-control" placeholder="lastname"></form:input>
                <form:errors path="lastname"></form:errors>
            </div>
        </spring:bind>
        
         <spring:bind path="phone">
            <div class="form-group">
                <form:input type="text" path="phone" class="form-control" placeholder="phone"></form:input>
                <form:errors path="phone"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
<script src="resources/js/tanay.js"></script>
</body>
</html>