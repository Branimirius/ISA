package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.repository.HouseRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.UserRepository;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;


    public House findOne(Long id){ return houseRepository.findById(id).orElseGet(null); }
    public List<House> findAll(){ return houseRepository.findAll();}
    public House save(House house) {
        return houseRepository.save(house);
    }

    public boolean remove(Long id) {
        boolean status = houseRepository.existsById(id);
        if(status)
            houseRepository.deleteById(id);
        return status;
    }

}
