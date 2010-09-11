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
		<th style="text-align:left;" colspan="3"><form:checkbox path="selectedFoodItems" value="<%=Food.ALL%>" label="<%=Food.ALL%>"/></th>
	</tr>
	<tr>
		<th style="color:green; text-align:left;"><form:checkbox path="selectedFoodItems" value="<%=Food.RICE%>" label="<%=Food.RICE%>"/></th>
		<th style="color:blue; text-align:left;"><form:checkbox path="selectedFoodItems" value="<%=Food.MANGOES%>" label="<%=Food.MANGOES%>"/></th>
		<th style="color:red; text-align:left;"><form:checkbox path="selectedFoodItems" value="<%=Food.ORANGES%>" label="<%=Food.ORANGES%>"/></th>
	</tr>
	<tr>
		<td style="color:green;"><form:checkbox path="selectedFoodItems" value="<%=Food.AUS%>" label="<%=Food.AUS%>"/></td>
		<td style="color:blue;"><form:checkbox path="selectedFoodItems" value="<%=Food.LANGDA%>" label="<%=Food.LANGDA%>"/></td>
		<td style="color:red;"><form:checkbox path="selectedFoodItems" value="<%=Food.NAGPUR%>" label="<%=Food.NAGPUR%>"/></td>
	</tr>
	<tr>
		<td style="color:green;"><form:checkbox path="selectedFoodItems" value="<%=Food.BORO%>" label="<%=Food.BORO%>"/></td>
		<td style="color:blue;"><form:checkbox path="selectedFoodItems" value="<%=Food.FOJLI%>" label="<%=Food.FOJLI%>"/></td>
		<td style="color:red;"><form:checkbox path="selectedFoodItems" value="<%=Food.DARJEELING%>" label="<%=Food.DARJEELING%>"/></td>
	</tr>
	<tr>
		<td style="color:green;"><form:checkbox path="selectedFoodItems" value="<%=Food.BASMATI%>" label="<%=Food.BASMATI%>"/></td>
		<td style="color:blue;"><form:checkbox path="selectedFoodItems" value="<%=Food.DUSSERI%>" label="<%=Food.DUSSERI%>"/></td>
		<td style="color:red;"><form:checkbox path="selectedFoodItems" value="<%=Food.WELLINGTON%>" label="<%=Food.WELLINGTON%>"/></td>
	</tr>
	<tr>
		<td style="color:green;"><form:checkbox path="selectedFoodItems" value="<%=Food.SONAMASURI%>" label="<%=Food.SONAMASURI%>"/></td>
		<td style="color:blue;" colspan="2"><form:checkbox path="selectedFoodItems" value="<%=Food.ALFONSO%>" label="<%=Food.ALFONSO%>"/></td>
	</tr>
	<tr>
		<td style="text-align:center;" colspan="3"><input type="submit" value="Submit"/></td>
	</tr>
</table>
</form:form>
</body>
</html>