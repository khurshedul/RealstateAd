package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.HomeAdapter;
import adapters.LandAdapter;
import adapters.OfficeAdapter;
import adapters.UploadAdapter;
import models.Home;
import sessions.SessionJobs;

/**
 * Servlet implementation class DeleteUserOfferData
 */
@WebServlet({ "/DeleteUserOfferData", "/deleteuserofferdata" })
public class DeleteUserOfferData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		if(request.getParameter("homeId") != null){
			HomeAdapter ha = new HomeAdapter();
			UploadAdapter ua = new UploadAdapter();
			ua.deleteHomePic(Integer.parseInt(request.getParameter("homeId")));
			ha.delete(Integer.parseInt(request.getParameter("homeId")));
			response.sendRedirect("/RealEstate/UserOfferedDetails");
		}else if(request.getParameter("officeId") != null){
			OfficeAdapter oa = new OfficeAdapter();
			UploadAdapter ua = new UploadAdapter();
			ua.deleteOfficePic(Integer.parseInt(request.getParameter("officeId")));
			oa.delete(Integer.parseInt(request.getParameter("officeId")));
			response.sendRedirect("/RealEstate/UserOfferedDetails");
		}else if(request.getParameter("landId") != null){
			LandAdapter la = new LandAdapter();
			UploadAdapter ua = new UploadAdapter();
			ua.deleteHomePic(Integer.parseInt(request.getParameter("landId")));
			la.delete(Integer.parseInt(request.getParameter("landId")));
			response.sendRedirect("/RealEstate/UserOfferedDetails");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
