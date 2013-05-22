package baublery;
import org.apache.log4j.*;

import org.bson.BSONObject;
import org.bson.types.ObjectId;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;


public class DBManager {
	private Logger dbLogger = null;
	private DB db = null;
	private String dbName = ""; 
	
	public DBManager(String dbName) {
		this.dbLogger = Logger.getLogger(DBManager.class.getName());
		this.dbName = dbName;
		this.db = this.connect(this.dbName);
		if (this.db == null) {
			dbLogger.error("Couldn't connect to DB \"" + this.dbName + "\"! Exiting ...");
			System.exit(1);
		}
	}
	protected DB getDB() {
		return this.db;
	}
	protected DBCollection getDBCollection(String collName) {
		try {
			DBCollection dbc = null;
			dbc = this.db.getCollection(collName);
			if (dbc == null) {
				throw new Exception ("Error while getting collection" 
						+ collName + " from DB " 
						+ this.dbName);
			}
			else {
				return dbc;
			}
		}
		catch (Exception e) {
			dbLogger.error(e.getMessage() + " - " + e.getStackTrace());
			return null;
		}
	}
	protected DB connect(String dbName) {
		try {
			Mongo mongoDBConnection = new Mongo(Constants.HOST, Constants.PORT);
			//connect to the database <dbName>
			return mongoDBConnection.getDB(dbName);
		} 
		catch (Exception e) {
	    	dbLogger.error(e.getMessage() + " - " + e.getStackTrace());
	    	return null;
	    }
	}
	protected String insertDB(BasicDBObject obj2Insert, DBCollection coll) {
		try {
			WriteResult insertRes = coll.insert(obj2Insert);
			if (!insertRes.getLastError().ok()) {
				throw new Exception("Error inserting object with id "
						+ obj2Insert.get("_id") + " from DB "
						+ this.dbName);
			}
			return ((ObjectId)obj2Insert.get("_id")).toString();
		}
		catch (Exception e) {
			dbLogger.error(e.getMessage() + " - " + e.getStackTrace());
			return "" + Constants.INSERT_FAILED;
		}
	}
	protected int deleteDB(BSONObject searchKeys, DBCollection coll) {
		try {
			DBObject obj2Delete = this.getUniqueObject(searchKeys, coll);
			if (obj2Delete != null ) {
				WriteResult delRes = coll.remove(obj2Delete);
				if (!delRes.getLastError().ok()) {
					throw new Exception("Error deleting document with id "
							+ obj2Delete.get("_id") + " from DB "
							+ this.dbName);
				}
				else {
					dbLogger.info("Successfully deleted document " + obj2Delete.get("_id"));
					return 1;	//successful
				}
			}
			else {
				throw new Exception("Error deleting document from DB " + this.dbName);			}
		}
		catch (Exception e) {
			dbLogger.error(e.getMessage() + " - " + e.getStackTrace());
			return Constants.DELETION_FAILED;
		}
	}
	protected int updateDB(BSONObject searchKeys, DBCollection coll, String key, Object value) {
		try {
			DBObject obj2Update = this.getUniqueObject(searchKeys, coll);
			if (obj2Update != null) {
				BasicDBObject updateEntry = new BasicDBObject();
				updateEntry.put(key, value);
				WriteResult updateRes = coll.update(obj2Update, updateEntry);
				if (!updateRes.getLastError().ok()) {
					throw new Exception("Error updating document with id "
							+ obj2Update.get("_id") + " from DB "
							+ this.dbName);
				}
				else {
					dbLogger.info("Successfully updated document with id " + obj2Update.get("_id"));
					return 1;	//success
				}
			}
			else {
				throw new Exception("Error updating document with id from DB " + this.dbName);			}
		}
		catch (Exception e) {
			dbLogger.error(e.getMessage() + " - " + e.getStackTrace());
			return Constants.UPDATE_FAILED;
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
	protected DBObject getUniqueObject(BSONObject searchKeys, DBCollection searchColl) {
		BasicDBObject query = new BasicDBObject();
		query.putAll(searchKeys);
		
		DBCursor cursor = searchColl.find(query);
		
		if (cursor.size() == 1) {
			return cursor.next();
		}
		else {
			dbLogger.info("Found more than one object with the given searchKeys");
			return null;
		}
	}
}