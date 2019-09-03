<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <style>td{text-transform:uppercase;}</style>

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
            <ul class="nav navbar-nav navbar-right">
                <li><a href='<c:url value="/registration" />'>Registration</a></li>
                <li><a href='<c:url value="/login" />'>Login</a></li>
                <li><a href='<c:url value="/logout" />'>Logout</a></li>
            </ul>
        </div>
    </div>
</div>

<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>


<br></br><br></br>
<div class="container">

    <h2 class="sub-header">SELLERS LIST</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <tbody>
            <c:forEach var="seller" items="${sellers}">
                <tr>
                    <td>${seller.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>