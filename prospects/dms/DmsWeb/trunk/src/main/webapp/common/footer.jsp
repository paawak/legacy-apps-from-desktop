<%@ include file="/common/taglibs.jsp" %>

	
	<table border= "0" width = "100%"><tr><td>	
    <div id="divider"></div>
    <span class="left"><fmt:message key="webapp.version"/> |
        <span id="validators">
            <a href="http://validator.w3.org/check?uri=referer" target="_blank">XHTML Valid</a> |
            <a href="http://jigsaw.w3.org/css-validator/validator-uri.html" target="_blank">CSS Valid</a>
        </span>
        <c:if test="${pageContext.request.remoteUser != null}">
        | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
        </c:if>
    </span>
    <span class="right">
        &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>" target="_blank"><fmt:message key="company.name"/></a>
    </span>
    </td></tr></table>
