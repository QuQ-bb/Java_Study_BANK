<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>

		<form action="./login" method="post"> <!-- action="요청주소" -->
		        <h1>로그인</h1>
		
		        <div>
		            ID
		            <input type="text" name="id" placeholder="ID를 입력해주세요.">
		        </div>
		        <div>
		            PW
		            <input type="password" name="pw" placeholder="PW를 입력해주세요.">
		        </div>
		        <div>
		           <input type="checkbox" name="check">  ID Remember  
		        </div>
		        <div>
		            <input type="submit" value="로그인">
		            <input type="reset">
		            <a href="/study_index.html">Index Page</a><!--절대경로-->
		            <a href="../study_index.html">인덱스 상대이이이잉</a> <!--상대경로-->
		            <img src="/images/jjupul.jpg"> <!--절대경로-->
		            <img src="../images/chim.jpg">
		            
		        </div>
		       
		
		    </form>


</body>
</html>