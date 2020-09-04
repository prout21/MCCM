package Mccm.Unix.Outbound;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class general_ReadProperty {
		
	public static String PROJECT_FOLDER_PATH1;
	public static String TEST_ENV1;
	public static String user;
	public static String pass;
	public static String host;
	public static XSSFWorkbook wb;
	public static String ENV_WIKI;
	
	//DB Details: Will be read from Env Wiki
	public static String userName;
	public static String password;
 
	public static String port;
	public static String SID;
	public static String schema;
 

	
	
	//*******************************************************************************************
	//*Function:	general_ReadProperty														*
	//*Arguments:	Property Key as String													 	*
	//*Return 		Poverty Value as String														*
	//*Descriptions: 																			*
	//*	This function will read the Properties file and return property value to based on key.	*
	//*Author: 														*
	//*******************************************************************************************
	public static String general_ReadProperty(String propertyKey)
	{
		String propertyValue="";
		File cfgfile = new File("configurationFile.properties");

		if(cfgfile.exists())
		{
			Properties propties = new Properties();
			FileInputStream propFile;

			try {
				propFile = new FileInputStream(cfgfile);
				propties.load(propFile);
				propertyValue=propties.getProperty(propertyKey);
			} catch (Exception e1) {

				e1.printStackTrace();
			} 
		}
		return propertyValue;
	
	}
	
	public static String getCellValue(String sheetName, int rowIndex, int cellIndex) {
		XSSFSheet sheet = wb.getSheet(sheetName);
		if (sheet == null) {
			return "sheet doesn't exist for sheet name : " + sheetName;
		}
		XSSFRow row = sheet.getRow(rowIndex);
		if (row == null) {
			return "row doesn't exist for index : " + rowIndex;
		}
		XSSFCell cell = row.getCell(cellIndex);
		if (cell == null) {
			return "";
		}
		return cell.toString().trim();
	}


}
