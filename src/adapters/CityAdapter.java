package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.City;


public class CityAdapter {

	public void insert(City city)
	{
		String sql = "INSERT INTO city VALUES (null,'"+city.getCityTitle()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(City city)
	{
		String sql = "UPDATE city SET citytitle = '"+city.getCityTitle()+"'' WHERE id = '"+city.getCityId()+"'";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM city WHERE id="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(City city)
	{
		String sql = "DELETE FROM city WHERE id="+city.getCityId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<City> getAll()
	{
		String sql = "SELECT * FROM city";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<City> citylist = new ArrayList<City>();
		try {
			while(rs.next())
			{
				City city  = new City();
				city.setCityId(rs.getInt("id"));
				city.setCityTitle(rs.getString("citytitle"));
				
				citylist.add(city);
			}
			return citylist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public City getSingle(int id)
	{
		String sql = "SELECT * FROM city WHERE id="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		City city = new City();
		try {
			if(rs.next())
			{
				city.setCityId(rs.getInt("id"));
				city.setCityTitle(rs.getString("citytitle"));
				
				
				return city;
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
}