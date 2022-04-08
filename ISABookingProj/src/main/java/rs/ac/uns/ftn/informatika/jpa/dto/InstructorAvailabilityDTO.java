package rs.ac.uns.ftn.informatika.jpa.dto;

import java.sql.Timestamp;

import rs.ac.uns.ftn.informatika.jpa.model.InstructorAvailability;
import rs.ac.uns.ftn.informatika.jpa.model.User;

public class InstructorAvailabilityDTO {
	private long id;
	private long userId;
	private Timestamp start;
	private Timestamp endTime;
	
	public InstructorAvailabilityDTO(long id, long userId, Timestamp start, Timestamp endTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.start = start;
		this.endTime = endTime;
	}
	
	public InstructorAvailabilityDTO() {}
	
	public InstructorAvailabilityDTO(InstructorAvailability availability) {
		this(availability.getId(), availability.getUserId(), availability.getStart(), availability.getEndTime());
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
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
}
