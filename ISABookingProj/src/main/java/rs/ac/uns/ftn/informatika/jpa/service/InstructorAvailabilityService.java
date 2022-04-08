package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.InstructorAvailability;
import rs.ac.uns.ftn.informatika.jpa.repository.InstructorAvailabilityRepository;

@Service
public class InstructorAvailabilityService {
	
	@Autowired
	private InstructorAvailabilityRepository instructorAvailabilityRepository;
	
	public InstructorAvailability findOne(Long id) {
		return instructorAvailabilityRepository.findById(id).orElseGet(null);
	}

	public List<InstructorAvailability> findAll() {
		return instructorAvailabilityRepository.findAll();
	}
	
	public Page<InstructorAvailability> findAll(Pageable page) {
		return instructorAvailabilityRepository.findAll(page);
	}

	public InstructorAvailability save(InstructorAvailability instructorAvailability) {
		return instructorAvailabilityRepository.save(instructorAvailability);
	}

	public void remove(Long id) {
		instructorAvailabilityRepository.deleteById(id);
	}
	
	
}
