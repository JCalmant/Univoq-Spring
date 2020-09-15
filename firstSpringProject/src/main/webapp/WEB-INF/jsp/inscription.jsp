<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">

    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
    <script src="webjars/jquery/3.5.1/jquery.min.js" ></script>

</head>
<body>

    <div class="container">

        <h1><spring:message code="menu2"/></h1>
        <c:choose>
            <c:when test="${!areCorrectsFields}">
                <div class="error">
                    <p style="font-size: 125%"><spring:message code="badFields"/></p>
                    <c:forEach var="erreur" items="${erreurs}">
                        <p>- <spring:message code="${erreur}"/></p>
                    </c:forEach>
                </div>
            </c:when>
        </c:choose>


        <form:form class="registration"
                   method="POST"
                   action="/firstSpring/userInscription/sendInscription"
                   modelAttribute="profilInscription"
        >
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <form:label path="name"><spring:message code="id"/>*</form:label>
                        <form:input class="form-control" path="name"/>
                    </div>
                    <div class="form-group">
                        <form:label path="password"><spring:message code="password"/>*</form:label>
                        <form:input class="form-control" type="password" path="password"/>
                    </div>
                    <div class="form-group">
                        <form:label path="confirmPassword"><spring:message code="confirmPassword"/>*</form:label>
                        <form:input class="form-control" type="password" path="confirmPassword"/>
                    </div>
                    <div class="form-group">
                        <form:label path="firstName"><spring:message code="firstName"/>*</form:label>
                        <form:input class="form-control" path="firstName"/>
                    </div>
                    <div class="form-group">
                        <form:label path="lastName"><spring:message code="lastName"/>*</form:label>
                        <form:input class="form-control" path="lastName"/>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <form:label path="mail">eMail*</form:label>
                        <form:input class="form-control" path="mail"/>
                    </div>
                    <div class="form-group">
                        <form:label path="locality"><spring:message code="locality"/>*</form:label>
                        <form:select class="form-control" path="localityString">
                            <form:options items="${localities}" itemValue="locality" itemLabel="toString"/>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="deliveryAddress"><spring:message code="deliveryAddress"/>*</form:label>
                        <form:input class="form-control" path="deliveryAddress"/>
                    </div>
                    <div class="form-group">
                        <form:label path="billingAddress"><spring:message code="billingAddress"/></form:label>
                        <form:input class="form-control" path="billingAddress"/>
                    </div>
                    <div class="form-group">
                        <form:label path="phoneNumber"><spring:message code="phoneNumber"/></form:label>
                        <form:input class="form-control" path="phoneNumber"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <form:button class="btn btn-primary"><spring:message code="register"/></form:button>
            </div>

            <br>

        </form:form>
    </div>
</body>
</html>