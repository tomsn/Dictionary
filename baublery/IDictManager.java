package baublery;

import com.mongodb.DBCollection;

public interface IDictManager {
	public String insertWord(DBCollection coll, String word, String example);
}
