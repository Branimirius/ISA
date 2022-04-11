package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "fishing_reviews")
@Table(name = "fishing_reviews")
public class FishingReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client")
	private User client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instructor")
	private User instructor;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "report")
	private boolean report;
	
	@Column(name = "show_up")
	private boolean showUp;

	public FishingReview(long id, User client, User instructor, String comment, boolean report, boolean showUp) {
		super();
		this.id = id;
		this.client = client;
		this.instructor = instructor;
		this.comment = comment;
		this.report = report;
		this.showUp = showUp;
	}
	
	public FishingReview() {}
	//public FishingReview(FishingReviewDTO) {
	//	this();
	//}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
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
