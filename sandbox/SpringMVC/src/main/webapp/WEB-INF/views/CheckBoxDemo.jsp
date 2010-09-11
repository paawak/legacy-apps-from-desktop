<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.swayam.demo.web.formbean.Food"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckBox Demo</title>
</head>
<body>
<form:form commandName="command" method="post">
<table align="center"">
	<tr>
		<td colspan="4"><form:checkbox path="selectedFoodItems" value="<%=Food.ALL%>" label="<%=Food.ALL%>"/></td>
	</tr>
	<tr>
		<td>Rice</td>
		<td>Mangoes</td>
		<td>Apples</td>
		<td>Oranges</td>
	</tr>
	<tr>
		<td>Aus</td>
		<td>Basmati</td>
		<td>Sona Masuri</td>
		<td>Boro</td>
	</tr>
	<tr>
		<td>Langda</td>
		<td>Fojli</td>
		<td>Dusseri</td>
		<td>Alfonso</td>
	</tr>
	<tr>
		<td>Nagpur</td>
		<td>Darjeeling</td>
		<td colspan="2">Wellington</td>
	</tr>
</table>
</form:form>
</body>
</html>