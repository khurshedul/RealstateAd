package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.OfferAdapter;
import adapters.OfficeAdapter;
import sessions.SessionJobs;

/**
 * Servlet implementation class CustomerHome
 */
@WebServlet({ "/CustomerHome", "/customerhome" })
public class CustomerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		else{
			OfferAdapter oa = new OfferAdapter();
			request.setAttribute("offerlist", oa.getAll());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_customerHome.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_customerHome.jsp");
		rd.forward(request, response);
	}

}
