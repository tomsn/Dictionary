package depricated;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.Key;

public interface IEntityLogic<T> {
	
	Key<T> save(T object2Store);

	T get(ObjectId objectId);
	
	List<T> find(String query, Object value);
	
	int delete(T object2Delete);
	
	//UPDATE METHODS
	//##############
	int set(T updateObj, String fieldExpr, Object value);
	
	int add(T updateObj, String fieldExpr, Object value);
	
	//adds <value> to the <fieldExpr> field (must be numeric)
	int addNumber(T updateObj, String fieldExpr, Number value);
	
	//removes the value from an array field
	int removeAll(T updateObj, String fieldExpr, Object value);
}