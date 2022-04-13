package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Grade;
import rs.ac.uns.ftn.informatika.jpa.repository.GradeRepository;

@Service
public class GradeService {
	
	@Autowired
	private GradeRepository gradeRepository;
	
	public Grade findOne(Long id) {
		return gradeRepository.findById(id).orElseGet(null);
	}

	public List<Grade> findAll() {
		return gradeRepository.findAll();
	}
	
	public Page<Grade> findAll(Pageable page) {
		return gradeRepository.findAll(page);
	}

	public Grade save(Grade grade) {
		return gradeRepository.save(grade);
	}

	public void remove(Long id) {
		gradeRepository.deleteById(id);
	}
	
	
}
