<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="pl-PL">
<head>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

    <meta http-equiv="X-UA-Compatibile" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title> Student | Show Message </title>
    <link hred="static/css/bootstrap.min.css" rel="stylesheet">
    <link hred="static/css/style.css" rel="stylesheet">

</head>
<body>
<div role = "navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">  Strefa studenta</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Zajęcia</a></li>
                <li><a href="/show-message">Wiadomości</a></li>
                <%--<li><a href="data-student">Profil</a></li>--%>
                <li><a href="/show-presence">Moje obecności</a></li>
            </ul>
            <ul class ="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
</div>
    <div class="container text-center" id="tasksDiv">
        <h3>Wiadomości od trenera</h3>
        <hr>
        <div class="table-responsive">
            <table class="table table-striped table-bordered text-left">
                <thead>
                <tr>
                    <th>INDEKS</th>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                </tr>
                </thead>
                <tbody>
    <c:forEach items="${taski}" var="task">
        <tr>
            <td><c:out value="${task.indeks}"/></td>
            <td><c:out value="${task.name}"/></td>
            <td><c:out value="${task.description}"/></td>
        </tr>
    </c:forEach>

                </tbody>

            </table>
        </div>
        </div>
</body>


</html>