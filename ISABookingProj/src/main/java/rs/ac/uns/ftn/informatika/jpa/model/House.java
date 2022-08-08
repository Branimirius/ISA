package rs.ac.uns.ftn.informatika.jpa.model;


import javax.persistence.*;

@Entity(name = "houses")
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "description", nullable = false)
    private String description;
    //slike enterijera i eksterijera
    //broj soba, broj kreveta po sobi
    //slobodni termini sa akcijama za brzu rezervaciju
    @Column(name = "rules", nullable = false)
    private String rules;
    //cenovnik i informacije o dodatnim uslugama


    public House(){}
    public House(long id, String name, String address, String description, String rules){
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.rules = rules;
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
