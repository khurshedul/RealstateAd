<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="public/js/ajax.js"></script>
<title>Add New Home</title>
</head>
<body onload="getArea()">
	<h2>Add new Home</h2>
	${Message}
	<form action="" method="post" enctype="multipart/form-data">
	<table>
			<tr>
				<td>Title: </td>
				<td><input type="text" name="title" id="title" required></td>
			</tr>
			<tr>
				<td>No Of Beds: </td>
				<td><input type="text" name="noofbeds" id="noofbeds" required /></td>
			</tr>
			<tr>
				<td>No Of Baths: </td>
				<td><input type="text" name="noofbaths" id="noofbaths" required/></td>
			</tr>
			<tr>
				<td>Size In sqf:</td>
				<td><input type="text" name="size" id="size" required/></td>
			</tr>
			<tr>
				<td>Price Per sq Foot:</td>
				<td><input type="text" name="price" id="price" required /></td>
			</tr>
			<tr>
				<td>Floor:</td>
				<td><select name = floorList>
					<c:forEach  var="floorList" items="${floorList}">
						<option value="${floorList}">${floorList}</option>
					</c:forEach>	
				</select></td>
			</tr>
			<tr>
				<td>Description: </td>
				<td><input type="text" name="description" id="description" required /></td>
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
				<td><input type="text" name="address" id="address" required /></td>
			</tr>
			<tr>
				<td>For: </td>
				<td>
				<select name="offerlist">
					<c:forEach  var="offerlist" items="${offerlist}">
						<option value="${offerlist}">${offerlist}</option>
					</c:forEach>	
					</select>
				
				</td>
			</tr>

			<tr>
				<td>Select Images:</td>
				<td><ul>
					<li><input type="file"  name="file" size="50" accept="image/*" value="Select Image" required></li></td>
				</ul>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" name="submit" value="Add"/></td>
			</tr>			
			<!-- city area city offer type -->
	</table>
	</form>
</body>
</html>