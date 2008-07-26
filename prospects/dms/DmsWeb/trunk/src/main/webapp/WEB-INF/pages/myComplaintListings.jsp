<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="myComplaintListings.title" /></title>
<meta name="heading"
	content="<fmt:message key='myComplaintListings.heading'/>" />
<meta name="menu" content="MyComplaintListings" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
</head>

<body id="login" class="body">

<c:forEach var="complaint" items="${complaints}">
    <c:out value="${complaint.details}"/>
    <br />
</c:forEach>

</body>