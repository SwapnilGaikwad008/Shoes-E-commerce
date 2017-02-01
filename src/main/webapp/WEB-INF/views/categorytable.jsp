<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container"> 
<div class="col-md-6">            
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
         <th>EDIT</th>
          <th>DELETE</th>
      </tr>
    </thead>
   <tbody>
   <c:forEach items="${CategoryList}" var="category">
        <tr>
        
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="<c:url value='/manage_category_edit?id=${category.id }'/>" button class="btn btn-success btn-sm">Edit</a></td>
            <td><a href="<c:url value='/manage_category_remove?id=${category.id }'/>" button class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>   
  </table>
</div>

</body>
</html>