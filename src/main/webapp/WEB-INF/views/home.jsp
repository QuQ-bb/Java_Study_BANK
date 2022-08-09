<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

 <a href ="/member/login">Login</a><br>
 <a href="/member/join">Join</a><br>
 <a href="/bankbook/list">List</a><br>
 <a href="/bankbook/detail">Detail</a><br>
 <a href="/bankbook/add">상품등록</a>
</body>
</html>
