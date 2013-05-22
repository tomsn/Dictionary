package baublery;

import org.bson.BSONObject;
import org.bson.types.ObjectId;

import vocabook.Constants;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

public class GerEngDict extends DictManager {
	private DBCollection gerTable = null;
	private DBCollection engTable = null;
	private DBCollection engGerTranslationTable = null;
	
	public GerEngDict() {
		super();
		
		this.gerTable = this.dictDB.getDBCollection(Constants.GER_TABLE_NAME);
		this.engTable = this.dictDB.getDBCollection(Constants.ENG_TABLE_NAME);
		this.eng_ger_translation = this.dictDB.getDBCollection(Constants.ENG_GER_TRANSLATION_TABLE_NAME);
	}
	
	
}
