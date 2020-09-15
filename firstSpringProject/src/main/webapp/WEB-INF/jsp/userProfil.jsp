<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
</head>
<body>
<c:set var="user" value="${user}" scope="page"/>
<h1><spring:message code="profil"/></h1>
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
           action="/firstSpring/profil/sendUpDate"
           modelAttribute="upDateProfil"
>
    <form:label path="name"><spring:message code="id"/></form:label>
    <br>
    <form:input path="name" disabled="true" value="${user.name}"/>
    <br>
    <form:label path="firstName"><spring:message code="firstName"/>*</form:label>
    <br>
    <form:input path="firstName" value="${user.firstName}"/>
    <br>
    <form:label path="firstName"><spring:message code="lastName"/>*</form:label>
    <br>
    <form:input path="lastName" value="${user.lastName}"/>
    <br>
    <form:label path="firstName"><spring:message code="deliveryAddress"/>*</form:label>
    <br>
    <form:input path="deliveryAddress" value="${user.deliveryAddress}"/>
    <br>
    <form:label path="firstName"><spring:message code="billingAddress"/></form:label>
    <br>
    <form:input path="billingAddress" value="${user.billingAddress}"/>
    <br>
    <form:label path="firstName">eMail*</form:label>
    <br>
    <form:input path="mail" value="${user.mail}"/>
    <br>
    <form:label path="firstName"><spring:message code="phoneNumber"/></form:label>
    <br>
    <form:input path="phoneNumber" value="${user.phoneNumber}"/>
    <br>
    <form:label path="locality"><spring:message code="locality"/></form:label>
    <br>
    <form:select path="localityString">
        <form:option value="${user.locality.toString}"/>
        <form:options items="${localities}" itemValue="locality" itemLabel="toString"/>
    </form:select>
    <br>
    <form:label path="password"><spring:message code="new"/><spring:message code="password"/></form:label>
    <br>
    <form:input type="password" path="password"/>
    <br>
    <form:button><spring:message code="saveProfil"/></form:button>
</form:form>
<div class="vide"></div>
</body>
</html>