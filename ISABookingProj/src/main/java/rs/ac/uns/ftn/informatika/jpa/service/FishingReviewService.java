package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.FishingReview;
import rs.ac.uns.ftn.informatika.jpa.repository.FishingReviewRepository;

@Service
public class FishingReviewService {
	
	@Autowired
	private FishingReviewRepository fishingReviewRepository;
	
	public FishingReview findOne(Long id) {
		return fishingReviewRepository.findById(id).orElseGet(null);
	}

	public List<FishingReview> findAll() {
		return fishingReviewRepository.findAll();
	}
	
	public Page<FishingReview> findAll(Pageable page) {
		return fishingReviewRepository.findAll(page);
	}

	public FishingReview save(FishingReview fishingReview) {
		return fishingReviewRepository.save(fishingReview);
	}

	public void remove(Long id) {
		fishingReviewRepository.deleteById(id);
	}
	
	
}
