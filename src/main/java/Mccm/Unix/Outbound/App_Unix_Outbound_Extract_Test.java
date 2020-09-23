	package Mccm.Unix.Outbound;
	
	import com.jcraft.jsch.ChannelSftp;
	import com.jcraft.jsch.ChannelSftp.*;
	import com.jcraft.jsch.ChannelSftp.LsEntry;
	
	import Mccm.Unix.Outbound.Upload;
	import Mccm.Unix.Outbound.XLSXReadWrite;
	
	import com.jcraft.jsch.JSch;
	import com.jcraft.jsch.JSchException;
	import com.jcraft.jsch.Session;
	import com.jcraft.jsch.SftpException;
	// import com.sun.tools.javac.util.Assert;
	
	
	import java.awt.AWTException;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;
	import java.util.regex.Pattern;
	
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import java.util.Properties;
	import java.util.Vector;
	import org.testng.annotations.Test;
			
	/**	
	 *
	 */
		
	@Test
	
	public class App_Unix_Outbound_Extract_Test extends general_ReadProperty {
		public static String PROJECT_FOLDER_PATH1;
		public static String TEST_ENV1;
		public static String user;
		public static String pass;
		public static String host;
		public static XSSFWorkbook wb;
	
		public void VerifyExtracDataLoadedSuccessfully() throws InterruptedException, AWTException, SftpException, JSchException {
	
			System.out.println("Connection started");        	
			System.out.println("PROJECT_FOLDER_PATH:");  
			System.out.println("ENV_WIKI:");  
			PROJECT_FOLDER_PATH1=general_ReadProperty("PROJECT_FOLDER_PATH");
			ENV_WIKI=general_ReadProperty("ENV_WIKI");
			String path= (PROJECT_FOLDER_PATH1+ENV_WIKI);
			TEST_ENV1=general_ReadProperty("TEST_ENV");
	
			XLSXReadWrite readFile = new XLSXReadWrite(path);
	
			int rowIndex=readFile.findRowIndex("EnvDetails", TEST_ENV1);
			int userNameColIndex=readFile.findColumnIndex("EnvDetails", "USER_NAME");
			int passwordColIndex=readFile.findColumnIndex("EnvDetails", "PASSWORD");
	
			int hostColIndex=readFile.findColumnIndex("EnvDetails", "UNIX-SERVER");
	
			user= readFile.getCellValue("EnvDetails", rowIndex, userNameColIndex); 
			pass= readFile.getCellValue("EnvDetails", rowIndex, passwordColIndex);
			host=readFile.getCellValue("EnvDetails", rowIndex, hostColIndex);
	
	
			Properties config = new Properties();
			config.put("StrictHostKeyChecking","no");
	 
			JSch jSch = new JSch();
			Session session = jSch.getSession(user,host,9022);
			 
			session.setPassword(pass);
			session.setConfig(config);
			session.connect();
			 			 
	
			//Extract script Load    
			
			Object args = null;
	 
	   		System.out.println("Extract script Load Started"); 
	   		
	   		DataExtractScriptsExecution.main(args); // Extraction script
			 
	
			/**
			 * Checker prevents this from compiling...
			 */
			//        System.out.println("myObject: " + myObject.toString());
			/**
			 * ... which is simply fantastic. It shows:
			 *
			 * error: [dereference.of.nullable] dereference of possibly-null
			 * reference myObject
			 *
			 * http://checkerframework.org
			 */
	
			System.out.println("Extract script Loaded completed");
		}
		
	}
