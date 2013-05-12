import java.net.UnknownHostException;

import org.bson.BSONObject;
import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoDBFind {

	public static void main(String[] args) {

		try {
			DB dictDB = DBManager.connect("dictionary");	//equivalent to "use dictionary"
			if (dictDB == null) {
				System.out.println("Couldn't connect to DB! Exiting ...");
				System.exit(1);
			}
			DBManager dbl = new DBManager(dictDB);
			DBCollection gerTable = dictDB.getCollection("german");
			DBCollection engTable = dictDB.getCollection("english");
			DBCollection eng_de_translation = dictDB.getCollection("eng_ger_translation");
			
			BasicDBObject tmp = new BasicDBObject();
			tmp.put("word", "table");
			System.out.println("Result: " + dbl.getObjectID(tmp, engTable));
			
	    } catch (MongoException e) {
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}