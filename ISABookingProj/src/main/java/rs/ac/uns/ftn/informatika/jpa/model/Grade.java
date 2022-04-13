package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.GradeDTO;

@Entity(name = "grades")
@Table(name = "grades")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "grade")
	private long grade;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "subject_id")
	private long subjectId;

	public Grade(long id, long grade, long userId, long subjectId) {
		super();
		this.id = id;
		this.grade = grade;
		this.userId = userId;
		this.subjectId = subjectId;
	}
	
	public Grade() {}

	public Grade(GradeDTO grade) {
		this(grade.getId(), grade.getUserId(), grade.getSubjectId(), grade.getGrade());
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	
	
}
