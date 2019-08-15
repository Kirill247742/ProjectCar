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
    <link href="carousel.css" rel="stylesheet">
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="signin.css" rel="stylesheet">

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

    <form class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading">&nbsp;&nbsp;&nbsp;&nbsp;Please enter date</h2>
        <input name="name" value="${seller.name}" type="text" class="form-control" placeholder="Name" required autofocus>
        <input name="gender"  value="${seller.gender}"type="text" class="form-control" placeholder="Gender" required>
        <input name="age"  value="${seller.age}" type="number" min="18" max="110" class="form-control" placeholder="Age" required>
        <input name="email"  value="${seller.email}"type="text" class="form-control" placeholder="Email" required>
        <input name="telnumber"  value="${seller.telnumber}"type="number" min="250000000" max="449999999"class="form-control" placeholder="Telnumber" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Save">Sand</button>
    </form>

</div>

<script src="bootstrap.min.js"></script>
<script src="docs.min.js"></script>
</body>
</html>