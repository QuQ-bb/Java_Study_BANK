<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>UPDATE PAGE</h3>
	<form action="update.jp" method="post">
				<input type="hidden" name ="boardNum" value="${update.boardNum}">
	<table border="1">
			<tr>
				<th>BoardNum</th>
				<td>
				${update.boardNum}
				</td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${update.username}</td>
				
			</tr>
			<tr>
			<th>Hit</th>
				<td>${update.hit}</td>
			</tr>
			<tr>
			<th>Date</th>
				<td>${update.reporting_date}</td>
			</tr>
			<tr>
				<th>BoardTitle</th>
				<td>
				<input type="text" name ="boardTitle" value="${update.boardTitle}">
				
				</td>
			</tr>
			<tr>
				<th>BoardContent</th>
				<td>
				<textarea rows="20" cols="20" name="boardContent">${update.boardContent}</textarea>
				
				</td>
			</tr>
		</table>
		<input type="submit" value="UPDATE">
		</form>

</body>
</html>