<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="container">
		<div id="carttable" class="col-md-6" style="overflow: auto;">
			<h2>Total cost : Rs ${totalAmount}</h2>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>STOCK</th>
						<th>PRICE</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartList}" var="cart">
						<tr>

							<td>${cart.id}</td>
							<td>${cart.productName}</td>
							<td>${cart.stock}</td>
							<td>${cart.price}</td>
							<td><a
								href="<c:url value='/manage_cart_remove?id=${cart.id}'/>" button
								class="btn btn-danger btn-sm">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<h4>
					<a href="cart_checkout">checkout</a>
				</h4>
			</table>
		</div>
	</div>
</body>
</html>