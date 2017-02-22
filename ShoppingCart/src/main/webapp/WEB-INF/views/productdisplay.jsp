<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<style>
body{
margin:0;
}
h4{
padding:0;
margin:0;
font-family: san-serif;
}
</style>
<body>


<div class="row" style="margin:0">

    			<c:forEach items="${productListBySubCategory}" var="product">
        <div class="col-sm-3" style="margin-left:70px;padding-bottom:10px">
               <img src="resources/img/${product.id}.jpg" height="220" width="220" style="padding:5px;border-bottom:1px solid grey">           
       <h4>${product.name}</h4>
                  
                   <a href="show_product/get/${product.id}"> <h4>price ${product.price}</h4></a>
					<%-- <a href="<c:url value='/addToCart?productId=${product.id}'/>">Add to cart</a> --%>
			
               </div>
       </c:forEach>
</div>

</body>
</html>
