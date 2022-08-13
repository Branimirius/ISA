package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.dto.HouseDTO;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.repository.HouseRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;


    public House findOne(Long id){
        return houseRepository.findById(id).orElseGet(null);
    }
    public List<HouseDTO> findAll(){
        List<House> houses = houseRepository.findAll();
        List<HouseDTO> houseDTO = new ArrayList<>();
        for(House house: houses){
            houseDTO.add(new HouseDTO(house));
        }
        return houseDTO;
    }
    public HouseDTO save(HouseDTO houseDTO) {

        House house = new House(houseDTO);
        houseRepository.save(house);

        return new HouseDTO(house);
    }

    public boolean remove(Long id) {
        boolean status = houseRepository.existsById(id);
        if(status)
            houseRepository.deleteById(id);
        return status;
    }

    public boolean updateHouse(HouseDTO houseDTO){
        boolean status = houseRepository.existsById(houseDTO.id);
        if(status){
            House house = houseRepository.findById(houseDTO.id).orElse(null);
            assert house != null;
            house.userId = houseDTO.userId;
            house.name = houseDTO.name;
            house.address = houseDTO.address;
            house.description = houseDTO.description;
            house.rules = houseDTO.rules;

            houseRepository.save(house);
        }
        return status;
    }

}
