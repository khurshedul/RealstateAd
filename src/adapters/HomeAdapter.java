package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;


import models.Home;

public class HomeAdapter {

	public void insert(Home home)
	{
		String sql = "INSERT INTO home VALUES (null,'"+home.getHomeTitle()+"',"+home.getNoOfBeds()+","+home.getNoOfBaths()+","+home.getSizeInSqFeet()+","+home.getPricePerSqFeet()+",'"+home.getFloor()+"','"+home.getHomeDescription()+"','"+home.getUsername()+"','"+home.getCity()+"','"+home.getArea()+"','"+home.getAddress()+"','"+home.getOffertype()+"','"+home.getDate()+"','"+home.getPic1()+"','false','avilable',"+home.getPrice()+")";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(Home home)
	{
		double price = home.getPricePerSqFeet()*home.getSizeInSqFeet();
		String sql = "UPDATE home SET homeTitle = '"+home.getHomeTitle()+"', noofbeds= "+home.getNoOfBeds()+",noofbaths= "+home.getNoOfBaths()+",sizeInSqFeet = "+home.getSizeInSqFeet()+", pricePerSqFeet = "+home.getPricePerSqFeet()+", floor = '"+home.getFloor()+"', homeDescription = '"+home.getHomeDescription()+"', username = '"+home.getUsername()+"',  city = '"+home.getCity()+"', area = '"+home.getArea()+"', address = '"+home.getAddress()+"', offertype = '"+home.getOffertype()+"', pic1 = '"+home.getPic1()+"', price = "+price+" WHERE homeId ="+home.getHomeId()+"";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM home WHERE homeId="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(Home home)
	{
		String sql = "DELETE FROM home WHERE homeId="+home.getHomeId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<Home> getAll()
	{
		String sql = "SELECT * FROM home";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Home> homelist = new ArrayList<Home>();
		try {
			while(rs.next())
			{
				Home home = new Home();
				home.setHomeId(rs.getInt("homeId"));
				home.setHomeTitle(rs.getString("homeTitle"));
				home.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				home.setFloor(rs.getString("floor"));
				home.setPricePerSqFeet(rs.getDouble("price"));
				home.setHomeDescription(rs.getString("homeDescription"));
				
				home.setUsername(rs.getString("username"));
				home.setNoOfBeds(rs.getInt("noofbeds"));
				home.setNoOfBaths(rs.getInt("noofbaths"));
				home.setCity(rs.getString("city"));
				home.setArea(rs.getString("area"));
				home.setAddress(rs.getString("address"));
				home.setOffertype(rs.getString("offertype"));				
				homelist.add(home);
			}
			return homelist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Home get(int id)
	{
		String sql = "SELECT * FROM `home` WHERE homeId="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Home home = new Home();
		try {
			if(rs.next())
			{
				home.setHomeId(rs.getInt("homeId"));
				home.setHomeTitle(rs.getString("homeTitle"));
				home.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				home.setFloor(rs.getString("floor"));
				home.setPricePerSqFeet(rs.getDouble("price"));
				home.setHomeDescription(rs.getString("homeDescription"));
				home.setUsername(rs.getString("username"));
				home.setNoOfBeds(rs.getInt("noofbeds"));
				home.setNoOfBaths(rs.getInt("noofbaths"));
				home.setCity(rs.getString("city"));
				home.setArea(rs.getString("area"));
				home.setAddress(rs.getString("address"));
				home.setOffertype(rs.getString("offertype"));	
				home.setDate(rs.getString("postdate"));
				home.setPic1(rs.getString("pic1"));
				home.setPrice(rs.getDouble("price"));
				home.setFlag(rs.getString("flag"));
				home.setStatus(rs.getString("status"));
				return home;
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
	
	public ArrayList<Home> getAllForSearch(String sql)
	{
		//String sql = "SELECT * FROM home";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Home> homelist = new ArrayList<Home>();
		try {
			while(rs.next())
			{
				Home home = new Home();
				home.setHomeId(rs.getInt("homeId"));
				home.setHomeTitle(rs.getString("homeTitle"));
				home.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				home.setFloor(rs.getString("floor"));
				home.setPricePerSqFeet(rs.getDouble("price"));
				home.setHomeDescription(rs.getString("homeDescription"));
				
				home.setUsername(rs.getString("username"));
				home.setNoOfBeds(rs.getInt("noofbeds"));
				home.setNoOfBaths(rs.getInt("noofbaths"));
				home.setCity(rs.getString("city"));
				home.setArea(rs.getString("area"));
				home.setAddress(rs.getString("address"));
				home.setOffertype(rs.getString("offertype"));				
				homelist.add(home);
			}
			return homelist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
