package baublery;

public class Constants {
	//DB CONNECTION PARAMETER
	public static final String HOST = "localhost";
	public static final int PORT = 27017;
	
	//RETURNVALUES
	public static final int INAPPROPRIATE_NUMBER_OF_ARGUMENTS_FOUND = -1;
	public static final int INSERT_FAILED = -2;
	public static final int DELETION_FAILED = -3;
	public static final int UPDATE_FAILED = -4;
	
	//NAMES
	public static final String DB_NAME = "dictionary";
	public static final String GER_TABLE_NAME = "german";
	public static final String ENG_TABLE_NAME = "english";
	public static final String ENG_GER_TRANSLATION_TABLE_NAME = "eng_ger_translation";
}