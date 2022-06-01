package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "loyality_program")
@Table(name = "loyality_program")
public class LoyalityProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "client_points", nullable = false)
	private int clientPointStep;
	
	@Column(name = "owner_points", nullable = false)
	private int ownerPointStep;
	
	@Column(name = "bronze_line", nullable = false)
	private int bronzeLine;
	
	@Column(name = "silver_line", nullable = false)
	private int silverLine;
	
	@Column(name = "gold_line", nullable = false)
	private int goldLine;

	public LoyalityProgram(long id, int clientPointStep, int ownerPointStep, int bronzeLine, int silverLine, int goldLine) {
		super();
		this.id = id;
		this.clientPointStep = clientPointStep;
		this.ownerPointStep = ownerPointStep;
		this.bronzeLine = bronzeLine;
		this.silverLine = silverLine;
		this.goldLine = goldLine;
	}
	
	public LoyalityProgram() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getClientPointStep() {
		return clientPointStep;
	}

	public void setClientPointStep(int clientPointStep) {
		this.clientPointStep = clientPointStep;
	}

	public int getOwnerPointStep() {
		return ownerPointStep;
	}

	public void setOwnerPointStep(int ownerPointStep) {
		this.ownerPointStep = ownerPointStep;
	}

	public int getBronzeLine() {
		return bronzeLine;
	}

	public void setBronzeLine(int bronzeLine) {
		this.bronzeLine = bronzeLine;
	}

	public int getSilverLine() {
		return silverLine;
	}

	public void setSilverLine(int silverLine) {
		this.silverLine = silverLine;
	}

	public int getGoldLine() {
		return goldLine;
	}

	public void setGoldLine(int goldLine) {
		this.goldLine = goldLine;
	}

}
