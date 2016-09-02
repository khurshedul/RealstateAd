<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<form method="post" >
		<input type="text" name="txtsearch"/> <input type="submit" value="Search"/>
	</form>
	<br/>
	<br/>
	<table border="1px">
		<tr>
			<th>Username</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Address</th>
			<th>Contact Number</th>
		</tr>
		<c:forEach  var="s" items="${userlist}">
		<tr>
			<td>${s.username}</td>
			<td>${s.name}</td>
			<td>${s.password}</td>
			<td>${s.email}</td>
			<td>${s.address}</td>
			<td>${s.contactnumber}</td>
		</tr>
		</c:forEach>	
	</table>
	
</center>

</body>
</html>