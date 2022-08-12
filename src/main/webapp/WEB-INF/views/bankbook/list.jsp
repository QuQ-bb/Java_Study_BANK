<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%
	//스크립틀릿 <% java code작성 % >
	//html 출력 <%= 자바변수 또는 값 % >
	ArrayList<BankBookDTO> al = (ArrayList<BankBookDTO>)request.getAttribute("list");
%>   --%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!--/bankbook/list  -->
	
	<!-- /bankbook/detail jsp: detail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	
	<!-- 훙냥따리~ -->
	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Rate</th>
				<th>Sale</th>
			</tr>
		</thead>
		  <tbody>
		  	<c:forEach items="${list}" var="book">
		  		<tr>
		  			<td>${book.booknum}</td>
		  			<td>
		  			 <a href="detail.jp?booknum=${book.booknum}">
		  			${book.bookname }
		  			</a>
		  			</td>
		  			<td>${book.bookrate }</td>
		  			<td>${book.booksale }</td>
		  		
		  		
		  		
		  		</tr>
		  		
		  	
		  	</c:forEach>
		  
			<%-- <%for(BankBookDTO bankBookDTO : al){ %>
				<tr>
				<td>BookNum : <%=bankBookDTO.getBooknum() %> </td>
				
				<td>
				<a href="./detail?booknum=<%=bankBookDTO.getBooknum()%>">
				BookName : <%=bankBookDTO.getBookname() %>
				</a>
				</td>
				
				<td>BookRate : <%=bankBookDTO.getBookrate() %></td>
				<td>
					BookSale : 
					<%if(bankBookDTO.getBooksale() == 1){ %>
						판매중
					<% }else { %>	
						판매중단
					<% }  %>
				</td>
				</tr>
			<% } %> --%>
		</tbody>
	</table>
	
	<a href="add.jp">GoodsRegister</a>
	
</body>
</html>