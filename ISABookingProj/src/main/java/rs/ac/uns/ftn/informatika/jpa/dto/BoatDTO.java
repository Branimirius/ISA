package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Boat;

public class BoatDTO {

    public long id;
    public long userId;

    public BoatDTO(){}
    public BoatDTO(Boat boat){
        this.id = boat.id;
        this.userId = boat.userId;
    }
}
