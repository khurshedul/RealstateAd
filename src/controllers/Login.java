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

import adapters.UserAdapter;
import cookies.CookieJobs;
import models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private String err;
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
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_login.jsp");
			disp.forward(request, response);
		}else{
			if(user.getType() == 1){
				response.sendRedirect("/RealEstate/AdminHome");
			}else if(user.getType()==2){
				response.sendRedirect("/RealEstate/CustomerHome");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*username = request.getParameter("username");
		password = request.getParameter("password");
		remember = request.getParameter("remember");*/
		err="";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		//request.setAttribute("rememberval", remember);
		
		
		if(username==null || password ==null){
			err ="Invalid Username/Password";
			request.setAttribute("errors", err);
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_login.jsp");
			disp.forward(request, response);
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserAdapter ua = new UserAdapter();
		user = ua.login(user);
		
		if(user==null){
			err ="Invalid Username/Password";
			request.setAttribute("errors", err);
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_login.jsp");
			disp.forward(request, response);
			return;
			
		}else{
			if(remember!= null){
				if(remember.equals("on")){
					CookieJobs cj = new CookieJobs();
					cj.addUserDetail(username, password, response);
				}
			}
			err = "";
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			if(user.getType() == 1){
				response.sendRedirect("/RealEstate/AdminHome");
			}else if(user.getType()==2){
				response.sendRedirect("/RealEstate/CustomerHome");
			}
		}
	}

}
