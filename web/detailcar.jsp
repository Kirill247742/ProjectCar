<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <style>td{text-transform:uppercase;}</style>
    <title>Grid Template for Bootstrap</title>
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="grid.css" rel="stylesheet">
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="starter-template.css" rel="stylesheet">

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

<br></br><br></br>
<div class="container">

    <h2 class="sub-header">DETAILS</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>BRAND</th>
                <th>MODEL</th>
                <th>AGE</th>
                <th>MILEAGE</th>
                <th>PRICE</th>
                <th>COLOUR</th>
                <th>SELLER DETAILS</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.age}</td>
                    <td>${car.mileage}</td>
                    <td>${car.price}</td>
                    <td>${car.colour}</td>
                    <td><a href='<c:url value="/detailsell?id=${car.seller_id}&car_id=${car.id}&location_id=${car.location_id}" />'>DETAILS</a></td>
                    <td><p><a href='<c:url value="/car" />'>BACK</a></p></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>