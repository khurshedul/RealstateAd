<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="/RealEstate/public/css/login.css"/>
		<script type="text/javascript">	
		
			//validation function
			function validate(){
				
				//getting all input text
				var un=document.forms["login_form"]["username"]; //document.forms only kaj korbe form sumbit korle...
				var ps=document.forms["login_form"]["password"];
					
				//getting the label where to put error message
				var un_error=document.getElementById("err_username");
				var ps_error=document.getElementById("err_password");
				
				var check =1;
					
				if (un.value==null || un.value==""){
					un_error.innerHTML="Username required";
					un_error.style.color='red';
					//return false;
					check =0;
				}
				
				if (ps.value==null || ps.value==""){
					ps_error.innerHTML= "Password required";
					ps_error.style.color='red';
					//return false;
					check =0;
				}
				return Boolean(check);
				
				//check , Boolean() use korsi username, password 2 ta akshathe check korar jonno.... 
				//username password kisu na boshaye Login button e clik kore dekho... akhon 2 ta required akshathe dekhay
				//Boolean(0) -> false retrun kore
				//Boolena(1) -> true return kore
				
			}
			
			function unVerify(){ // ai level e kono return dorkar nai...
				
				//getting all input text
				var un_input=document.getElementById("username").value;
				//alert(un.value);
			
				//getting the label where to put error message
				var un_error=document.getElementById("err_username");
				
				if(un_input!=""){
					if(un_input.length<6){
						un_error.innerHTML="Username must contain 6 letters";
						un_error.style.color='red';	
						un_error.style.fontSize='5px';	
					}
					else {
						un_error.innerHTML=".";
						un_error.style.color='#154360';
					}
					
				}
				else{
					un_error.innerHTML="Username required";
					un_error.style.color='red';		//ai statement ta tumi likho nai jar jonno , onblur kaj kortesilo na... 
				}
			}
			
			function psVerify(){
				//getting all input text
				//kono js function call hocche kina sheta check korte paro  alert() call kore... :) 
				//alert();
				var ps_input=document.getElementById("password").value;
			
				//getting the label where to put error message
				var ps_error=document.getElementById("err_password");
				
				if(ps_input!=""){
					ps_error.innerHTML=".";
					ps_error.style.color='#154360';
				}
				else{
					ps_error.innerHTML="Password required";
					ps_error.style.color='red';
					ps_error.style.fontSize='5px';
				}
			}
			//naming (id,name,class) convention ta ai rokom rakhar try korio... :) 
		</script>
	</head>
	
	<body>
		<div class="wrap">
				
				<h3>Login</h3>
				<div class="body">
					<form method="post" name="login_form"  onsubmit="return validate();">
						<ul>
							<li>
								<input type="text" class="username" name="username" id="username" placeholder="Username" onblur="unVerify();"/>
							</li>
							<li>
								<label id="err_username">.</label>
							</li>
							<li>
								<input type="password" id="password" class="password" name="password" placeholder="Password" onblur="psVerify();"/>
							</li>
							<li>
								<label id="err_password">.</label>
							</li>
							<li>
								<input type="checkbox" name="remember" id="remember"/> Remember me?
							</li>
							<li>
								<input type="submit" class="login" value="Login" />
							</li>
							<li>
								${errors}
							</li>
						</ul>
						<p id="p">Not registered?Signup <a href="./register"><strong>here</strong></a></p>
					</form>
					
				</div><!-- end of right div -->
					
		</div><!-- end of wrap div -->
	</body>
</html>