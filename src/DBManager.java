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


public class DBManager {
	private DB db = null;
	
	public DBManager(String dbName) {
		this.db = DBManager.connect(dbName);
		if (this.db == null) {
			//TODO: logger ...
			System.out.println("Couldn't connect to DB! Exiting ...");
			System.exit(1);
		}
	}
	public DBManager(DB db) {
		this.db = db;
	}
	
	protected static DB connect(String dbName) {
		try {
			Mongo mongoDBConnection = new Mongo("localhost", 27017);
			//connect to the database dictionary
			return mongoDBConnection.getDB(dbName);
		} catch (UnknownHostException e) {
	    	e.printStackTrace(); //TODO: add logger
	    	return null;
	    } catch (MongoException e) {
	    	e.printStackTrace();
	    	return null;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	protected String dbInsert(BasicDBObject insertObject, DBCollection coll) {
		try {
			coll.insert(insertObject);
			return ((ObjectId)insertObject.get("_id")).toString();
		}
		catch (Exception e) {
			return "" + Constants.INSERT_FAILED;
		}
	}
	
	/***
	 * Return the ObjectId of a database object
	 * 
	 * @param searchKeys
	 * @param searchColl
	 * @return String: the ObjectId of the searched Document
	 */
	protected String getUniqueObjectID(BSONObject searchKeys, DBCollection searchColl) {
		BasicDBObject query = new BasicDBObject();
		query.putAll(searchKeys);
		
		DBCursor cursor = searchColl.find(query);
		
		if (cursor.size() == 1) {
			DBObject res = cursor.next();
			return ((ObjectId)res.get("_id")).toString();
		}
		else {
			return "" + Constants.INAPPROPRIATE_NUMBER_OF_ARGUMENTS_FOUND;
		}
	}
}