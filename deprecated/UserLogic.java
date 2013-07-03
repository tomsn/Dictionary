package deprecated;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

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
	public User get(ObjectId objId) {
		return this.ds.get(User.class, objId);
	}
	
	@Override
	public List<User> find(String query, Object value) {
		return this.ds.find(User.class, query, value).asList();
	}

	@Override
	public int delete(User object2Delete) {
		return this.ds.delete(User.class, object2Delete).getN();  //return number of deleted objects
	}

	@Override
	public int set(User updateObj, String fieldExpr, Object value) {
		UpdateOperations<User> ops = null;
		Query<User> updateQuery = null;
		
		updateQuery = this.ds.createQuery(User.class).field("_id").equal(updateObj.getId());
		ops = this.ds.createUpdateOperations(User.class).set(fieldExpr, value);
		return this.ds.update(updateQuery, ops).getUpdatedCount();
	}

	@Override
	public int add(User updateObj, String fieldExpr, Object value) {
		UpdateOperations<User> ops = null;
		Query<User> updateQuery = null;
		
		updateQuery = this.ds.createQuery(User.class).field("_id").equal(updateObj.getId());
		ops = this.ds.createUpdateOperations(User.class).add(fieldExpr, value);
		return this.ds.update(updateQuery, ops).getUpdatedCount();
	}

	@Override
	public int addNumber(User updateObj, String fieldExpr, Number value) {
		UpdateOperations<User> ops = null;
		Query<User> updateQuery = null;
		
		updateQuery = this.ds.createQuery(User.class).field("_id").equal(updateObj.getId());
		ops = this.ds.createUpdateOperations(User.class).inc(fieldExpr, value);
		return this.ds.update(updateQuery, ops).getUpdatedCount();
	}

	@Override
	public int removeAll(User updateObj, String fieldExpr, Object value) {
		UpdateOperations<User> ops = null;
		Query<User> updateQuery = null;
		
		updateQuery = this.ds.createQuery(User.class).field("_id").equal(updateObj.getId());
		ops = this.ds.createUpdateOperations(User.class).removeAll(fieldExpr, value);
		return this.ds.update(updateQuery, ops).getUpdatedCount();
	}
}