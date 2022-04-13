package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Grade;

public class GradeDTO {
	
	private long id;
	private long userId;
	private long subjectId;
	private long grade;
	
	public GradeDTO(long id, long userId, long subjectId, long grade) {
		super();
		this.id = id;
		this.userId = userId;
		this.subjectId = subjectId;
		this.grade = grade;
	}
	
	public GradeDTO() {}
	
	public GradeDTO(Grade grade) {
		this(grade.getId(), grade.getUserId(), grade.getSubjectId(), grade.getGrade());
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

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}
	
}
