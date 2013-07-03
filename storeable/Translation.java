package storeable;

import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Reference;

@Embedded
public class Translation {
	private String language = null;
	@Reference("vocabookentry")
	private ObjectId reference = null;
	
	public Translation() {}
	public Translation(String lang, ObjectId ref) {
		this.setLanguage(lang);
		this.setReference(ref);
	}
	
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
}