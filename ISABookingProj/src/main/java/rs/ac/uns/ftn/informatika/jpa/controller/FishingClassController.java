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

import rs.ac.uns.ftn.informatika.jpa.dto.FishingClassDTO;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClass;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClassReservation;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassReservationService;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/fishing")
public class FishingClassController {
	@Autowired
	private FishingClassService fishingClassService;
	@Autowired
	private FishingClassReservationService fishingClassReservationService;
	
	//get fishingClasss
	@GetMapping(value = "/classes")
	public List<FishingClass> getAllFishingClasses(){
		System.out.println("KONTROLA 500: ");
		return this.fishingClassService.findAll();
	}
	
	//get fishingClass by id
	@GetMapping(value = "/classes/{id}")
	public ResponseEntity<FishingClass> getFishingClassOne(@PathVariable(value = "id") Long fishingClassId) {
		FishingClass fishingClass = fishingClassService.findOne(fishingClassId);
		return ResponseEntity.ok().body(fishingClass);
	}
	//get fishingClass by instructor
	@GetMapping(value = "/classInstructor/{id}")
	public ResponseEntity<FishingClass> getFishingClassByInstructor(@PathVariable(value = "id") Long fishingClassId) {
		FishingClass fishingClass = fishingClassService.findByInstructor(fishingClassId);
		return ResponseEntity.ok().body(fishingClass);
	}
	
	//save fishingClass
	
	@PostMapping(value = "/classes", consumes = "application/json")
	public ResponseEntity<FishingClassDTO> saveFishingClass(@RequestBody FishingClassDTO fishingClassDTO) {

		FishingClass fishingClass = new FishingClass();
		fishingClass.setId(fishingClassDTO.getId());
		fishingClass.setUserId(fishingClassDTO.getUserId());
		fishingClass.setAdress(fishingClassDTO.getAdress());
		fishingClass.setDescription(fishingClassDTO.getDescription());
		fishingClass.setInstructorBio(fishingClassDTO.getInstructorBio());
		fishingClass.setMaxCap(fishingClassDTO.getMaxCap());
		fishingClass.setRules(fishingClassDTO.getRules());
		fishingClass.setEquipment(fishingClassDTO.getEquipment());
		fishingClass.setMenu(fishingClassDTO.getMenu());
		fishingClass.setCancelConditions(fishingClassDTO.getCancelConditions());
		fishingClass = fishingClassService.save(fishingClass);
		return new ResponseEntity<>(new FishingClassDTO(fishingClass), HttpStatus.CREATED);
	}
	
	//update fishingClass
	@PutMapping(value = "/classes", consumes = "application/json")
	public ResponseEntity<FishingClassDTO> updateFishingClass(@RequestBody FishingClassDTO fishingClassDTO) {
		FishingClass fishingClass = fishingClassService.findOne(fishingClassDTO.getId());
		fishingClass.setId(fishingClassDTO.getId());
		fishingClass.setUserId(fishingClassDTO.getUserId());
		fishingClass.setAdress(fishingClassDTO.getAdress());
		fishingClass.setDescription(fishingClassDTO.getDescription());
		fishingClass.setInstructorBio(fishingClassDTO.getInstructorBio());
		fishingClass.setMaxCap(fishingClassDTO.getMaxCap());
		fishingClass.setRules(fishingClassDTO.getRules());
		fishingClass.setEquipment(fishingClassDTO.getEquipment());
		fishingClass.setMenu(fishingClassDTO.getMenu());
		fishingClass.setCancelConditions(fishingClassDTO.getCancelConditions());

		fishingClass = fishingClassService.save(fishingClass);
		return new ResponseEntity<>(new FishingClassDTO(fishingClass), HttpStatus.CREATED);
	}
	
	//delete fishingClass
	@DeleteMapping(value = "/classes/{id}")
	public Map<String, Boolean> deleteFishingClass(@PathVariable(value = "id") long fishingClassId) {	
		Map<String, Boolean> response = new HashMap<>();
		for(FishingClassReservation res : this.fishingClassReservationService.findAll()) {
			if((res.getFishingClass().getId() == fishingClassId) && (res.getUserId() != 0)) {
				response.put("deleted", Boolean.FALSE);
				return response;
			}
		}
		this.fishingClassService.remove(fishingClassId);		
		response.put("deleted", Boolean.TRUE);		
		return response;
	}
	
	

}
