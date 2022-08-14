package rs.ac.uns.ftn.informatika.jpa.model;

import rs.ac.uns.ftn.informatika.jpa.dto.BoatDTO;

import javax.persistence.*;

@Entity(name = "boats")
@Table(name = "boats")
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "user_id", nullable = false)
    public long userId;

    public Boat(){}
    public Boat(BoatDTO boatDTO){
        this.id = boatDTO.id;
        this.userId = boatDTO.userId;
    }
}
