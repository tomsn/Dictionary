package logic;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.Key;

public interface IEntityLogic<T> {
	
	public Key<T> save(T object2Store);
	
	public T get(ObjectId objId);
	
	public List<T> find(String query, String value);
	
	public int delete(T object2Delete);
	
	public T update(T object2Update, T updateObject);
	
	public T update(ObjectId objId, T updateObject);
	
	
	//returns a document and deletes it
	//public T findAndDelete(ObjectId objId);
}
