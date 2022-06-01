package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.LoyalityProgram;
import rs.ac.uns.ftn.informatika.jpa.repository.LoyalityProgramRepository;

@Service
public class LoyalityProgramService {
	@Autowired
	private LoyalityProgramRepository loyalityProgramRepository;
	
	public LoyalityProgram findOne(Long id) {
		return loyalityProgramRepository.findById(id).orElseGet(null);
	}

	public List<LoyalityProgram> findAll() {
		return loyalityProgramRepository.findAll();
	}
	
	public Page<LoyalityProgram> findAll(Pageable page) {
		return loyalityProgramRepository.findAll(page);
	}

	public LoyalityProgram save(LoyalityProgram loyalityProgram) {
		return loyalityProgramRepository.save(loyalityProgram);
	}

	public void remove(Long id) {
		loyalityProgramRepository.deleteById(id);
	}
	
}
