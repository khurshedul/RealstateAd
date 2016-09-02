package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Area;
import models.Land;

public class AreaAdapter {

	public void insert(Area area)
	{
		String sql = "INSERT INTO area VALUES (null,'"+area.getAreaTitle()+"','"+area.getCityTitle()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(Area area)
	{
		String sql = "UPDATE area SET areaname = '"+area.getAreaTitle()+"', cityid = '"+area.getCityTitle()+"' WHERE id = '"+area.getAreaId()+"'";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM area WHERE id="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(Land land)
	{
		String sql = "DELETE FROM area WHERE id="+land.getLandId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<Area> getAll()
	{
		String sql = "SELECT * FROM area";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Area> arealist = new ArrayList<Area>();
		try {
			while(rs.next())
			{
				Area area = new Area();
				area.setAreaId(rs.getInt("id"));
				area.setAreaTitle(rs.getString("areaname"));
				area.setCityTitle(rs.getString("citytitle"));
				arealist.add(area);
			}
			return arealist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Area getSingle(int id)
	{
		String sql = "SELECT * FROM area WHERE id="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Area area = new Area();
		try {
			if(rs.next())
			{
				area.setAreaId(rs.getInt("id"));
				area.setAreaTitle(rs.getString("areaname"));
				area.setCityTitle(rs.getString("citytitle"));
				
				return area;
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
	public ArrayList<Area> getAllArea(String cityId){
		DataAccess DA = new DataAccess();
		String sql = "SELECT * FROM area WHERE citytitle = '"+cityId+"'";
		ResultSet rs = DA.getResultSet(sql);
		ArrayList<Area> areaList = new ArrayList<>();
		try {
			while(rs.next()){
				Area area = new Area();
				area.setAreaId(rs.getInt("id"));
				area.setAreaTitle(rs.getString("areaname"));
				area.setCityTitle(rs.getString("citytitle"));
				areaList.add(area);
			}
			return areaList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}