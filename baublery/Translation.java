package baublery;

import org.bson.types.ObjectId;


public class Translation {
	private String language = null;
	private ObjectId reference = null;
	
	protected String getLanguage() {
		return this.language;
	}
	protected void setLanguage(String language) {
		this.language = language;
	}
	protected ObjectId getReference() {
		return this.reference;
	}
	protected void setReference(ObjectId reference) {
		this.reference = reference;
	}
	
	public Translation() {}
	public Translation(String lang, ObjectId ref) {
		this.setLanguage(lang);
		this.setReference(ref);
	}
}
