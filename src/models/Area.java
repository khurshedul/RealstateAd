package models;

public class Area {
	public int areaId;
	public String areaTitle;
	public String cityTitle;
	
	
	public String getCityTitle() {
		return cityTitle;
	}
	public void setCityTitle(String cityTitle) {
		this.cityTitle = cityTitle;
	}
	public int getAreaId() {
		return areaId;
	}
	public String getAreaTitle() {
		return areaTitle;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public void setAreaTitle(String areaTitle) {
		this.areaTitle = areaTitle;
	}
	
}