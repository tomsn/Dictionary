package main;
import java.net.UnknownHostException;
import org.apache.log4j.*;

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
	private Logger dbLogger = null;
	private DB db = null;
	
	public DBManager(String dbName) {
		this.dbLogger = Logger.getLogger(DBManager.class.getName());
		this.db = this.connect(dbName);
		if (this.db == null) {
			dbLogger.error("Couldn't connect to DB \"" + dbName + "\"! Exiting ...");
			System.exit(1);
		}
	}
	protected DB getDB() {
		return this.db;
	}
	protected DBCollection getDBCollection(String collName) {
		DBCollection dbc = null;
		dbc = this.db.getCollection(collName);
		if (dbc == null) {
			dbLogger.error("Error while trying to communicate with collection" + collName);
			return null;
		}
		else {
			return dbc;
		}
	}
	protected DB connect(String dbName) {
		try {
			Mongo mongoDBConnection = new Mongo(Constants.HOST, Constants.PORT);
			//connect to the database dictionary
			return mongoDBConnection.getDB(dbName);
		} catch (UnknownHostException e) {
	    	dbLogger.error(e.getStackTrace());
	    	return null;
	    } catch (MongoException e) {
	    	dbLogger.error(e.getStackTrace());
	    	return null;
	    } catch (Exception e) {
	    	dbLogger.error(e.getStackTrace());
	    	return null;
	    }
	}
	protected String insertDB(BasicDBObject insertObject, DBCollection coll) {
		try {
			coll.insert(insertObject);
			return ((ObjectId)insertObject.get("_id")).toString();
		}
		catch (Exception e) {
			dbLogger.error(e.getStackTrace());
			return "" + Constants.INSERT_FAILED;
		}
	}
	
	/***
	 * Return the ObjectId of a document; the searchKeys attribute must result
	 * in an unique document, otherwise an error code will be returned
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
			dbLogger.info("Found more than one object with the given searchKeys");
			return "" + Constants.INAPPROPRIATE_NUMBER_OF_ARGUMENTS_FOUND;
		}
	}
}