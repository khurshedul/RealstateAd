package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessions.SessionJobs;
import adapters.CityAdapter;
import adapters.OfferAdapter;
import models.City;
import models.Offer;


@WebServlet({ "/AddOffer", "/addoffer" })
public class AddOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addOffer.jsp");
		disp.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String offertitle = request.getParameter("offertitle");
		
		if(offertitle==null||offertitle.isEmpty()){
			request.setAttribute("message", "Offer name Can't be empty");
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addOffer.jsp");
			disp.forward(request, response);
			return;
		}
		Offer offer = new Offer();
		offer.setOfferType(offertitle);
		
		OfferAdapter oa = new OfferAdapter();
		oa.insert(offer);
		
		request.setAttribute("message", "Offer added to database");
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addOffer.jsp");
		disp.forward(request, response);

	}

}
