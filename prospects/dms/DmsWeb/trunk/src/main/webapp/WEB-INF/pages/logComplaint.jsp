<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="logComplaint.title"/></title>
    <meta name="heading" content="<fmt:message key='logComplaint.heading'/>"/>
    <meta name="menu" content="NewComplaint"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
</head>

<spring:bind path="complaint.*">
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

<form:form commandName="complaint" method="post">
    <ul>

    <li>
        <appfuse:label styleClass="desc" key="logComplaint.complaintType"/>
        <form:errors path="complaintType" cssClass="fieldError"/>
        <form:select path="complaintType" id="complaintType" cssClass="text large" cssErrorClass="text large error">
            <option value="-1">Select...</option>
            <form:options items="${complaintTypeList}" itemValue="complaintTypeId" itemLabel="shortDescription"/>
        </form:select>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="logComplaint.details"/>
        <form:errors path="details" cssClass="fieldError"/>
        <form:textarea path="details" id="details" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="logComplaint.ward"/>
        <form:errors path="ward" cssClass="fieldError"/>
        <form:select path="ward" id="ward" cssClass="text large" cssErrorClass="text large error">
            <option value="-1">Select...</option>
            <form:options items="${wardList}" itemValue="wardId" itemLabel="name"/>
        </form:select>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="logComplaint.complaintPriority"/>
        <form:errors path="complaintPriority" cssClass="fieldError"/>
        <form:select path="complaintPriority" id="complaintPriority" cssClass="text large" cssErrorClass="text large error">
            <form:options items="${priorityList}" itemValue="complaintPriorityId" itemLabel="priority"/>
        </form:select>
    </li>
    
    <li>
        <appfuse:label styleClass="desc" key="logComplaint.department"/>
        <form:errors path="department" cssClass="fieldError"/>
        <form:select path="department" id="department" cssClass="text large" cssErrorClass="text large error" onchange="javascript:submit();">
            <option value="-1">Select...</option>
            <form:options items="${departmentList}" itemValue="departmentId" itemLabel="name"/>
        </form:select>
    </li>

    <li>
        <appfuse:label styleClass="desc" key="logComplaint.assignedTo"/>
        <form:errors path="assignedTo" cssClass="fieldError"/>
        <form:select path="assignedTo" id="assignedTo" cssClass="text large" cssErrorClass="text large error">
            <form:options items="${usersForDeptList}" itemValue="id" itemLabel="username"/>
        </form:select>
    </li>

    <li>
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
    </li>

    </ul>
</form:form>
