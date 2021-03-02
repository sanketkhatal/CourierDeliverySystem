<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Courier Delivery System</title>
</head>
<body>
	<h2><a href= "/admin/login">ADMIN</a> | <a href= "/customer/login">Customer</a>|<a href= "/delivery/login">Delivery Partner</a></h2>
</body>
</html> -->

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
    <style>
    	*{
    margin:0;
    padding:0;
}

body {
    font-family: sans-serif;
}
#nav-bar {
    position: sticky;
    top: 0;
    z-index: 10;  
}
 .navbar{
    background-image: linear-gradient(to right ,  #9ce3f0,#024044);  
    padding: 0 !important;
} 
.navbar-nav li {
    padding: 0 10px;
}
.navbar-nav li a {
    color: #fff;
    font-weight: 600;
}

.navbar-brand {
    color: #fff;
}

/* banner section*/
#banner {
    background-image: linear-gradient(to right ,  #9ce3f0,#024044); 
    color: #fff;
    padding-top: 5%;
}

 .promo-title {
    font-size :40px;
    font-weight: 600;
    /* margin-top:100px; */
} 

.bottom-img {
    width:100%; 
   
}

/* service section */

#services {
    padding: 800px ,0;
}
.service-img{
    width:400px ;
    margin-top: 20px;
}
.services {
    padding: 20px;
}

.services h4 {
    padding:5px;
    margin-top:25px;
    
}

.title::before {
    content: '';
    background: #7b1798;
    height: 5px;
    width: 250px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 100;
    display: block;
    transform: translateY(63px);
}
.title::after {
    content: '';
    background: #7b1798;
    height: 10px;
    width: 50px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 100;
    display: block;
    transform: translateY(63px);
}

#services .btn-primary {
    box-shadow: none;
    padding:8px ,25px ;
    border: none;
    border-radius: 20px;
    background-image: linear-gradient(to right ,  #9ce3f0,#024044);  

}

/* about us section */

#about-us {
    background-color: #f8f9fa;
    padding-top: 50px;
    padding-bottom: 50px;
}
    </style>    

    <title>Online Courier Delivery System</title>
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-info">
        <a class="navbar-brand" href="#">Online Courier Delivery System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">Services <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">About us <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">Contact <span class="sr-only">(current)</span></a>
                </li>




            </ul>
            <!-- login -->
            <ul class="navbar-nav mr-5 px-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        login
                    </a>
                    <div class="dropdown-menu text-dark" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item text-dark" href="/customer/login">Customer</a>
                        <a class="dropdown-item text-dark" href="/delivery/login">Delivery Partner</a>
                        <a class="dropdown-item text-dark" href="/admin/login">Admin</a>

                    </div>
                </li>
            </ul>
        </div>
    </nav>


        <!-- Banner section -->

        <section id="banner">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <p class="promo-title">Fastest Courier Service in Pune</p>
                        <p>Low-priced same day delivery service!</p>
                    </div>
                </div>
            </div>
            <img src="/images/wave.png" class="bottom-img" alt="">
        </section>


        
    <section id="services">

        <div class="container text-center">


             
            <div class="row text-center">
                <div class="col-md-4 services">
                    <img src="/images/5227.jpg" class="service-img" alt="">
                    <h4>Cheap delivery</h4>
                    <p>Walking couriers and riders are always available. We assign the nearest courier with the highest
                        rating within 7 minutes.</p>

                </div>

                <div class="col-md-4 services">
                    <img src="/images/4811.jpg" class="service-img" alt="">
                    <h4>Match Special Requirement</h4>
                    <p>Walking couriers and riders are always available. We assign the nearest courier with the highest
                        rating within 7 minutes.</p>

                </div>

                <div class="col-md-4 services">
                    <img src="/images/10098.jpg" class="service-img" alt="">
                    <h4>moto delivery</h4>
                    <p>Walking couriers and riders are always available. We assign the nearest courier with the highest
                        rating within 7 minutes.</p>

                </div>
            </div>
            <div>
                <button type="button" class="btn btn-lg btn-primary">All Services</button>
            </div>
        </div>

    </section>



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