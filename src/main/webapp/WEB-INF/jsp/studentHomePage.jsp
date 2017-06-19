<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<meta name="viewport" content="initial-scale=1, maximum-scale=1">--%>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

    <meta http-equiv="X-UA-Compatibile" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Task Manager | Home </title>
    <link hred="static/css/bootstrap.min.css" rel="stylesheet">
    <link hred="static/css/style.css" rel="stylesheet">
    <style>.carousel-inner > .item > img { width:100%; height:360px; } </style>
</head>
<body>
<div role = "navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">  Strefa studenta</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/enroll-lessons">Zajęcia</a></li>
                <li><a href="/show-message">Wiadomości</a></li>
                <%--<li><a href="data-student">Profil</a></li>--%>
                <li><a href="/show-presence">Moje obecności</a></li>
            </ul>
            <ul class ="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
        <%--<div class="navbar-collapse navbar-right collapse">--%>

        </div>
    </div>
</div>

<div class="container">
    <br>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">

            <div class="item active">
                <img src="./images/all.jpg" alt="sport" width="460" height="800">
                <div class="carousel-caption">
                    <%--<h3>Chania</h3>--%>
                    <%--<p>The atmosphere in Chania has a touch of Florence and Venice.</p>--%>
                </div>
            </div>

            <div class="item">
                <img src="./images/all2.jpg" alt="sport2" width="460" height="345">
                <div class="carousel-caption">
                    <%--<h3>Chania</h3>--%>
                    <%--<p>The atmosphere in Chania has a touch of Florence and Venice.</p>--%>
                </div>
            </div>

            <div class="item">
                <img src="./images/running.jpg" alt="run" width="460" height="345">
                <div class="carousel-caption">
                    <%--<h3>Flowers</h3>--%>
                    <%--<p>Beautiful flowers in Kolymbari, Crete.</p>--%>
                </div>
            </div>

            <div class="item">
                <img src="./images/cycling.jpg" alt="cycle" width="460" height="345">
                <div class="carousel-caption">
                    <%--<h3>Flowers</h3>--%>
                    <%--<p>Beautiful flowers in Kolymbari, Crete.</p>--%>
                </div>
            </div>

        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<script src="static/js/bootstrap.js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script><%--<script language="JavaScript" type="text/javascript">--%>

<script>

    // Activate Carousel
    $("#myCarousel").carousel();

    // Enable Carousel Indicators
    $(".item").click(function(){
        $("#myCarousel").carousel(1);
    });

    // Enable Carousel Controls
    $(".left").click(function(){
        $("#myCarousel").carousel("prev");
    });
    $('#myCarousel').carousel({
        interval: 1000})

</script>

</body>

</html>

