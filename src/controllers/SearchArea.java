package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.AreaAdapter;
import models.Area;

/**
 * Servlet implementation class SearchArea
 */
@WebServlet({ "/SearchArea", "/searcharea" })
public class SearchArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		AreaAdapter AD = new AreaAdapter();
		ArrayList<Area> areaList =   AD.getAllArea(request.getParameter("cityId"));
		request.setAttribute("areaNames", areaList);
		PrintWriter out = response.getWriter();
		out.println("Hello");
	    try {
	    	String str = "";
	        for (Area area : areaList) {
				str+= "<option value=\""+area.getAreaTitle()+"\">"+area.getAreaTitle()+"</option>";
			}
	        out.println(str);
	    } finally {
	        out.close();
	    }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AreaAdapter AD = new AreaAdapter();
		ArrayList<Area> areaList =   AD.getAllArea(request.getParameter("cityId"));
		request.setAttribute("areaNames", areaList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println("Hello");
	    try {
	    	String str = "<option value\"0\">-- Select Area --</option>";
	        for (Area area : areaList)str+= "<option value=\""+area.getAreaId()+"\">"+area.getAreaTitle()+"</option><br/>";
	        response.getWriter().write(str);
	    } finally {
	        out.close();
	    }
	}

}
