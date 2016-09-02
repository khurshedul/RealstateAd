package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import adapters.CityAdapter;
import adapters.HomeAdapter;
import adapters.UploadAdapter;
import models.City;
import models.Home;
import sessions.SessionJobs;

/**
 * Servlet implementation class AddNewHome
 */
@WebServlet({ "/AddNewHome", "/addnewhome" })
public class AddNewHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_addNewHome.jsp");
		CityAdapter CA = new CityAdapter();
		ArrayList<City> cityList = CA.getAll();
		request.setAttribute("cityList", cityList);
		
		int[] floorList = {1,2,3,4,5,6,7,8};
		request.setAttribute("floorList", floorList);
		String[] offerlist = {"Sell","Rent"};
		request.setAttribute("offerlist", offerlist);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadAdapter ua = new UploadAdapter();
		ua.uploadHome(request, response);
		//ua.deleteHomePic(6);
		response.getWriter().println("Inserted.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_customerHome.jsp");
		rd.forward(request, response);
	}

}
