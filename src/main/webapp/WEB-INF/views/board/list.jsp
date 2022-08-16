<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>List Page</h3>
	
	<table border="1">
		<tr>
			<th>BoardNum</th>		
			<th>BoardTitle</th>		
			<th>Writer</th>
			<th>Reporting Date</th>		
			<th>Hit</th>		
		</tr>
		<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.boardNum}</td>
			<td>
				<a href="detail.jp?boardNum=${list.boardNum}">
				${list.boardTitle}
				</a>
			</td>
			<td>${list.username}</td>
			<td>${list.reporting_date}</td>
			<td>${list.hit}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="/">Back</a>
	<c:if test="${not empty sessionScope.member}">
	<a href="add.jp">Add</a>
	</c:if>
	
	

</body>
</html>