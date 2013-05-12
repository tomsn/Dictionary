package src;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;


public class DictManager implements IDictManager {
	protected DBManager dictDB = null;
	
	public DictManager() {
		this.dictDB = new DBManager(Constants.DB_NAME);		//connect to database dictionary
	}
	
	@Override
	public String insertWord(DBCollection coll, String word, String example) {
		BasicDBObject insertObject = new BasicDBObject();
		insertObject.put("word", word);
		insertObject.put("example", example);
		return this.dictDB.insertDB(insertObject, coll);
	}
}
