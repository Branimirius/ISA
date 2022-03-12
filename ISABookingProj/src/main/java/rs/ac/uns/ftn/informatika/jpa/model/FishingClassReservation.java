package rs.ac.uns.ftn.informatika.jpa.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "fishing_class_reservations")
@Table(name = "fishing_class_reservations")
public class FishingClassReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "start", nullable = false)
	private Timestamp start;
	
	@Column(name = "end_time", nullable = false)
	private Timestamp endTime;
	
	@Column(name = "duration", nullable = false)
	private long duration;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "max_cap", nullable = true)
	private Integer maxCap;
	
	@Column(name = "extra_offers", nullable = true)
	private String extraOffers;
	
	@Column(name = "price", nullable = false, precision=10, scale=2)
	private Double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	private FishingClass fishingClass;

	public FishingClassReservation(long id, Timestamp start, long duration, String location,
			Integer maxCap, String extraOffers, Double price, FishingClass fishingClass) {
		super();
		this.id = id;
		this.start = start;
		this.endTime.setTime(start.getTime() + (duration*60000));
		this.duration = duration;
		this.location = location;
		this.maxCap = maxCap;
		this.extraOffers = extraOffers;
		this.price = price;
		this.fishingClass = fishingClass;
	}
	
	public FishingClassReservation() {}

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

	public Timestamp getEnd() {
		return endTime;
	}

	public void setEnd(Timestamp end) {
		this.endTime = end;
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

	public FishingClass getFishingClass() {
		return fishingClass;
	}

	public void setFishingClass(FishingClass fishingClass) {
		this.fishingClass = fishingClass;
	}
	
	
}
