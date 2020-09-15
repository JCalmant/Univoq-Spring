<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-10 col-md-offset-1">
                <c:set var="total" value="0" scope="page" />
                <table class="panier">
                    <thead>
                    <tr>
                        <th><spring:message code="product"/></th>
                        <th><spring:message code="quantity"/></th>
                        <th class="text-center"><spring:message code="price"/></th>
                        <th class="text-center"><spring:message code="total"/></th>
                        <th></th>
                    </tr>
                    </thead>
                    <hr>
                    <tbody>
                        <c:forEach var="orderDetail" items="${basket}">
                            <tr>
                                <form:form
                                        method="post"
                                        action="/firstSpring/basket/updateBasket"
                                        modelAttribute="changeBasket">

                                    <form:input path="product.id" type="hidden" value="${orderDetail.value.product.id}"/>

                                    <td class="col-sm-8 col-md-6">${orderDetail.key}</td>
                                    <td class="col-sm-1 col-md-1 text-center">${orderDetail.value.quantity}</td>
                                    <td class="col-sm-1 col-md-1 text-center">${orderDetail.value.realPrice}€</td>
                                    <td class="col-sm-1 col-md-1 text-center">${orderDetail.value.tot}€</td>
                                    <td class="col-sm-1 col-md-1"><form:button><spring:message code="update"/></form:button></td>

                                    <c:set var="total" value="${total + orderDetail.value.realPrice*orderDetail.value.quantity}" scope="page"/>

                                </form:form>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:set var="log" value="${isLogged}" scope="page"/>
    <c:choose>
        <c:when test="${log}">
            <c:set var="formAction" value="https://www.sandbox.paypal.com/cgi-bin/webscr" scope="page"/>
        </c:when>
        <c:otherwise>
            <c:set var="formAction" value="/firstSpring/basket/connection" scope="page"/>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${reduction && total>=20}">
            <c:set var="total" value="${total-10}" scope="page"/>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${total != 0}">
            <form
                    id="formAchat"
                    method="post"
                    action="${formAction}">
                <input type="hidden" name="cmd" value="_xclick">
                <input type="hidden" name="return" value="https://localhost:8443/firstSpring/basket/buy">
                <input type="hidden" name="business" value="payment@univoq.com">
                <input type="hidden" name="amount" value="${total}">
                <input type="hidden" name="cert_id" value="AaiJ05djBRtWclVi5KDlaskwLpM3pjNl9vC9gwLPBa9OtmSQrtdu1c2cPV0tLuJUI-0I3_LmNGc_txwd">
                <input type="hidden" name="password" value="EFxNLq7y9Z-r1bEIvW6WrF1u_TXmNfDb0cusJ28lLAXrUNGaFLLkimDCQumXIGYKCNdn9kHO4juADP0r">
                <input type="hidden" name="currency_code" value="EUR">
                <p>
                    <spring:message code="totalSum"/>
                    <fmt:formatNumber type = "number" value = "${total}" />€
                    <button><spring:message code="buy"/></button>
                </p>
            </form>
        </c:when>
    </c:choose>
    <div class="vide"></div>
</body>
</html>