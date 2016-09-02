package models;


public class Office {
	private int officeId;
	private String officeTitle;
	private double sizeInSqFeet;
	private String floor;
	private double price;
	private String category;
	private String officeDescription;
	//private Date date;
	private String username;
	private String city;
	private String area;
	private String address;
	private String offertype;
	
	
	
	private String date;
	private String pic1;
	
	private String flag;
	private String status;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}	
	
	public String getCity() {
		return city;
	}
	public String getArea() {
		return area;
	}
	public String getAddress() {
		return address;
	}
	public String getOffertype() {
		return offertype;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setOffertype(String offertype) {
		this.offertype = offertype;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getOfficeId() {
		return officeId;
	}
	public String getOfficeTitle() {
		return officeTitle;
	}
	public double getSizeInSqFeet() {
		return sizeInSqFeet;
	}
	public String getFloor() {
		return floor;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public String getOfficeDescription() {
		return officeDescription;
	}
/*	public Date getDate() {
		return date;
	}*/
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public void setOfficeTitle(String officeTitle) {
		this.officeTitle = officeTitle;
	}
	public void setSizeInSqFeet(double sizeInSqFeet) {
		this.sizeInSqFeet = sizeInSqFeet;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setOfficeDescription(String officeDescription) {
		this.officeDescription = officeDescription;
	}
	/*
	public void setDate(Date date) {
		this.date = date;
	}
	*/

	
}