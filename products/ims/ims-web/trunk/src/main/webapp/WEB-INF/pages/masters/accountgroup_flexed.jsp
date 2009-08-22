<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.masters.accountGroup.title"/></title>
    <meta name="heading" content="<fmt:message key='menu.masters.accountGroup.title'/>"/>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<script src="AC_OETags.js" language="javascript"></script>


<script language="JavaScript" type="text/javascript">

// -----------------------------------------------------------------------------
// Globals
// Major version of Flash required
var requiredMajorVersion = 9;
// Minor version of Flash required
var requiredMinorVersion = 0;
// Minor version of Flash required
var requiredRevision = 124;
// -----------------------------------------------------------------------------

</script>
</head>

<body scroll="no">
<script language="JavaScript" type="text/javascript">

// Version check for the Flash Player that has the ability to start Player Product Install (6.0r65)
var hasProductInstall = DetectFlashVer(6, 0, 65);

// Version check based upon the values defined in globals
var hasRequestedVersion = DetectFlashVer(requiredMajorVersion, requiredMinorVersion, requiredRevision);

if ( hasProductInstall && !hasRequestedVersion ) {
    // DO NOT MODIFY THE FOLLOWING FOUR LINES
    // Location visited after installation is complete if installation is required
    var MMPlayerType = (isIE == true) ? "ActiveX" : "PlugIn";
    var MMredirectURL = window.location;
    document.title = document.title.slice(0, 47) + " - Flash Player Installation";
    var MMdoctitle = document.title;

    AC_FL_RunContent(
        "src", "playerProductInstall",
        "FlashVars", "MMredirectURL="+MMredirectURL+'&MMplayerType='+MMPlayerType+'&MMdoctitle='+MMdoctitle+"",
        "width", "1000",
        "height", "1000",
        "align", "middle",
        "id", "NewAccountGroup",
        "quality", "high",
        "bgcolor", "#869ca7",
        "name", "NewAccountGroup",
        "allowScriptAccess","sameDomain",
        "type", "application/x-shockwave-flash",
        "pluginspage", "http://www.adobe.com/go/getflashplayer"
    );
} else if (hasRequestedVersion) {
    // if we've detected an acceptable version
    // embed the Flash Content SWF when all tests are passed
    AC_FL_RunContent(
            "src", "NewAccountGroup",
            "width", "1000",
            "height", "1000",
            "align", "middle",
            "id", "NewAccountGroup",
            "quality", "high",
            "bgcolor", "#869ca7",
            "name", "NewAccountGroup",
            "allowScriptAccess","sameDomain",
            "type", "application/x-shockwave-flash",
            "pluginspage", "http://www.adobe.com/go/getflashplayer"
    );
  } else {  // flash is too old or we can't detect the plugin
    var alternateContent = 'Alternate HTML content should be placed here. '
    + 'This content requires the Adobe Flash Player. '
    + '<a href=http://www.adobe.com/go/getflash/>Get Flash</a>';
    document.write(alternateContent);  // insert non-flash content
  }

</script>
    
</head>

<spring:bind path="accountGroup.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">    
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<div class="separator"></div>

<p>
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
            id="NewAccountGroup" width="100%" height="100%"
            codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
            <param name="movie" value="http://localhost:8080/flash/exp.swf" />
            <param name="quality" value="high" />
            <param name="bgcolor" value="#869ca7" />
            <param name="allowScriptAccess" value="sameDomain" />
            <embed src="http://localhost:8080/flash/exp.swf" quality="high" bgcolor="#869ca7"
                width="1000" height="1000" name="NewAccountGroup" align="middle"
                play="true"
                loop="false"
                quality="high"
                allowScriptAccess="sameDomain"
                type="application/x-shockwave-flash"
                pluginspage="http://www.adobe.com/go/getflashplayer">
            </embed>
    </object>
</p>




