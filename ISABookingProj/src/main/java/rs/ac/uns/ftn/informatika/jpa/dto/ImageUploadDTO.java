package rs.ac.uns.ftn.informatika.jpa.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadDTO {
	private MultipartFile file;
	private long fishingId;
	
	public ImageUploadDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public ImageUploadDTO(MultipartFile file, long fishingId) {
		super();
		this.file = file;
		this.fishingId = fishingId;
	}



	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public long getFishingId() {
		return fishingId;
	}

	public void setFishingId(long fishingId) {
		this.fishingId = fishingId;
	}
	
	
}
