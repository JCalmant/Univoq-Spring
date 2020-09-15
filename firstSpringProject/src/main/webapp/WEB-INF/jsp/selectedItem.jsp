<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <style>
        .selecteditembox {
            width: 340px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
    <div class="selecteditembox">
        <div class="product">
            <img width="200" height="200" src="<spring:url value='${imgProduct}'/>">
            <h4>${productName}</h4>
            <p>${productDescription}</p>
            <h5>${productPrice}€</h5>
        </div>
        <form:form
                method="post"
                action="/firstSpring/products/addToBasket"
                modelAttribute="productsToBasket">
            <div class="row">
                <div class="col">
                    <form:input path="realPrice" type="hidden" value="${productPrice}"/>
                    <form:label path="quantity"><spring:message code="quantity"/></form:label>
                    <form:input class="form-control" path="quantity" type="number" onkeypress="return event.charCode >= 48" min="0"/>
                </div>
                <br>
                <div class="col">
                    <form:button class="btn btn-primary"><spring:message code="addToBasket"/></form:button>
                </div>
            </div>
        </form:form>
    </div>

</body>
</html>