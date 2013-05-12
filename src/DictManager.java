import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;


public class DictManager {
	private DB db = null;
	
	public DictManager() {
		this.db = DBManager.connect("dictionary");
	}
	
	protected String insertWord(DBCollection coll, String word, String example) {
		BasicDBObject insertObject = new BasicDBObject();
		insertObject.put("word", word);
		insertObject.put("example", example);
		return this.dbInsert(insertObject, coll);
	}
	private String inserWord(DBCollection coll, String word) {
		return this.insertWord(coll, word, "");
	}
	private String insertGermanWord() {
		return "";
	}
}
