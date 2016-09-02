function validateEmail(email) {
  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}	


function validate(){
				var un=document.forms["signup_form"]["username"]; 
				var fn=document.forms["signup_form"]["firstname"];
				//var ln=document.forms["signup_form"]["lastname"];
				var cn=document.forms["signup_form"]["contactnumber"];
				var email=document.forms["signup_form"]["email"];
				var add=document.forms["signup_form"]["address"];
				var ps=document.forms["signup_form"]["password"];
				var conps=document.forms["signup_form"]["conpassword"];
				var checkbox=document.forms["signup_form"]["checkbox"];
				
					
				
				var un_error=document.getElementById("err_username");
				var fn_error=document.getElementById("err_firstname");
				//var ln_error=document.getElementById("err_lastname");
				var cn_error=document.getElementById("err_contactnumber");
				var email_error=document.getElementById("err_email");
				var add_error=document.getElementById("err_address");
				var ps_error=document.getElementById("err_password");
				var conps_error=document.getElementById("err_conpassword");
				var checkbox_error=document.getElementById("err_checkbox");
				
				
				var email_input=document.getElementById("email").value;
				var email_error=document.getElementById("err_email");
				var at_postion=email_input.indexOf("@");
				var dot_postion=email_input.indexOf(".");
				
				var check =1;
					
				if (un.value==null || un.value==""){
					un_error.innerHTML="Username required";
					un_error.style.color='red';	
					//return false;
					check =0;
				}
				
				if (fn.value==null || fn.value==""){
					fn_error.innerHTML="Name required";
					fn_error.style.color='red';	
					//return false;
					check =0;
				}
				/*
				if (ln.value==null || ln.value==""){
					ln_error.innerHTML="Lastname required";
					ln_error.style.color='red';	
					//return false;
					check =0;
				}*/
				
				if (cn.value==null || cn.value==""){
					cn_error.innerHTML="Contact Number required";
					cn_error.style.color='red';	
					//return false;
					check =0;
				}
				
				if (email.value==null || email.value==""){
					email_error.innerHTML="Email required";
					email_error.style.color='red';	
					//return false;
					check =0;
				}
				
				if(email_input!=""){
					
					if(!validateEmail(email_input)){
						email_error.innerHTML="Not a valid email!!";
						email_error.style.color='red';	
						check =0;
					}
					
				}
				
				if (add.value==null || add.value==""){
					add_error.innerHTML="Address required";
					add_error.style.color='red';	
					//return false;
					check =0;
				}
				if (ps.value==null || ps.value==""){
					ps_error.innerHTML= "Password required";
					ps_error.style.color='red';	
					//return false;
					check =0;
				}
				if (conps.value==null || conps.value==""){
					conps_error.innerHTML= "Confirm password required";
					conps_error.style.color='red';	
					//return false;
					check =0;
				}
				
				if(checkbox.checked ==false){
					checkbox_error.innerHTML= "You must agree to our terms and conditions."
					checkbox_error.style.color='red';	
					check=0;
				}
				return Boolean(check);
				
				
			}//validate funtion only checks if any field is empty or not
	
	function unVerify(){
// ai level e kono return dorkar nai..
		
		var un_input=document.getElementById("username").value;		
		var un_error=document.getElementById("err_username");
		
		if(un_input!=""){
			if(un_input.length<5){
				un_error.innerHTML="Username must contain 5 letters";
				un_error.style.color='red';	
			}
			else un_error.innerHTML="";
		}
		else{
			un_error.innerHTML="Username required";
			un_error.style.color='red';	
		}
			
	}

	
	function fnVerify(){ //
		var fn=document.getElementById("firstname");
		var fn_error=document.getElementById("err_firstname");
		if(fn.value!=""){
			fn_error.innerHTML="";
		}
		else{
			fn_error.innerHTML="Firstname required";  
			fn_error.style.color='red';	
		}
	}
	
	function lnVerify(){ //
		var ln=document.getElementById("lastname");
		var ln_error=document.getElementById("err_lastname");
		if(ln.value!=""){
			ln_error.innerHTML="";
		}
		else{
			ln_error.innerHTML="Lastname required";  
			ln_error.style.color='red';	
		}
	}
	
	function addVerify(){ //
		var add=document.getElementById("address");
		var add_error=document.getElementById("err_address");
		if(add.value!=""){
			add_error.innerHTML="";
		}
		else{
			add_error.innerHTML="Address required";  
			add_error.style.color='red';	
		}
	}
	
	function emailVerify(){
		
		var email_input=document.getElementById("email").value;
		
		var email_error=document.getElementById("err_email");
		
		var at_postion=email_input.indexOf("@");
		var dot_postion=email_input.indexOf(".");
		
		if(email_input!=""){
			/*
			if(at_postion<1 || dot_postion<at_postion+2 || dot_position+2>=email_input.length){
				email_error.innerHTML="Not a valid email!!";
				email_error.style.color='red';	
			}*/
			if(!validateEmail(email_input)){
				email_error.innerHTML="Not a valid email!!";
				email_error.style.color='red';	
			}
			
			else email_error.innerHTML="";
		}
		else{
			email_error.innerHTML="Email address required";  
			email_error.style.color='red';	
		}
	}
	
	function psVerify(){
		var ps=document.getElementById("password");
		var ps_error=document.getElementById("err_password");
		if(ps.value!=""){
			ps_error.innerHTML="";
		}
		else{
			ps_error.innerHTML="Password required";  
			ps_error.style.color='red';	
		}
	}
	
	function cnVerify(){
		var cn=document.getElementById("contactnumber");
		var cn_error=document.getElementById("err_contactnumber");
		if(cn.value!=""){
			cn_error.innerHTML="";
		}
		else{
			cn_error.innerHTML="Contact Number required";  
			cn_error.style.color='red';	
		}
	}
	
	function conpsVerify(){
		
		var ps_input=document.getElementById("password").value;
		var conps_input=document.getElementById("conpassword").value;
		
		var conps_error=document.getElementById("err_conpassword");
		
		if(conps_input!=""){
			if(conps_input!=ps_input){
				conps_error.innerHTML="Both passwords dont match!!";
				conps_error.style.color='red';	
			}
			else conps_error.innerHTML="";
		
		}
		else{
			conps_error.innerHTML="Confirm password required";  
			conps_error.style.color='red';	
		}
	}