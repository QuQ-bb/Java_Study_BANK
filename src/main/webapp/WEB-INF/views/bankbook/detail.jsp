<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	
	<!-- 상대경로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
		<%if(bankBookDTO != null){ %>
	<table border="1">
		<tr>
			<td>BookNum : <%=bankBookDTO.getBooknum() %></td>
			<td>BookName : <%=bankBookDTO.getBookname() %></td>
			<td>BookRate : <%=bankBookDTO.getBookrate() %></td>
			<td>
			BookSale : <%if(bankBookDTO.getBooksale() == 1){ %>
						판매중
						<%}else { %>
						판매중단	
			<% } %>
			</td>
		</tr>	
	</table>
	<%}else { %>
		<h3>Data가 존재하지 않습니다.</h3>
	<% } %>

</body>
</html>