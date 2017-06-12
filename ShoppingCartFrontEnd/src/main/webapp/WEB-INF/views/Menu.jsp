<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <link rel="stylesheet" href="resources/css/bootstrap.css"> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> 
  <link rel="stylesheet" href="resources/js/bootstrap.js"> -->
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<script>

</script>
<nav class="navbar navbar-inverse">
<div class="navbar-header">
     <a class="navbar-brand" href="Home">Mobilekart</a>
    </div>
  <div class="container-fluid">
    <ul class="nav navbar-nav">
        <c:forEach var="category" items="${categoryList}">
    
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
    <ul class="dropdown-menu">
								<c:forEach var="product" items="${productList}">
									<c:if test="${product.category_id == category.id}">
										<li><a href="viewProduct/${product.id}">${product.name}</a></li>
									</c:if>

									<!-- <li><a href="#">${product.name}</a></li> -->
								</c:forEach>
 

							</ul></li>
     <!--    <ul class="dropdown-menu">
           <li><a href="${productList}"></a></li>
           <li><a href="#">TV</a></li>
          <li><a href="#">Refrigerator</a></li> -->
       
    </c:forEach>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
    <c:when test="${isUserLoggedIn=='true'}">
    <li><a href="myCart">Cart</a></li>
    <li><a href="SignOut"><i class="fa fa-sign-out" aria-hidden="true"></i>${userName} SignOut </a></li>
    </c:when>
    <c:when test="${isAdmin=='true'}">
    <li><a href="SignOut"><i class="fa fa-sign-out" aria-hidden="true"></i> SignOut </a></li>
    </c:when>
    <c:otherwise>
      <li><a href="RegistrationPage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="LoginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:otherwise>
      </c:choose>
          </ul>
  </div>
</nav>
</body>
</html>