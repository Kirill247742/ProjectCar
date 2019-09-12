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
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">

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
                <li><a href='<c:url value="/registration" />'>I'm a new seller</a></li>
                <li><a href='<c:url value="/registration" />'>My location</a></li>
                <li><a href='<c:url value="/registration" />'>Sell a car</a></li>
                <li><a href='<c:url value="/sell" />'>Sellers</a></li>
                <li><a href='<c:url value="/loc" />'>Locations</a></li>
                <li><a href='<c:url value="/car" />'>Buy a car</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href='<c:url value="/registration" />'>Registration</a></li>
                <li><a href='<c:url value="/login" />'>Login</a></li>
                <li><a href='<c:url value="/logout" />'>Logout</a></li>
            </ul>
        </div>
    </div>
</div>

<br></br>
<div class="container">

    <form class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading">&nbsp;&nbsp;&nbsp;&nbsp;Please enter date</h2>
        <input name="login" type="text" class="form-control" placeholder="Login" required autofocus>
        <input name="password" type="password"class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Save">SIGN IN</button>
        <div class="alert alert-danger">
            <Strong>Incorrect login or password.</Strong>
            <strong>Try again.</strong>
        </div>
    </form>
    <div class="starter-template">
    </div>
    <form class="form-signin" action='<c:url value="/registration" />'>
        <h3 class="form-signin-heading">&nbsp;&nbsp;If you don't have account</h3>
        <button class="btn btn-lg btn-primary btn-block" type="submit">REG</button>
    </form>

</div>

<script src="js/bootstrap.min.js"></script>
<script src="js/docs.min.js"></script>
</body>
</html>