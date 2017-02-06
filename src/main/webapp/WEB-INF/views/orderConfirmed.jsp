<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html> 
<html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <!-- Css -->
<spring:url value="/resources/css" var="css" />
<spring:url value="/Resources/Images" var="images" />
<!--  Javascript -->
<spring:url value="/resources/js" />
 --%>
 <!-- Latest compiled and minified CSS -->
<link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/lib/js/jquery.js" />"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/lib/js/bootstrap.js" />"></script>
<!-- Font-awesome -->
<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
	


<head>

</head>

<body>
<div class="container">
 <div class="row">
 <div class="col-xs-6 col-md-6">
 <br><br><br><br><br>
 </div>
 <div class="col-xs-6 col-md-5">
    <br><br><br><br><br><br><br><br><br><br>
     <i><h3>  Your order is confirmed.</h3>
      <p> <h3> Thank You For Visiting  </h3>
       <p> <h1>Your Product will be delivered in 10 days</h1></i><br>
      <form:form action="${flowExecutionUrl}&_eventId=finalIndex"><input type= "submit" value="Continue Shopping"   class="btn btn-md btn-success"/></form:form>
     </div>
    </div>
  </div>
 
</body>
</html>