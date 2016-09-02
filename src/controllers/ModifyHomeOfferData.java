package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.CityAdapter;
import adapters.HomeAdapter;
import adapters.UploadAdapter;
import models.City;
import sessions.SessionJobs;

/**
 * Servlet implementation class ModifyHomeOfferData
 */
@WebServlet({ "/ModifyHomeOfferData", "/modifyhomeofferdata" })
public class ModifyHomeOfferData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		HomeAdapter ha = new HomeAdapter();
		CityAdapter CA = new CityAdapter();
		ArrayList<City> cityList = CA.getAll();
		request.setAttribute("cityList", cityList);
		
		int[] floorList = {1,2,3,4,5,6,7,8};
		request.setAttribute("floorList", floorList);
		String[] offerlist = {"Sell","Rent"};
		request.setAttribute("offerlist", offerlist);
		
		request.setAttribute("data", ha.get(Integer.parseInt(request.getParameter("homeId"))));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/View_modifyhomeofferdata.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadAdapter ua = new UploadAdapter();
		ua.updateHome(request, response);
		response.getWriter().println("Update Complete.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_customerHome.jsp");
		rd.forward(request, response);
	}

}
