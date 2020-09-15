<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <style>
        .productbox {
            width: 340px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
<div class="productbox">
    <c:forEach var="product" items="${products}">
        <form:form
                class="buttonCategory"
                method="post"
                action="/firstSpring/products/choosenProduct"
                modelAttribute="productRedirection">

                <form:input path="id" value="${product.id}" type="hidden"/>
                <form:button>
                    <img width="200" height="200" src="<spring:url value='${product.product.image}'/>">
                </form:button>

                <h4> <c:out value="${product.name}"/> </h4>
                <h5> <c:out value="${product.product.price}"/>€</h5>

        </form:form>
    </c:forEach>
</div>

</body>
</html>