package rs.ac.uns.ftn.informatika.jpa.model;


import rs.ac.uns.ftn.informatika.jpa.dto.HouseDTO;

import javax.persistence.*;
import java.util.List;

@Entity(name = "houses")
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "user_id", nullable = false)
    public long userId;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "address", nullable = false)
    public String address;

    @Column(name = "description", nullable = false)
    public String description;
    //1) slike enterijera i eksterijera
    //2) slobodni termini sa akcijama za brzu rezervaciju
    @Column(name = "room", nullable = false)
    public String room;
    @Column(name = "beds", nullable = false)
    public int beds;

    @Column(name = "rules", nullable = false)
    public String rules;

    @ManyToMany
    @Column(name = "additional_service", nullable = false)
    public List<AdditionalService> additionalService;

    public House(){}


    public House(long id, long userId, String name, String address, String description,
                 String room, int beds, String rules, List<AdditionalService> additionalService){
        super();
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.room = room;
        this.beds = beds;
        this.rules = rules;
        this.additionalService = additionalService;
    }


    public House(HouseDTO houseDTO){
        this.id = houseDTO.id;
        this.userId = houseDTO.userId;
        this.name = houseDTO.name;
        this.address = houseDTO.address;
        this.description = houseDTO.description;
        this.room = houseDTO.room;
        this.beds = houseDTO.beds;
        this.rules = houseDTO.rules;
        this.additionalService = houseDTO.additionalService;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public List<AdditionalService> getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(List<AdditionalService> additionalService) {
        this.additionalService = additionalService;
    }
}
