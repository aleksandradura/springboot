<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:url var="firstUrl" value="/teacher2/1" />
<c:url var="lastUrl" value="/teacher2/${pageLog.totalPages}" />
<c:url var="prevUrl" value="/teacher2/${currentIndex - 1}" />
<c:url var="nextUrl" value="/teacher2/${currentIndex + 1}" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script type="text/javascript" src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" />
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<meta name="viewport" content="initial-scale=1, maximum-scale=1">--%>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatibile" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Teacher | My students </title>
    <%--<link hred="static/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link hred="static/css/style.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <style>
        #pag {
            margin-left: 560px;
        }
        #searching {
            margin-right: 100px;
        }

    </style>

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
            </ul>
            <ul class ="nav navbar-nav navbar-right">
                <li><a href="logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
Welcome <c:out value="${requestScope['username']}"></c:out>!
<br/>
This is the main page!

<form id="searching" method="get" action="/search" class="navbar-form navbar-right" role="search">
    <div class="form-group">
        <input type="text" class="form-control" id="searchString" name="searchString" placeholder="Search student">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

<h3>File Upload:</h3>
Select a file to upload: <br />
<form action = "/teacher2/imageUpload" method = "post"
      enctype = "multipart/form-data">
    <input type = "file" name = "file" />
    <br />
    <input type = "submit" value = "Upload File" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<%--<c:choose>--%>
<%--<c:when test="${mode == 'MODE_STATUS'}">--%>
<div class="container text-center" id="tasksDiv">
    <h3>My Students</h3>
    <hr>
    <div class="table-responsive">
        <table class="table table-striped table-bordered text-left">
            <thead>
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Indeks</th>
                <%--<th>kategoria</th>--%>
                <%--<th>data</th>--%>
                <%--<th>obecnosc</th>--%>
                <%--<th>delete</th>--%>

            </tr>
            </thead>
            <tbody>
    <form class="form-horizontal" method="POST" action="save-status">

            <c:forEach items="${taski}" var="task">
                <tr>
                    <input type="hidden" name="id" value="${task.id}"/>
                    <td><c:out value="${task.firstName}"/></td>
                    <td><c:out value="${task.lastName}"/></td>
                    <td><c:out value="${task.indeks}"/></td>
                    <%--<td><c:out value="${task.kategoria}"/></td>--%>
                    <%--<td><input type="text" name="data" id="data" value="${stat.data}"></td>--%>
                    <%--<td><input type="text" name="status" id="status" value="${stat.status}"></td>--%>
                    <%--<td><a href="delete-student?id=${task.studentId}"><span class="glyphicon glyphicon-trash"></span></a></td>--%>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<nav aria-label="Page navigation">
<div class="pagination" id = "pag">
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/teacher2/${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == pageLog.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li>
                <a aria-label="Previous" href="${nextUrl}">
                    <span aria-hidden="true">&gt;</span></a>
                </li>
                <li>
                    <a aria-label="Next" href="${lastUrl}">
                        <span aria-hidden="true">&gt;&gt;</span></a></li>
            </c:otherwise>
        </c:choose>

</div>
</nav>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


</body>

</html>

