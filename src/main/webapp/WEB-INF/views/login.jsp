<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
</div></div>
<form:form method="POST" modelAttribute="login" action="login" class="form-signin">
        <p>Login</p>
        <spring:bind path="username">
            <div class="form-group">
                <form:input type="text" path="username" class="form-control" placeholder="Username*" autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group">
                <form:input type="password" path="password" class="form-control" placeholder="Password*"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        
    </form:form>
    
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>