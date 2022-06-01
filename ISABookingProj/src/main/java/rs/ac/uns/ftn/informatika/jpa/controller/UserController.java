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

import rs.ac.uns.ftn.informatika.jpa.dto.InstructorAvailabilityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.LoyalityProgramDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.UserLoginDTO;
import rs.ac.uns.ftn.informatika.jpa.model.InstructorAvailability;
import rs.ac.uns.ftn.informatika.jpa.model.LoyalityProgram;
import rs.ac.uns.ftn.informatika.jpa.model.Mail;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.InstructorAvailabilityService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;
import rs.ac.uns.ftn.informatika.jpa.service.LoyalityProgramService;
import rs.ac.uns.ftn.informatika.jpa.service.SendMailService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private InstructorAvailabilityService availabilityService;
	@Autowired
	private LoyalityProgramService loyalityProgramService;
	@Autowired
	private SendMailService sendMailService;
	
	//get users
	@GetMapping(value = "/users")
	public List<User> getAllUsers(){
		return this.userService.findAll();
	}
	
	//get user by id
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> getUserOne(@PathVariable(value = "id") Long userId) {
		User user = userService.findOne(userId);
		return ResponseEntity.ok().body(user);
	}
	
	//get loyality 
		@GetMapping(value = "/loyality")
		public ResponseEntity<LoyalityProgram> getLoyalityOne() {
			LoyalityProgram loyality = loyalityProgramService.findOne((long) 1);
			return ResponseEntity.ok().body(loyality);
		}
	
	//save user
	
	@PostMapping(value = "/users", consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

		User user = new User();
		user.setAdress(userDTO.getAdress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.seteMail(userDTO.geteMail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhoneNumber());
		user.setRegType(userDTO.getRegType());
		user.setActive(userDTO.isActive());
		user.setDeleteRequested(userDTO.isDeleteRequested());
		user = userService.save(user);
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
	
	//update user
	@PutMapping(value = "/users", consumes = "application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
		System.out.println("UPDATE: " + userDTO.getId() + " " + userDTO.getFirstName());
		User user = userService.findOne(userDTO.getId());
		user.setAdress(userDTO.getAdress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.seteMail(userDTO.geteMail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhoneNumber());
		user.setRegType(userDTO.getRegType());
		user.setActive(userDTO.isActive());
		user.setDeleteRequested(userDTO.isDeleteRequested());
		user = userService.save(user);
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
	
	//delete user
	@DeleteMapping(value = "/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long userId) {	
		this.userService.remove(userId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	@PostMapping(value = "/authenticate", consumes = "application/json")
	public ResponseEntity<User> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
		System.out.println("KONTROLA 1: " + userLoginDTO.geteMail() + " " + userLoginDTO.getPass());
		User user = userService.findOneByLogin(userLoginDTO.geteMail(), userLoginDTO.getPass());
		if((userService.findOneByLogin(userLoginDTO.geteMail(), userLoginDTO.getPass()) != null) && (user.isActive() || user.getRegType().equals("ADMIN"))) {
			System.out.println("KONTROLA 3: " + user.geteMail() + " " + user.getPassword());
			return ResponseEntity.ok().body(user);
		}
		else {
			System.out.println("KONTROLA3: NULLLLL, Active: " + user.isActive() + "  Admin: " + user.getRegType());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		//return ResponseEntity.ok().body(user);
	}
	@PostMapping(value = "/availabilities", consumes = "application/json")
	public ResponseEntity<InstructorAvailabilityDTO> saveInstructorAvailability(@RequestBody InstructorAvailabilityDTO availabilityDTO) {

		InstructorAvailability availability = new InstructorAvailability();
		availability.setStart(availabilityDTO.getStart());
		availability.setEndTime(availabilityDTO.getEndTime());
		availability.setUserId(availabilityDTO.getUserId());
		
		availability = availabilityService.save(availability);
		return new ResponseEntity<>(new InstructorAvailabilityDTO(availability), HttpStatus.CREATED);
	}
	//update user
	@PutMapping(value = "/loyality", consumes = "application/json")
	public ResponseEntity<LoyalityProgramDTO> updateLoyality(@RequestBody LoyalityProgramDTO loyalityProgramDTO) {
		System.out.println("UPDATE: " + loyalityProgramDTO.getId() + " " );
		LoyalityProgram loyalityProgram = loyalityProgramService.findOne((long)1);
		loyalityProgram.setClientPointStep(loyalityProgramDTO.getClientPointStep());
		loyalityProgram.setOwnerPointStep(loyalityProgramDTO.getOwnerPointStep());
		loyalityProgram.setBronzeLine(loyalityProgramDTO.getBronzeLine());
		loyalityProgram.setSilverLine(loyalityProgramDTO.getSilverLine());
		loyalityProgram.setGoldLine(loyalityProgramDTO.getGoldLine());
		
		loyalityProgram = loyalityProgramService.save(loyalityProgram);
		return new ResponseEntity<>(new LoyalityProgramDTO(loyalityProgram), HttpStatus.CREATED);
	}
	@PostMapping(value = "/mail", consumes = "application/json")
	public ResponseEntity<Mail> sendMail(@RequestBody Mail mail) {

		sendMailService.sendMail(mail);
		return new ResponseEntity<>(mail, HttpStatus.CREATED);
	}
	

}
