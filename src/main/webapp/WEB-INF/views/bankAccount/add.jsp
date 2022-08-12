<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Account Join</h3>

	<form action="add.jp" method="post">
		<table boreder="1">
			<tr>
				<th>AccountNum</th>
				<th>UserName</th>
				<th>BookNum</th>
				<th>AccountDate</th>
			</tr>
			<tr>
				<td></td>
				<td>${member.username}</td>
				<td>${ac.booknum}</td>
				<td></td>
			</tr>
		</table>
			<input type="submit" value="Account Join">
	</form>
</body>
</html>