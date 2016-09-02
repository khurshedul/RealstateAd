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
	
		<form method="post">
		<br/><br/>
		<h4>${message}</h4>
			<label>City: </label>
			<select name = "city">
			<c:forEach  var="s" items="${citylist}">
				<option>${s.cityTitle}</option>
			</c:forEach>	
			</select>
			<br/><br/>
			<label>Area: </label>
			<input type="text" name="area"/>
			<input type="submit" value="Add Area"/>
		
		
		</form>
	
	</center>
					

</body>
</html>