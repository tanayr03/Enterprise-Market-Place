<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Webstore</title>

 <!--     Bootstrap Core CSS -->
    <!-- <link href="resources/css/bootstrap.min.css" rel="stylesheet"> -->
<!--     <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">    
 -->
<!--     Custom CSS -->
    <!-- <link href="resources/css/logo-nav.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">  -->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- <span class="header_logo glyphicon glyphicon-fire "></span> -->
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<c:url value="/home" />">Home</a>
                    </li>
                    <li>
                        <a href="<c:url value="/market/products" />">Products</a>
                    </li>
                   <!--  <li>
                        <a href="#">Contact</a> 
                    </li> -->
                      </ul>
                <br>
                <div class=""  align="right"> 
                <a href="<c:url value="/login" />">Login</a> |
                <a href="<c:url value="/register" />">Register</a>
                 </div>
            </div>
        </div>
    </nav>

    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/tanay.js"></script>

</body>

</html>
