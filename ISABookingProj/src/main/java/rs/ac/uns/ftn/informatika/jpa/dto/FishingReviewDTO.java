package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.FishingReview;
import rs.ac.uns.ftn.informatika.jpa.model.User;

public class FishingReviewDTO {
	
	private long id;
	private UserDTO client;
	private UserDTO instructor;
	private String comment;
	private boolean report;
	private boolean showUp;
	
	public FishingReviewDTO(long id, UserDTO client, UserDTO instructor, String comment, boolean report,
			boolean showUp) {
		super();
		this.id = id;
		this.client = client;
		this.instructor = instructor;
		this.comment = comment;
		this.report = report;
		this.showUp = showUp;
	}
	
	public FishingReviewDTO() {}
	
	public FishingReviewDTO(FishingReview review) {
		this(review.getId(), new UserDTO(review.getClient()), new UserDTO(review.getInstructor()), review.getComment(), review.isReport(), review.isShowUp());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserDTO getClient() {
		return client;
	}
	public void setClient(UserDTO client) {
		this.client = client;
	}
	public UserDTO getInstructor() {
		return instructor;
	}
	public void setInstructor(UserDTO instructor) {
		this.instructor = instructor;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isReport() {
		return report;
	}
	public void setReport(boolean report) {
		this.report = report;
	}
	public boolean isShowUp() {
		return showUp;
	}
	public void setShowUp(boolean showUp) {
		this.showUp = showUp;
	}
	
	
}
