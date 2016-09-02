package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessions.SessionJobs;
import adapters.UserAdapter;


@WebServlet({ "/SearchCustomer", "/searchcustomer" })
public class SearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		
		UserAdapter ua = new UserAdapter();
		request.setAttribute("userlist",ua.getAll() );
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_searchCustomer.jsp");
		disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		
		String str="";
		str = request.getParameter("txtsearch");
		
		UserAdapter ua = new UserAdapter();
		
		request.setAttribute("userlist",ua.search(str) );
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_searchCustomer.jsp");
		disp.forward(request, response);
		
	}

}
