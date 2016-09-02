package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.CityAdapter;
import models.City;

@WebServlet({ "/Index", "/index" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_index.jsp");
		CityAdapter CA = new CityAdapter();
		ArrayList<City> cityList = CA.getAll();
		request.setAttribute("cityList", cityList);
		String propertyTypes[] = {"Home","Office","Land"};
		request.setAttribute("propertyTypes", propertyTypes);
		String minPrice[] = {"5000","50000","100000","500000","1000000","5000000","10000000","50000000"};
		request.setAttribute("minPrices", minPrice);
		String maxPrice[] = {"10000","50000","100000","500000","1000000","5000000","10000000","50000000","100000000"};
		request.setAttribute("maxPrices", maxPrice);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city=(String)request.getParameter("city");
		String propertyTypes=(String)request.getParameter("propertyTypes");
		String area=(String)request.getParameter("area");
		String minPrice=(String)request.getParameter("minPrice");
		String maxPrice=(String)request.getParameter("maxPrice");
		String sql = "SELECT * FROM "+propertyTypes.toLowerCase()+" WHERE city = '"+city+"' AND area = '"+area+"' AND price BETWEEN "+minPrice+" AND "+maxPrice;
		HttpSession session = request.getSession();
		session.setAttribute("TableName", propertyTypes);
		session.setAttribute("sql", sql);
		response.sendRedirect("/RealEstate/searchproperty");
	}

}
