package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessions.SessionJobs;

/**
 * Servlet implementation class Home
 */
@WebServlet({ "/AdminHome", "/adminhome" })
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is admin or not
			return ;
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_adminHome.jsp");
		disp.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
		
		
	}

}
