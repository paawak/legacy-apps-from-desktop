<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="menu.masters.lot.title" /></title>
<meta name="heading"
	content="<fmt:message key='menu.masters.lot.title'/>" />
<meta name="menu" content="NewLot" />
</head>

<spring:bind path="lot.*">
	<c:if test="${not empty status.errorMessages}">
		<div class="error"><c:forEach var="error"
			items="${status.errorMessages}">
			<img src="<c:url value="/images/iconWarning.gif"/>"
				alt="<fmt:message key="icon.warning"/>" class="icon" />
			<c:out value="${error}" escapeXml="false" />
			<br />
		</c:forEach></div>
	</c:if>
</spring:bind>

<form:form commandName="lot" method="post">

	<ul>

        <li>
            <appfuse:label styleClass="desc" key="lot.item" />
            <form:errors path="item" cssClass="fieldError" />
            <form:select path="item"
                id="item" cssClass="text large"
                cssErrorClass="text large error">
                <option value="-1">------Select One------</option>

                <c:forEach var="item" items="${itemList}">
                    <option value="${item.id}"
                        <c:if test="${item.id == lot.item.id}">
                                                selected="true"
                                            </c:if>>${item.name}</option>
                </c:forEach>
            </form:select>
        </li>

        <li>
            <appfuse:label styleClass="desc" key="lot.batchNo" />
            <form:errors path="batchNo" cssClass="fieldError" />
            <form:input path="batchNo" id="batchNo" cssClass="text medium" cssErrorClass="text medium error" maxlength="50" />
        </li>

		<li>
			<appfuse:label styleClass="desc" key="lot.price" />
			<form:errors path="price" cssClass="fieldError" />
			<form:input path="price" id="price" cssClass="text medium" cssErrorClass="text medium error" maxlength="10" />
		</li>
		
		<li>
            <appfuse:label styleClass="desc" key="lot.quantity" />
            <form:errors path="quantity" cssClass="fieldError" />
            <form:input path="quantity" id="price" cssClass="text medium" cssErrorClass="text medium error" maxlength="10" />
        </li>

		

		<li>
			<div align="center">
			<table width="100%" cellpadding="0" cellspacing="0" border="0"
				style="border-collapse: collapse">
				<tr>
					<td><img src="<c:url value="/images/dms/botLeft.gif"/>" /></td>
					<td align="center" width="90%"
						background="<c:url value="/images/dms/botCenter.gif"/>"><input
						type="submit" class="button" name="save"
						value="<fmt:message key="button.save"/>" /> <input type="submit"
						class="button" name="cancel"
						value="<fmt:message key="button.cancel"/>" /></td>
					<td><img src="<c:url value="/images/dms/botRight.gif"/>" /></td>
				</tr>
			</table>
			</div>
		</li>
	</ul>
</form:form>
