package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessions.SessionJobs;
import adapters.AreaAdapter;
import adapters.CityAdapter;
import models.Area;

/**
 * Servlet implementation class AddArea
 */
@WebServlet({ "/AddArea", "/addarea" })
public class AddArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		
		CityAdapter ca = new CityAdapter();
		request.setAttribute("citylist", ca.getAll());
		
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addArea.jsp");
		disp.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.adminCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied");
			//checking user is customer or not
			return ;
		}
		CityAdapter ca = new CityAdapter();
		Area area = new Area();
		
		String city = request.getParameter("city");
		String areatitle = request.getParameter("area");
		
		if(areatitle == null||areatitle.isEmpty()){
			request.setAttribute("message", "Area Title Can't be empty");
			
			request.setAttribute("citylist", ca.getAll());
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addArea.jsp");
			disp.forward(request, response);
			return;
		}
		
		
		area.setAreaTitle(areatitle);
		area.setCityTitle(city);
		
		AreaAdapter aa= new AreaAdapter();
		aa.insert(area);
		
		request.setAttribute("citylist", ca.getAll());

		request.setAttribute("message", "Area Added To database");
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addArea.jsp");
		disp.forward(request, response);

	}

}
