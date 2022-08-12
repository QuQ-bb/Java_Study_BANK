<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

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
	<a href="../member/login.jp">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join.jp">Join</a>
	
	
	<form action="detail.jp">
	<table border="1">
		<tr>
			<td>BookNum  : ${requestScope.detail.getBooknum() }</td>
			<td>BookName : ${requestScope.detail.bookname}</td>
			<td>BookRate : ${detail.bookrate}</td>
			<td>BookSale : ${detail.booksale} </td>
		</tr>	
	</table>
	</form>
	<a href="list.jp">Back List</a>
	<a href="update.jp?booknum=${detail.booknum}">Update</a>
	<a href="delete.jp?booknum=${detail.booknum}">Delete</a>
	<c:if test="${not empty sessionScope.member }">
	<a href="../bankAccount/add.jp?booknum=${detail.booknum}">AccountJoin</a>
	</c:if>

</body>
</html>