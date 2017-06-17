<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <a href="/" class="navbar-brand">  BootSample</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-task">New Task</a></li>
                <li><a href="all-tasks">All Task</a></li>
                <%--<li><a href="student">Strefa studenta</a></li>--%>

                <li class="dropdown">
                    <a href ="#" class="dropdown-toggle" data-toggle="dropdown">Strefa studenta
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="loginStudent">Logowanie</a></li>
                        <li><a href="registrationStudent">Rejestracja</a></li>
                    </ul>
                </li>

                <li><a href="teacher2">Strefa nauczyciela</a></li>
            </ul>
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


<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>HI, Welcome to Tasks</h1>
            </div>
        </div>

    </c:when>
    <c:when test="${mode == 'MODE_TASKS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>My Tasks</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Finished</th>
                        <th colspan="2">o</th>
                    <th></th>
                        <th></th>
                    </tr>
                    <tr>

                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>tak</th>
                        <th>nie</th>
                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <td><c:out value="${task.id}"/></td>
                            <td><c:out value="${task.name}"/></td>
                            <td><c:out value="${task.description}"/></td>
                            <td><c:out value="${task.finished}"/></td>
                            <td><input type="checkbox"></td>
                            <td><input type="checkbox"></td>
                            <td><a href="update-task?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="delete-task?id=${task.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode=='MODE_UPDATE'}">
        <div class="container text-center">
            <h3>Manage Task</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="save-task">
                <input type="hidden" name="id" value="${task.id}"/>
                <div class="form-group">
                    <label class="control-label col-md-3"> Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="name" value="${task.name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3"> Description</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="description" value="${task.description}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Finished</label>
                    <div class="col-md-7">
                        <input type="radio" class="col-sm-1" name="finished" value="true"/>
                        <div class="col-sm-1">Yes</div>
                        <input type="radio" class="col-sm-1" name="finished" value="false" checked/>
                        <div class="col-sm-1">No</div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>

    </c:when>
</c:choose>

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