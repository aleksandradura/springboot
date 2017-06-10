<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="firstUrl" value="/teacher2/1" />
<c:url var="lastUrl" value="/teacher2/${pageLog.totalPages}" />
<c:url var="prevUrl" value="/teacher2/${currentIndex - 1}" />
<c:url var="nextUrl" value="/teacher2/${currentIndex + 1}" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
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
    <title>Task Manager | Home </title>
    <link hred="static/css/bootstrap.min.css" rel="stylesheet">
    <link hred="static/css/style.css" rel="stylesheet">
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


<form id="searching" method="get" action="/search" class="navbar-form navbar-right" role="search">
    <div class="form-group">
        <input type="text" class="form-control" name="searchString" placeholder="Search student">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>


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
            <c:forEach items="${taski}" var="task">
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


<div class="pagination">
    <ul>
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
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>

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

