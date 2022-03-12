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

import rs.ac.uns.ftn.informatika.jpa.dto.FishingClassReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClassReservation;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassReservationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api")
public class FishingClassReservationController {
	@Autowired
	private FishingClassReservationService fishingClassReservationService;
	
	//get fishingClassReservations
	@GetMapping(value = "/fishingClassReservations")
	public List<FishingClassReservation> getAllFishingClassReservations(){
		return this.fishingClassReservationService.findAll();
	}
	
	//get fishingClassReservation by id
	@GetMapping(value = "/fishingClassReservations/{id}")
	public ResponseEntity<FishingClassReservation> getFishingClassReservationOne(@PathVariable(value = "id") Long fishingClassReservationId) {
		FishingClassReservation fishingClassReservation = fishingClassReservationService.findOne(fishingClassReservationId);
		return ResponseEntity.ok().body(fishingClassReservation);
	}
	
	//save fishingClassReservation
	/*
	@PostMapping(value = "/fishingClassReservations", consumes = "application/json")
	public ResponseEntity<FishingClassReservationDTO> saveFishingClassReservation(@RequestBody FishingClassReservationDTO fishingClassReservationDTO) {

		FishingClassReservation fishingClassReservation = new FishingClassReservation();
		fishingClassReservation.setId(fishingClassReservationDTO.getId());
		fishingClassReservation.setUserId(fishingClassReservationDTO.getUserId());
		fishingClassReservation.setAdress(fishingClassReservationDTO.getAdress());
		fishingClassReservation.setDescription(fishingClassReservationDTO.getDescription());
		fishingClassReservation.setInstructorBio(fishingClassReservationDTO.getInstructorBio());
		fishingClassReservation.setMaxCap(fishingClassReservationDTO.getMaxCap());
		fishingClassReservation.setRules(fishingClassReservationDTO.getRules());
		fishingClassReservation.setEquipment(fishingClassReservationDTO.getEquipment());
		fishingClassReservation.setMenu(fishingClassReservationDTO.getMenu());
		fishingClassReservation.setCancelConditions(fishingClassReservationDTO.getCancelConditions());
		fishingClassReservation = fishingClassReservationService.save(fishingClassReservation);
		return new ResponseEntity<>(new FishingClassReservationDTO(fishingClassReservation), HttpStatus.CREATED);
	}
	
	//update fishingClassReservation
	
	@PutMapping(value = "/fishingClassReservations", consumes = "application/json")
	public ResponseEntity<FishingClassReservationDTO> updateFishingClassReservation(@RequestBody FishingClassReservationDTO fishingClassReservationDTO) {
		FishingClassReservation fishingClassReservation = fishingClassReservationService.findOne(fishingClassReservationDTO.getId());
		fishingClassReservation.setId(fishingClassReservationDTO.getId());
		fishingClassReservation.setUserId(fishingClassReservationDTO.getUserId());
		fishingClassReservation.setAdress(fishingClassReservationDTO.getAdress());
		fishingClassReservation.setDescription(fishingClassReservationDTO.getDescription());
		fishingClassReservation.setInstructorBio(fishingClassReservationDTO.getInstructorBio());
		fishingClassReservation.setMaxCap(fishingClassReservationDTO.getMaxCap());
		fishingClassReservation.setRules(fishingClassReservationDTO.getRules());
		fishingClassReservation.setEquipment(fishingClassReservationDTO.getEquipment());
		fishingClassReservation.setMenu(fishingClassReservationDTO.getMenu());
		fishingClassReservation.setCancelConditions(fishingClassReservationDTO.getCancelConditions());

		fishingClassReservation = fishingClassReservationService.save(fishingClassReservation);
		return new ResponseEntity<>(new FishingClassReservationDTO(fishingClassReservation), HttpStatus.CREATED);
	}
	
	//delete fishingClassReservation
	@DeleteMapping(value = "/fishingClassReservations/{id}")
	public Map<String, Boolean> deleteFishingClassReservation(@PathVariable(value = "id") long fishingClassReservationId) {	
		this.fishingClassReservationService.remove(fishingClassReservationId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	*/
	

}

