<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="data-student">Profil</a></li>
                <li><a href="#">Moje treningi</a></li>
            </ul>
            <ul class ="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
        <%--<div class="navbar-collapse navbar-right collapse">--%>

        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_DATASTUDENT'}">
        <div class="container text-center" id="dataDiv">
        <h3>My Data</h3>
        <hr>
        <div class="table-responsive">
        <table class="table table-striped table-bordered text-left">
        <thead>
        <tr>
        <th>ID</th>
        <th>imie</th>
        <th>nazwisko</th>
        <th>indeks</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${tas}" var="task">
            <tr>
                <td><c:out value="${task.indeks}"/></td>
                <td><c:out value="${task.firstName}"/></td>
                <td><c:out value="${task.lastName}"/></td>

            </tr>
        </c:forEach>
        </tbody>
        </table>
        </div>
        </div>
    </c:when>
</c:choose>


</body>

</html>

