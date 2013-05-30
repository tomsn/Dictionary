package vocabook;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Key;

import storeable.User;

public class Main {

	public static void main(String[] args) {
		//System.setErr(new PrintStream(new ByteArrayOutputStream()));
		try {
//			User u = new User();
//			u.setFirstName("Martina");
//			u.setLastName("Mustermann");
//			u.setEMail("m.mustermann@test.com");
//			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//			Date d = sdf.parse("07.10.1978");
//			u.setDateOfBirth(d);
//			u.getAddress().setCity("Entenhausen");
//			u.getAddress().setCountry("Duckland");
//			u.getAddress().setStreet("Moneystreet");
//			u.getAddress().setPostCode("10101");
//			u.getAddress().setNumber("1");
//			Key<User> uk = User.save2DB(u);
//			System.out.println(uk.toString());
			
			
			User u = User.findFirst(User.AttributeNames.firstNameAttribute, "Martina");
			System.out.println(u.getEMail());

//			ObjectId id = u.getId();
//			int i = User.delete(id);
//			System.out.println("number: " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//System.setErr(System.err);
		}
	}
}