package main;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;


public class MongoDBTest {
	
	
	public static void main(String[] args) {
		try {
			DictManager dm = new DictManager();

			
			//database table "german"
			DBCollection gerTable = dictDB.getCollection("german");
			DBCollection engTable = dictDB.getCollection("english");
			DBCollection eng_de_translation = dictDB.getCollection("eng_ger_translation");
			
			BasicDBObject gerEntry = new BasicDBObject();
			gerEntry.put("word", "Tisch");
			gerEntry.put("example", "");
			gerTable.insert(gerEntry);
			ObjectId gerEntryOID = (ObjectId)gerEntry.get( "_id" );
			
			BasicDBObject engEntry = new BasicDBObject();
			engEntry.put("word", "table");
			engEntry.put("example", "");
			engTable.insert(engEntry);
			ObjectId engEntryOID = (ObjectId)engEntry.get("_id");
			
			BasicDBObject engGerTranslEntry = new BasicDBObject();
			engGerTranslEntry.put("gerID", gerEntryOID);
			engGerTranslEntry.put("engID", engEntryOID);
			eng_de_translation.insert(engGerTranslEntry);
			
			
	    } catch (UnknownHostException e) {
	    	e.printStackTrace();
	    } catch (MongoException e) {
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}