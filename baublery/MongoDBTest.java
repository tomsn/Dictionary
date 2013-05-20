package baublery;
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
			
			
			
	    } catch (UnknownHostException e) {
	    	e.printStackTrace();
	    } catch (MongoException e) {
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}