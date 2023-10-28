<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page = "/pages/include.jsp"/>


<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
 


<div align="center">
<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
	<TR VALIGN=TOP>
		<TH colspan="2">
			<spring:message code = "app.deletebook.title"/>
		</TH>
	</TR>
	<TR VALIGN=TOP>
		<TD colspan="2">
		</TD>
	</TR>
	</TABLE>

	<form:form method ="POST" modelAttribute = "book" action = "/deleteBook">
		<form:errors path = "*" cssClass = "errorblock" element = "div"/>
		

		<table>
			
			<tr>
				<td> <spring:message code = "app.book_number"/>  </td>
				<td> <form:input path = "bookNumber"/>  </td>
				<td> <form:errors path = "bookNumber" cssClass = "error" element = "div"/>  </td>
			</tr>
		
			
		</table>
		
		<form method="post" action="/deleteBook">
    		<button>Delete Book</button>
		</form>
		
	</form:form>





</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>