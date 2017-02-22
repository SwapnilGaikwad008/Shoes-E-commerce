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
<style>
#footer{
	position: absolute;
	width: 100%;
	height: 300px;
	background-color: black;
}

#footer-logo{
	margin-left: 10px;
	width: 100px;
	height: 100px;
}
#footer-text{
	color: white;
	font-family: 'Raelway',sans-serif;
	text-align: inherit;
	font-weight: bold;
	margin-left: 100px;
	margin-top: -55px;
	margin-left:120px;
	text-transform: uppercase;
	letter-spacing: 0.1em;
}

#footer_links{
	position: absolute;
	width: 100%;
	height: 50px;
}
.footer-links{
	display: inline;
	font-family: sans-serif;
	color: White;
	text-decoration: none;
	padding: 5px;
	margin: 12px;
	margin-top: -30px;
	float: right;
}

.footer-links:hover{
	background-color: rgba(0, 0, 0, 0.2);
}

#footer_social{
	position: absolute;
	width: 600px;
	height: 140px;
	bottom: 20px;
	left: 50%;
	margin-left: -330px;
}

#join_us{
	font-family: 'Raelway',sans-serif;
	font-size: 18px;
	text-align: center;
	font-weight: bold;
	margin-top: 0;
	color:white;
}

#social_links_div{
	position: absolute;
	width: 500px;
	height: 50px;
	left: 50px;
	margin-left: -250px;
}
.social_links:link{
	 margin-left: 25px;


}


</style>
<body>

<div id="footer">
	<img id="footer-logo" src="<c:url value="/resources/img/logo.jpg"/>" id="logo">
	<p id="footer-text">Let Your Style Speaks About You</p>
        <div id=footer_links>
		<a href="login" class="footer-links">log in</a>
  		<a href="registration" class="footer-links">Sign up</a>
  		</div>
  		<div id="footer_social">
  		<p id="join_us">Join us On</p>
  		<div id="social_links">
  			<a href="https://www.instagram.com/?hl=en" class="social_links"><img src="<c:url value="/resources/img/instagram.jpg"/>">
  			</a>
  			<a href="https://www.facebook.com/" class="social_links"><img src="<c:url value="/resources/img/facebook.jpg"/>">
  			</a>
  			<a href="https://www.tumblr.com/" class="social_links"><img src="<c:url value="/resources/img/tumblr.jpg"/>">
  			</a>
  			<a href="https://twitter.com/login" class="social_links"><img src="<c:url value="/resources/img/twitter.jpg"/>">
  			</a>
  			<a href="https://plus.google.com/" class="social_links"><img src="<c:url value="/resources/img/google.jpg"/>">
  			</a>
  			<a href="https://www.whatsapp.com/" class="social_links"><img src="<c:url value="/resources/img/whatsapp.jpg"/>">
  			</a>
  		</div>
  		
  		
	
</div>

	
</div>
</body>
</html>