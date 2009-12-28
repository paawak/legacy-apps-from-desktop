<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="menu.masters.item.title" /></title>
<meta name="heading"
	content="<fmt:message key='menu.masters.item.title'/>" />
<meta name="menu" content="ListItems" />
</head>

	<ul>
		<c:forEach var="item" items="${itemList}">
		  <li>
		      <a href="/masters/new_item.html?id=${item.id}">${item.name}</a>
		  </li>
		</c:forEach>	   
	</ul>

