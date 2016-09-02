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
import models.City;

@WebServlet({ "/AddCity", "/addcity" })
public class AddCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addCity.jsp");
		disp.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		
		String cityname = request.getParameter("cityname");
		City city = new City();
		city.setCityTitle(cityname);
		
		CityAdapter ca = new CityAdapter();
		ca.insert(city);
	
		request.setAttribute("message", "City added to database");
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addCity.jsp");
		disp.forward(request, response);
		
		
		
	}

}
