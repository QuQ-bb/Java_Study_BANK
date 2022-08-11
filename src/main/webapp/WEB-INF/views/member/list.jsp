<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <% 
ArrayList<BankMembersDTO> al = (ArrayList<BankMembersDTO>)request.getAttribute("search");
%> --%>
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
		<%-- <c:forEach  begin="0" end ="10" var="i" step="2">
		<!-- for (int i=0; i<10; i+=2) -->
		<h3>${pageScope.i}</h3>
		</c:forEach> --%>
		
		<c:forEach items="${requestScope.search}" var="search">
			<tr>
				<td>${pageScope.search.username}</td>
				<td>${pageScope.search.name}</td>
				<td>${pageScope.search.email}</td>
				<td>${pageScope.search.phone}</td>
			</tr>
		 
		</c:forEach>
		
			<%-- <%for(BankMembersDTO bankMembersDTO : al) { %>
	
			<td>MemberID:<%=bankMembersDTO.getUsername() %></td>
			<td>MeberName : <%=bankMembersDTO.getName() %> </td>
			<td>MemberEmail : <%=bankMembersDTO.getEmail() %></td>
			<td>MemberPhone : <%=bankMembersDTO.getPhone() %></td>
		
		
	<% } %>	 --%>
		</tbody>
	</table>

</body>
</html>