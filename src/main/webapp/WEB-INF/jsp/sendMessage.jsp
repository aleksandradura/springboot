<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE >
<html lang="pl-PL">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<meta name="viewport" content="initial-scale=1, maximum-scale=1">--%>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatibile" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Teacher | Send Message </title>
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
                <li><a href="data-teacher">Moje dane</a></li>
                <li class="dropdown">
                    <a href ="#" class="dropdown-toggle" data-toggle="dropdown">Moje przedmioty
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">W-F</a></li>
                    </ul>
                </li>
                <li><a href="teacher2/1">Lista studentów</a></li>
            </ul>
            <ul class ="nav navbar-nav navbar-right">
                <li><a href="logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container text-center">
    <h3>Manage Task</h3>
    <hr>
<form:form method="post" action="/save-taskStudent" modelAttribute="task">
    <%String name=(String)session.getAttribute("theName");%>
    <input type="hidden" name="indeks" id="indeks" value="${sessionScope.indeks}"/>
        <%--<input type="hidden" name="id" value="${id}"/>--%>
        <div class="form-group">
            <label class="control-label col-md-3"> Name</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="name" id="name" value="${name}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3"> Description</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="description" id="description" value="${description}"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </div>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-md-3">Finished</label>--%>
            <%--<div class="col-md-7">--%>
                <%--<input type="radio" class="col-sm-1" name="finished" value="true"/>--%>
                <%--<div class="col-sm-1">Yes</div>--%>
                <%--<input type="radio" class="col-sm-1" name="finished" value="false" checked/>--%>
                <%--<div class="col-sm-1">No</div>--%>
            <%--</div>--%>

        <%--</div>--%>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Save"/>
        </div>
</form:form>
</div>
<script src="static/js/bootstrap.js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script><%--<script language="JavaScript" type="text/javascript">--%>
</body>
</html>