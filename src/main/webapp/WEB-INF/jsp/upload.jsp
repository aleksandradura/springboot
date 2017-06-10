<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>


<c:choose>
    <c:when test="${edit}">

    </c:when>
    <c:otherwise>
        <spring:bind path="img">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="file" path="img" name="img" class="form-control"></form:input>
                <c:set var="imageError">
                    <form:errors path="img" />
                </c:set>
                <c:if test="${not empty imageError}">
                    <div class="alert alert-danger" role="alert" style="margin-top: 10px;">
                        <form:errors path="img"></form:errors>
                    </div>
                </c:if>
            </div>
        </spring:bind>
    </c:otherwise>
</c:choose>
</body>
</html>