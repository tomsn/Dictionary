package vocabook;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address {
	private String street = null;
	private String number = null;
	private String postCode = null;
	private String city = null;
	private String country = null;
	
	protected String getStreet() {
		return this.street;
	}
	protected void setStreet(String street) {
		this.street = street;
	}
	protected String getNumber() {
		return this.number;
	}
	protected void setNumber(String number) {
		this.number = number;
	}
	protected String getPostCode() {
		return this.postCode;
	}
	protected void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	protected String getCity() {
		return this.city;
	}
	protected void setCity(String city) {
		this.city = city;
	}
	protected String getCountry() {
		return this.country;
	}
	protected void setCountry(String country) {
		this.country = country;
	}
}