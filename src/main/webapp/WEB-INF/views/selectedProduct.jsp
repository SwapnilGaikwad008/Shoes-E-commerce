<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <c:set var="imageFolder"  value="/resources/img/"/>
    <div class="container">
<div class="row">
           <div class="col-xs-12 col-sm-6">
                <img alt="${selectedProduct.product.id}" src="<c:url value="${imageFolder}${selectedProduct.product.id}.jpg " />" style="height:320; width:250">
             </div>
        <div class="col-xs-6 col-md-5">
               Price: ${selectedProduct.price}<br><br>
<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#discription" >Description</button>
 <div id="discription" class="collapse">
 Description: ${selectedProduct.description}</div><br><br>
               <a  class="btn btn-lg btn-success" href="cart_checkout">Buy</a><br><br>
               <c:if test="${not empty loggedInUser}">
               <a class="btn btn-lg btn-success" class="icon-shopping-cart" href="<c:url value='/cart_add?productName=${selectedProduct.product.id}'/>">Add to cart</a>
            </c:if>
      </div></div>
               
      </div>

</body>
</html>