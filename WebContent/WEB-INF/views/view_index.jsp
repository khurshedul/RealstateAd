<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="/public/head.jsp" />
<jsp:include page="/public/navigationDiv.jsp" />
<link rel="stylesheet" href="/RealEstate/public/css/signup.css"/>
<script type="text/javascript" src="/RealEstate/public/js/signup.js"></script>	
<link rel="stylesheet" type="text/css" href="public/css/main_style.css"/>
<script type="text/javascript" src="public/js/emptyValidation.js"></script>
<script type="text/javascript" src="public/js/ajax.js"></script>
</head>
<body class="homebg" background="C:/Users/Rizve/Desktop/Image For Project/home_bg.jpg">
	<div class="flex-container">
		<center>	
			<div class="search">
				<p class="warning" id="searchWarningTag"> </p>
				<form action="" method="post" onsubmit="return checkEmptyOrNot();">
					<select name="city" id="city" onchange="getArea();">
						<option value="null">-- Select City --</option>
				    	<c:forEach var="city" items="${cityList}">
							<option value="${city.getCityTitle()}">${city.getCityTitle()}</option>
						</c:forEach>
					</select>
					<select name="area" id="area">
					<option value="null">-- Select Area --</option>
					</select>
					<select name="propertyTypes" id="propertyTypes">
						<option value="null">-- Property Types --</option>
					 	<c:forEach var="propertyTypes" items="${propertyTypes}">
							<option value="${propertyTypes}">${propertyTypes}</option>
						</c:forEach>
					</select>
					<select name="minPrice" id="minPrice">
						<option value="null">-- Min Price --</option>
						<c:forEach var="minPrice" items="${minPrices}">
							<option value="${minPrice}">${minPrice}</option>
						</c:forEach>
					</select>
					<select name="maxPrice" id = "maxPrice">
						<option value="null">-- Max Price --</option>
					 	<c:forEach var="maxPrice" items="${maxPrices}">
							<option value="${maxPrice}">${maxPrice}</option>
						</c:forEach>
					</select><br/>
					<input type="submit" name="submit" value="Search">
				</form>
			</div>
		</center>
		<footer id="footer">Copyright © Prosen Ghosh</footer>
	</div>
</body>
</html>