package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.UserOfferedSearchAdapter;
import sessions.SessionJobs;

@WebServlet({ "/UserOfferedDetails", "/useroffereddetails" })
public class UserOfferedDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		
		UserOfferedSearchAdapter uosa = new UserOfferedSearchAdapter();
		
		request.setAttribute("homeList", uosa.getAllHomeOffered(sj.getUsername(request)));
		request.setAttribute("landList", uosa.getAllLandOffered(sj.getUsername(request)));
		request.setAttribute("officeList", uosa.getAllOfficeOffered(sj.getUsername(request)));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/useroffereddetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
