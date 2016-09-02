package models;

public class Land {
	private int landId;
	private String landTitle;
	private double totalKatha;
	private double pricePerKatha;
	private String landDescription;
	private String category;
	
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
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
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

	public int getLandId() {
		return landId;
	}
	public void setLandId(int landId) {
		this.landId = landId;
	}
	public String getLandTitle() {
		return landTitle;
	}
	public void setLandTitle(String landTitle) {
		this.landTitle = landTitle;
	}
	public double getTotalKatha() {
		return totalKatha;
	}
	public void setTotalKatha(double totalKatha) {
		this.totalKatha = totalKatha;
	}
	public double getPricePerKatha() {
		return pricePerKatha;
	}
	public void setPricePerKatha(double pricePerKatha) {
		this.pricePerKatha = pricePerKatha;
	}
	public String getLandDescription() {
		return landDescription;
	}
	public void setLandDescription(String landDescription) {
		this.landDescription = landDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}