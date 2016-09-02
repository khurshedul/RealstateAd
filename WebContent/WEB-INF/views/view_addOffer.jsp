<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Offer</title>
</head>
<body>
	<center>
		<form method="post">
		<h4>${message}</h4>
		<label>Offer Title: </label>
		<input type="text" name="offertitle"/>
		<input type="submit" value="AddOffer"/>
		</form>
	</center>

</body>
</html>