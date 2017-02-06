<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoes</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
      height: 500px;
  }
  
  
    .image { 
   position: relative; 
   width: 600px;
}

h2 { 
   position: absolute; 
   top: 200px; 
   left: 0; 
   width: 100%; 
   margin-left: 10px;
   padding: 10px;
}

  
</style>

<body>


  <!-- carosouel -->
 
<div class="container" style=" width: 100%;padding: 0px;margin-top:-39.5px">
  <br>
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="<c:url value="/resources/img/Metcon.jpg"/>" alt="shoes" width="460" height="345">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/img/OffCourt.jpg"/>" alt="shoes" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/img/Sneakers.jpg"/>" alt="shoes" width="460" height="345">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/img/HP.jpg"/>" alt="shoes" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



  
<div class="image">

      <img src="<c:url value="/resources/img/Mid1.jpg"/>" alt="" style="width: 1349Px;" />
      

      <h2>INTRODUCING
HYPERVENOM 3<br>

<div class="dropdown">
  <button class="btn btn-Default dropdown-toggle" type="button" data-toggle="dropdown">Mens shop Now
  <span class="caret"></span></button>
  <c:forEach items="${productListBySubCategory}" var="product">
  <ul class="dropdown-menu" aria-labelledby="dLabel-${category.name}" >
    <c:forEach items="${subcategoryList}" var="subcategory">
              <li><a href="<c:url value='/displayProduct?categoryId=${category.id}&subCategoryId=${subcategory.id}'/>">${subcategory.name}</a></li>
            </c:forEach>
  </ul>
  </c:forEach>
</div></h2>

</div>

<script type="text/javascript">
  $(function() {
    
    $("h2")
        .wrapInner("<span>")

    $("h2 br")
        .before("<span class='spacer'>")
        .after("<span class='spacer'>");

});
</script>




</body>
</html>