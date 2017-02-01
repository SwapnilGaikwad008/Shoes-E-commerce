<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body style="padding: 0px;">

  <div class="container" style="margin-bottom: 19px">
    <center><h1 class="well">Address Details!</h1></center>
    <div class="col-lg-12 well">
      <div class="row">

        <form:form role="form" action="${flowExecutionUrl}&_eventId=submitBillingAddress"  commandName="billingAddress" method="post">


         <center>   <Strong>Billing Address:</Strong></center>
            <br>
            <div class="form-group">
              <label for="address">Address</label>
              <form:textarea type="text" class="form-control"
                path="line1" ></form:textarea>
            </div>
            <div class="row">
              <div class="col-sm-6 form-group">
                <label for="city">City</label>
                <form:input type="text" class="form-control"
                  path="city" ></form:input>
              </div>
              <div class="col-sm-6 form-group">
                <label for="state">State</label>
                <form:input type="text" class="form-control"
                  path="state" ></form:input>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6 form-group">
                <label for="country">Country</label>
                <form:input type="text" class="form-control"
                  path="country" ></form:input>
              </div>
              <div class="col-sm-6 form-group">
                <label for="zipcode">Zipcode</label>
                <form:input type="text" class="form-control"
                  path="zipcode"  pattern="^[1-9][0-9]{5}$"  ></form:input>
              </div>
            </div>
            <input type="hidden" name="_flowExecutionKey" />

            <div class="form-actions">
              <button type="Submit" class="btn btn-lg btn-info "
                name="_eventID_submitBillingAddress" style="margin-right: 44px; margin-left: 0px;color: white;background-color: grey">Next</button>
              <a href="${flowExecutionUrl}&_eventId=cancel" class="btn btn-lg btn-default" name="_eventId_cancel" type="button">Cancel</a>
            </div>

          </div>
        </form:form>
      </div>
    </div>
  
</body>
</html>