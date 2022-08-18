package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.jpa.dto.HouseDTO;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.service.HouseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    public ResponseEntity<List<HouseDTO>> getAllHouses() {
        List<HouseDTO> houses;
        houses = houseService.findAll();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getHouseOne(@PathVariable(value = "id") Long id) {
        House house = houseService.findOne(id);
        if(house != null)
            return new ResponseEntity<>(house, HttpStatus.OK);
        else
            return new ResponseEntity<>("House not found!", HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> saveHouse(@RequestBody HouseDTO houseDTO){

        House house = new House();
        house.setUserId(houseDTO.userId);
        house.setName(houseDTO.name);
        house.setAddress(houseDTO.address);
        house.setDescription(houseDTO.description);
        house.setRoom(houseDTO.room);
        house.setBeds(houseDTO.beds);
        house.setRules(houseDTO.rules);
        house = houseService.save(house);

        return new ResponseEntity<>(new HouseDTO(house), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateHouse(@RequestBody HouseDTO houseDTO) {
        House house = houseService.findOne(houseDTO.id);
        house.setName(houseDTO.name);
        house.setAddress(houseDTO.address);
        house.setDescription(houseDTO.description);
        house.setBeds(houseDTO.beds);
        house.setRules(houseDTO.rules);
        house.setRules(houseDTO.rules);

        return new ResponseEntity<>(new HouseDTO(house), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Boolean> removeHouse(@PathVariable long id) {
        this.houseService.remove(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

}
