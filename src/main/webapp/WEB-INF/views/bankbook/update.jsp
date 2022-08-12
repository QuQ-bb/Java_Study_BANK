<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Update Page</h3>
	<h1>델리만쥬 먹고싶다</h1>
	
	<form action="update.jp" method="post">
	<table>
		<div>
		Num : <input type="hidden" name ="booknum" value="${update.booknum}" readonly>
		</div>
		<div>		<!-- name 값은 set의 첫글자를 소문자로 바꾼것 -->
		Name : <input type="text" name="bookname" value ="${update.bookname}">
		</div>
		<div>
		Rate : <input type="text" name ="bookrate" value="${update.bookrate}">
		</div>
		<!-- sql에 써있지도 않은 값을 여기다 넣어두니 update이 되지않았음 -->
		<div>
		Sale : <input type="text" name="booksale" value="${update.booksale}" disabled="disabled">
		</div>
		<input type="submit" value ="update">
		<button type="submit">수정</button>
		<br>
		<a href="detail.jp?booknum=${update.booknum}">Back Detail</a>
		
		</tr>	
	
	
	</table>
	</form>
	
	
	<a href="add">Add</a>

</body>
</html>