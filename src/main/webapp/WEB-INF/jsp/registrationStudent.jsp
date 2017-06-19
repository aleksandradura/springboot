<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>
    <style>

    .errorblock {
    color: #000;
    background-color: #ffEEEE;
    border: 3px solid #ff0000;
    padding: 8px;
    margin: 16px;
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
                <li><a href="student">Strefa studenta</a></li>
                <li><a href="student2">Zaloguj sie</a></li>
                <li><a href="registrationStudent">Zarejestruj</a></li>
            </ul>
        </div>
    </div>
</div>
<hr>
<h3 style="margin-left:300px;"> Registration: </h3>
<hr>

<div class = "container text-center" id="loginId">
    <form class="form-horizontal" method="POST" action="save-student" commandName="userForm">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <%--<sf:errors path="*" element="div"--%>
        <input type="hidden" name="idStudent" value="${student.idStudent}"/>
        <div class="form-group">
            <label class="control-label col-md-3"> First Name</label>
            <div class="col-md-7">
                <input id="firstName" type="text" path="firstName" class="form-control" name="firstName" value="${student.firstName}"/>

                <form:errors path="firstName" cssClass="error"></form:errors>
                <br /><br />


            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3"> Last Name</label>
            <div class="col-md-7">
                <input path="last" type="text" class="form-control" name="lastName" value="${student.last_name}"/>
                <form:errors path="last" cssClass="error"></form:errors>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3"> Indeks</label>
            <div class="col-md-7">
                <input path="f" type="text" class="form-control" name="indeks" value="${student.indeks}"/>
                <form:errors path="f" cssClass="error"></form:errors>
            </div>
        </div>
            <div class="form-group">
                <label class="control-label col-md-3"> Password</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" name="password" value="${student.password}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>

        <div class="form-group">
            <input type="submit" clas="btn btn-primary" value="Save"/>
        </div>

    </form>
</div>


</body>

</html>