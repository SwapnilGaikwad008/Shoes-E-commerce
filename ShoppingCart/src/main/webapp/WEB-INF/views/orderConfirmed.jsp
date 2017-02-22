<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoes</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><title>shoes</title>
</head>
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