package adapters;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Home;
import models.Land;
import models.Office;
import sessions.SessionJobs;

public class UploadAdapter {
	
	static String imageName;
	String path;
	static String text = "img0";
	public void uploadHome(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String filename = "last_val.txt";
		ServletContext context = request.getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			if((text = reader.readLine()) != null);
		}		
		imageName = text;
		
		if(ServletFileUpload.isMultipartContent(request)) {

	        try  {
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            double size = 0,price = 0;
	            Home home = new Home();
	            for (FileItem item : multiparts) {
	                if (!item.isFormField()) { 
	                	
	                	
	    				/*File file = File.createTempFile("img1",".tmp");
	    				String imgName = getNextImageName();
	    				String destPath = uploadDir+File.separator+imgName+".jpg";
	    				File destFile = new File(destPath);
	    				file.renameTo(destFile);
	    				item.write(file);*/
	                	File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	                	String name = new File(item.getName()).getName();
                        item.write( new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img" + File.separator + name));

	    				path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+name;
	                }
	                else{
	                    String fieldName = item.getFieldName();
	                    String value = item.getString();
	                    
	                    if(fieldName.equals("title"))home.setHomeTitle(value);
	    			    if(fieldName.equals("noofbeds"))home.setNoOfBeds(Integer.parseInt(value));
	    			    if(fieldName.equals("noofbaths"))home.setNoOfBaths(Integer.parseInt(value));
	    			    if(fieldName.equals("size")){
	    			    	size = Double.parseDouble(value);
	    			    	home.setSizeInSqFeet(size);
	    			    }
	    			    if(fieldName.equals("price")){
	    			    	price = Double.parseDouble(value);
	    			    	home.setPricePerSqFeet(price);
	    			    }
	    			    if(fieldName.equals("floorList"))home.setFloor(value);
	    			    if(fieldName.equals("description"))home.setHomeDescription(value);	    				
	    				if(fieldName.equals("cityList"))home.setCity(value);
	    				if(fieldName.equals("area"))home.setArea(value);
	    				if(fieldName.equals("address"))home.setAddress(value);
	    				if(fieldName.equals("offerlist"))home.setOffertype(value);
	    				
	                }
	            }//end for
	            SessionJobs sj = new SessionJobs();
				home.setUsername(sj.getUsername(request));
				GregorianCalendar gcalendar = new GregorianCalendar();
				String str = String.valueOf(gcalendar.get(Calendar.MONTH))+" " + gcalendar.get(Calendar.DATE) + " ";
			     str += gcalendar.get(Calendar.YEAR);
			     home.setDate(str);
			     home.setPic1(path);
			     home.setPrice(size*price);
			     HomeAdapter ha = new HomeAdapter();
			     ha.insert(home);
	        }
	        catch (Exception ex)
	        {
	            request.setAttribute("message", "File Upload Failed due to " + ex);
	            //ex.printStackTrace();
	        }
	    }
	    else
	    {
	        request.setAttribute("message", "Sorry this Servlet only handles file upload request");
	    }
	}
	
	public void updateHome(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		String filename = "last_val.txt";
		ServletContext context = request.getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			if((text = reader.readLine()) != null);
		}		
		imageName = text;
		
		if(ServletFileUpload.isMultipartContent(request)) {

	        try  {
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            double size = 0,price = 0;
	            Home home = new Home();
	            int homeId = 0;
	            for (FileItem item : multiparts) {
	                if (!item.isFormField()) { 
	                	/*File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	    				File file = File.createTempFile("img1",".tmp");
	    				String imgName = getNextImageName();
	    				String destPath = uploadDir+File.separator+imgName+".jpg";
	    				File destFile = new File(destPath);
	    				file.renameTo(destFile);
	    				item.write(file);
	    				path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+imgName+".jpg";*/
	                	File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	                	String name = new File(item.getName()).getName();
                        item.write( new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img" + File.separator + name));
                        path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+name;
	                }
	                else{
	                    String fieldName = item.getFieldName();
	                    String value = item.getString();
	                    if(fieldName.equals("id")){
	                    	home.setHomeId(Integer.parseInt(value));
	                    	deleteHomePic(Integer.parseInt(value));
	                    }
	                    if(fieldName.equals("title"))home.setHomeTitle(value);
	    			    if(fieldName.equals("noofbeds"))home.setNoOfBeds(Integer.parseInt(value));
	    			    if(fieldName.equals("noofbaths"))home.setNoOfBaths(Integer.parseInt(value));
	    			    if(fieldName.equals("size")){
	    			    	size = Double.parseDouble(value);
	    			    	home.setSizeInSqFeet(size);
	    			    }
	    			    if(fieldName.equals("price")){
	    			    	price = Double.parseDouble(value);
	    			    	home.setPricePerSqFeet(price);
	    			    }
	    			    if(fieldName.equals("floorList"))home.setFloor(value);
	    			    if(fieldName.equals("description"))home.setHomeDescription(value);	    				
	    				if(fieldName.equals("cityList"))home.setCity(value);
	    				if(fieldName.equals("area"))home.setArea(value);
	    				if(fieldName.equals("address"))home.setAddress(value);
	    				if(fieldName.equals("offerlist"))home.setOffertype(value);
	    				
	                }
	            }//end for
	           
	            SessionJobs sj = new SessionJobs();
				home.setUsername(sj.getUsername(request));
				GregorianCalendar gcalendar = new GregorianCalendar();
				String str = String.valueOf(gcalendar.get(Calendar.MONTH))+" " + gcalendar.get(Calendar.DATE) + " ";
			     str += gcalendar.get(Calendar.YEAR);
			     home.setDate(str);
			     home.setPic1(path);
			     home.setPrice(size*price);
			     
			     HomeAdapter ha = new HomeAdapter();
			     ha.update(home);
			     
	        }
	        catch (Exception ex)
	        {
	            request.setAttribute("message", "File Upload Failed due to " + ex);
	            //ex.printStackTrace();
	        }
	    }
	    else
	    {
	        request.setAttribute("message", "Sorry this Servlet only handles file upload request");
	    }
	}
	
	public void uploadLand(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String filename = "last_val.txt";
		ServletContext context = request.getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			if((text = reader.readLine()) != null);
		}		
		imageName = text;
		
		if(ServletFileUpload.isMultipartContent(request)) {

	        try  {
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            double size = 0,price = 0;
	            Land land = new Land();
	            for (FileItem item : multiparts) {
	                if (!item.isFormField()) { 
	                	/*File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	    				File file = File.createTempFile("img1",".tmp");
	    				String imgName = getNextImageName();
	    				String destPath = uploadDir+File.separator+imgName+".jpg";
	    				File destFile = new File(destPath);
	    				file.renameTo(destFile);
	    				item.write(file);
	    				path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+imgName+".jgp";*/
	                	File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	                	String name = new File(item.getName()).getName();
                        item.write( new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img" + File.separator + name));
                        path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+name;
	                }
	                else{
	                    String fieldName = item.getFieldName();
	                    String value = item.getString();
	                    
	                    if(fieldName.equals("title"))land.setLandTitle(value);
	    			    if(fieldName.equals("katha")){
	    			    	size = Double.parseDouble(value);
	    			    	land.setTotalKatha(size);
	    			    }
	    			    if(fieldName.equals("price")){
	    			    	price = Double.parseDouble(value);
	    			    	land.setPricePerKatha(price);
	    			    }
	    			    if(fieldName.equals("description"))land.setLandDescription(value);	    				
	    				if(fieldName.equals("cityList"))land.setCity(value);
	    				if(fieldName.equals("area"))land.setArea(value);
	    				if(fieldName.equals("address"))land.setAddress(value);
	    				if(fieldName.equals("offerlist"))land.setOffertype(value);	    				
	                }
	            }//end for
	            SessionJobs sj = new SessionJobs();
				land.setUsername(sj.getUsername(request));
				GregorianCalendar gcalendar = new GregorianCalendar();
				String str = String.valueOf(gcalendar.get(Calendar.MONTH))+" " + gcalendar.get(Calendar.DATE) + " ";
			     str += gcalendar.get(Calendar.YEAR);
			     land.setDate(str);
			     land.setPic1(path);
			     land.setPrice(price*size);
			     LandAdapter ha = new LandAdapter();
			     ha.insert(land);
	        }
	        catch (Exception ex)
	        {
	            request.setAttribute("message", "File Upload Failed due to " + ex);
	            //ex.printStackTrace();
	        }
	    }
	    else
	    {
	        request.setAttribute("message", "Sorry this Servlet only handles file upload request");
	    }
	}
	
	public void updateLand(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String filename = "last_val.txt";
		ServletContext context = request.getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			if((text = reader.readLine()) != null);
		}		
		imageName = text;
		
		if(ServletFileUpload.isMultipartContent(request)) {

	        try  {
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            double size = 0,price = 0;
	            int landId = 0;
	            Land land = new Land();
	            for (FileItem item : multiparts) {
	                if (!item.isFormField()) { 
	                	/*File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	    				File file = File.createTempFile("img1",".tmp");
	    				String imgName = getNextImageName();
	    				String destPath = uploadDir+File.separator+imgName+".jpg";
	    				File destFile = new File(destPath);
	    				file.renameTo(destFile);
	    				item.write(file);
	    				path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+imgName+".jgp";*/
	                	File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	                	String name = new File(item.getName()).getName();
                        item.write( new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img" + File.separator + name));
                        path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+name;
	                }
	                else{
	                    String fieldName = item.getFieldName();
	                    String value = item.getString();
	                    System.out.println(fieldName+" "+value);
	                    if(fieldName.equals("landid")){
	                    	//land.setLandId(Integer.parseInt(value));
	                    	landId = Integer.parseInt(value);
	                    	deleteLandPic(Integer.parseInt(value));
	                    }
	                    if(fieldName.equals("title"))land.setLandTitle(value);
	    			    if(fieldName.equals("katha")){
	    			    	size = Double.parseDouble(value);
	    			    	land.setTotalKatha(size);
	    			    }
	    			    if(fieldName.equals("price")){
	    			    	price = Double.parseDouble(value);
	    			    	land.setPricePerKatha(price);
	    			    }
	    			    if(fieldName.equals("description"))land.setLandDescription(value);	    				
	    				if(fieldName.equals("cityList"))land.setCity(value);
	    				if(fieldName.equals("area"))land.setArea(value);
	    				if(fieldName.equals("address"))land.setAddress(value);
	    				if(fieldName.equals("offerlist"))land.setOffertype(value);	    				
	                }
	            }//end for
	            SessionJobs sj = new SessionJobs();
				land.setUsername(sj.getUsername(request));
				GregorianCalendar gcalendar = new GregorianCalendar();
				String str = String.valueOf(gcalendar.get(Calendar.MONTH))+" " + gcalendar.get(Calendar.DATE) + " ";
			     str += gcalendar.get(Calendar.YEAR);
			     land.setLandId(landId);
			     land.setDate(str);
			     land.setPic1(path);
			     land.setPrice(price*size);
			     LandAdapter ha = new LandAdapter();
			     ha.update(land);
	        }
	        catch (Exception ex)
	        {
	            request.setAttribute("message", "File Upload Failed due to " + ex);
	            //ex.printStackTrace();
	        }
	    }
	    else
	    {
	        request.setAttribute("message", "Sorry this Servlet only handles file upload request");
	    }
	}
	
	public void uploadOffice(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String filename = "last_val.txt";
		ServletContext context = request.getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			if((text = reader.readLine()) != null);
		}		
		imageName = text;
		
		if(ServletFileUpload.isMultipartContent(request)) {

	        try  {
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            double size = 0,price = 0;
	            Office office = new Office();
	            for (FileItem item : multiparts) {
	                if (!item.isFormField()) { 
	                	/*File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	    				File file = File.createTempFile("img1",".tmp");
	    				String imgName = getNextImageName();
	    				String destPath = uploadDir+File.separator+imgName+".jpg";
	    				File destFile = new File(destPath);
	    				file.renameTo(destFile);
	    				item.write(file);
	    				path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+imgName+".jpg";*/
	                	File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	                	String name = new File(item.getName()).getName();
                        item.write( new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img" + File.separator + name));
                        path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+name;
	                }
	                else{
	                    String fieldName = item.getFieldName();
	                    String value = item.getString();
	                    
	                    if(fieldName.equals("title"))office.setOfficeTitle(value);
	    			    if(fieldName.equals("size"))office.setSizeInSqFeet(Double.parseDouble(value));
	    			    if(fieldName.equals("floor"))office.setFloor(value);
	    			    if(fieldName.equals("price"))office.setPrice(Double.parseDouble(value));   
	    			    if(fieldName.equals("description"))office.setOfficeDescription(value);
	    				if(fieldName.equals("cityList"))office.setCity(value);
	    				if(fieldName.equals("area"))office.setArea(value);
	    				if(fieldName.equals("address"))office.setAddress(value);
	    				if(fieldName.equals("offerlist"))office.setOffertype(value);	    				
	                }
	            }//end for
	            SessionJobs sj = new SessionJobs();
				office.setUsername(sj.getUsername(request));
				GregorianCalendar gcalendar = new GregorianCalendar();
				String str = String.valueOf(gcalendar.get(Calendar.MONTH))+" " + gcalendar.get(Calendar.DATE) + " ";
			     str += gcalendar.get(Calendar.YEAR);
			     office.setDate(str);
			     office.setPic1(path);
			     OfficeAdapter oa = new OfficeAdapter();
			     oa.insert(office);
	        }
	        catch (Exception ex)
	        {
	            request.setAttribute("message", "File Upload Failed due to " + ex);
	            //ex.printStackTrace();
	        }
	    }
	    else
	    {
	        request.setAttribute("message", "Sorry this Servlet only handles file upload request");
	    }
	}
	
	public void updateOffice(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String filename = "last_val.txt";
		ServletContext context = request.getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			if((text = reader.readLine()) != null);
		}		
		imageName = text;
		
		if(ServletFileUpload.isMultipartContent(request)) {

	        try  {
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            double size = 0,price = 0;
	            Office office = new Office();
	            for (FileItem item : multiparts) {
	                if (!item.isFormField()) { 
	                	/*File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	    				File file = File.createTempFile("img1",".tmp");
	    				String imgName = getNextImageName();
	    				String destPath = uploadDir+File.separator+imgName+".jpg";
	    				File destFile = new File(destPath);
	    				file.renameTo(destFile);
	    				item.write(file);
	    				path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+imgName+".jpg";*/
	                	File uploadDir = new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img");
	                	String name = new File(item.getName()).getName();
                        item.write( new File("C:/Users/Rizve/workspace/RealEstate/WebContent/img" + File.separator + name));
                        path = "C:/Users/Rizve/workspace/RealEstate/WebContent/img/"+name;
	                }
	                else{
	                    String fieldName = item.getFieldName();
	                    String value = item.getString();
	                    
	                    if(fieldName.equals("officeid")){
	                    	office.setOfficeId(Integer.parseInt(value));
	                    	deleteOfficePic(Integer.parseInt(value));
	                    }
	                    if(fieldName.equals("title"))office.setOfficeTitle(value);
	    			    if(fieldName.equals("size"))office.setSizeInSqFeet(Double.parseDouble(value));
	    			    if(fieldName.equals("floor"))office.setFloor(value);
	    			    if(fieldName.equals("price"))office.setPrice(Double.parseDouble(value));   
	    			    if(fieldName.equals("description"))office.setOfficeDescription(value);
	    				if(fieldName.equals("cityList"))office.setCity(value);
	    				if(fieldName.equals("area"))office.setArea(value);
	    				if(fieldName.equals("address"))office.setAddress(value);
	    				if(fieldName.equals("offerlist"))office.setOffertype(value);	    				
	                }
	            }//end for
	            SessionJobs sj = new SessionJobs();
				office.setUsername(sj.getUsername(request));
				GregorianCalendar gcalendar = new GregorianCalendar();
				String str = String.valueOf(gcalendar.get(Calendar.MONTH))+" " + gcalendar.get(Calendar.DATE) + " ";
			     str += gcalendar.get(Calendar.YEAR);
			     office.setDate(str);
			     office.setPic1(path);
			     OfficeAdapter oa = new OfficeAdapter();
			     oa.update(office);
	        }
	        catch (Exception ex)
	        {
	            request.setAttribute("message", "File Upload Failed due to " + ex);
	            //ex.printStackTrace();
	        }
	    }
	    else
	    {
	        request.setAttribute("message", "Sorry this Servlet only handles file upload request");
	    }
	}
	
	public void deleteHomePic(int id){
		DataAccess da = new DataAccess();
		String sql = "SELECT pic1 FROM `home` WHERE homeId = "+id;
		ResultSet rs = da.getResultSet(sql);
		String path = null;
		try{
			if(rs.next()){
				path = rs.getString("pic1");
			}
			if(path != null)new File(path).delete();
		}catch(Exception e){
			
		}
	}
	public void deleteLandPic(int id){
		DataAccess da = new DataAccess();
		String sql = "SELECT pic1 FROM `land` WHERE landId = "+id;
		ResultSet rs = da.getResultSet(sql);
		String path = null;
		try{
			if(rs.next()){
				path = rs.getString("pic1");
			}
			if(path != null)new File(path).delete();
		}catch(Exception e){
			
		}
	}
	public void deleteOfficePic(int id){
		DataAccess da = new DataAccess();
		String sql = "SELECT pic1 FROM `office` WHERE officeId = "+id;
		ResultSet rs = da.getResultSet(sql);
		String path = null;
		try{
			if(rs.next()){
				path = rs.getString("pic1");
			}
			if(path != null)new File(path).delete();
		}catch(Exception e){
			
		}
	}
	
	public void update(){
		//this method is not necessary
		
		//first delete image file from img folder calling delete() method 
		// then upload image into the file, after this operation objects setter method can be call from controller
		//for more information contact with me... :P 
	}
	private String getNextImageName(){
		imageName = imageName.replaceAll("[^0-9]", "");
		int tmp = Integer.parseInt(imageName);
		tmp++;
		imageName = "img"+String.valueOf(tmp);
		try{
			File file = new File("C:\\Users\\Rizve\\workspace\\RealEstate\\WebContent\\last_val.txt");
		    //if(!file.exists())file.createNewFile();
		    FileWriter fw = new FileWriter(file);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(imageName);
		    bw.close();
		}catch(Exception e){
			
		}
		return imageName;
	}

}