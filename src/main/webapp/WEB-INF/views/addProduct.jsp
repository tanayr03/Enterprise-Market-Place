<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>

</head>
<body>
<header>
        <jsp:include page="/WEB-INF/views/header/header.jsp"/>
</header>
      <section> 
         <div class="pull-right" style="padding-right:50px"> 
            <a href="?siteLanguage=en" >English</a> ||
            <a href="?siteLanguage=nl" >Dutch</a>                
         </div> 
      </section>
      
	<section>
		<div class="jumbotron">
			<div class="container">
				<!-- <h1>Products</h1> -->
				<h1>Add a product</h1>
			</div>
		</div>
	</section>
	
	<section class="container">
		<form:form method="POST" action="/springexample2/market/products/addTheProduct" modelAttribute="newProduct" class="form-horizontal" enctype='multipart/form-data'>
			<fieldset>
				<legend>Add new product</legend>	
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit Price</label>
					<div class="col-lg-10">
						<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="3" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
					<div class="col-lg-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
					<div class="col-lg-10">
						<form:input id="category" path="category" type="text" class="form:input-large" />
					</div>
				</div>
				
				<%-- <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="img">Upload Image</label>
					<div class="col-lg-10">
						<form:input id="img" path="img" type="file" class="form:input-large" />
					</div>
				</div>  --%>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition"> Condition </label>
				
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" /> New
						<form:radiobutton path="condition" value="Old" /> Old
						<form:radiobutton path="condition" value="Refurbished" /> Refurbished
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>