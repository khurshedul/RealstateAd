<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	ul.homeList li {
    width: 200px;
    display: inline-block;
    vertical-align: top;
    *display: inline;
    *zoom: 1;
}
.button {
    display: block;
    width: 115px;
    height: 25px;
    background: #4CAF50;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    display: inline
}
</style>
</head>
<body>
 <div class="button"><a href="/RealEstate/CustomerHome">Home</a></div>
<center><h2>Offered Details</h2></center><hr/>
	<ul class="homeList">
		<c:forEach var="homeList" items="${homeList}">
			    <li>
			        <a href="/RealEstate/ShowSpecificDataItem?homeId=${homeList.getHomeId()}">
			            <img src="${homeList.getPic1()}"  width="200px" height="200px">
			            <h4>Name: ${homeList.getHomeTitle()}</h4></a>
			            <p>Price: ${homeList.getPrice()}</p>
			            <p>#Beds: ${homeList.getNoOfBeds()} #Baths: ${homeList.getNoOfBaths()}</p>
			        <div class="button"><a href="/RealEstate/DeleteUserOfferData?homeId=${homeList.getHomeId()}">Delete</a></div>
			        <div class="button"><a href="/RealEstate/modifyhomeofferdata?homeId=${homeList.getHomeId()}">Edit</a></div>
			    </li>
		</c:forEach>
		</ul>
		<ul class="landList">
		<c:forEach var="landList" items="${landList}">
			
			    <li>
			        <a href="/RealEstate/ShowSpecificDataItem?landId=${landList.getLandId()}">
			            <img src="${landList.getPic1()}"  width="200px" height="200px">
						<h4>Name: ${landList.getLandTitle()}</h4></a>
						<p>Price: ${landList.getPrice()}</p>
						<p>#City: ${landList.getCity()} #Katha: ${landList.getTotalKatha()}</p>
			            <div class="button"><a href="/RealEstate/DeleteUserOfferData?landId=${landList.getLandId()}">Delete</a></div>
			            <div class="button"><a href="/RealEstate/modifylandofferdata?landId=${landList.getLandId()}">Edit</a></div>
			    </li>		
		</c:forEach>
		</ul>
		<ul class="officeList">
		<c:forEach var="officeList" items="${officeList}">
			
			    <li>
			        <a href="/RealEstate/ShowSpecificDataItem?officeId=${officeList.getOfficeId()}">
			            <img src="${officeList.getPic1()}"  width="200px" height="200px">
			            <h4>${officeList.getOfficeTitle()}</h4></a>
			            <p>Price: ${officeList.getPrice()}</p>
			            <div class="button"><a href="/RealEstate/DeleteUserOfferData?officeId=${officeList.getOfficeId()}">Delete</a></div>
			            <div class="button"><a href="/RealEstate/modifyofficeofferdata?officeId=${officeList.getOfficeId()}">Edit</a></div>  
			    </li>
		</c:forEach>
		</ul>
</body>
</html>