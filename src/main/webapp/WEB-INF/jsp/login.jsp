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

            </ul>
        </div>
    </div>
</div>
<hr>
<h3 style="margin-left:300px;"> Login: </h3>
<hr>
<div class = "container text-center" id="loginId">
    <form name="loginForm" class="form-horizontal" method="POST" action="<c:url value='j_spring_security_check' />">
        <div class="form-group">
            <label class="control-label col-md-3"> lastName</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="username" value=''/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3"> Password</label>
            <div class="col-md-7">
                <input type="password" class="form-control" name="password"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </div>
        <input type="submit" name="submit" class="btn btn-default" value="Submit"></input>


    </form>
    <font color="red">

        <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
    </font>
</div>

</body>

</html>