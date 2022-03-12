package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.FishingClassImage;
import rs.ac.uns.ftn.informatika.jpa.repository.FishingClassImageRepository;

@Service
public class FishingClassImageService {
	
	@Autowired
	private FishingClassImageRepository fishingClassImageRepository;
	
	public FishingClassImage findOne(Long id) {
		return fishingClassImageRepository.findById(id).orElseGet(null);
	}

	public List<FishingClassImage> findAll() {
		return fishingClassImageRepository.findAll();
	}
	
	public Page<FishingClassImage> findAll(Pageable page) {
		return fishingClassImageRepository.findAll(page);
	}

	public FishingClassImage save(FishingClassImage fishingClassImage) {
		return fishingClassImageRepository.save(fishingClassImage);
	}

	public void remove(Long id) {
		fishingClassImageRepository.deleteById(id);
	}
	
	
}
