package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookies.CookieJobs;
import adapters.UserAdapter;
import models.User;

@WebServlet({ "/Register", "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user ;
		//Cookie check
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession();
		String username,password;
		
		if(cookies!=null){
			user = new User();
			CookieJobs cj = new CookieJobs();
			
			username =  cj.getUsername(cookies);
			password = cj.getPassword(cookies);
			
			user.setUsername(username);
			user.setPassword(password);
			
			UserAdapter ua = new UserAdapter();
			user = ua.login(user);
			
			if(user != null){
				session.setAttribute("currentUser", user);
			}
		}
		user = (User)session.getAttribute("currentUser"); //check session
		
		if(user == null){
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_register.jsp");
			disp.forward(request, response);
		}else{
			response.sendRedirect("/RealEstate/home");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err="";
		User user = new User();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		//String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String address = request.getParameter("address");
		String contact=request.getParameter("contactnumber");
		
		if(username==null||password==null||firstname == null /*||lastname == null*/||email==null||address==null){
			err="All fields are required";
			request.setAttribute("errors", err);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_register.jsp");
			disp.forward(request, response);
			
			return;
			
		}
		
		user.setName(firstname);
		//user.setLastname(lastname);
		user.setAddress(address);
		user.setContactnumber(contact);
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		
		
		UserAdapter ua= new UserAdapter();
		if(ua.isUserNameUnique(username)){
			if(ua.isEmailUnique(email)){
				ua.insert(user);
				request.setAttribute("Message", "User Registered Successfully");
			}
			else{
				request.setAttribute("Message", "Email already taken");
			}
		}
		else{
			request.setAttribute("Message", "Username not available");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_register.jsp");
		disp.forward(request, response);
		
	}

}
