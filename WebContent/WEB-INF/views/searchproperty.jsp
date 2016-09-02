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
<style>
	ul.homeList li {
    width: 200px;
    display: inline-block;
    vertical-align: top;
    *display: inline;
    *zoom: 1;
}
</style>
</head>
<body class="" style="background-color: lightgray">
	<div class="flex-container">
		<center>	
			<div class="search" style="margin-top: 40px;">
				<p class="warning" id="searchWarningTag"> </p>
				<form action="" method="post" onsubmit="return checkEmptyOrNot();">
					<select name="city" id="city" onchange="getArea();">
						<option value="null">-- Select City --</option>
				    	<c:forEach var="city" items="${cityList}">
							<option value="${city.getCityTitle()}">${city.getCityTitle()}</option>
						</c:forEach>
					</select>
					<select name="area" id="area" id="area">
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
		</center><hr/>
	<ul class="homeList">
		<c:forEach var="homeList" items="${homeList}">
			    <li>
			        <a href="/RealEstate/ShowSpecificDataItem?homeId=${homeList.getHomeId()}">
			            <img src="${homeList.getPic1() }" width="200px" height="200px">
			            <h4>Name: ${homeList.getHomeTitle()}</h4></a>
			            <p>Price: ${homeList.getPrice()}</p>
			            <p>#Beds: ${homeList.getNoOfBeds()} #Baths: ${homeList.getNoOfBaths()}</p>
			    </li>
		</c:forEach>
		</ul>
		<ul class="homeList">
		<c:forEach var="landList" items="${landList}">
			
			    <li>
			        <a href="/RealEstate/ShowSpecificDataItemForLand?homeId=${landList.getLandId()}">
			            <img src="${landList.getPic1()}" width="200px" height="200px">
						<h4>Name: ${landList.getLandTitle()}</h4></a>
						<p>Price: ${landList.getPrice()}</p>
						<p>#City: ${landList.getCity()} #Katha: ${landList.getTotalKatha()}</p>
			    </li>		
		</c:forEach>
		</ul>
		<ul class="homeList">
		<c:forEach var="officeList" items="${officeList}">
			
			    <li>
			        <a href="#">
			            <img src="${officeList.getPic1()}"  width="200px" height="200px">
			            <h4>${officeList.getOfficeTitle()}</h4></a>
			            <p>Price: ${officeList.getPrice()}</p>
			    </li>
		</c:forEach>
		</ul>
		<footer id="footer">Copyright © Prosen Ghosh</footer>
	</div>
</body>
</html>