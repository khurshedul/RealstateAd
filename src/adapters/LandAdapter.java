package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Land;

public class LandAdapter {
	
	public void insert(Land land)
	{
		String sql = "INSERT INTO land VALUES (null,'"+land.getLandTitle()+"',"+land.getTotalKatha()+","+land.getPricePerKatha()+",'"+land.getLandDescription()+"','"+land.getUsername()+"','"+land.getCity()+"','"+land.getArea()+"','"+land.getAddress()+"','"+land.getOffertype()+"','"+land.getDate()+"','"+land.getPic1()+"','false','avilable',"+land.getPrice()+")";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(Land land)
	{
		String sql = "UPDATE land SET landTitle = '"+land.getLandTitle()+"', totalKatha = "+land.getTotalKatha()+", pricePerKatha = "+land.getPricePerKatha()+", landDescription = '"+land.getLandDescription()+"', username = '"+land.getUsername()+"', city = '"+land.getCity()+"', area = '"+land.getArea()+"', address = '"+land.getAddress()+"', offertype = '"+land.getOffertype()+"',pic1 = '"+land.getPic1()+"' WHERE  landId = "+land.getLandId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM land WHERE landId="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(Land land)
	{
		String sql = "DELETE FROM land WHERE landId="+land.getLandId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<Land> getAll()
	{
		String sql = "SELECT * FROM land";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Land> landlist = new ArrayList<Land>();
		try {
			while(rs.next())
			{
				Land land = new Land();
				land.setLandId(rs.getInt("landId"));
				land.setLandTitle(rs.getString("landTitle"));
				land.setTotalKatha(rs.getDouble("totalkatha"));
				land.setPricePerKatha(rs.getDouble("pricePerKatha"));
				land.setLandDescription(rs.getString("landDescription"));
				land.setUsername(rs.getString("username"));
				
				land.setCity(rs.getString("city"));
				land.setArea(rs.getString("area"));
				land.setAddress(rs.getString("address"));
				land.setOffertype(rs.getString("offertype"));
				land.setDate(rs.getString("postdate"));
				land.setPic1(rs.getString("pic1"));
				land.setFlag(rs.getString("flag"));
				land.setStatus(rs.getString("status"));
				land.setPrice(rs.getDouble("price"));

				landlist.add(land);
			}
			return landlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Land getSingle(int id)
	{
		String sql = "SELECT * FROM land WHERE landId="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Land land = new Land();
		try {
			if(rs.next())
			{
				land.setLandId(rs.getInt("landId"));
				land.setLandTitle(rs.getString("landTitle"));
				land.setTotalKatha(rs.getDouble("totalkatha"));
				land.setPricePerKatha(rs.getDouble("pricePerKatha"));
				land.setLandDescription(rs.getString("landDescription"));
				land.setUsername(rs.getString("username"));
				
				land.setCity(rs.getString("city"));
				land.setArea(rs.getString("area"));
				land.setAddress(rs.getString("address"));
				land.setOffertype(rs.getString("offertype"));
				land.setDate(rs.getString("postdate"));
				land.setPic1(rs.getString("pic1"));
				land.setFlag(rs.getString("flag"));
				land.setStatus(rs.getString("status"));
				land.setPrice(rs.getDouble("price"));
				
				return land;
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
	public ArrayList<Land> getAllForSearch(String sql)
	{
		//String sql = "SELECT * FROM land";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Land> landlist = new ArrayList<Land>();
		try {
			while(rs.next())
			{
				Land land = new Land();
				land.setLandId(rs.getInt("landId"));
				land.setLandTitle(rs.getString("landTitle"));
				land.setTotalKatha(rs.getDouble("totalkatha"));
				land.setPricePerKatha(rs.getDouble("pricePerKatha"));
				land.setLandDescription(rs.getString("landDescription"));
				land.setUsername(rs.getString("username"));
				
				land.setCity(rs.getString("city"));
				land.setArea(rs.getString("area"));
				land.setAddress(rs.getString("address"));
				land.setOffertype(rs.getString("offertype"));
				land.setDate(rs.getString("postdate"));
				land.setPic1(rs.getString("pic1"));
				land.setFlag(rs.getString("flag"));
				land.setStatus(rs.getString("status"));
				land.setPrice(rs.getDouble("price"));

				landlist.add(land);
			}
			return landlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}