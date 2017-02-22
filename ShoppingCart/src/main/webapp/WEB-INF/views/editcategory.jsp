<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Edit Category</title>
   <meta charset="utf-8">
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
 ${message }
<div class="container" >
  <h1 class="well center"><center>Edit category</center></h1>
  <div class="col-lg-12 well">
    <div class="row">
    <form  action="editcategory" method="post">
      <div class="col-sm-12">
        <div class="row">
          <div>
            <center><h2>Category Details</h2></center>
          </div>
          <div class="col-sm-6 form-group">
              <h4>ID</h4>
                <input type="text" placeholder="Enter ID.."
                  class="form-control" name="id" required value=${category.id}></input>
              </div>

              <div class="col-sm-6 form-group">
              <h4>Name</h4>
                <input type="text" placeholder="Enter Name.."
                  class="form-control " name="name" required value=${category.name}></input>
              </div>
              
              </div>     

                        <div class="row">
                          <div class="col-sm-12 form-group">
              <h4>Description</h4>
                <textarea type="text" placeholder="Enter Description"
                  class="form-control" name="description" required >${category.description}</textarea>
              </div>
                        </div>

                 

            <div class="form-actions">
              <button type="submit" class="btn  btn-lg btn ">Edit Category</button>
            


           
            </div>

        </div>
      </div>
    </form>

     <div class="form-actions " style="float: right">
              <button type="submit" class="btn  btn-lg btn "><a href="categorytable">View Category</button>
            </div>
      
    </div>
  </div>
</div>

</body>
</html>