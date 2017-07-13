package vancouver.model;

public class PublicWashroom {
	
	private Integer primaryind;
	
	private String name;
	
	private String address;
	
	private String type;
	
	private String location;
	
	private String summer_hours;
	
	private String winter_hours;
	
	private String wheelchair_access;
	
	private String note;
	
	private Double latitude;
	
	private Double longitude;
	
	private String maintainer;
	
	
	
	public PublicWashroom(Integer primaryind, String name, String address, String type, String location,
			String summer_hours, String winter_hours, String wheelchair_access, String note, Double latitude,
			Double longitude, String maintainer) {
		this.primaryind = primaryind;
		this.name = name;
		this.address = address;
		this.type = type;
		this.location = location;
		this.summer_hours = summer_hours;
		this.winter_hours = winter_hours;
		this.wheelchair_access = wheelchair_access;
		this.note = note;
		this.latitude = latitude;
		this.longitude = longitude;
		this.maintainer = maintainer;
	}
	public Integer getPrimaryind() {
		return primaryind;
	}
	public void setPrimaryind(Integer primaryind) {
		this.primaryind = primaryind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSummer_hours() {
		return summer_hours;
	}
	public void setSummer_hours(String summer_hours) {
		this.summer_hours = summer_hours;
	}
	public String getWinter_hours() {
		return winter_hours;
	}
	public void setWinter_hours(String winter_hours) {
		this.winter_hours = winter_hours;
	}
	public String getWheelchair_access() {
		return wheelchair_access;
	}
	public void setWheelchair_access(String wheelchair_access) {
		this.wheelchair_access = wheelchair_access;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getMaintainer() {
		return maintainer;
	}
	public void setMaintainer(String maintainer) {
		this.maintainer = maintainer;
	}
	
}
