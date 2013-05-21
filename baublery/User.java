package baublery;

import java.util.Date;

public class User {
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	private Date timeOfBirth = null;
	private Address address = null;
	
	protected String getFirstName() {
		return firstName;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	protected String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	protected String getEMail() {
		return eMail;
	}
	protected void setEMail(String mail) {
		eMail = mail;
	}
	protected Date getTimeOfBirth() {
		return timeOfBirth;
	}
	protected void setTimeOfBirth(Date timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}
	protected Address getAddress() {
		return address;
	}
	protected void setAddress(Address address) {
		this.address = address;
	}
	
	public User() {}
	public User(String firstName, String lastName, String eMail) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEMail(eMail);
	}
}