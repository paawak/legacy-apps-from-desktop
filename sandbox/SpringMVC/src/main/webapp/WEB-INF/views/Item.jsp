<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Item</title>
	</head>
	<body>
	
		<form:form commandName="command" method="post">
			<div>
				<table style="text-align: left; width: 100%;" border="0" cellpadding="2"
				cellspacing="2">
					<tbody>
						<tr>
							<th style="vertical-align: top;">Select</th>
							<th style="vertical-align: top;">Item Name</th>
							<th style="vertical-align: top;">Price</th>
							<th style="vertical-align: top;">Quantity</th>
						</tr>
						<c:forEach var="item" items="${command.items}" varStatus="count">
						<tr>
							<td style="vertical-align: middle;">
								<form:checkbox path="items[${count.index}].selected"/>
							</td>
							<td style="vertical-align: middle;">
								<form:input readonly="true" path="items[${count.index}].itemName" size="60"/>
							</td>
							<td style="vertical-align: middle;">
								<form:input readonly="true" path="items[${count.index}].price" size="7"/>
							</td>
							<td style="vertical-align: middle;">
								<form:input path="items[${count.index}].quantity" size="3"/>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form:form>
	
	</body>
</html>