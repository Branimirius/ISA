package rs.ac.uns.ftn.informatika.jpa.dto;

public class UserLoginDTO {
	private String eMail;
	private String pass;
	
	public UserLoginDTO(String eMail, String pass) {
		super();
		this.eMail = eMail;
		this.pass = pass;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
