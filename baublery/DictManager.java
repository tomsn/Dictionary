package baublery;

import org.bson.BSONObject;
import org.bson.types.ObjectId;

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
	
	//how to do this right??
	private int insertWordTupel(String gerWord, String gerExample, 
			String engWord, String engExample) {
		String returnValue = "";
		BasicDBObject gerEntry = new BasicDBObject();
		gerEntry.put("word", gerWord);
		gerEntry.put("example", gerExample);
		returnValue = this.dictDB.insertDB(gerEntry, this.gerTable);
		if (returnValue.equals(Constants.INSERT_FAILED)) {
		return Constants.INSERT_FAILED;
		}
		ObjectId gerEntryOId = (ObjectId)gerEntry.get( "_id" );
		
		returnValue = "";
		BasicDBObject engEntry = new BasicDBObject();
		engEntry.put("word", "table");
		engEntry.put("example", "");
		returnValue = this.dictDB.insertDB(engEntry, this.engTable);
		if (returnValue.equals(Constants.INSERT_FAILED)) {
		BSONObject delObj = new BasicDBObject();
		delObj.put("_id", gerEntryOId);
		this.dictDB.deleteDB(delObj, this.gerTable);
		return Constants.INSERT_FAILED;
		}
		ObjectId engEntryOId = (ObjectId)engEntry.get("_id");
		
		returnValue = "";
		BasicDBObject engGerTranslEntry = new BasicDBObject();
		engGerTranslEntry.put("gerID", gerEntryOId);
		engGerTranslEntry.put("engID", engEntryOId);
		returnValue = this.dictDB.insertDB(engGerTranslEntry, this.engGerTranslationTable);
	}
}
