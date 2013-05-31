package storeable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.Key;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;

import data.DBBaseEntity;
import data.DBLogic;

@Entity("user")
public class User extends DBBaseEntity {
	public static final class AttributeNames {
		public static final String firstNameAttribute = "firstName";
	}
	private String firstName = null;
	private String lastName = null;
	private String eMail = null;
	//private String password = null;		//TODO: make secure
	private Date dateOfBirth = null;
	private Date lastLogin = null;
	@Embedded
	private Address address = null;
	private Date createdAt = null;
	@Indexed
	private List<ObjectId> vocabularies = null;
	
	public User() {
		super();
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
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEMail() {
		return this.eMail;
	}
	public void setEMail(String mail) {
		this.eMail = mail;
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
	
	
	
	public static Key<User> save2DB(User u) {
		return DBLogic.<User>save(u);
	}
	public static User getUserFromDB(ObjectId objId) {
		return DBLogic.<User>get(User.class, objId);
	}
	public static User find(String fieldExpr, String operator, Object value) {
		return DBLogic.<User>findFirst(User.class, fieldExpr, operator, value);
	}
	public static int delete(User user2Delete) {
		return DBLogic.<User>delete(user2Delete);
	}
	public static int delete(ObjectId userObjId) {
		return DBLogic.<User>delete(User.class, userObjId);
	}
	//methods for update
	public static int set(User updateUser, String fieldExpr, Object value) {
		return DBLogic.set(updateUser, fieldExpr, value);
	}
	public static int add(User updateUser, String fieldExpr, Object value) {
		return DBLogic.add(updateUser, fieldExpr, value);
	}
	public static int addNumber(User updateUser, String fieldExpr, Number value) {
		return DBLogic.addNumber(updateUser, fieldExpr, value);
	}
	public static int removeAll(User updateUser, String fieldExpr, Object value) {
		return DBLogic.removeAll(updateUser, fieldExpr, value);
	}
}