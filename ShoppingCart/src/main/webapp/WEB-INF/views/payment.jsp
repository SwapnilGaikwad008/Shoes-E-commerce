<html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Method</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body style="padding: 0px;">

  <div class="container" style="margin-bottom: 19px">
    <center><h1 class="well">Payment Method!</h1></center>
    <div class="col-lg-6 well">
      <div class="row">

        <form:form role="form" action="${flowExecutionUrl}&_eventId=submitPaymentMethod"  commandName="paymentMethod" method="post">


         
           

    <div class="radio">
      <label><input type ="radio" name="paymentMethod" value="Net Banking">net banking</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="paymentMethod" value="cash on delivery">cod</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="paymentMethod" value="Debit card">Debit card</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="paymentMethod" value="Credit card">Credit card</label>
    </div>
  
           <div class="form-group last">
                            <div class="col-sm-offset-1 col-sm-11">
                                <input type="submit" name="_eventID_submitPaymentMethod"
                 class="btn btn-md btn-success" value="Save">
<a href="${flowExecutionUrl}&_eventId=cancel" type="button" class="btn btn-md btn-danger">Cancel</a>
                            </div>
                        </div>

        </form:form>
      </div>
    </div>
  </div>
</body>
</html>