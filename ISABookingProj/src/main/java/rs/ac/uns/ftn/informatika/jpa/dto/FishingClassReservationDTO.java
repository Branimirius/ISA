package rs.ac.uns.ftn.informatika.jpa.dto;

import java.sql.Timestamp;

import rs.ac.uns.ftn.informatika.jpa.model.FishingClassReservation;

public class FishingClassReservationDTO {
	private long id;
	private long userId;
	private Timestamp start;
	private Timestamp end;
	private long duration;
	private String location;
	private Integer maxCap;
	private String extraOffers;
	private Double price;
	private FishingClassDTO fishingClass;
	
	public FishingClassReservationDTO(long id, Timestamp start, Timestamp end, long duration, String location,
			Integer maxCap, String extraOffers, Double price, FishingClassDTO fishingClass) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.location = location;
		this.maxCap = maxCap;
		this.extraOffers = extraOffers;
		this.price = price;
		this.fishingClass = fishingClass;
	}
	
	public FishingClassReservationDTO(FishingClassReservation fcr) {
		this.id = fcr.getId();
		this.start = fcr.getStart();
		this.end = fcr.getEnd();
		this.duration = fcr.getDuration();
		this.location = fcr.getLocation();
		this.maxCap = fcr.getMaxCap();
		this.extraOffers = fcr.getExtraOffers();
		this.price = fcr.getPrice();
		this.fishingClass = new FishingClassDTO(fcr.getFishingClass());
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
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
