package baublery;

import java.util.List;

public class VocabookEntry {
	
	private String word = null;
	private String description = null;
	private String pronunciation = null;
	private List<Translation> translations = null;
	
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
	protected void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}
	
	public VocabookEntry() {}
	public VocabookEntry(String word) {
		this.setWord(word);
	}
}