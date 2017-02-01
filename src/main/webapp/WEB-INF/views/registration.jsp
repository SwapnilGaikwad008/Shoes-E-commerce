<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Register</title>
	 <meta charset="utf-8">
	 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container" >
	<h1 class="well center"><center>Register</center></h1>
	<div class="col-lg-12 well">
		<div class="row">
		<form  action="register">
			<div class="col-sm-12">
				<div class="row">
					<div>
						<center><h2>USER DETAILS</h2></center>
					</div>
					<div class="col-sm-6 form-group">
							<h4>User ID</h4>
								<input type="text" placeholder="Enter First Name.."
									class="form-control" name="id" ></input>
							</div>

							<div class="col-sm-6 form-group">
							<h4>Name</h4>
								<input type="text" placeholder="Enter Name.."
									class="form-control" name="name" ></input>
							</div>
							
							</div>

						<div class="row">
							<div class="col-sm-6 form-group">
							<h4>E-mail ID</h4>
								<input type="text" placeholder="Enetr E-mail Id"
									class="form-control" name="mail" ></input>
							</div>

							<div class="col-sm-6 form-group">
							<h4>Contact Number</h4>
								<input type="text" placeholder="Enter Contact Number.."
									class="form-control" name="contact" ></input>
							</div>
						</div>	
                        


                        <div class="row">
                        	<div class="col-sm-6 form-group">
							<h4>Password</h4>
								<input type="password" placeholder="Enter Password.."
									class="form-control" name="password" ></input>
							</div>                
        
						</div>

						<div class="form-actions">
							<center><button type="submit" class="btn  btn-lg btn " value="Register">Submit</button></center>
						</div>

				</div>
			</div>
		</form>
			
		</div>
	</div>
</div>
</body>
</html>
