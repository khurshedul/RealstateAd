<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="public/js/ajax.js"></script>
<title>Insert title here</title>
</head>
<body onload="getArea()">
	<form method="post" enctype="multipart/form-data">
	<table>			
			<tr>
				<td>Title: </td>
				<td><input type="text" name="title" id="title" value="${data.getOfficeTitle()}"/></td>
				<td><input type="hidden" name="officeid" id="officeid"value="${data.getOfficeId()}" /></td>
			</tr>
			<tr>
				<td>Office Size:</td>
				<td><input type="text" name="size" id="size" value="${data.getSizeInSqFeet()}"/></td>
			</tr>
			<tr>
				<td>Floor:</td>
				<td><select name = "floor">
					<c:forEach  var="s" items="${floors}">
						<option>${s}</option>
					</c:forEach>	
				</select></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" id="price" value="${data.getPrice()}"/></td>
			</tr>
			
			<tr>
				<td>Description: </td>
				<td><input type="text" name="description" id="description" value="${data.getOfficeDescription()}"/></td>
			</tr>
			
			<tr>
				<td>City: </td>
				<td>
					<select name = "cityList" id="city" onchange="getArea()">
					
					<c:forEach var="city" items="${cityList}">
							<option value="${city.getCityTitle()}">${city.getCityTitle()}</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<td>Area: </td>
				<td>
				<select name="area" id="area">
					</select>
				</td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><input type="text" name="address" id="address" value="${data.getAddress()}"/></td>
			</tr>
			<tr>
				<td>For: </td>
				<td>
				<select name="offerlist">
					<c:forEach  var="offerlist" items="${offerlist}">
						<option value="${offerlist.getOfferType()}">${offerlist.getOfferType()}</option>
					</c:forEach>	
					</select>
				
				</td>
			</tr>	
			<tr>
				<td>Select Images:</td>
				<td><ul>
					<li><input type="file"  name="file" size="50" accept="image/*" value="Select Image"></li></td>
				</ul>
			</tr>		
			<tr>
				<td></td>
				<td><input type="submit"  value="Add"/></td>
			</tr>
			
			<!-- city area city offer type -->
	</table>
	</form>
</body>
</html>