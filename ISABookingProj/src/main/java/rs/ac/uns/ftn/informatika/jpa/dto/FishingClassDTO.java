package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.FishingClass;

public class FishingClassDTO {
	private long id;
	private long userId;
	private String adress;
	private String description;
	private String instructorBio;
	private Integer maxCap;
	private String rules;
	private String equipment;
	private String menu;
	private String cancelConditions;
	
	public FishingClassDTO(long id, long userId, String adress, String description, String instructorBio,
			Integer maxCap, String rules, String equipment, String menu, String cancelConditions) {
		super();
		this.id = id;
		this.userId = userId;
		this.adress = adress;
		this.description = description;
		this.instructorBio = instructorBio;
		this.maxCap = maxCap;
		this.rules = rules;
		this.equipment = equipment;
		this.menu = menu;
		this.cancelConditions = cancelConditions;
	}
	public FishingClassDTO(FishingClass fc) {
		this(fc.getId(), fc.getUserId(), fc.getAdress(), fc.getDescription(), fc.getInstructorBio(), fc.getMaxCap(), fc.getRules(), fc.getEquipment(), 
				fc.getMenu(), fc.getCancelConditions());
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstructorBio() {
		return instructorBio;
	}
	public void setInstructorBio(String instructorBio) {
		this.instructorBio = instructorBio;
	}
	public Integer getMaxCap() {
		return maxCap;
	}
	public void setMaxCap(Integer maxCap) {
		this.maxCap = maxCap;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getCancelConditions() {
		return cancelConditions;
	}
	public void setCancelConditions(String cancelConditions) {
		this.cancelConditions = cancelConditions;
	}
	
	
}
