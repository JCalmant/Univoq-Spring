<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-type" content="type-text/html; charset=utf-8">

    <link type="text/css" href="<spring:url value='/css/first.css' />"
          rel="stylesheet">

    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
    <script src="webjars/jquery/3.5.1/jquery.min.js" ></script>

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
    <c:choose>
        <c:when test="${connection}">
            <spring:message code="disconnection" var="menu1"/>
            <spring:message code="profil" var="menu2"/>
        </c:when>
        <c:otherwise>
            <spring:message code="connection" var="menu1"/>
            <spring:message code="menu2" var="menu2"/>
        </c:otherwise>
    </c:choose>
    <spring:message code="menu3" var="menu3" />
    <spring:message code="menu4" var="menu4" />
    <spring:message code="menu5" var="menu5" />

</head>
<body background="<spring:url value='/images/background.png'/>">

<div class="header">
    <a href="/firstSpring">
        <div class="circle">
            <img src='<spring:url value="/images/placeholder-icon.png"/>' alt="logo" vspace="17" height="50" width="50">
        </div>
    </a>
    <h1>Univoq.me</h1>
    <p>Your first stop for your college shop</p>
</div>
<div id="scrollWait"></div>
<div id="underHeader">
    <form class="menu"
          method="POST"
          action="/firstSpring/menu">
        <input class="underHeaderP" type="submit" name="actionMenu" value="${menu1}"/>
        <input class="underHeaderP" type="submit" name="actionMenu" value="${menu2}"/>
        <input class="underHeaderP" type="submit" name="actionMenu" value="${menu3}"/>
        <input class="underHeaderP" type="submit" name="actionMenu" value="${menu4}"/>
        <input class="underHeaderP" type="submit" name="actionMenu" value="${menu5}"/>
    </form>
</div>

<p id="flag">
    <a href="${localeFr}"><img src='<spring:url value="/images/localeFr.png"/>' height="42" width="42"/></a>
    <a href="${localeEn}"><img src='<spring:url value="/images/localeEn.png"/>' height="42" width="42"/></a>
</p>

<div>
    <tiles:insertAttribute name = "main-content"/>
    <link type="text/css" href="<spring:url value='/css/first.css' />" rel="stylesheet">
    <script src="<spring:url value='/javascript/cssTransformation.js'/>"></script>
</div>

</body>
</html>