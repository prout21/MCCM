package Mccm.Unix.Outbound;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyAutomationConstants {

	//Will be read from Properties file
	public static String PROJECT_FOLDER_PATH;
	public static String TEST_ENV;
	public static String ENV_WIKI;
	public static String VF_DO_INPUT;
	public static String VF_DO_ATTACHMENTS;
	public static String VF_DO_REFERENCE_FILES;
	public static String VF_DO_RESULTS;
	public static String CHROME_DRIVER;
	public static String IE_DRIVER;
	public static String GECKO_DRIVER;
	
	//Unix Details: Will be read from Env Wiki
	public static String serverHostName;
	public static String serverUserName;
	public static String serverPassword;
	public static String xmlOMFolder;
	public static String xmlMOMFolder;
	public static String excelMOMFolder;

	//DB Details: Will be read from Env Wiki
	public static String userName;
	public static String password;
	public static String host;
	public static String port;
	public static String SID;
	public static String schema;
	public static XSSFWorkbook wb;


}