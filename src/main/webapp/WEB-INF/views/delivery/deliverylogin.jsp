<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container"> <br>

       
        <div class="col-lg-8 m-auto d-block"><br> 
        	<div class="card-header bg-info">
                <h1 class="text-white text-center">Delivery Partner Login</h1>   
            </div>

            <form method="post"   class="bg-light">
   
                <div class="form-group">
                    <label>Email:</label>
                    <input  class="form-control" id="email" type="text" name="email"/>
                    <span id="emailid" class="text-danger font-weight-bold"></span>
                </div>

                <div class="form-group">
                    <label>Password:</label>
                    <input class="form-control" id="pass" type="text" name="pass">
                    <span id="Password" class="text-danger font-weight-bold"></span>
                </div>

               
                
                <div class="form-group ">
				 <label>		
                	<a href="<spring:url value='/delivery/reg'/>">Create New Account</a>
                </label><br/> 
				  </div>
				  
				  <div class="form-group">
                    <span class="text-success font-weight-bold">${requestScope.success} </span>
                    <span class="text-danger font-weight-bold">${requestScope.error} </span>
                </div>
                
                <input class="btn btn-success" type="submit" name="submit" value="submit">
            </form>
        </div>
    </div>


</body>
</html>