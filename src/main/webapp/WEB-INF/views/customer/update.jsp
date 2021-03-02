<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <!-- To support form binding , import spring supplied form tag lib -->
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>

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
 <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <a class="navbar-brand" href="#">W E F A S T</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a class="nav-link active" href="/customer/customerprofile">Profile</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/customer/placeorders">Place Orders </a>
                </li>
                
                <li class="nav-item ">
                    <a class="nav-link" href="/customer/myorders">My Orders </a>
                </li>

                  <li class="nav-item ">
                    <a class="nav-link" href="/customer/update">Update Profile </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/customer/delete/${sessionScope.customer_details.cid}">Delete Account </a>
                </li>
                
                
                
                
            </ul>
          

            <ul class="navbar-nav mr-right px-4">
                <li class="nav-item">
                    <a class="nav-link " href="#" > ${sessionScope.customer_details.getCemail()}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link "  href="/customer/logout">Log Out</a>
                </li>

            </ul>

        </div>
    </nav>


    <div class="container"> <br>

        
        <div class="col-lg-8 m-auto d-block"><br> 
			<div class="card-header bg-info">
                <h1 class="text-white text-center">Update Profile</h1>   
            </div>
            <form method="post" action="/customer/update/${sessionScope.customer_details.cid }" class="bg-light">
            

                <div class="form-group">
                    <label>Customer Name:</label>
                    <input  class="form-control" id="name" value="${sessionScope.customer_details.cname }" type="text" name="name"/>
                    <span id="customername" class="text-danger font-weight-bold"></span>
                </div>
                
                
                <div class="form-group">
                    <label>Email:</label>
                    <input  class="form-control" id="email"  value="${sessionScope.customer_details.cemail }"  type="text" name="email"/>
                    <span id="emailid" class="text-danger font-weight-bold"></span>
                </div>
                

                <div class="form-group">
                    <label>MobileNo:</label>
                   <input type="text" class="form-control" id="mobile"  value="${sessionScope.customer_details.cmobile }"  name="mobile"/>
                    <span id="MobileNo" class="text-danger font-weight-bold"></span>
                </div>
                
                <div class="form-group">
                    <label>Address:</label>
                    <input class="form-control" id="address"  value="${sessionScope.customer_details.caddress }"  type="text" name="address"/>
                    <span id="address" class="text-danger font-weight-bold"></span>
                </div>
                
                <div class="form-group">
                    <span  class="text-danger font-weight-bold">${requestScope.message} </span>
                </div>

                
                <input class="btn btn-success" onClick="return validation();" type="submit" name="submit" value="update">
            </form>
        </div>
    </div>

     <script >
     
     function validation() {
         var user = document.getElementById('name').value;
         var pass = document.getElementById('pass').value;
         var conpass = document.getElementById('conpass').value;
         var mobile = document.getElementById('mobile').value;
         var email = document.getElementById('email').value;

         
         if (user == "") {
             document.getElementById('customername').innerHTML = "**you must enter your username";
             return false;
         }
         if (user.length <= 2 || user.length > 20) {
             document.getElementById('customername').innerHTML = "**please enter username between 2 to 20 character";
             return false;
         }

         if (!isNaN(user)) {
             document.getElementById('customername').innerHTML = "**only characters are allowed";
             return false;
         }
         
         
         if (email == "") {
             document.getElementById('emailid').innerHTML = "**you must enter your email";
             return false;
         }

         if(email.indexOf('@') <= 0) {
             document.getElementById('emailid').innerHTML = "**@ is at invalid position ";
             return false;
         }

         if((email.charAt(email.length-4)!='.') && (email.charAt(email.length-3) != '.')) {
             document.getElementById('emailid').innerHTML = "**. is at invalid position ";
             return false;
         }

        
         if (pass == "") {
             document.getElementById('Password').innerHTML = "**you must enter your password";
             return false;
         }

         if (pass.length <= 5 || pass.length > 20) {
             document.getElementById('Password').innerHTML = "**please enter password greater than 5 and less thana 20 characterss ";
             return false;
         }

         
         if (conpass == "") {
             document.getElementById('conpassword').innerHTML = "**you must enter your confirm password";
             return false;
         }
         if (pass != conpass) {
             document.getElementById('conpassword').innerHTML = "**passwords are not matching";
             return false;

         }

        
         if (mobile == "") {
             document.getElementById('MobileNo').innerHTML = "**you must enter your mobile no";
             return false;
         }

         if(isNaN(mobile)) {
             document.getElementById('MobileNo').innerHTML = "**you must enter digits only";
             return false;
         }

         if(mobile.length !=10) {
             document.getElementById('MobileNo').innerHTML = "**you must enter digits 10 digits";
             return false;

         }

      


     }

    </script>

</body>

</html>