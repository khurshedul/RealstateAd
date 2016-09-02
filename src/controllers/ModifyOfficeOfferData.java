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
import adapters.OfferAdapter;
import adapters.OfficeAdapter;
import adapters.UploadAdapter;
import models.Office;
import sessions.SessionJobs;

/**
 * Servlet implementation class ModifyOfficeOfferData
 */
@WebServlet({ "/ModifyOfficeOfferData", "/modifyofficeofferdata" })
public class ModifyOfficeOfferData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		
		String []floors ={"Ground Floor","1st Floor","2nd Floor","3rd Floor","4th Floor","5th Floor"};
		
		request.setAttribute("floors", floors);
		Office office  = new Office();
		
		
		CityAdapter ca = new CityAdapter();
		AreaAdapter aa = new AreaAdapter();
		OfferAdapter oa = new OfferAdapter();
		OfficeAdapter officeAdapter = new OfficeAdapter();
		request.setAttribute("cityList",ca.getAll() );
		request.setAttribute("offerlist",oa.getAll() );
		request.setAttribute("data", officeAdapter.get(Integer.parseInt(request.getParameter("officeId"))));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_modifyofficeofferdata.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadAdapter ua = new UploadAdapter();
		ua.updateOffice(request, response);
		response.sendRedirect("/RealEstate/CustomerHome");
	}

}
