package logic;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import storeable.User;
import data.Constants;
import data.DBManager;

public class UserLogic implements IEntityLogic<User> {
	DBManager dbm = DBManager.getInstance();
	Datastore ds = dbm.connectDB(Constants.DB_NAME);
	
	public UserLogic() {
		super();
	}

	@Override
	public Key<User> save(User c) {
		return this.ds.save(c);
	}

	@Override
	public int delete(User object2Delete) {
		return this.ds.delete(object2Delete).getN();  //return number of deleted objects
	}

	@Override
	public User get(ObjectId objId) {
		return this.ds.get(User.class, objId);
	}
	
	@Override
	public List<User> find(String query, String value) {
		return this.ds.find(User.class, query, value).asList();
	}

	@Override
	public User update(User object2Update, User updateObject) {
//		UpdateOperations<User> ops = null;
//		Query<User> updateQuery = null;
//		
//		updateQuery = this.ds.createQuery(User.class).field("_id").equal(object2Update.getId());
//		ops = this.ds.createUpdateOperations(User.class).set(null, updateObject);
//		this.ds.update(updateQuery, ops).getUpdatedCount();
		return null;
	}

	@Override
	public User update(ObjectId objId, User updateObject) {
		return null;
	}
}