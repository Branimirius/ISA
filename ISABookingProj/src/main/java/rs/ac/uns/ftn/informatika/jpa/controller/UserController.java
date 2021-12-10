package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;


@RestController
@RequestMapping(value = "api")
public class UserController {
	@Autowired
	private UserService userService;
	
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
	
	//save user
	@PostMapping(value = "/users")
	public User createUser(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	//update user
	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
		User user = userService.findOne(userId);
		user.setAdress(userDetails.getAdress());
		user.setCity(userDetails.getCity());
		user.setCountry(userDetails.getCountry());
		user.seteMail(userDetails.geteMail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPassword(userDetails.getPassword());
		user.setPhone(userDetails.getPhone());
		//user = userDetails;
		return ResponseEntity.ok(this.userService.save(user));
	}
	//delete user
	@DeleteMapping(value = "/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long userId) {	
		this.userService.remove(userId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}
