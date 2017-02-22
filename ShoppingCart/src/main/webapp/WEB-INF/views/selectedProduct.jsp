<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<title>Product selected</title>
<style>
.product{
	width: 100%;
	height: 800px;
	background-color:white;
}

.product-image {
	width: 620px;
	height: 620px;
	padding-top: 40px;
	padding-left: 80px;
}

.product-details{
	width: 500px;
	height: 620px;
	background-color: white;
	float: right;
	margin-top: -580px;
    margin-right: 90px;
}

.product-details h1,h2,h3,h4,h5,p{
	margin:0;
text-transform: uppercase;
    max-width: 380px;
    letter-spacing: -1px;
    line-height: 1.1;
    padding-top: 10px;
    padding-left: 10px;
}



</style>
<body>
<c:set var="imageFolder" value="/resources/img/"/>
<div class="product">
<c:if test="${!empty selectedProduct.id}">
	<div class="product-image">
		<img src="<c:url value="${imageFolder}${selectedProduct.id}.jpg"/>"
							style="width: 620px; height: 620px;" /> 
	</div>

	<div class="product-details">
	<h1>${selectedProduct.name}</h1>
	<h5>${selectedSubcategory.name}</h5>
	<h3>price ${selectedProduct.price}</h3>
	<div style="border-bottom: 1px solid grey"></div>
	<p>${selectedProduct.description}</p>
		<br>
		<br>

<br>

<div class="col-sm-4" style="margin-left:0px;">

 <a href="<c:url value='/addToCart?productId=${selectedProduct.id}'/>" button class="btn btn-danger btn-sm">Add to cart</a>
                      </div>

                      <!-- <div class="col-sm-4" style="margin-left:0px;">

<a href="cart_checkout" button class="btn btn-success btn-sm">Checkout</a>                          
                      </div> -->

	<br>
	<br>
	<br>
			<div style="border-bottom: 1px solid grey"></div>



</div>
</c:if>
</div> 
	


</body>
</html>