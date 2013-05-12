package src;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

public class GerEngDict extends DictManager {
	private DBCollection gerTable = null;
	private DBCollection engTable = null;
	private DBCollection eng_ger_translation = null;
	
	public GerEngDict() {
		super();
		
		this.gerTable = this.dictDB.getDBCollection(Constants.GER_TABLE_NAME);
		this.engTable = this.dictDB.getDBCollection(Constants.ENG_TABLE_NAME);
		this.eng_ger_translation = this.dictDB.getDBCollection(Constants.ENG_GER_TRANSLATION_TABLE_NAME);
	}
	
	private int insertWordTupel(String gerWord, String gerExample, 
								String engWord, String engExample) {
		WriteResult wr = null;
		BasicDBObject gerEntry = new BasicDBObject();
		gerEntry.put("word", gerWord);
		gerEntry.put("example", gerExample);
		wr = this.gerTable.insert(gerEntry);
		ObjectId gerEntryOID = (ObjectId)gerEntry.get( "_id" );
		
		BasicDBObject engEntry = new BasicDBObject();
		engEntry.put("word", "table");
		engEntry.put("example", "");
		engTable.insert(engEntry);
		ObjectId engEntryOID = (ObjectId)engEntry.get("_id");
		
		BasicDBObject engGerTranslEntry = new BasicDBObject();
		engGerTranslEntry.put("gerID", gerEntryOID);
		engGerTranslEntry.put("engID", engEntryOID);
		eng_ger_translation.insert(engGerTranslEntry);
	}
}
