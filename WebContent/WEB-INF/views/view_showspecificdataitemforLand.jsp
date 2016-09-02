<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item</title>
<style>
	ul.div li {
    width: 400px;
    display: inline-block;
    vertical-align: top;
    *display: inline;
    *zoom: 1;
}
</style>
</head>
<body>
<h1>Hello</h1>
	<ul class="div">
		<li>
			<img src="${data.getPic1()}"  width="400px" height="400px">
			<h4>Name: ${data.getLandTitle()}</h4>
			<p>Price: ${data.getPrice()}</p>
			<p>#City: ${data.getCity()} #Katha: ${data.getTotalKatha()}</p> 
		</li>
	</ul>
</body>
</html>