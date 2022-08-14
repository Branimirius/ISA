package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.informatika.jpa.dto.BoatDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.HouseDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Boat;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.service.BoatService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/boats")
public class BoatController {

    @Autowired
    private BoatService boatService;


    @GetMapping
    public ResponseEntity<List<BoatDTO>> getAllBoats() {
        List<BoatDTO> boats;
        boats = boatService.findAll();
        return new ResponseEntity<>(boats, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getBoatOne(@PathVariable(value = "id") Long id) {
        Boat boat = boatService.findOne(id);
        if(boat != null)
            return new ResponseEntity<>(boat, HttpStatus.OK);
        else
            return new ResponseEntity<>("Boat not found!", HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> saveBoat(@RequestBody BoatDTO boatDTO){

        BoatDTO boat = boatService.save(boatDTO);

        return new ResponseEntity<>(boat, HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateBoat(@RequestBody BoatDTO boatDTO) {
        boolean status = boatService.updateBoat(boatDTO);
        if(status)
            return new ResponseEntity<>("Boat successfully updated!", HttpStatus.OK);
        else
            return new ResponseEntity<>("There was an error while updating!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeBoat(@PathVariable long id) {
        boolean status = boatService.remove(id);
        if (status)
            return new ResponseEntity<>("Boat successfully deleted!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Boat not found!", HttpStatus.NOT_FOUND);
    }

}
