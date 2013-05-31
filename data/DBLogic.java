package data;

import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

public abstract class DBLogic<T extends DBBaseEntity> {
	private static DBManager dbm = DBManager.getInstance();
	private static Datastore ds = dbm.connectDB(Constants.DB_NAME);
	
	public DBLogic() {
	}

	public static <E extends DBBaseEntity> Key<E> save(E object2Save) {
		return ds.save(object2Save);
	}

	public static <E extends DBBaseEntity> E get(Class<E> c, ObjectId objId) {
		return c.cast(ds.get(c, objId));
	}
	//possible operators:  ["=", "==","!=", "<>", ">", "<", ">=", "<=", "in", "nin", "all", "size", "exists"]
	public static <E extends DBBaseEntity> E findFirst(Class<E> c, String fieldExpr, String operator, Object value) {
		return ds.find(c, fieldExpr + operator, value).get();
	}

	public static <E extends DBBaseEntity> int delete(E object2Delete) {
		return ds.delete(object2Delete.getClass(), object2Delete).getN();  //return number of deleted objects
	}
	public static <E extends DBBaseEntity> int delete(Class<E> c, ObjectId objId) {
		return ds.delete(get(c, objId)).getN();  //return number of deleted objects
	}

	public static <E extends DBBaseEntity> int set(E updateObj, String fieldExpr, Object value) {
		UpdateOperations<E> ops = null;
		Query<E> updateQuery = null;
		
		updateQuery = (Query<E>) ds.createQuery(updateObj.getClass()).field("_id").equal(updateObj.getId());
		ops = (UpdateOperations<E>) ds.createUpdateOperations(updateObj.getClass()).set(fieldExpr, value);
		return ds.update(updateQuery, ops).getUpdatedCount();
	}

	public static <E extends DBBaseEntity> int add(E updateObj, String fieldExpr, Object value) {
		UpdateOperations<E> ops = null;
		Query<E> updateQuery = null;
		
		updateQuery = (Query<E>) ds.createQuery(updateObj.getClass()).field("_id").equal(updateObj.getId());
		ops = (UpdateOperations<E>) ds.createUpdateOperations(updateObj.getClass()).add(fieldExpr, value);
		return ds.update(updateQuery, ops).getUpdatedCount();
	}

	public static <E extends DBBaseEntity> int addNumber(E updateObj, String fieldExpr, Number value) {
		UpdateOperations<E> ops = null;
		Query<E> updateQuery = null;
		
		updateQuery = (Query<E>) ds.createQuery(updateObj.getClass()).field("_id").equal(updateObj.getId());
		ops = (UpdateOperations<E>) ds.createUpdateOperations(updateObj.getClass()).inc(fieldExpr, value);
		return ds.update(updateQuery, ops).getUpdatedCount();
	}

	public static <E extends DBBaseEntity> int removeAll(E updateObj, String fieldExpr, Object value) {
		UpdateOperations<E> ops = null;
		Query<E> updateQuery = null;
		
		updateQuery = (Query<E>) ds.createQuery(updateObj.getClass()).field("_id").equal(updateObj.getId());
		ops = (UpdateOperations<E>) ds.createUpdateOperations(updateObj.getClass()).removeAll(fieldExpr, value);
		return ds.update(updateQuery, ops).getUpdatedCount();
	}
}