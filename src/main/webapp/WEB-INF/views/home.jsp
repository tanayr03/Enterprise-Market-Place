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
 </header>
<div class="container">
<br>
<div align="center">

<h2>
<a href="<c:url value="home" />">
<span class="header_logo glyphicon glyphicon-fire " ></span><br>Kudize
</a>
</h2>
</div></div>
</body>
</html>