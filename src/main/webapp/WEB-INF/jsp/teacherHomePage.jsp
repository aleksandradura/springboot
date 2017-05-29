<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatibile" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Task Manager | Home </title>
</head>
<body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<div role = "navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">  BootSample</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-task">New Task</a></li>
                <li><a href="all-tasks">All Task</a></li>
                <li><a href="student">Strefa nauczyciela</a></li>
                <li><a href="teacherData">Moje dane</a></li>
                <li class="dropdown">
                    <a href ="#" class="dropdown-toggle" data-toggle="dropdown">Moje przedmioty
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">W-F</a></li>
                    </ul>
                </li>
            </ul>
            <ul class ="nav navbar-nav navbar-right">
                <li><a href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="jumbotron">
<div class="image">
        <img src="./images/cycling.jpg" alt="Mountain View" style="width:304px;height:228px;">
</div>
</div>
<div class="row">
<div class="col-sm-2"> Imie </div>
<div class="col-sm-10"> Janusz</div>
</div>
<div class="row">
    <div class="col-sm-2"> Nazwisko </div>
    <div class="col-sm-10"> Kowalski</div>
</div>
<button type="button">Change your data</button>


<%--moje przedmioty -> WF--%>
<div class="row">
<div class="col-sm-2">Twoje przedmioty:</div>
    <div class="btn-toolbar" role="toolbar">
    <div class="btn-group" role="button">Kolarstwo</div>
    <div class="btn-group" role="button">Plywanie</div>
</div>
</div>


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

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td><c:out value="${task.id}"/></td>
                    <td><c:out value="${task.name}"/></td>
                    <td><c:out value="${task.description}"/></td>
                    <td><c:out value="${task.finished}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="col-lg-6">
        <div class="input-group">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button">Search</button>
            </span>
            <input type="text" class="form-control" placeholder="Search student">
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script>
    $(document).ready(function () {
        $('.dropdown-toggle').dropdown();
    });
</script>
</body>

</html>

