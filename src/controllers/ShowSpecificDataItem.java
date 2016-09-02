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
import sessions.SessionJobs;

/**
 * Servlet implementation class ShowSpecificDataItem
 */
@WebServlet({ "/ShowSpecificDataItem", "/showspecificdataitem" })
public class ShowSpecificDataItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionJobs sj = new SessionJobs();
		if(!sj.customerCheck(request)){
			response.sendRedirect("/RealEstate/AccessDenied"); //checking user is customer or not
		}
		
		if(request.getParameter("landId") != null){
			LandAdapter la = new LandAdapter();
			request.setAttribute("data", la.getSingle(Integer.parseInt(request.getParameter("landId"))));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_showspecificdataitemforLand.jsp");
			rd.forward(request, response);
		}else if(request.getParameter("homeId") != null){
			HomeAdapter ha = new HomeAdapter();
			request.setAttribute("data", ha.get(Integer.parseInt(request.getParameter("homeId"))));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_showspecificdataitem.jsp");
			rd.forward(request, response);
		}else if(request.getParameter("officeId") != null){
			OfficeAdapter oa = new OfficeAdapter();
			request.setAttribute("data", oa.get(Integer.parseInt(request.getParameter("officeId"))));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/view_showspecificdataitemforOffice.jsp");
			rd.forward(request, response);
		}
		response.getWriter().println("There Is Some Error.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
