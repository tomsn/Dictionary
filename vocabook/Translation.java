package vocabook;

import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Translation {
	private String language = null;
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