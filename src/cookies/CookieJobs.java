package cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


public class CookieJobs {
	public CookieJobs() {
	
	}
	
	public Boolean getUserDetail(Cookie[] cookies,String username,String password){
		
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("username")){
				//writer.print(cookies[i].getValue());
				username = cookies[i].getValue();
			}
			if(cookies[i].getName().equals("password")){
				//writer.print(cookies[i].getValue());
				password = cookies[i].getValue();
			}
		}
		//System.out.println(username+password);
		if(username.equals("")||password.equals("") ){
			return false;
		}
		return true;
	}
	
	public String getUsername(Cookie[] cookies){
		String username = "";
		try {
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("username")){
					//writer.print(cookies[i].getValue());
					username = cookies[i].getValue();
					return username;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public String getPassword(Cookie[] cookies){
		String password = "";
		try {
			
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("password")){
					//writer.print(cookies[i].getValue());
					password = cookies[i].getValue();
					return password;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public void deleteUserDetail(HttpServletResponse response ,Cookie[] cookies){
		try {
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("username")){
					
					Cookie c = new Cookie("username","");
					c.setMaxAge(0);
					response.addCookie(c);
					continue;
				}
				if(cookies[i].getName().equals("password")){
					Cookie c = new Cookie("password","");
					c.setMaxAge(0);
					response.addCookie(c);
					continue;
				}	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addUserDetail(String username, String password , HttpServletResponse response){
		Cookie c = new Cookie("username",username);
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		
		c=new Cookie("password", password);
		response.addCookie(c);
	}	
}