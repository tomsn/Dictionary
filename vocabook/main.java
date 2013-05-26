package vocabook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class main {

	public static void main(String[] args) {
		Mongo mongo = new Mongo("localhost");
		Datastore datastore = new Morphia().createDatastore(mongo, "bandmanager");
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.bandmanager.model");
		datastore = morphia.createDatastore(mongo, "bandmanager");
		datastore.ensureIndexes();
		
		
		try {
			User u = new User();
			u.setFirstName("Stefanie");
			u.setLastName("Roﬂdorfer");
			u.setEMail("stefanie.rossdorfer@gmx.at");
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			Date d = sdf.parse("06.11.1987");
			u.setDateOfBirth(d);
			u.getAddress().setCity("Munich");
			u.getAddress().setCountry("Germany");
			u.getAddress().setStreet("Leopoldstraﬂe");
			u.getAddress().setPostCode("80807");
			u.getAddress().setNumber("251");
			
			userTable.save(u);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}