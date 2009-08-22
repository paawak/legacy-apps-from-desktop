<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.masters.accountGroup.title"/></title>
    <meta name="heading" content="<fmt:message key='menu.masters.accountGroup.title'/>"/>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<spring:bind path="accountGroup.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">    
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<div class="separator"></div>

<p>

    <object id="NewAccountGroup" width="600" height="600" align="middle"
    codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" 
    classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">
    <param name="allowScriptAccess" value="sameDomain" />
    <param name="movie" value="http://localhost:8080/flash/exp.swf" />
    <param name="quality" value="high" />
    <param name="bgcolor" value="#ffffff" />
    <embed src="http://localhost:8080/flash/exp.swf" quality="high" bgcolor="#ffffff" width="600" height="600" name="NewAccountGroup" align="middle" 
    allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
    </object>

</p>






