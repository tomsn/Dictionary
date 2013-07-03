package storeable;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.Key;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;

import data.DBBaseEntity;
import data.DBLogic;

@Entity("vocabookentry")
public class VocabookEntry extends DBBaseEntity {
	private String language = null;
	private String word = null;
	private String description = null;
	private String pronunciation = null;
	@Indexed
	@Embedded
	private List<Translation> translations = null;
	@Indexed
	private List<ObjectId> affiliation = null;
	
	public VocabookEntry() {
		this.translations = new ArrayList<Translation>();
		this.affiliation = new ArrayList<ObjectId>();
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
	public List<ObjectId> getAffiliation() {
		return this.affiliation;
	}
	public void setAffiliation(List<ObjectId> affiliation) {
		this.affiliation = affiliation;
	}
	
	public static Key<VocabookEntry> save2DB(VocabookEntry u) {
		return DBLogic.<VocabookEntry>save(u);
	}
	public static VocabookEntry getVocabookEntryFromDB(ObjectId objId) {
		return DBLogic.<VocabookEntry>get(VocabookEntry.class, objId);
	}
	public static VocabookEntry find(String fieldExpr, String operator, Object value) {
		return DBLogic.<VocabookEntry>findFirst(VocabookEntry.class, fieldExpr, operator, value);
	}
	public static int delete(VocabookEntry VocabookEntry2Delete) {
		return DBLogic.<VocabookEntry>delete(VocabookEntry2Delete);
	}
	public static int delete(ObjectId VocabookEntryObjId) {
		return DBLogic.<VocabookEntry>delete(VocabookEntry.class, VocabookEntryObjId);
	}
	//methods for update
	public static int set(VocabookEntry updateVocabookEntry, String fieldExpr, Object value) {
		return DBLogic.set(updateVocabookEntry, fieldExpr, value);
	}
	public static int add(VocabookEntry updateVocabookEntry, String fieldExpr, Object value) {
		return DBLogic.add(updateVocabookEntry, fieldExpr, value);
	}
	public static int addNumber(VocabookEntry updateVocabookEntry, String fieldExpr, Number value) {
		return DBLogic.addNumber(updateVocabookEntry, fieldExpr, value);
	}
	public static int removeAll(VocabookEntry updateVocabookEntry, String fieldExpr, Object value) {
		return DBLogic.removeAll(updateVocabookEntry, fieldExpr, value);
	}
}