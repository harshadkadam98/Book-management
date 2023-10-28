<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page = "/pages/include.jsp"/>

<c:if test = "${sessionScope.user != null}">

<div align="right"><table><tr><td>
<spring:url var = "fetchurl" value = "/logout"/>
<a href = "${fetchurl}"> Logout </a>
                                                        </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


</c:if>




<div align="center">
<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">
	
		<TR VALIGN=TOP>
		<TH colspan="2">
			<spring:message code = "app.books.title"/>
		</TH>
	</TR>
	<TR VALIGN=TOP>
		<TD colspan="2">
		</TD>
	</TR>
	</TABLE>
	
	<form:form method ="GET" modelAttribute = "user" action = "books">
		<form:errors path = "*" cssClass = "errorblock" element = "div"/>
	
	<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">
			
			<c:forEach var = "o" items = "${book}" >
	  
			<tr>
				<td> ${o.name}</td>
				<td> ${o.author}</td>	
			
				
			</tr>
			
			</c:forEach>
		
			
	</table>
	
	<c:if test = "${not empty user}"> 	<a href="/addBookPage">Add Book</a>
	<a href="/deleteBookPage">Delete Book</a> 
	<a href="/updateBookPage">Update Book</a>
	</c:if>
	
	
	
	
	</form:form>
	
</TABLE>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>