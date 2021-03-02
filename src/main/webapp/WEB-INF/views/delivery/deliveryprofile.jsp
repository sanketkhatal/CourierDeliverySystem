<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Profile</title>
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
                    <a class="nav-link active" href="/delivery/deliveryprofile">Profile</a>
                </li>
       
                
                 <!-- <li class="nav-item ">
                    <a class="nav-link" href="/delivery/deliveryorders">Orders </a>
                </li> --> 
                
                <li class="nav-item dropdown">
       			 <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
       			 aria-haspopup="true" aria-expanded="false">Orders</a>
       			 
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/delivery/deliveryorders">All Orders</a>
          <a class="dropdown-item" href="/delivery/pendingorders">Pending orders</a>
        </div>
      </li>
                
                

                <li class="nav-item ">
                    <a class="nav-link" href="/delivery/update">Update Profile </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/delivery/delete/${sessionScope.delivery_details.did }">Delete Account </a>
                </li>
                
                
                
                
            </ul>
          

            <ul class="navbar-nav mr-right px-4">
                <li class="nav-item">
                    <a class="nav-link " href="#" > ${sessionScope.delivery_details.getDemail()}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link "  href="/delivery/logout">Log Out</a>
                </li>

            </ul>

        </div>
    </nav>

    <!-- See your profile -->
    
    
    <div class="col-lg-8 m-auto d-block"><br>
        <div class="card-header bg-info">
            <h1 class="text-white text-center">My Profile</h1>
        </div>


        <div id="items" class="my-4">


            <table class="table">
                <tbody id="tableBody">
                    <tr>
                        <th scope="row">Name</th>
                        <td>${sessionScope.delivery_details.getDname()}</td>
                    </tr>

                    <tr>
                        <th scope="row">Email:</th>
                        <td>${sessionScope.delivery_details.getDemail()}</td>
                    </tr>

                    <tr>
                        <th scope="row">Area:</th>
                        <td>${sessionScope.delivery_details.getArea()}</td>
                    </tr>

                    <tr>
                        <th scope="row">Mobile NO:</th>
                        <td>${sessionScope.delivery_details.getDmobileno()}</td>
                    </tr>
                    
                    <tr>
                        <th scope="row">License No:</th>
                        <td>${sessionScope.delivery_details.getLicenceno()}</td>
                    </tr>
                    
                    <tr>
                        <th scope="row">Earning:</th>
                        <td>${sessionScope.delivery_details.getEarning()}</td>
                    </tr>

                </tbody>	
            </table>
            
          
        </div>

    </div>

    
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
</body>

</html>