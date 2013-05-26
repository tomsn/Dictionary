package vocabook;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;

@Entity("vocabookentry")
public class VocabookEntry extends DBStoreable {
	private String language = null;
	private String word = null;
	private String description = null;
	private String pronunciation = null;
	@Embedded
	private List<Translation> translations = null;
	@Embedded
	private List<User> affiliation = null;
	
	public VocabookEntry() {
		this.translations = new ArrayList<Translation>();
		this.affiliation = new ArrayList<User>();
	}
	public VocabookEntry(String word) {
		this();
		this.setWord(word);
	}
	
	protected String getLanguage() {
		return this.language;
	}
	protected void setLanguage(String language) {
		this.language = language;
	}
	protected String getWord() {
		return this.word;
	}
	protected void setWord(String word) {
		this.word = word;
	}
	protected String getDescription() {
		return this.description;
	}
	protected void setDescription(String description) {
		this.description = description;
	}
	protected String getPronunciation() {
		return this.pronunciation;
	}
	protected void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}
	protected List<Translation> getTranslations() {
		return this.translations;
	}
	protected void setTranslations(ArrayList<Translation> translations) {
		this.translations = translations;
	}
	public List<User> getAffiliation() {
		return this.affiliation;
	}
	public void setAffiliation(List<User> affiliation) {
		this.affiliation = affiliation;
	}
}