<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
        <div class="container text-center" id="dataDiv">
            <h3>My Data</h3>
            <hr>
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
                            <td><c:out value="${a.indeks}"/></td>
                            <td><c:out value="${a.firstName}"/></td>
                            <td><c:out value="${a.lastName}"/></td>


                        </tr>
                    <%--</c:forEach>--%>
                    </tbody>
                </table>
            </div>
        </div>
<script src="static/js/bootstrap.js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script><%--<script language="JavaScript" type="text/javascript">--%>
</body>
</html>