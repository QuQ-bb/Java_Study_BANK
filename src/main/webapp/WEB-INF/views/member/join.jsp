<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	
	<form action="./join" method="post">
        <h1>회원가입</h1>
        <div>
            ID : <input type="text" name="username" placeholder="ID를 입력해 주세요.">
         </div>
         <div>  
            PW : <input type="password" name="password" placeholder="PW를 입력해 주세요.">
        </div> 
        <div> 
            NAME  : <input type="text" name="name" placeholder="이름을 입력해 주세요.">
        </div>
        <div>     
            EMAIL : <input type="email" name="email" placeholder="Email를 입력해 주세요.">
        </div>     
        <div>
            PHONE : <input type="tel" name="phone" placeholder="전화번호를 입력해주세요.">
        </div>    
        <div>
            <input type="submit" value="회원가입">
            <input type="reset">
        </div>
    </form>

</body>
</html>