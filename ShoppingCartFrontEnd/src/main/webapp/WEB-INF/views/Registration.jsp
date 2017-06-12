<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="resources/css/bootstrap.css">  
  <link rel="stylesheet" href="resources/js/bootstrap.js">  
  <link rel="stylesheet" href="resources/css/signup.css">
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign Up</div>
                       </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form action="registered" class="form-horizontal">
            <input class="form-control" name="username" placeholder="Your Name" type="text" required="required"/>
            <input class="form-control" name="emailid" placeholder="Email Id" type="text" required="required"/>
            <input class="form-control" name="password" placeholder="Password" type="password" pattern=".{5,15}" required="required"/>
            <input type="hidden">${idmessage}
            <input class="form-control" name="contact" placeholder="Your Contact No"  type="number" pattern="[789][0-9]{9}" required="required"/>
            <input class="form-control" name="role" placeholder="Role" type="text" required="true"/>
           <!--  Role: <select>
  <option value="admin">Admin</option>
  <option value="user">User</option>
  </select>     -->       
            <br />
            <button class="btn btn-lg btn-success btn-block">
                Sign Up</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>