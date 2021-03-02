<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
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

    <div class="container"> <br>

        
        <div class="col-lg-8 m-auto  d-block"><br> 
        	<div class="card-header bg-info">
                <h1 class="text-white text-center">Create new Account here</h1>   
            </div>

            <form method="post"   class="bg-light">

                <div class="form-group">
                    <label> Name:</label>
                    <input  class="form-control" id="name" type="text" name="name"/>
                    <span id="deliveryname" class="text-danger font-weight-bold"></span>
                </div>
                
                
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

                <div class="form-group">
                    <label>Confirm Password:</label>
                    <input class="form-control" id="conpass" type="text" name="conpass"/>
                    <span id="conpassword" class="text-danger font-weight-bold"></span>
                </div>
                

                <div class="form-group">
                    <label>MobileNo:</label>
                   <input type="number" class="form-control" id="mobile"  name="mobile"/>
                    <span id="MobileNo" class="text-danger font-weight-bold"></span>
                </div>
                
                <div class="form-group">
                    <label>Area:</label>
                    <input class="form-control" id="area" type="text" name="area"/>
                    <span id="area1" class="text-danger font-weight-bold"></span>
                </div>
                
                <div class="form-group">
                    <label>License No:</label>
                    <input class="form-control" id="license" type="text" name="license"/>
                    <span id="license1" class="text-danger font-weight-bold"></span>
                </div>
                
                 <div class="form-group">
                    <span class="text-danger font-weight-bold">${requestScope.error}</span>
                </div>

                
                <input class="btn btn-success" onClick="return validation();" type="submit" name="submit" value="submit">
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
             document.getElementById('deliveryname').innerHTML = "**you must enter your username";
             return false;
         }
         if (user.length <= 2 || user.length > 20) {
             document.getElementById('deliveryname').innerHTML = "**please enter username between 2 to 20 character";
             return false;
         }

         if (!isNaN(user)) {
             document.getElementById('deliveryname').innerHTML = "**only characters are allowed";
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