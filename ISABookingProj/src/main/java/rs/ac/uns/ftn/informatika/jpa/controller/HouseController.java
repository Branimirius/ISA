package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.jpa.dto.FishingClassDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.HouseDTO;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.service.HouseService;
import java.util.List;
import java.util.Objects;


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

        HouseDTO house = houseService.save(houseDTO);

        return new ResponseEntity<>(house, HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateHouse(@RequestBody HouseDTO houseDTO) {
        boolean status = houseService.updateHouse(houseDTO);
        if(status)
            return new ResponseEntity<>("House successfully updated!", HttpStatus.OK);
        else
            return new ResponseEntity<>("There was an error while updating!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeHouse(@PathVariable long id) {
        boolean status = houseService.remove(id);
        if (status)
            return new ResponseEntity<>("House successfully deleted!", HttpStatus.OK);
        else
            return new ResponseEntity<>("House not found!", HttpStatus.NOT_FOUND);
    }

}
