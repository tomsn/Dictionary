package vocabook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import storeable.User;
import storeable.VocabookEntry;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;

import data.Constants;
import data.DBManager;
import data.DBBaseEntity;

public class Main {

	public static void main(String[] args) {
		DBManager dbm = DBManager.getInstance();
		ArrayList<Class<? extends DBBaseEntity>> al = new ArrayList<Class<? extends DBBaseEntity>>();
		al.add(User.class);
		al.add(VocabookEntry.class);
		
		dbm.setMapping(al);
		Datastore ds = dbm.connectDB(Constants.DB_NAME);
		//ds.ensureIndexes();
		
		try {
			User u = new User();
			u.setFirstName("Martina");
			u.setLastName("Mustermann");
			u.setEMail("m.mustermann@test.com");
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			Date d = sdf.parse("07.10.1978");
			u.setDateOfBirth(d);
			u.getAddress().setCity("Entenhausen");
			u.getAddress().setCountry("Duckland");
			u.getAddress().setStreet("Moneystreet");
			u.getAddress().setPostCode("10101");
			u.getAddress().setNumber("1");
			
			Key<User> uk = ds.save(u);
			System.out.println(uk.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}