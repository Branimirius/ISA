package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.User;

public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private String phoneNumber;
	private String adress;
	private String country;
	private String city;
	private String regType;
	
	public UserDTO(Long id, String firstName, String lastName, String eMail, String password, String phoneNumber, String adress,
			String country, String city, String regType) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.country = country;
		this.city = city;
		this.regType = regType;
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getFirstName(), user.getLastName(), user.geteMail(),user.getPassword(),user.getPhone(),user.getAdress(), user.getCountry(), user.getCity(), user.getRegType());
	}
	
	public UserDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	
	
}
