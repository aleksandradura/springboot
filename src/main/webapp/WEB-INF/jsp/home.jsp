<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html lang="en">

<body>
<table>
    hello
    <c:forEach items="${taski}" var="task">
        <tr>
            <td>Name: <c:out value="${task.name}"/></td>
            <td>Description: <c:out value="${task.description}"/></td>
            <td>Finished: <c:out value="${task.finished}"/></td>
        </tr>
    </c:forEach>
</table>
</body>

</html>