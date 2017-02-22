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
<style>
@import "bourbon";

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  
}

.form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
    text-align:center;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;

@include box-sizing(border-box);

&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}

</style>
<body>
  <div class="wrapper">
    <form class="form-signin" action="register" method="post">       
      <h2 class="form-signin-heading">YOUR ACCOUNT FOR EVERYTHING PADUKA</h2>
       <input type="text" class="form-control" name="id" placeholder="Your Id" required="" autofocus="" /><br>
       <input type="text" class="form-control" name="name" placeholder="Name" required="" autofocus="" /><br>
      <input type="text" class="form-control" name="mail" placeholder="Email Address" required=""   pattern="[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*"  autofocus="" /><br>
      <input type="text" class="form-control" name="contact" placeholder="Contact Number" required="" pattern="[789][0-9]{9}" autofocus="" /><br>
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
      <br>

      <button class="btn btn-lg  btn-block" type="submit" value="Register" style="background-color:black;color:white">JOIN NOW</button> <br>
      <!-- <button class="btn btn-lg  btn-block" type="submit" style="background-color: #6699ff
;color:white;border-style: solid ;">JOIN NOW</button>
    --> </form>
  </div>

</body>
</html>