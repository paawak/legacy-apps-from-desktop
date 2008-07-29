<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="complainant.new.title" /></title>
<meta name="heading"
	content="<fmt:message key='complainant.new.heading'/>" />
<meta name="menu" content="NewComplainant" />
</head>

<spring:bind path="complainant.*">
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

<form:form commandName="complainant" method="post">
		
		<div align = "center">
		 <!-- #D7E9E5 -->
		<table bgcolor = "#EBF5FC" width = "100%" cellpadding = "2" cellspacing = "2" border = "0" 
				style = "border-collapse:collapse;border-color:blue;">
			<tr><td height = "20"></td></tr>
			<tr><td width = "2%"></td>
				<td align = "left">
	            	<appfuse:label styleClass="desc" key="user.firstName"/>
	            </td>
	            <td align = "left">
		            <form:errors path="firstName" cssClass="fieldError"/>
		            <form:input path="firstName" id="firstName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        		</td>
        		</tr>
        		
        		<tr><td width = "2%">
        			<td align = "left">
	            		<appfuse:label styleClass="desc" key="user.lastName"/>
	             	</td>
	            	<td align = "left">
	            		<form:errors path="lastName" cssClass="fieldError"/>
	            		<form:input path="lastName" id="lastName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
        			</td>
        		</tr>        		
        		<tr><td width = "2%">
        			<td align = "left">
        				<appfuse:label styleClass="desc" key="complainant.email"/>
        			</td>
	            	<td align = "left">
	            		<form:errors path="emailId" cssClass="fieldError"/>
        				<form:input path="emailId" id="emailId" cssClass="text large" cssErrorClass="text large error"/>   
	            	</td>
        		</tr>        		
        		<tr><td width = "2%">
        			<td align = "left">        
                		<appfuse:label styleClass="desc" key="user.phoneNumber"/>
                	</td>
	            	<td align = "left">
                		<form:errors path="homePhone" cssClass="fieldError"/>
                		<form:input path="homePhone" id="homePhone" cssClass="text medium" cssErrorClass="text medium error"/>
           			</td>
        		</tr>        		
        		<tr><td width = "2%">
        			<td align = "left">
                		<appfuse:label styleClass="desc" key="complainant.handPhone"/>
                	</td>
	            	<td align = "left">
                		<form:errors path="handPhone" cssClass="fieldError"/>
                		<form:input path="handPhone" id="phoneNumber" cssClass="text medium" cssErrorClass="text medium error"/>
           			</td>
        		</tr>        		
        		<tr><td width = "2%">
        			<td align = "left">
        				<label class="desc"><fmt:message key="user.address.address"/></label>
        			</td>
	            	<td align = "left">      
                		<form:input path="address.address" id="address.address" cssClass="text large" cssErrorClass="text large error"/>
                		<form:errors path="address.address" cssClass="fieldError"/>
                		<appfuse:label key="user.address.address"/>
                	</td>
        		</tr>        		
        		<tr><td width = "2%">
        			<td> </td>
        		
        			<td align = "left">
        				<table width = "100%" cellpadding = "2" cellspacing = "2" border = "0" style = "border-collapse:collapse">
        					<tr>
        						<td>
                					<form:input path="address.city" id="address.city" cssClass="text medium" cssErrorClass="text medium error"/>
			                		<form:errors path="address.city" cssClass="fieldError"/>
			                		<appfuse:label key="user.address.city"/>
			                	</td>
			        		</tr>        		
			        		<tr>
				            	<td>
			                		<form:input path="address.province" id="address.province" cssClass="text state" cssErrorClass="text state error"/>
			                		<form:errors path="address.province" cssClass="fieldError"/>
			                		<appfuse:label key="user.address.province"/>
			                	</td>
			        		</tr>        		
			        		<tr>
				            	<td>
			                		<form:input path="address.postalCode" id="address.postalCode" cssClass="text medium" cssErrorClass="text medium error"/>
			                		<form:errors path="address.postalCode" cssClass="fieldError"/>
			                		<appfuse:label key="user.address.postalCode"/>
			                	</td>
			        		</tr>        		
			        		<tr>
				            	<td>
			                		<appfuse:country name="address.country" prompt="" default="${user.address.country}"/>
			                		<appfuse:label key="user.address.country"/>
			                	</td>
			        		</tr>
        				</table>
	            	</td>
	            </tr>
	            
	            <tr>
	            	<td colspan = "3">
	            		<table width = "100%" cellpadding = "0" cellspacing = "0" border = "0" style = "border-collapse:collapse">
	            			<tr>
	            				<td>
	            					<img src="<c:url value="/images/dms/botLeft.gif"/>"/>
	            				</td>
	            				<td align = "right" width = "90%" background = "<c:url value="/images/dms/botCenter.gif"/>">
	            					<input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        							<input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
	            				</td>
	            				<td>
	            					<img src="<c:url value="/images/dms/botRight.gif"/>"/>
	            				</td>
	            			</tr>
	            		</table>
	            	</td>
	            </tr>	            
        	</table>
        	</div>
</form:form>
