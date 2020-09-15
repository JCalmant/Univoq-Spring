<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
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
            <div class="form-content">
                <form:form class="registration"
                           method="POST"
                           action="/firstSpring/userConnection/sendConnection"
                           modelAttribute="profilConnection"
                >
                    <c:choose>
                        <c:when test="${isWrongID}">
                            <h3><spring:message code="connection"/></h3>
                        </c:when>
                        <c:otherwise>
                            <h3 style="color: red"><spring:message code="wrongID"/></h3>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <div class="form-group">
                        <form:label path="name"><spring:message code="id"/>*</form:label>
                        <form:input class="form-control" path="name"/>
                        <form:errors path="name"/>
                    </div>

                    <div class="form-group">
                        <form:label path="password"><spring:message code="password"/>*</form:label>
                        <form:input class="form-control" type="password" path="password"/>
                        <form:errors path="password"/>
                    </div>
                    <br>
                    <div class="form-group">
                        <form:button type="submit" class="btn btn-primary"><spring:message code="logIn"/></form:button>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>