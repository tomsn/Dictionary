package main;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;


public class DictManager implements IDictManager {
	private DBManager dictDB = null;
	
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
	private String insertGermanWord(String word, String example) {
		DBCollection gerTable = this.dictDB.getDBCollection(Constants.GER_TABLE_NAME);
		//prepare DB entry to insert
		BasicDBObject gerEntry = new BasicDBObject();
		gerEntry.put("word", word);
		gerEntry.put("example", example);
		gerTable.insert(gerEntry);
		return ((ObjectId)gerEntry.get( "_id" )).toString();
	}
}
