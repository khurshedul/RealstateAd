package adapters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.User;

public class UserAdapter {

	public void insert(User usr)
	{
		String sql = "INSERT INTO Users VALUES (null,'"+usr.getUsername()+"','"+usr.getPassword()+"','2','"+usr.getName()+"', 'null' ,'"+usr.getAddress()+"','"+usr.getEmail()+"','"+usr.getContactnumber()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(User usr)
	{
		String sql = "UPDATE Users SET username = '"+usr.getUsername()+"', password = '"+usr.getPassword()+"', firstname = '"+usr.getName()+"', address = '"+usr.getAddress()+"', email = '"+usr.getEmail()+"', contactnumber '"+usr.getContactnumber()+"'WHERE id ='"+usr.getId()+"'";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM Users WHERE id="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(User usr)
	{
		String sql = "DELETE FROM Users WHERE id="+usr.getId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<User> getAll()
	{
		String sql = "SELECT * FROM Users";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<User> usrlist = new ArrayList<User>();
		try {
			while(rs.next())
			{
				User usr = new User();
				usr.setId(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				//usr.setLastname(rs.getString("lastname"));
				usr.setEmail(rs.getString("email"));
				usr.setType(rs.getInt("type"));
				usr.setAddress(rs.getString("address"));
				usr.setPassword(rs.getString("password"));
				usr.setUsername(rs.getString("username"));
				usr.setContactnumber(rs.getString("contactnumber"));
				
				usrlist.add(usr);
			}
			return usrlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean isUserNameUnique(String username){
		String sql = "SELECT COUNT(*) as count FROM users WHERE username = '"+username+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int count=0;
		try {
			while(rs.next()){
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0){
			return false;
					
		}
		return true;
	}
	public boolean isEmailUnique(String email){
		String sql = "SELECT COUNT(*) as count FROM users WHERE email = '"+email+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int count=0;
		try {
			while(rs.next()){
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0){
			return false;
					
		}
		return true;
	}
	public ArrayList<User> search(String str)
	{
		
		String sql = "SELECT * FROM Users WHERE username LIKE '%"+str+"%' or contactnumber LIKE '%"+str+"%' or name LIKE '%"+str+"%' or address LIKE '%"+str+"%' or email LIKE '%"+str+"%'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<User> usrlist = new ArrayList<User>();
		try {
			while(rs.next())
			{
				User usr = new User();
				usr.setId(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				//usr.setLastname(rs.getString("lastname"));
				usr.setEmail(rs.getString("email"));
				usr.setType(rs.getInt("type"));
				usr.setAddress(rs.getString("address"));
				usr.setPassword(rs.getString("password"));
				usr.setUsername(rs.getString("username"));
				usr.setContactnumber(rs.getString("contactnumber"));
				
				usrlist.add(usr);
			}
			return usrlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public User get(int id)
	{
		String sql = "SELECT * FROM Users WHERE id="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		User usr = new User();
		try {
			if(rs.next())
			{
				usr.setId(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				//usr.setLastname(rs.getString("lastname"));
				usr.setEmail(rs.getString("email"));
				usr.setType(rs.getInt("type"));
				usr.setAddress(rs.getString("address"));
				usr.setPassword(rs.getString("password"));
				usr.setUsername(rs.getString("username"));
				usr.setContactnumber(rs.getString("contactnumber"));
				return usr;
			}
			else
			{
				return null;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public models.User login(models.User user){
		
		String sql = "Select * from Users where username = '"+user.getUsername()+"' And password = '"+user.getPassword()+"'";
		
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		try {
			if(rs.next())
			{
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				//user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setType(rs.getInt("type"));
				user.setAddress(rs.getString("address"));
				user.setContactnumber(rs.getString("contactnumber"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	
	
	
}
