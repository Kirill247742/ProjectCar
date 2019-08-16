<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/starter-template.css" rel="stylesheet">

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

<div class="container">
    <br></br><br></br>
    <div class="starter-template">
        <div class="alert alert-danger">
            <strong>Oh snap!</strong> Invalid SELLER_ID or LOCATION_ID.
        </div>
        <p class="lead"><a href='<c:url value="/createcar" />'>TRY AGAIN</a>
    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>