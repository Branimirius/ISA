package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.FishingClassImageDTO;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClassImage;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassImageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api")
public class FishingClassImageController {
	@Autowired
	private FishingClassImageService fishingClassImageService;
	
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
	

}

