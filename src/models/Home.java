package models;


public class Home {
	private int homeId;
	private String homeTitle;
	private String homeLocation;
	private int noOfBeds;
	private int noOfBaths;
	private double sizeInSqFeet;
	private double pricePerSqFeet;
	private String floor;
	private String homeDescription;
	private String username;
		
	private String city;
	private String area;
	private String address;
	private String offertype;
	
	private String date;
	private String pic1;
	private String flag;
	private String status;
	private double price;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
/*	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public String getHomeTitle() {
		return homeTitle;
	}
	public void setHomeTitle(String homeTitle) {
		this.homeTitle = homeTitle;
	}
	public String getHomeLocation() {
		return homeLocation;
	}
	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public int getNoOfBaths() {
		return noOfBaths;
	}
	public void setNoOfBaths(int noOfBaths) {
		this.noOfBaths = noOfBaths;
	}
	public double getSizeInSqFeet() {
		return sizeInSqFeet;
	}
	public void setSizeInSqFeet(double sizeInSqFeet) {
		this.sizeInSqFeet = sizeInSqFeet;
	}
	public double getPricePerSqFeet() {
		return pricePerSqFeet;
	}
	public void setPricePerSqFeet(double pricePerSqFeet) {
		this.pricePerSqFeet = pricePerSqFeet;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getHomeDescription() {
		return homeDescription;
	}
	public void setHomeDescription(String homeDescription) {
		this.homeDescription = homeDescription;
	}	
}