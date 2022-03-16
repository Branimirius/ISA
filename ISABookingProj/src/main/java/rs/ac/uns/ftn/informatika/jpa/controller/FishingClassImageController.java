package rs.ac.uns.ftn.informatika.jpa.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.uns.ftn.informatika.jpa.dto.FishingClassImageDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ImageUploadDTO;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClass;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClassImage;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassImageService;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/fishingImages")
public class FishingClassImageController {
	@Autowired
	private FishingClassImageService fishingClassImageService;
	@Autowired
	private FishingClassService fishingClassService;
	
	//get fishingClassImages
	@GetMapping(value = "/fishingClassImages")
	public List<FishingClassImage> getAllFishingClassImages(){
		return this.fishingClassImageService.findAll();
	}
	
	//get fishingClassImage by id
	@GetMapping(value = "/fishingClassImages/{id}")
	public ResponseEntity<FishingClassImage> getFishingClassImageOne(@PathVariable(value = "id") Long fishingClassImageId) {
		FishingClassImage fishingClassImage = fishingClassImageService.findOne(fishingClassImageId);
		return ResponseEntity.ok().body(fishingClassImage);
	}
	
	@PostMapping("/upload")
	public BodyBuilder uploadImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("fishingId") long id) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("FISHING ID KONTROLA: " + id + " PLS RADI: " + fishingClassService.findOne(id).getAdress());
		//FishingClassImage img = new FishingClassImage(file.getOriginalFilename(), file.getContentType(),
		//		compressBytes(file.getBytes()));
//		FishingClassImage fishingClassImage = fishingClassImageService.findOne(id-1);
//		fishingClassImage.setImage(compressBytes(file.getBytes()));
//		fishingClassImage.setFishingClass(fishingClassService.findOne(id));
//		fishingClassImageService.save(fishingClassImage);
		
		FishingClassImage img = new FishingClassImage();
		img.setImage(compressBytes(file.getBytes()));
		img.setFishingClass(fishingClassService.findOne(id));
		fishingClassImageService.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	@GetMapping(path = { "/get/{fishingId}" })
	public FishingClassImage getImages(@PathVariable("fishingId") long id) throws IOException {
		List<FishingClassImage> ret = new ArrayList<FishingClassImage>();
		int i = 0;
		for(FishingClassImage fci : fishingClassImageService.findByClassId(id)) {
			if(i > 0) {
				FishingClassImage img = new FishingClassImage(fci.getId(), decompressBytes(fci.getImage()), fci.getFishingClass());
				ret.add(img);
			}
			i++;
			
		}
		
		return ret.get(0);
	}
	
	//save fishingClassImage
	/*
	@PostMapping(value = "/fishingClassImages", consumes = "application/json")
	public ResponseEntity<FishingClassImageDTO> saveFishingClassImage(@RequestBody FishingClassImageDTO fishingClassImageDTO) {

		FishingClassImage fishingClassImage = new FishingClassImage();
		fishingClassImage.setId(fishingClassImageDTO.getId());
		fishingClassImage.setUserId(fishingClassImageDTO.getUserId());
		fishingClassImage.setAdress(fishingClassImageDTO.getAdress());
		fishingClassImage.setDescription(fishingClassImageDTO.getDescription());
		fishingClassImage.setInstructorBio(fishingClassImageDTO.getInstructorBio());
		fishingClassImage.setMaxCap(fishingClassImageDTO.getMaxCap());
		fishingClassImage.setRules(fishingClassImageDTO.getRules());
		fishingClassImage.setEquipment(fishingClassImageDTO.getEquipment());
		fishingClassImage.setMenu(fishingClassImageDTO.getMenu());
		fishingClassImage.setCancelConditions(fishingClassImageDTO.getCancelConditions());
		fishingClassImage = fishingClassImageService.save(fishingClassImage);
		return new ResponseEntity<>(new FishingClassImageDTO(fishingClassImage), HttpStatus.CREATED);
	}
	
	//update fishingClassImage
	
	@PutMapping(value = "/fishingClassImages", consumes = "application/json")
	public ResponseEntity<FishingClassImageDTO> updateFishingClassImage(@RequestBody FishingClassImageDTO fishingClassImageDTO) {
		FishingClassImage fishingClassImage = fishingClassImageService.findOne(fishingClassImageDTO.getId());
		fishingClassImage.setId(fishingClassImageDTO.getId());
		fishingClassImage.setUserId(fishingClassImageDTO.getUserId());
		fishingClassImage.setAdress(fishingClassImageDTO.getAdress());
		fishingClassImage.setDescription(fishingClassImageDTO.getDescription());
		fishingClassImage.setInstructorBio(fishingClassImageDTO.getInstructorBio());
		fishingClassImage.setMaxCap(fishingClassImageDTO.getMaxCap());
		fishingClassImage.setRules(fishingClassImageDTO.getRules());
		fishingClassImage.setEquipment(fishingClassImageDTO.getEquipment());
		fishingClassImage.setMenu(fishingClassImageDTO.getMenu());
		fishingClassImage.setCancelConditions(fishingClassImageDTO.getCancelConditions());

		fishingClassImage = fishingClassImageService.save(fishingClassImage);
		return new ResponseEntity<>(new FishingClassImageDTO(fishingClassImage), HttpStatus.CREATED);
	}
	
	//delete fishingClassImage
	@DeleteMapping(value = "/fishingClassImages/{id}")
	public Map<String, Boolean> deleteFishingClassImage(@PathVariable(value = "id") long fishingClassImageId) {	
		this.fishingClassImageService.remove(fishingClassImageId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	*/
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	

}

