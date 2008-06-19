<%@ include file="/common/taglibs.jsp"%>

<%--
<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
--%>

<c:choose>
  <c:when test="${pageContext.request.locale.language == 'en'}">
     <div id="switchLocale"><a href="<c:url value='/?locale=kn'/>"><fmt:message key="webapp.name"/> in Kannada</a></div>
  </c:when>
  <c:when test="${pageContext.request.locale.language == 'kn'}">
     <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
  </c:when>
</c:choose>

<div id="branding">
    <h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a></h1>
    <p><fmt:message key="webapp.tagline"/></p>
</div>
<hr />

<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>