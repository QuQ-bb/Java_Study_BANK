<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>BOARD DETAIL PAGE</h3>
		<table border="1">
			<tr>
				<th>BoardNum</th>
				<td>${detail.boardNum}</td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${detail.username}</td>
				<td>세션:${member.username}</td>
				
			</tr>
			<tr>
			<th>Hit</th>
				<td>${detail.hit}</td>
			</tr>
			<tr>
			<th>Date</th>
				<td>${detail.reporting_date}</td>
			</tr>
			<tr>
				<th>BoardTitle</th>
				<td>${detail.boardTitle}</td>
			</tr>
			<tr>
				<th>BoardContent</th>
				<td>${detail.boardContent }</td>
			</tr>
		
		
		</table>


	<a href="list.jp">Back List</a>
	<c:if test="${member.username eq detail.username }">
	<a href="update.jp?boardNum=${detail.boardNum}">Board Update</a>
	<a href="delete.jp?boardNum=${detail.boardNum}">Board Delete</a>
	</c:if>
</body>
</html>