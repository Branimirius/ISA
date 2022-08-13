package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.House;

public class HouseDTO {

    public long id;
    public long userId;
    public String name;
    public String address;
    public String description;
    public String rules;

    public HouseDTO(){}

    public HouseDTO(long id, long userId, String name, String address, String description, String rules) {
        super();
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.rules = rules;
    }

    public HouseDTO(House house){
       this.id = house.id;
       this.userId = house.userId;
       this.name = house.name;
       this.address = house.address;
       this.description = house.description;
       this.rules = house.rules;
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
}
