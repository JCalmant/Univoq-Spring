<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=utf-8">
    <style>
        .signinbox {
            width: 340px;
            margin: 50px auto;
        }
        .form-content{
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 10px 10px 25px 0px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

    </style>
</head>
<body>
    <div class="signinbox">
        <c:choose>
            <c:when test="${testConnection}">
                <div class="form-content">
                    <form:form id="logIn"
                               method="POST"
                               action="/firstSpring/userConnection/sendConnection"
                               modelAttribute="profilConnection"
                    >
                        <h2><spring:message code="welcomeMessage"/></h2>
                        <br>
                        <div class="form-group">
                            <form:label path="name"><spring:message code="id"/></form:label>
                            <form:input class="form-control" path="name"/>
                            <form:errors path="name"/>
                        </div>
                        <div class="form-group">
                            <form:label path="password"><spring:message code="password"/></form:label>
                            <form:input class="form-control" type="password" path="password"/>
                            <form:errors path="password"/>
                        </div>
                        <br>
                        <div class="form-group">
                            <form:button type="submit" class="btn btn-primary"><spring:message code="logIn"/></form:button>
                        </div>
                    </form:form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-content">
                    <form id="logOut"
                          method="POST"
                          action="/firstSpring/disconnection"
                    >
                        <p><spring:message code="welcome"/>, ${username}</p>
                        <button class="btn btn-primary"><spring:message code="logOut"/></button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>