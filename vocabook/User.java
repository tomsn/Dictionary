package vocabook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;

@Entity("user")
public class User extends DBStoreable {
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	private String password = null;		//TODO: make secure
	private Date dateOfBirth = null;
	@Embedded
	private Address address = null;
	private Date createdAt = null;
	private List<VocabookEntry> vocabularies = null;
	
	
	public User() {
		this.address = new Address();
		this.setCreatedAt(new Date());
		this.setVocabularies(new ArrayList<VocabookEntry>());
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
		return this.eMail;
	}
	protected void setEMail(String mail) {
		//TODO: check if email-address is valid (not at this position in the code)
		eMail = mail;
	}
	protected Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	protected void setDateOfBirth(Date timeOfBirth) {
		this.dateOfBirth = timeOfBirth;
	}
	protected Address getAddress() {
		return this.address;
	}
	protected void setAddress(Address address) {
		this.address = address;
	}
	protected void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	protected Date getCreatedAt() {
		return this.createdAt;
	}
	protected void setVocabularies(List<VocabookEntry> vocabularies) {
		this.vocabularies = vocabularies;
	}
	protected List<VocabookEntry> getVocabularies() {
		return this.vocabularies;
	}
}