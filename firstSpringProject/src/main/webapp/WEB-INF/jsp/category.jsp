<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <style>
        .categorybox {
            width: 340px;
            margin: 50px auto;
        }
        .btn-sq-lg {
            width: 150px;
            height: 100px;
        }
    </style>
</head>
<body>
<div class="categorybox">

        <c:forEach var="category" items="${categories}">
            <form:form
                    class="buttonCategory"
                    method="post"
                    action="/firstSpring/catalog/choosenCategory"
                    modelAttribute="categoryRedirection">

                <div class="form-group">
                    <form:input path="id" type="hidden" value="${category.category.id}"/>
                    <form:button class="btn btn-sq-lg btn-primary">
                        <i class="fa fa-shopping-bag fa-2x"></i>
                        <c:out value="${category.name}"/>
                    </form:button>
                </div>

            </form:form>
        </c:forEach>

</div>

</body>
</html>