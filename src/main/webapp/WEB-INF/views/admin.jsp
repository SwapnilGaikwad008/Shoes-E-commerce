<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
 <jsp:include page="adminHome.jsp" />



 <c:if test="${UserClickedCATEGORY}">
	<jsp:include page="category.jsp" />
	</c:if>

	
 <c:if test="${UserClickedViewCategoryTable}">
		<jsp:include page="categorytable.jsp" />
	</c:if>
	
	
	 <c:if test="${UserClickedEDIT}">
		 <jsp:include page="editcategory.jsp" />
	</c:if>
	
	<c:if test="${EditCategory }">
	<jsp:include page="editcategory.jsp" />
	</c:if>
	
   <c:if test="${UserclickedEDIT }">
	<jsp:include page="editsupplier.jsp" />
	</c:if>
	<c:if test="${EditSupplier }">
	<jsp:include page="editsupplier.jsp" />
	</c:if>
	
	<c:if test="${UserClickedSUPPLIER}">
		<jsp:include page="supplier.jsp" />
	</c:if>
	
	
	 <c:if test="${UserClickedViewSupplierTable }">
		<jsp:include page="suppliertable.jsp" />
	</c:if>
	
	<c:if test="${UserClickedPRODUCT}">
	<jsp:include page="product.jsp" />
	</c:if>
	
	<c:if test="${UserClickedViewProductTable}">
	<jsp:include page="producttable.jsp" />
	</c:if>
	
	<c:if test="${UserClickedProduct}">
	<jsp:include page="product.jsp" />
	</c:if>
	
	<c:if test="${UserClickedPRODUCTEDIT}">
	<jsp:include page="editproduct.jsp" />
	</c:if>
	
	<c:if test="${EditProduct}">
	<jsp:include page="editproduct.jsp" />
	</c:if>
	
	<c:if test="${UserClickedSUBCATEGORY}">
		<jsp:include page="subcategory.jsp" />
	</c:if>


	<c:if test="${UserClickedViewSubCategoryTable}">
		<jsp:include page="subcategorytable.jsp" />
	</c:if>


	<c:if test="${UserClickedSubCategoryEDIT}">
		<jsp:include page="editsubcategory.jsp" />
	</c:if>

	<c:if test="${EditSubCategory }">
		<jsp:include page="editsubcategory.jsp" />
	</c:if>
	
	

	
</body>
</html>