package rs.ac.uns.ftn.informatika.jpa.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "instructor_availabilities")
@Table(name = "instructor_availabilities")
public class InstructorAvailability {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_id", nullable = false)
	private long userId;
	
	@Column(name = "start", nullable = false)
	private Timestamp start;
	
	@Column(name = "end_time", nullable = false)
	private Timestamp endTime;

	public InstructorAvailability(long id, long userId, Timestamp start, Timestamp endTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.start = start;
		this.endTime = endTime;
	}
	
	public InstructorAvailability() {}

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
