<%@ include file="/common/taglibs.jsp"%>

<%--
<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
--%>

<c:choose>
  <c:when test="${pageContext.request.locale.language == 'en'}">
    <c:set var="locale" value="kn" scope="page" />
  </c:when>
  <c:when test="${pageContext.request.locale.language == 'kn'}">
    <c:set var="locale" value="en" scope="page" />
  </c:when>
</c:choose>

<table width = "100%" height = "100%" border = "1" cellpadding = 0 cellspacing = 0 bordercolor="white" style="border-collapse:collapse" >
		<tr>
			<td rowspan="10" width="2%" height="100%" background="<c:url value="/images/bg1222.jpg"/>" style="background-position:right top; background-repeat:repeat-y"></td>
			
			<td colspan="2">
				
			</td>
			
			<td rowspan="10" width="2%" height="100%" background="<c:url value="/images/bg1223.jpg"/>" style="background-position:left top; background-repeat:repeat-y"></td>	
		</tr>
		<tr>
			<td align = "center" colspan= 6 valign = "top">

<Table cellpadding = "0" cellspacing = "0" border = "0" style = "border-collapse:collapse" width = "100%"><tr><td>
	<div id="switchLocale"><a href="<c:url value='${pageContext.request.requestURI}?locale=${locale}'/>"><fmt:message key="locale.${locale}"/> </a></div>

	<div id="branding">
		<table>
			<tr><td colspan = "2">
					<img src="<c:url value="/images/dms/dmslogo.gif"/>"
                	alt="<fmt:message key="logo.warning"/>" class="icon"/>	    		
	    		</td>
	    		<td width = "10">
	    		<td>
	    			<h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a></h1>
	    			<p><font color="gray" size = "1px"><fmt:message key="webapp.tagline"/></font></p><br>
	    		</td>	    		
	    	</tr>	    	
	    </table>
	    <br>
	</div>
	</td>
	</tr>
	</Table>
	

<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>