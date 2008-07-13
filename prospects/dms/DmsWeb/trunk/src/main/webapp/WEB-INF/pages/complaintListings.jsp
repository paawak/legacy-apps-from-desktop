<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="complaintListings.title" /></title>
<meta name="heading"
	content="<fmt:message key='complaintListings.heading'/>" />
<meta name="menu" content="ComplaintListings" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
</head>

<spring:bind path="testStrings">
	<c:forEach var="string" items="${testStrings}">
		<c:out value="${string}" escapeXml="false" />
		<br />
	</c:forEach>
</spring:bind>

<body id="login" class="body">
<p>Content goes here...</p>
</body>