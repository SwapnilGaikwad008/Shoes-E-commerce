<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Category</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 </head>
<body>
<body>
${message }
<div class="container" >

  <h1 class="well center"><center>Edit Product</center></h1>
  <div class="col-lg-12 well">
    <div class="row">
    <form  action="addproduct" method="post" commandName="product" enctype="multipart/form-data" > 
      <div class="col-sm-12">
        <div class="row">
          <div>
            <center><h2>Product Details</h2></center>
          </div>
          <div class="col-sm-6 form-group">
              <h4>ID</h4>
                <input type="text"  name="id" placeholder="ID" required value=${product.id}></input>
              </div>

              <div class="col-sm-6 form-group">
              <h4>Name</h4>
                <input type="name"  name="name" placeholder="Name" required value=${product.name}></input>
              </div>
           <div class="col-sm-6 form-group">
              <h4>Stock</h4>
                <input type="number"  name="stock" placeholder="Stock" required value=${product.stock}></input>
              </div>


               <div class="col-sm-6 form-group">
              <h4>Price</h4>
            <input type="number"  name="price" placeholder="Price" required value=${product.price}></input>
              </div>

                 <div class="col-sm-6 form-group">
              <h4>Category Name</h4>
                 <input type="text"  name="category_id" placeholder="ID" required value=${product.category.name}></input>
              </div>

              <div class="col-sm-6 form-group">
              <h4>Supplier Name</h4>
                <input type="text"  name="supplier_id" placeholder="ID" required value=${product.supplier.name}></input>
              </div>


              <div class="col-sm-12 form-group">
              <h4>Description</h4>
                <textarea type="name" name="description" placeholder="Description" required> ${product.description}</textarea>
              </div>
              
              <div class="col-sm-6 form-group">
              <h4>Image</h4>
                <input type="file"  name="image"  CommandName="product" path="image" method="post" >
              </div>

            <div class="form-actions">
              <button type="submit" class="btn  btn-lg btn ">Edit Product</button>
            </div>

        </div>
      </div>
    </form>

    <div class="form-actions " style="float: right">
              <button type="submit" class="btn  btn-lg btn "><a href="producttable">View Product</button>
            </div>
      
    </div>
  </div>
</div>

</html>