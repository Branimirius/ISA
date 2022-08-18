package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.AdditionalService;
import rs.ac.uns.ftn.informatika.jpa.model.House;
import rs.ac.uns.ftn.informatika.jpa.model.Pricelist;

import java.util.List;

public class HouseDTO {

    public long id;
    public long userId;
    public String name;
    public String address;
    public String description;
    public String room;
    public int beds;
    public String rules;
    public List<AdditionalService> additionalService;


    public HouseDTO(){}

    public HouseDTO(long id, long userId, String name, String address, String description, String room, int beds, String rules, List<AdditionalService> additionalService) {
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


    public HouseDTO(House house){
       this.id = house.id;
       this.userId = house.userId;
       this.name = house.name;
       this.address = house.address;
       this.description = house.description;
       this.room = house.room;
       this.beds = house.beds;
       this.rules = house.rules;
       this.additionalService = house.additionalService;
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
