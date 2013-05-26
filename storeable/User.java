package storeable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;

import data.DBBaseEntity;

@Entity("user")
public class User extends DBBaseEntity {
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	private String password = null;		//TODO: make secure
	private Date dateOfBirth = null;
	private Date lastLogin = null;
	@Embedded
	private Address address = null;
	private Date createdAt = null;
	@Indexed
	private List<ObjectId> vocabularies = null;
	
	
	public User() {
		this.address = new Address();
		this.setCreatedAt(new Date());
		this.setVocabularies(new ArrayList<ObjectId>());
	}
	public User(String firstName, String lastName, String eMail) {
		this();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEMail(eMail);
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
	public String getEMail() {
		return this.eMail;
	}
	public void setEMail(String mail) {
		//TODO: check if email-address is valid (not at this position in the code)
		eMail = mail;
	}
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	public void setDateOfBirth(Date timeOfBirth) {
		this.dateOfBirth = timeOfBirth;
	}
	public Date getLastLogin() {
		return this.lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setVocabularies(List<ObjectId> vocabularies) {
		this.vocabularies = vocabularies;
	}
	public List<ObjectId> getVocabularies() {
		return this.vocabularies;
	}
}