package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.CityAdapter;
import adapters.LandAdapter;
import adapters.OfferAdapter;
import adapters.UploadAdapter;
import models.Land;
import models.Office;
import sessions.SessionJobs;

/**
 * Servlet implementation class ModifyLandOfferData
 */
@WebServlet({ "/ModifyLandOfferData", "/modifylandofferdata" })
public class ModifyLandOfferData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		LandAdapter la = new LandAdapter();
		CityAdapter ca = new CityAdapter();
		OfferAdapter oa = new OfferAdapter();
		
		request.setAttribute("cityList",ca.getAll() );
		request.setAttribute("offerlist",oa.getAll() );
		request.setAttribute("data", la.getSingle(Integer.parseInt(request.getParameter("landId"))));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_modifylandofferdata.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadAdapter ua = new UploadAdapter();
		ua.updateLand(request, response);
		response.getWriter().println("Update Complete.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_customerHome.jsp");
		rd.forward(request, response);
	}

}
