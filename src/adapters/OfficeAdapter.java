package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Office;


public class OfficeAdapter {
	public void insert(Office office)
	{
		String sql = "INSERT INTO office VALUES (null,'"+office.getOfficeTitle()+"',"+office.getSizeInSqFeet()+",'"+office.getFloor()+"',"+office.getPrice()+",'"+office.getOfficeDescription()+"','"+office.getUsername()+"','"+office.getCity()+"','"+office.getArea()+"','"+office.getAddress()+"','"+office.getOffertype()+"','"+office.getDate()+"','"+office.getPic1()+"','false','avilable')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(Office office)
	{
		String sql = "UPDATE office SET officeTitle = '"+office.getOfficeTitle()+"', sizeInSqFeet = "+office.getSizeInSqFeet()+", floor = '"+office.getFloor()+"', price = "+office.getPrice()+",  officeDescription = '"+office.getOfficeDescription()+"', username = '"+office.getUsername()+"',  city = '"+office.getCity()+"', area = '"+office.getArea()+"', address = '"+office.getAddress()+"', offertype = '"+office.getOffertype()+"', dateposted = '"+office.getDate()+"', pic1 = '"+office.getPic1()+"' WHERE officeId = "+office.getOfficeId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM office WHERE officeId="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(Office office)
	{
		String sql = "DELETE FROM office WHERE officeId="+office.getOfficeId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<Office> getAll()
	{
		String sql = "SELECT * FROM office";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Office> officelist = new ArrayList<Office>();
		try {
			while(rs.next())
			{
				Office office = new Office();
				office.setOfficeId(rs.getInt("officeId"));
				office.setOfficeTitle(rs.getString("officeTitle"));
				office.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				office.setFloor(rs.getString("floor"));
				office.setPrice(rs.getDouble("price"));
				office.setCategory(rs.getString("category"));
				office.setOfficeDescription(rs.getString("officeDescription"));
				
				office.setUsername(rs.getString("username"));
				
				office.setCity(rs.getString("city"));
				office.setCity(rs.getString("area"));
				office.setCity(rs.getString("address"));
				office.setCity(rs.getString("offertype"));				
				officelist.add(office);
			}
			return officelist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Office get(int id)
	{
		String sql = "SELECT * FROM office WHERE officeId="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Office office = new Office();
		try {
			if(rs.next())
			{
				office.setOfficeId(rs.getInt("officeId"));
				office.setOfficeTitle(rs.getString("officeTitle"));
				office.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				office.setFloor(rs.getString("floor"));
				office.setPrice(rs.getDouble("price"));
				office.setOfficeDescription(rs.getString("officeDescription"));
				
				office.setUsername(rs.getString("username"));
				
				office.setCity(rs.getString("city"));
				office.setCity(rs.getString("area"));
				office.setCity(rs.getString("address"));
				office.setCity(rs.getString("offertype"));
				office.setDate(rs.getString("dateposted"));
				office.setPic1(rs.getString("pic1"));
				office.setFlag(rs.getString("flag"));
				office.setStatus(rs.getString("status"));
				
				return office;
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
	public ArrayList<Office> getAllForSearch(String sql)
	{
		//String sql = "SELECT * FROM office";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Office> officelist = new ArrayList<Office>();
		try {
			while(rs.next())
			{
				Office office = new Office();
				office.setOfficeId(rs.getInt("officeId"));
				office.setOfficeTitle(rs.getString("officeTitle"));
				office.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				office.setFloor(rs.getString("floor"));
				office.setPrice(rs.getDouble("price"));
				office.setOfficeDescription(rs.getString("officeDescription"));
				
				office.setUsername(rs.getString("username"));
				
				office.setCity(rs.getString("city"));
				office.setCity(rs.getString("area"));
				office.setCity(rs.getString("address"));
				office.setCity(rs.getString("offertype"));
				office.setDate(rs.getString("dateposted"));
				office.setPic1(rs.getString("pic1"));
				office.setFlag(rs.getString("flag"));
				office.setStatus(rs.getString("status"));
				officelist.add(office);
			}
			return officelist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}