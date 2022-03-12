package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.FishingClass;
import rs.ac.uns.ftn.informatika.jpa.repository.FishingClassRepository;

@Service
public class FishingClassService {
	
	@Autowired
	private FishingClassRepository fishingClassRepository;
	
	public FishingClass findOne(Long id) {
		return fishingClassRepository.findById(id).orElseGet(null);
	}
	
	public FishingClass findByInstructor(Long id) {
		List<FishingClass> allClasses = findAll();
		for(FishingClass fc : allClasses) {
			if(fc.getUserId() == id) {
				return fc;
			}
		}
		return null;
	}

	public List<FishingClass> findAll() {
		return fishingClassRepository.findAll();
	}
	
	public Page<FishingClass> findAll(Pageable page) {
		return fishingClassRepository.findAll(page);
	}

	public FishingClass save(FishingClass fishingClass) {
		return fishingClassRepository.save(fishingClass);
	}

	public void remove(Long id) {
		fishingClassRepository.deleteById(id);
	}
	
	
}
