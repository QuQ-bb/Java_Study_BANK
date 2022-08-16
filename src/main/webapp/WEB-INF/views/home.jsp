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
	<c:if test="${empty sessionScope.member}">
 <a href ="/member/login.jp">Login</a><br>
 <a href="/member/join.jp">Join</a><br>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
	<h3>${member.name}님 환영합니다.</h3>
 <a href="/member/logout.jp">Logout</a><br>
 <a href="#">MyPage</a><br>
	 </c:if>
 <a href="/bankbook/list.jp">List</a><br>
 <a href="/bankbook/detail.jp">Detail</a><br>
 <a href="/bankbook/add.jp">GoodsRegister</a><br>
 <a href="/member/search.jp">IDSearch</a><br>
 히잉
 
 <hr><br>
 August HomeWork<br>
 <c:if test="${not empty sessionScope.member}"> 
 <a href="/board/add.jp">Add</a><br>
 </c:if>
 <a href="/board/list.jp">BoardList</a><br>
 <a href="/board/detail.jp">Detail</a>
</body>
</html>
