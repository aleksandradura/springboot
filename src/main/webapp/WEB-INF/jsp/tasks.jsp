<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>

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
    </div></div>
</body>
</html>