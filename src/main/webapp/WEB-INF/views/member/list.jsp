<%@page import="com.iu.start.member.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% ArrayList<BankMembersDTO> al = (ArrayList<BankMembersDTO>)request.getAttribute("search"); %>
<body>
	<h3>Search List</h3>
	<table border ="1">
		<thead>
			<tr>
			<th>username</th>
			<th>name</th>
			<th>email</th>
			<th>phone</th>
			</tr>
		</thead>
		
		<tbody>
			<%for(BankMembersDTO bankMembersDTO : al) { %>
	
			<td>MemberID:<%=bankMembersDTO.getUsername() %></td>
			<td>MeberName : <%=bankMembersDTO.getName() %> </td>
			<td>MemberEmail : <%=bankMembersDTO.getEmail() %></td>
			<td>MemberPhone : <%=bankMembersDTO.getPhone() %></td>
		
		</tbody>
	<% } %>	
	
	</table>

</body>
</html>