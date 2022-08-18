package rs.ac.uns.ftn.informatika.jpa.model;


import javax.persistence.*;
import java.util.List;

@Entity(name = "additional_service")
@Table(name = "additional_service")
public class AdditionalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "name", nullable = false)
    public String name;

    @ManyToMany
    @Column(name = "house", nullable = false)
    public List<House> house;

    @ManyToOne
    public Pricelist pricelist;

    public AdditionalService(){}

    public AdditionalService(long id, String name, List<House> house, Pricelist pricelist){
        this.id = id;
        this.name = name;
        this.house = house;
        this.pricelist = pricelist;
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

    public void setId(Long id) {
        this.id = id;
    }
    public List<House> getHouse() {
        return house;
    }

    public void setHouse(List<House> house) {
        this.house = house;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

}
