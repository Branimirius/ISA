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
import rs.ac.uns.ftn.informatika.jpa.dto.FishingReviewDTO;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClass;
import rs.ac.uns.ftn.informatika.jpa.model.FishingClassReservation;
import rs.ac.uns.ftn.informatika.jpa.model.FishingReview;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.FishingClassReservationService;
import rs.ac.uns.ftn.informatika.jpa.service.FishingReviewService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/fishingReservations")
public class FishingClassReservationController {
	@Autowired
	private FishingClassReservationService fishingClassReservationService;
	@Autowired
	private FishingReviewService fishingReviewService;
	
	//get fishingClassReservations
	@GetMapping(value = "/fishingClassReservations")
	public List<FishingClassReservation> getAllFishingClassReservations(){
		for(FishingClassReservation fcr : this.fishingClassReservationService.findAll()) {
			System.out.println("RESERVATIONS: " + fcr.getUserId());
		}
		return this.fishingClassReservationService.findAll();
	}
	
	//get fishingClassReservation by id
	@GetMapping(value = "/fishingClassReservations/{id}")
	public ResponseEntity<FishingClassReservation> getFishingClassReservationOne(@PathVariable(value = "id") Long fishingClassReservationId) {
		FishingClassReservation fishingClassReservation = fishingClassReservationService.findOne(fishingClassReservationId);
		return ResponseEntity.ok().body(fishingClassReservation);
	}
	
	//save fishingClassReservation
	
	@PostMapping(value = "/fishingClassReservations", consumes = "application/json")
	public ResponseEntity<FishingClassReservationDTO> saveFishingClassReservation(@RequestBody FishingClassReservationDTO fishingClassReservationDTO) {
		System.out.println("DODAVANJE REZERVACIJE: " + fishingClassReservationDTO.getExtraOffers());
		FishingClassReservation fishingClassReservation = new FishingClassReservation();
		fishingClassReservation.setId(fishingClassReservationDTO.getId());
		fishingClassReservation.setUserId(fishingClassReservationDTO.getUserId());
		fishingClassReservation.setLocation(fishingClassReservationDTO.getLocation());
		fishingClassReservation.setDuration(fishingClassReservationDTO.getDuration());
		fishingClassReservation.setStart(fishingClassReservationDTO.getStart());
		fishingClassReservation.setMaxCap(fishingClassReservationDTO.getMaxCap());
		fishingClassReservation.setEnd(fishingClassReservationDTO.getEnd());
		fishingClassReservation.setPrice(fishingClassReservationDTO.getPrice());
		fishingClassReservation.setFishingClass(new FishingClass(fishingClassReservationDTO.getFishingClass()));
		
		fishingClassReservation = fishingClassReservationService.save(fishingClassReservation);
		return new ResponseEntity<>(new FishingClassReservationDTO(fishingClassReservation), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/fishingClassReviews", consumes = "application/json")
	public ResponseEntity<FishingReviewDTO> saveFishingClassReview(@RequestBody FishingReviewDTO fishingReviewDTO) {
		System.out.println("DODAVANJE IZVESTAJA: " + fishingReviewDTO.getComment());
		FishingReview fishingReview = new FishingReview();
		fishingReview.setId(fishingReviewDTO.getId());
		fishingReview.setClient(new User(fishingReviewDTO.getClient()));
		fishingReview.setInstructor(new User(fishingReviewDTO.getInstructor()));
		fishingReview.setComment(fishingReviewDTO.getComment());
		fishingReview.setReport(fishingReviewDTO.isReport());
		fishingReview.setShowUp(fishingReviewDTO.isShowUp());
		
		fishingReview = fishingReviewService.save(fishingReview);
		return new ResponseEntity<>(new FishingReviewDTO(fishingReview), HttpStatus.CREATED);
	}
	
	//update fishingClassReservation
	/*
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

