package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.repository.UserRepository;
import rs.ac.uns.ftn.informatika.jpa.security.SecurityUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findOne(Long id) {
		return userRepository.findById(id).orElseGet(null);
	}
	
	public User findOneByLogin(String eMail, String pass) {
		List<User> allUsers = findAll();
		for(User u : allUsers) {
			System.out.println("KONTROLA 2: " + u.geteMail() + " " + u.getPassword());
			if((u.geteMail().equals(eMail) ) && (u.getPassword().equals(pass))) {
				return u;
			}
		}
		return null;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Page<User> findAll(Pageable page) {
		return userRepository.findAll(page);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void remove(Long id) {
		userRepository.deleteById(id);
	}

	public User getCurrentUser(){
		String email = SecurityUtils.getCurrentUserLogin().get();
		return userRepository.findOneByeMail(email).get();
	}
	
}
