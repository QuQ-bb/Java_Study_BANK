<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
<%
	//요청이 발생하면 생성, 응답이 나가면 소멸: RequestScope
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail");
%> 
--%>
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
	
	
	<form action="detail">
	<table border="1">
		<tr>
			<td>BookNum  : ${requestScope.detail.getBooknum() }</td>
			<td>BookName : ${requestScope.detail.bookname}</td>
			<td>BookRate : ${detail.bookrate}</td>
			<td>BookSale : ${detail.booksale} </td>
		</tr>	
	</table>
	</form>
	<a href="list">Back List</a>
	<a href="update?booknum=${detail.booknum}">Update</a>
	<a href="delete?booknum=${detail.booknum}">Delete</a>

</body>
</html>