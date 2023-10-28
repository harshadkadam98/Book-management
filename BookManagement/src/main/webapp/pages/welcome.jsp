<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page = "/pages/include.jsp"/>


<div align="center">
<TABLE WIDTH=60% BORDER=1 BORDERCOLOR="#aabbcc">
	<TR VALIGN=TOP>
		<TD WIDTH=50%>
			<spring:url var = "fetchurl" value ="/books"/>
			<a href = "${fetchurl}"> <spring:message code = "app.home.checkAvailability"/> </a>
			
		</TD>
		<TD WIDTH=50%>
			

			<spring:url var = "fetchurl" value ="/login"/>
			<a href = "${fetchurl}"> <spring:message code = "app.login"/> </a>
		</TD>
	</TR>
</TABLE>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>