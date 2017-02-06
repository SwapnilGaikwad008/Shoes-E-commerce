<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping Cart</title>
</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>



	${successMsg}
		
	<c:if test="${!empty selectedProduct.name}">
	<%@ include file="selectedProduct.jsp" %>
	</c:if>
	
	 <c:if test="${ShowMainPage}">
				<jsp:include page="mainpage.jsp" />
			</c:if>
	

	<c:if test="${ShowLoginPage}">
		<jsp:include page="login.jsp" />
	</c:if>

	<c:if test="${ShowRegistrationPage}">
		<jsp:include page="registration.jsp" />
	</c:if>


	<c:if test="${ShowProductsForSubCategory}">
		<jsp:include page="productdisplay.jsp" />
	</c:if>


	

	<c:if test="${ShowCartTable}">
		<jsp:include page="carttable.jsp" />
	</c:if>
	
	
</body>
</html>