package rs.ac.uns.ftn.informatika.jpa.dto;

import java.sql.Timestamp;

public class FishingClassReservationDTO {
	private long id;
	private Timestamp start;
	private Timestamp endTime;
	private long duration;
	private String location;
	private Integer maxCap;
	private String extraOffers;
	private Double price;
	private FishingClassDTO fishingClass;
	
	public FishingClassReservationDTO(long id, Timestamp start, Timestamp endTime, long duration, String location,
			Integer maxCap, String extraOffers, Double price, FishingClassDTO fishingClass) {
		super();
		this.id = id;
		this.start = start;
		this.endTime = endTime;
		this.duration = duration;
		this.location = location;
		this.maxCap = maxCap;
		this.extraOffers = extraOffers;
		this.price = price;
		this.fishingClass = fishingClass;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getMaxCap() {
		return maxCap;
	}
	public void setMaxCap(Integer maxCap) {
		this.maxCap = maxCap;
	}
	public String getExtraOffers() {
		return extraOffers;
	}
	public void setExtraOffers(String extraOffers) {
		this.extraOffers = extraOffers;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public FishingClassDTO getFishingClass() {
		return fishingClass;
	}
	public void setFishingClass(FishingClassDTO fishingClass) {
		this.fishingClass = fishingClass;
	}
	
	
	
	
	
}
