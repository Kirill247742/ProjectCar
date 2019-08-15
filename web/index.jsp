<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="carousel.css" rel="stylesheet">
    <link href="navbar.css" rel="stylesheet">

</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<c:url value="/" />'>AutoShop.by</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href='<c:url value="/" />'>Home</a></li>
                <li><a href='<c:url value="/createsell" />'>I'm a new seller</a></li>
                <li><a href='<c:url value="/createloc" />'>My location</a></li>
                <li><a href='<c:url value="/createcar" />'>Sell a car</a></li>
                <li><a href='<c:url value="/sell" />'>Sellers</a></li>
                <li><a href='<c:url value="/loc" />'>Locations</a></li>
                <li><a href='<c:url value="/car" />'>Buy a car</a></li>
            </ul>
        </div>
    </div>
</div>


<br></br><br></br><br></br><br></br>
<div class="container marketing">
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="sell.jpg">
            <h2>SELLER</h2>
            <p>To sell a car you need to create a user. We need your contact details so that buyers can contact you. Except fabulous buyers, no one will receive your data. Press the "I'm a new seller" below or in the menu above.</p>
            <p><a class="btn btn-default" href='<c:url value="/createsell" />' role="button">I'm a new seller &raquo;</a></p>
        </div>
        <div class="col-lg-4">
            <img class="img-circle" src="l.jpg">
            <h2>LOCATION</h2>
            <p>To sell a car you need to indicate your location. We need your city so that buyers can choose a place convenient for them. No one else will receive your data. Press the "New location" below or in the menu above.</p>
            <p><a class="btn btn-default" href='<c:url value="/createloc" />' role="button">My location &raquo;</a></p>
        </div>
        <div class="col-lg-4">
            <img class="img-circle" src="c.jpg">
            <h2>CAR</h2>
            <p>To sell a car you need to specify the data of the car. We need to know this data so that buyers can choose a car to their taste. No one else will receive your data. Press the "Sell a car" below or in the menu above.</p>
            <p><a class="btn btn-default" href='<c:url value="/createcar" />' role="button">Sell a car &raquo;</a></p>
        </div>
    </div>



    <hr class="featurette-divider">
    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
            <br></br>
            <p class="lead">... ... ... S O O N ... ... ...</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="1600.jpg">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="1600.jpg">
        </div>
        <div class="col-md-7">
            <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
            <br></br>
            <p class="lead">... ... ... S O O N ... ... ...</p>
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
            <br></br>
            <p class="lead">... ... ... S O O N ... ... ...</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="1600.jpg">
        </div>
    </div>
    <hr class="featurette-divider">



    <footer>
       <p>&copy; 2019 Company, Inc. &middot; <a href="#">Back to top</a></p>
    </footer>


</div>



<script src="bootstrap.min.js"></script>
<script src="docs.min.js"></script>
<script src="jquery.min.js"></script>
</body>
</html>