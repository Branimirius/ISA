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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.GradeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Grade;
import rs.ac.uns.ftn.informatika.jpa.service.GradeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	//get grades
	@GetMapping(value = "/grades")
	public List<Grade> getAllGrades(){
		return this.gradeService.findAll();
	}
	
	//get grade by id
	@GetMapping(value = "/grades/{id}")
	public ResponseEntity<Grade> getGradeOne(@PathVariable(value = "id") Long gradeId) {
		Grade grade = gradeService.findOne(gradeId);
		return ResponseEntity.ok().body(grade);
	}
	//get grade by SubjectId
	@GetMapping(value = "/bySubject/{id}")
	public List<Grade> getGradeBySubject(@PathVariable(value = "id") Long subjectId) {
		return gradeService.findAllBySubject(subjectId);
	}
	
	//save grade
	
	@PostMapping(value = "/grades", consumes = "application/json")
	public ResponseEntity<GradeDTO> saveGrade(@RequestBody GradeDTO gradeDTO) {

		Grade grade = new Grade();
		grade.setUserId(gradeDTO.getUserId());
		grade.setSubjectId(gradeDTO.getSubjectId());
		grade.setGrade(gradeDTO.getGrade());
		grade = gradeService.save(grade);
		return new ResponseEntity<>(new GradeDTO(grade), HttpStatus.CREATED);
	}
	
	//update grade
	/*
	@PutMapping(value = "/grades", consumes = "application/json")
	public ResponseEntity<GradeDTO> updateGrade(@RequestBody GradeDTO gradeDTO) {
		System.out.println("UPDATE: " + gradeDTO.getId() + " " + gradeDTO.getFirstName());
		Grade grade = gradeService.findOne(gradeDTO.getId());
		grade.setAdress(gradeDTO.getAdress());
		grade.setCity(gradeDTO.getCity());
		grade.setCountry(gradeDTO.getCountry());
		grade.seteMail(gradeDTO.geteMail());
		grade.setFirstName(gradeDTO.getFirstName());
		grade.setLastName(gradeDTO.getLastName());
		grade.setPassword(gradeDTO.getPassword());
		grade.setPhone(gradeDTO.getPhoneNumber());
		grade.setRegType(gradeDTO.getRegType());
		grade.setActive(gradeDTO.isActive());
		grade.setDeleteRequested(gradeDTO.isDeleteRequested());
		grade = gradeService.save(grade);
		return new ResponseEntity<>(new GradeDTO(grade), HttpStatus.CREATED);
	}
	*/
	//delete grade
	@DeleteMapping(value = "/grades/{id}")
	public Map<String, Boolean> deleteGrade(@PathVariable(value = "id") long gradeId) {	
		this.gradeService.remove(gradeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	
}
