<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Bar</title>
</head>
<body>
<div class="container">
 	<c:set var="count"  value="0"/>
	<h3 class="text-center"> Searched Products  ${searchName}</h3>
 	<hr>
 	<c:choose>
  	  	<c:when test="${productList.size()==0}">
    		<div class="alert alert-danger text-center">No products available with this search criteria.</div>
 		</c:when>
 		<c:otherwise>
 			<div class="col-md-10 col-md-offset-1">
 				<div class="row">
 					<c:forEach var="product" items="${productList}">
 					<div class="col-md-6">
							<div class="row">
									<a href="show_product/get/${product.id}">									
	         <div class="col-sm-3" style="margin-left:70px;padding-bottom:10px">
               <img src="resources/img/${product.id}.jpg" height="220" width="220" style="padding:5px;border-bottom:1px solid grey">           
       <h4>${product.name}</h4></a>
                  <c:if test="${loggedOut == false}">
                   <a href="show_product/get/${product.id}"> <h4>price ${product.price}</h4></a>
					<a href="<c:url value='/addToCart?productId=${product.id}'/>">Add to cart</a>
				 </c:if> 
               </div>
		        	</div>
						</div>
						<c:set var="count"  value="${count+1}"/>
						<c:if test="${count==6}">
								</div>
								<div class="row">
								<c:set var="count"  value="0"/>
						</c:if>
					</c:forEach>
 				</div>
 			</div> 
		 </c:otherwise>
	</c:choose>
</div>
</body>
</html>