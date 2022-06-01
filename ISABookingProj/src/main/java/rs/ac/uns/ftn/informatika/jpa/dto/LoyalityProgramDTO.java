package rs.ac.uns.ftn.informatika.jpa.dto;

import javax.persistence.Column;

import rs.ac.uns.ftn.informatika.jpa.model.LoyalityProgram;

public class LoyalityProgramDTO {
	private long id;
	private int clientPointStep;
	private int ownerPointStep;
	private int bronzeLine;
	private int silverLine;
	private int goldLine;
	
	
	
	public LoyalityProgramDTO(long id, int clientPointStep, int ownerPointStep, int bronzeLine, int silverLine,
			int goldLine) {
		super();
		this.id = id;
		this.clientPointStep = clientPointStep;
		this.ownerPointStep = ownerPointStep;
		this.bronzeLine = bronzeLine;
		this.silverLine = silverLine;
		this.goldLine = goldLine;
	}
	
	public LoyalityProgramDTO(LoyalityProgram lp) {
		this(lp.getId(), lp.getClientPointStep(), lp.getOwnerPointStep(), lp.getBronzeLine(), lp.getSilverLine(), lp.getGoldLine());
	}
	
	public LoyalityProgramDTO() {}
	
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
