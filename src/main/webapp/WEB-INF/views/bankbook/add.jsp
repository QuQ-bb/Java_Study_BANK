<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Add Page</h3>
	
	<form action="./add" method="post">
	<table>
		<div>
		통장번호 : <input type="text" name ="booknum" placeholder="BookNum을 입력해주세요.">
		</div>
		<div>
		통장이름 : <input type="text" name = "bookname" placeholder="BookName을 입력해주세요.">
		</div>
		<div>
		이자율 : <input type="text" name="bookrate" placeholder="BookRate을 입력해주세요.">
		</div>
		<div>
		 판매여부 : <input type="text" name="booksale" placeholder="BookSale을 입력해주세요.">
		</div>
		<div>
			<input type="submit" value="상품등록">
			<input type="reset">
		</div>
	
	</table>
	
	</form>

</body>
</html>