package data;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.*;
import com.mongodb.Mongo;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;

public class DBManager {
	private static DBManager dbManager = null;
	private Logger dbLogger = null;
	private Mongo mongo = null;
	private Morphia morphia = null;
	//TODO: add user and pwd to database connection (read from encrypted file?)
	//private String user = null;
	//private String pwd = null;
	
	private DBManager() {
		this.dbLogger = Logger.getLogger(DBManager.class.getName());
		this.mongo = this.connect();
		this.morphia = new Morphia();
		if (this.mongo == null) {
			dbLogger.error("Couldn't connect to MongoDb...");
		}
	}
	
	public static DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}
	private Mongo connect() {
		try {
			return new Mongo(Constants.HOST, Constants.PORT);
		} 
		catch (Exception e) {
	    	dbLogger.error(e.getMessage() + " - " + e.getStackTrace());
	    	return null;
	    }
	}
	public Morphia setMapping(ArrayList<Class<? extends DBBaseEntity>> classes) {
		Morphia m = new Morphia();
		for (Iterator<Class<? extends DBBaseEntity>> c = classes.iterator(); c.hasNext();) {
			m.map(c.next());
		}
		return m;
	}
	public Datastore connectDB(String dbName) {
		Datastore ds = this.morphia.createDatastore(this.mongo, dbName);
		ds.ensureIndexes();
		return ds;
	}
}