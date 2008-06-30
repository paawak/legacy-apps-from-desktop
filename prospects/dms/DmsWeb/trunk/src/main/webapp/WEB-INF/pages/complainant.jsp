<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="complainant.new.title" /></title>
<meta name="heading"
	content="<fmt:message key='complainant.new.heading'/>" />
<meta name="menu" content="NewComplainant" />
</head>

<spring:bind path="complainant.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon"/>
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<form:form commandName="complainant" method="post">

<ul>
    
    <li>
        <div class="left">
            <appfuse:label styleClass="desc" key="user.firstName"/>
            <form:errors path="firstName" cssClass="fieldError"/>
            <form:input path="firstName" id="firstName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        </div>
        <div>
            <appfuse:label styleClass="desc" key="user.lastName"/>
            <form:errors path="lastName" cssClass="fieldError"/>
            <form:input path="lastName" id="lastName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        </div>
    </li>

    <li>
        <appfuse:label styleClass="desc" key="complainant.email"/>
        <form:errors path="emailId" cssClass="fieldError"/>
        <form:input path="emailId" id="emailId" cssClass="text large" cssErrorClass="text large error"/>
    </li>

    <li>
        <div>
            <div class="left">
                <appfuse:label styleClass="desc" key="user.phoneNumber"/>
                <form:errors path="homePhone" cssClass="fieldError"/>
                <form:input path="homePhone" id="homePhone" cssClass="text medium" cssErrorClass="text medium error"/>
            </div>
            <div>
                <appfuse:label styleClass="desc" key="complainant.handPhone"/>
                <form:errors path="handPhone" cssClass="fieldError"/>
                <form:input path="handPhone" id="phoneNumber" cssClass="text medium" cssErrorClass="text medium error"/>
            </div>
        </div>
    </li>
    
    <li>
        <label class="desc"><fmt:message key="user.address.address"/></label>
        <div class="group">
            <div>
                <form:input path="address.address" id="address.address" cssClass="text large" cssErrorClass="text large error"/>
                <form:errors path="address.address" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.address"/></p>
            </div>
            <div class="left">
                <form:input path="address.city" id="address.city" cssClass="text medium" cssErrorClass="text medium error"/>
                <form:errors path="address.city" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.city"/></p>
            </div>
            <div>
                <form:input path="address.province" id="address.province" cssClass="text state" cssErrorClass="text state error"/>
                <form:errors path="address.province" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.province"/></p>
            </div>
            <div class="left">
                <form:input path="address.postalCode" id="address.postalCode" cssClass="text medium" cssErrorClass="text medium error"/>
                <form:errors path="address.postalCode" cssClass="fieldError"/>
                <p><appfuse:label key="user.address.postalCode"/></p>
            </div>
            <div>
                <appfuse:country name="address.country" prompt="" default="${user.address.country}"/>
                <p><appfuse:label key="user.address.country"/></p>
            </div>
        </div>
    </li>
    
    <li>
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
    </li>

</ul>

</form:form>
