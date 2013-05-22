package vocabook;

import java.util.Date;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;

@Entity("user")
public class User extends DBStoreable {
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	private Date timeOfBirth = null;
	@Embedded
	private Address address = null;
	
	public User() {
		this.address = new Address();
	}
	public User(String firstName, String lastName, String eMail) {
		this();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEMail(eMail);
	}
	
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
}