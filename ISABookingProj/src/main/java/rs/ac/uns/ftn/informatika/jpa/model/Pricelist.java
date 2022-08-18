package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.*;

@Entity(name = "pricelist")
@Table(name = "pricelist")
public class Pricelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "price", nullable = false)
    public String price;


    public Pricelist(){}

    public Pricelist(long id, String price){
        this.id = id;
        this.price = price;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
