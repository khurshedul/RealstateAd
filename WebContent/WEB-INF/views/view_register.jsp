<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Signup</title>
		<link rel="stylesheet" href="/RealEstate/public/css/signup.css"/>
		<script type="text/javascript" src="/RealEstate/public/js/signup.js"></script>	
	</head>
	
	<body>
		<div class="wrap">
			<h2>Signup</h2>
			<form method="post" name="signup_form"  onsubmit="return validate();">
				<ul>
					<li>${Message}</li>
					<li>
						<input type="text" class="username" name="username" id="username" placeholder="Username" onblur="unVerify()"/>
					</li>
					<li>
						<label id="err_username">a</label>
					</li>
					
					<li>
						<input type="text" class="firstname" name="firstname" id="firstname" placeholder="Name" onblur="fnVerify()"/>
					</li>
					<li>
						<label id="err_firstname">a</label>
					</li>
					<!-- 
					<li>
						<input type="text" class="lastname" name="lastname" id="lastname" placeholder="Lastname" onblur="lnVerify()"/>
					</li>
					<li>
						<label id="err_lastname">a</label>
					</li>  -->
					
					<li>
						<input type="text" class="email" name="email" id="email" placeholder="Email" onblur="emailVerify()"/>
					</li>
					<li>
						<label id="err_email">a</label>
					</li>
					
					<li>
						<input type="text" class="address" name="address" id="address" placeholder="Address" onblur="addVerify()"/>
					</li>
					<li>
						<label id="err_address">a</label>
					</li>
					
					<li>
						<input type="text" class="contactnumber" name="contactnumber" id="contactnumber" placeholder="Contact Number" onblur="cnVerify()"/>
					</li>
					<li>
						<label id="err_contactnumber">a</label>
					</li>
					
					
					<li>
						<input type="password" class="password" name="password" id="password" placeholder="Password" onblur="psVerify()"/>
					</li>
					<li>
						<label id="err_password">a</label>
					</li>
					
					<li>
						<input type="password" class="conpassword" name="conpassword" id="conpassword" placeholder="Confirm Password" onblur="conpsVerify()"/>
					</li>
					<li>
						<label id="err_conpassword">a</label>
					</li>
					
					
					<li>
						<input type="checkbox" class="checkbox" name="checkbox" id="checkbox"/><span>I agree with the <a href="#">terms and conditions.</a></span>
						<br>
						<label id="err_checkbox">a</label>
					</li>
					
					
					<li>
						<input type="submit" class="signup" value="Signup" />
					</li>
					<li>${errors}</li>
					
				</ul>
		
			</form>	
		<p id="p">Already registered?Login <a href="./Login"><strong>here</strong></a></p>			
		</div>
	</body>
</html>