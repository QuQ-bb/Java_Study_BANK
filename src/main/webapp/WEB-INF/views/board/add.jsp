<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>BOARD ADD Page</h3>
	<form action ="add.jp", method="post">
		<table border="1">
			<tr>
				<th>Writer</th>
				<td>
				<input type="text" name ="username" value="${member.username}" >
				</td>
			</tr>
			<tr>
					<th>BoardTitle</th>
				<td>
				<input type="text" name ="boardTitle" placeholder="글제목을 입력해주세요">
				</td>
			</tr>
			
				<tr>
					<th>BoardContent</th>
					<td>
						<textarea rows="20" cols="30" name="boardContent"></textarea>
					</td>	
			</tr>
		</table>
		<input type="submit" value="글작성"><br>
		<a href="list.jp">Back</a>
	</form>


</body>
</html>