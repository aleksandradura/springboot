<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>Teacher | Search student </title>
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

        <div class="container text-center" id="dataDiv">
            <h3>My Data</h3>
            <hr>
            <form:form method="post" action="/save-status" modelAttribute="obecnosc">
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>imie</th>
                        <th>nazwisko</th>
                        <th>indeks</th>
                    </tr>

                    </thead>
                    <tbody>
                    <%--<c:forEach var="task" items="${a}">--%>
                        <tr>

                            <td><c:out value="${a.indeks}" /></td>
                            <c:set var="indeks" value="${a.indeks}" scope="session"/>
                            <input type="hidden" id="indeks" name="indeks" value="${a.indeks}"/>
                            <%
                                String name = request.getParameter( "ndeks" );
                                session.setAttribute( "theName", name );
                            %>
                            <%--<td><c:out value="${a.firstName}"/></td>--%>
                            <%--<td><c:out value="${a.lastName}"/></td>--%>
                            <td><input type="text" name="data" id="data" value="${data}"/></td>
                            <td><input type="text" name="status" id="status" value="${status}"/></td>
                            <td><a href="send-message"><span class="glyphicon glyphicon-pencil"></span></a></td>


                        </tr>
                    <%--</c:forEach>--%>
                    </tbody>
                </table>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </div>
            </form:form>
        </div>

<script src="static/js/bootstrap.js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script><%--<script language="JavaScript" type="text/javascript">--%>
</body>
</html>