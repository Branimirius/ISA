package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.service.HouseService;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    //proveriti
    @GetMapping
    public List<House> getAllHouses() {
        return this.houseService.findAll();
    }

    //proveriti
    @GetMapping(value = "/{id}")
    public ResponseEntity<House> getHouseOne(@PathVariable(value = "id") Long id) {
        House house = houseService.findOne(id);
        return ResponseEntity.ok().body(house);
    }

    //proveriti
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeHouse(@PathVariable long id) {
        boolean status = houseService.remove(id);
        if (status)
            return new ResponseEntity<>("House successfully deleted!", HttpStatus.OK);
        else
            return new ResponseEntity<>("House not found!", HttpStatus.NOT_FOUND);
    }

}
