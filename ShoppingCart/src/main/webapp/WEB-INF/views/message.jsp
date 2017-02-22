<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

html, body { height: 100%; }
body {
    margin: 0;
    background: radial-gradient(#666, #222);
    overflow: hidden;
}

.moving-zone {
    position: absolute;
    top:50%; left:50%;
    width:300px; height:120px;
    margin: -60px 0 0 -150px;
    perspective: 800px;
}
.popup {
    position: absolute;
    width:300px;
    padding: 10px;
    box-sizing: border-box;
    border-radius: 20px 0 20px 0;
    cursor: pointer;
    background: -webkit-linear-gradient(top left, white 50%, coral 50%);
    background:         linear-gradient(top left, white 50%, coral 50%);
}

.popup-content {
    background: #444;
    padding: 20px;
    box-sizing: border-box;
    border-radius: 10px 0 10px 0;
}
.popup-text {
    color: white;
    font-family: 'Roboto', sans-serif;
    font-size: 20px;
    line-height: 30px;
    font-weight: 100;
    text-align: center;
}
.popup-text b {
    color: coral;
    font-weight: 300;
}

</style>
<body>
<div class="moving-zone">
    <div class="popup">
        <div class="popup-content">
            <div class="popup-text">
               ${message}
            </div>
        </div>
    </div>
</div>
</body>
</html>