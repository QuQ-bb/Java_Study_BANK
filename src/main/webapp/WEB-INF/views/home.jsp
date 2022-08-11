<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<c:if test="${empty login}">
 <a href ="/member/login">Login</a><br>
 <a href="/member/join">Join</a><br>
	</c:if>
	<c:if test="${not empty login }">
 <a href="#">Logout</a><br>
 <a href="#">MyPage</a><br>
	 </c:if>
 <a href="/bankbook/list">List</a><br>
 <a href="/bankbook/detail">Detail</a><br>
 <a href="/bankbook/add">GoodsRegister</a><br>
 <a href="/member/search">IDSearch</a><br>
 <a href="/member/list">MemberList</a>
 히잉
</body>
</html>
