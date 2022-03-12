package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.FishingClassReservation;
import rs.ac.uns.ftn.informatika.jpa.repository.FishingClassReservationRepository;

@Service
public class FishingClassReservationService {
	
	@Autowired
	private FishingClassReservationRepository fishingClassReservationRepository;
	
	public FishingClassReservation findOne(Long id) {
		return fishingClassReservationRepository.findById(id).orElseGet(null);
	}

	public List<FishingClassReservation> findAll() {
		return fishingClassReservationRepository.findAll();
	}
	
	public Page<FishingClassReservation> findAll(Pageable page) {
		return fishingClassReservationRepository.findAll(page);
	}

	public FishingClassReservation save(FishingClassReservation fishingClassReservation) {
		return fishingClassReservationRepository.save(fishingClassReservation);
	}

	public void remove(Long id) {
		fishingClassReservationRepository.deleteById(id);
	}
	
	
}
