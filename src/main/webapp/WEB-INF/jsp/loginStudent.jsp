<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatibile" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Task Manager | Home </title>
    <link hred="static/css/bootstrap.min.css" rel="stylesheet">
    <link hred="static/css/style.css" rel="stylesheet">
</head>
<body>
<div role = "navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">  BootSample</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-task">New Task</a></li>
                <li><a href="all-tasks">All Task</a></li>
                <li><a href="student">Strefa studenta</a></li>
                <li><a href="loginStudent">Zaloguj sie</a></li>
                <li><a href="#">Zarejestruj</a></li>
            </ul>
        </div>
    </div>
</div>
<hr>
<h3> Login: </h3>
<hr>
<div class = "container text-center" id="loginId">
    <form class="form-horizontal" method="POST" action="save-task">
        <input type="hidden" name="id" value="${student.id}"/>
        <div class="form-group">
            <label class="control-label col-md-3"> Indeks</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="indeks" value="${student.indeks}"/>
            </div>
        </div>
            <div class="form-group">
                <label class="control-label col-md-3"> Password</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" name="password" value="${student.password}"/>
                </div>
            </div>


    </form>
</div>

</body>

</html>