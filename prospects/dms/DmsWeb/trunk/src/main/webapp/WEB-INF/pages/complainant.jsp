<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="complainant.new.title" /></title>
<meta name="heading"
	content="<fmt:message key='complainant.new.heading'/>" />
<meta name="menu" content="NewComplainant" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
</head>


<form:form commandName="comp" method="post">

<ul>
    
    <li>
        <form:errors path="firstName" cssClass="fieldError"/>
        <form:input path="firstName" id="username" cssClass="text large" cssErrorClass="text large error"/>
    </li>
    
    <li>
        <form:errors path="lastName" cssClass="fieldError"/>
        <form:input path="lastName" id="passwordHint" cssClass="text large" cssErrorClass="text large error"/>
    </li>
 </ul>
</form:form>
