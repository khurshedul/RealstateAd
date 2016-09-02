package sessions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.User;

public class SessionJobs {
	public SessionJobs() {
		
	}
	
	public boolean adminCheck(HttpServletRequest request){
		HttpSession session =  request.getSession();
		User user= (User)session.getAttribute("currentUser");
		if(user==null){
			return false;
		}else{
			if(user.getType()!=1){
				return false;
			}
		}	
		return true;
	}
	public boolean customerCheck(HttpServletRequest request){
		HttpSession session =  request.getSession();
		User user= (User)session.getAttribute("currentUser");
		if(user==null){
			return false;
		}else{
			if(user.getType()!=2){
				return false;
			}
		}
		
		return true;
	}
	public String getUsername(HttpServletRequest request){
		HttpSession session =  request.getSession();
		User user= (User)session.getAttribute("currentUser");
		if(user==null){
			return "";
		}else{
			return user.getUsername();
		}
	}
}