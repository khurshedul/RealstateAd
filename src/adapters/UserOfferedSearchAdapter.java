package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Home;
import models.Land;
import models.Office;

public class UserOfferedSearchAdapter {
	public ArrayList<Home> getAllHomeOffered(String username)
	{
		String sql = "SELECT * FROM home Where username = '"+username+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Home> homelist = new ArrayList<Home>();
		try {
			while(rs.next())
			{
				Home home = new Home();
				home.setHomeId(rs.getInt("homeId"));
				home.setHomeTitle(rs.getString("homeTitle"));
				home.setNoOfBeds(rs.getInt("noofbeds"));
				home.setNoOfBaths(rs.getInt("noofbaths"));
				home.setSizeInSqFeet(rs.getDouble("sizeinsqfeet"));
				home.setFloor(rs.getString("floor"));
				home.setHomeDescription(rs.getString("homeDescription"));
				home.setUsername(rs.getString("username"));
				home.setCity(rs.getString("city"));
				home.setArea(rs.getString("area"));
				home.setAddress(rs.getString("address"));
				home.setOffertype(rs.getString("offertype"));	
				home.setDate(rs.getString("postdate"));
				home.setPic1(rs.getString("pic1"));
				home.setFlag(rs.getString("flag"));
				home.setStatus(rs.getString("status"));
				home.setPricePerSqFeet(rs.getDouble("price"));
				home.setPrice(rs.getDouble("price"));
				homelist.add(home);
			}
			return homelist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Land> getAllLandOffered(String username)
	{
		String sql = "SELECT * FROM land Where username = '"+username+"'";
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
	public ArrayList<Office> getAllOfficeOffered(String username)
	{
		String sql = "SELECT * FROM office Where username = '"+username+"'";
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
				office.setArea(rs.getString("area"));
				office.setAddress(rs.getString("address"));
				office.setOffertype(rs.getString("offertype"));		
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
