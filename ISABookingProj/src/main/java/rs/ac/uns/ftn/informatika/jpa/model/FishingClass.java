package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "fishing_class")
@Table(name = "fishing_class")
public class FishingClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "adress", nullable = false)
	private String adress;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "instructor_bio", nullable = true)
	private String instructorBio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fishingClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FishingClassImage> images = new HashSet<FishingClassImage>();
	
	@Column(name = "max_cap", nullable = true)
	private Integer maxCap;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fishingClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FishingClassReservation> reservations = new HashSet<FishingClassReservation>();
	
	@Column(name = "rules", nullable = true)
	private String rules;
	
	@Column(name = "equipment", nullable = true)
	private String equipment;
	
	@Column(name = "menu", nullable = true)
	private String menu;
	
	@Column(name = "cancel_conditions", nullable = true)
	private String cancelConditions;

	public FishingClass(long id, long userId, String adress, String description, String instructorBio, Set<FishingClassImage> images,
			Integer maxCap, Set<FishingClassReservation> reservations, String rules, String equipment, String menu,
			String cancelConditions) {
		super();
		this.id = id;
		this.userId = userId;
		this.adress = adress;
		this.description = description;
		this.instructorBio = instructorBio;
		this.images = images;
		this.maxCap = maxCap;
		this.reservations = reservations;
		this.rules = rules;
		this.equipment = equipment;
		this.menu = menu;
		this.cancelConditions = cancelConditions;
	}
	
	public FishingClass() {}

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

	public Set<FishingClassImage> getImages() {
		return images;
	}

	public void setImages(Set<FishingClassImage> images) {
		this.images = images;
	}

	public Integer getMaxCap() {
		return maxCap;
	}

	public void setMaxCap(Integer maxCap) {
		this.maxCap = maxCap;
	}

	public Set<FishingClassReservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<FishingClassReservation> reservations) {
		this.reservations = reservations;
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
