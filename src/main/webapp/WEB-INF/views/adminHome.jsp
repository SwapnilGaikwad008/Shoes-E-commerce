<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
 </nav>
<nav class="navbar navbar-default">
		<div class="container-fluid">
		<div class="navbar-header">
      	<a class="navbar-brand" href="#">ADMIN</a>
    	</div>

			<ul class="nav navbar-nav">
  	 <li><a style="font-size: 20px;" href="usertable">Manage</a></li>
   <li><a style="font-size: 20px;" href="category">Category</a></li>
   <li><a style="font-size: 20px;" href="subcategory">SubCategory</a></li>
   <li><a style="font-size: 20px;" href="supplier">Supplier</a></li>
    <li><a style="font-size: 20px;" href="product">Product</a></li>

    	<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>

       </ul>
       
    </div>
</nav>  
</body>

</html>