package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.dto.BoatDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.HouseDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Boat;
import rs.ac.uns.ftn.informatika.jpa.repository.BoatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Boat findOne(Long id){
        return boatRepository.findById(id).orElseGet(null);
    }
    public List<BoatDTO> findAll(){
        List<Boat> boats = boatRepository.findAll();
        List<BoatDTO> boatDTO = new ArrayList<>();
        for(Boat boat: boats){
            boatDTO.add(new BoatDTO(boat));
        }
        return boatDTO;
    }
    public BoatDTO save(BoatDTO boatDTO) {

        Boat boat = new Boat(boatDTO);
        boatRepository.save(boat);

        return new BoatDTO(boat);
    }

    public boolean remove(Long id) {
        boolean status = boatRepository.existsById(id);
        if(status)
            boatRepository.deleteById(id);
        return status;
    }
    public boolean updateBoat(BoatDTO boatDTO){
        boolean status = boatRepository.existsById(boatDTO.id);
        if(status){
            Boat boat = boatRepository.findById(boatDTO.id).orElse(null);
            assert boat != null;
            boat.userId = boatDTO.userId;


            boatRepository.save(boat);
        }
        return status;
    }
}
