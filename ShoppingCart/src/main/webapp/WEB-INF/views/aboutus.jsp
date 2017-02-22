<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoes</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $('.parallax').scrolly({bgParallax: true});
 });
 </script>
</head>
<style>
section{
  position: relative;
  width: 100% !important;
  min-height: 1000px;    
  overflow: hidden;
 }
  h1{
    color:#4F9426;  
    font-size:65px;
    line-height: 64px;
    margin-bottom:14px;
  }
  article{
    position:absolute;
    top:240px;
    left:40px;
    width:300px;
    z-index:14;
    font-size: 18px;
    line-height: 22px;
    color: gray;
  }
}
.parallax-item{
  position:absolute;
  z-index:5;
  top:40px;
  left:400px;
}

/* section:nth-of-type(1){height:1200px;}
section:nth-of-type(2){height:1600px;} */

#story-freext>div:nth-of-type(1) {
  position:absolute;
  top:0;
  left:0;
  
  width: 100%;
  height: 1600px;
  
  background: url(http://lab.victorcoulon.fr/javascript/scrolly/img/nike-bg.jpeg) 50% 0 no-repeat fixed;
}

#story-freext>div:nth-of-type(2) {
  position:absolute;
  top:0px;
  left:100px;
  
  width: 100%;
  height: 1600px;
  
  background: url(http://lab.victorcoulon.fr/javascript/scrolly/img/nike.png) 50% 0 no-repeat fixed;
}

#bottle>div:nth-of-type(1){
  position:absolute;
  top:0;
  left:0;
  width: 100%; 
  height: 1200px;
  
  background: url(https://wallpaperscraft.com/image/yeezy_adidas_yeezy_boost_350_sneakers_107414_1366x768.jpg) 50% 0 no-repeat fixed;
}

</style>
<body>
<section id="bottle">
  <article>
    <h1>About Us.</h1>
    <p>Our function is to provide knowledge and insights. We are the global repository for the science of human performance and potential. By Prathamesh jadhav, Senior Director of the Pudka Explore Team Sport Research Lab
.</p>
<br>
<p>Climate change is a global issue that requires global solutions. Resource scarcity, fluctuations in the prices of raw materials and disruptions to supply chains are real concerns for business. And, we understand the broader impact that climate-related issues have on the athletes we serve.

A sustainable economy is a low-carbon growth economy. Nike uses carbon as a leading indicator to assess sustainability, but we recognize sustainability goes way beyond carbon. It means addressing all our impacts on the environment and the communities where we operate, supporting labor rights in supply chains, while continuing to serve the athlete and our business.

</p>
  </article>
  <div class="parallax" data-velocity="-.3"></div>
</section>

<section id="story-freext">
  <article>
    <h1>Contact Us!</h1>
    <p>One Bowerman Drive
Beaverton, OR 97005
Phone: 1-503-671-6453
7:30 a.m. - 5:30 p.m. PT, Monday - Friday (except holidays).

</p>
    <p>No. 99, Jiangwancheng Road
Yangpu District
Shanghai 200438
Phone: +86-21-52882828

Regional operations for the Americas, Asia-Pacific and United States are located at Nike's World Headquarters location.</p>
  </article>
  <div class="parallax" data-velocity="-.1"></div>
  <div class="parallax" data-velocity="-.5" data-fit="525"></div>
</section>

</body>
</html>