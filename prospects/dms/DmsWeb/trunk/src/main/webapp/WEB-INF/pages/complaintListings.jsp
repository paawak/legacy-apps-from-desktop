<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="my${mode}ComplaintListings.title" /></title>
<meta name="heading"
	content="<fmt:message key='my${mode}ComplaintListings.heading'/>" />
<meta name="menu" content="My${mode}Complaints" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
</head>

<body id="login" class="body">

<c:forEach var="complaint" items="${complaints}">
    <c:out value="${complaint.details}"/>
    <br />
</c:forEach>

</body>