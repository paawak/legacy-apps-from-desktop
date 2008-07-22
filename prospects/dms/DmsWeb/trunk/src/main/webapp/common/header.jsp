<%@ include file="/common/taglibs.jsp"%>

<%--
<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
--%>
<c:set var="optionSelectOne" value='<option value="-1">____Select One____</option>' scope="session" />

<c:choose>
  <c:when test="${pageContext.request.locale.language == 'en'}">
    <c:set var="locale" value="kn" scope="page" />
  </c:when>
  <c:when test="${pageContext.request.locale.language == 'kn'}">
    <c:set var="locale" value="en" scope="page" />
  </c:when>
</c:choose>

<div id="switchLocale"><a href="<c:url value='${pageContext.request.requestURI}?locale=${locale}'/>"><fmt:message key="locale.${locale}"/> </a></div>

<div id="branding">
    <h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a></h1>
    <p><fmt:message key="webapp.tagline"/></p>
</div>
<hr />

<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>