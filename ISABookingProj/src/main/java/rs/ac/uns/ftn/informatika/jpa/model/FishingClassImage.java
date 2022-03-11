package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "fishing_class_images")
@Table(name = "fishing_class_images")
public class FishingClassImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Lob
	@Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	private FishingClass fishingClass;

	public FishingClassImage(long id, byte[] image, FishingClass fishingClass) {
		super();
		this.id = id;
		this.image = image;
		this.fishingClass = fishingClass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public FishingClass getFishingClass() {
		return fishingClass;
	}

	public void setFishingClass(FishingClass fishingClass) {
		this.fishingClass = fishingClass;
	}
	
	
}
