package vocabook;

import org.apache.log4j.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class DBManager {
	private static DBManager dbManager = null;
	private Logger dbLogger = null;
	private DB db = null;
	//TODO: add user and pwd to database connection (read from encrypted file)
	//private String user = null;
	//private String pwd = null;
	
	private DBManager(String dbName) {
		this.dbLogger = Logger.getLogger(DBManager.class.getName());
		this.db = this.connect(dbName);
		if (this.db == null) {
			dbLogger.error("Couldn't connect to DB \"" + dbName + "\"! Exiting ...");
			System.exit(1);
		}
	}
	
	public static DBManager getInstance(String dbName) {
		if (dbManager == null) {
			dbManager = new DBManager(dbName);
		}
		return dbManager;
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
	protected DBCollection getDBCollection(String collName) {
		try {
			DBCollection dbc = null;
			dbc = this.db.getCollection(collName);
			if (dbc == null) {
				throw new Exception ("Error while getting collection" + collName);
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
}