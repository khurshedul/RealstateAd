package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.AreaAdapter;
import adapters.CityAdapter;
import adapters.LandAdapter;
import adapters.OfferAdapter;
import adapters.UploadAdapter;
import models.Land;
import models.Office;
import sessions.SessionJobs;

/**
 * Servlet implementation class AddNewLand
 */
@WebServlet({ "/AddNewLand", "/addnewland" })
public class AddNewLand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		Office office  = new Office();

		CityAdapter ca = new CityAdapter();
		OfferAdapter oa = new OfferAdapter();
		
		request.setAttribute("cityList",ca.getAll() );
		request.setAttribute("offerlist",oa.getAll() );
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addNewLand.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadAdapter ua = new UploadAdapter();
		ua.uploadLand(request, response);
		response.sendRedirect("/RealEstate/CustomerHome");
	}

}
