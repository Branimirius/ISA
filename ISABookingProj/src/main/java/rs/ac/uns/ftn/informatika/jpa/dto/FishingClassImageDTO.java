package rs.ac.uns.ftn.informatika.jpa.dto;

public class FishingClassImageDTO {
	private long id;
	private byte[] image;
	private FishingClassDTO fishingClass;
	
	public FishingClassImageDTO(long id, byte[] image, FishingClassDTO fishingClass) {
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
	public FishingClassDTO getFishingClass() {
		return fishingClass;
	}
	public void setFishingClass(FishingClassDTO fishingClass) {
		this.fishingClass = fishingClass;
	}
	
}
