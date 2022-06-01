package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "mail")
@Table(name = "mail")
public class Mail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String destination;
	private String object;
	private String message;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getObjet() {
		return object;
	}
	public void setObjet(String objet) {
		this.object = objet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Mail(long id, String destination, String object, String message) {
		super();
		this.id = id;
		this.destination = destination;
		this.object = object;
		this.message = message;
	}
	
	public Mail() {}
	
}
