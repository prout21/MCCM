package Demo.DBquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.testng.Assert.assertEquals;

import java.sql.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DBValidationOutbound {

	@Test
	
	public void VerifyDBValidationOutboundSuccessfull() throws InterruptedException {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			System.out.println("Driver loaded");			  
			//step2 create  the connection object  
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:10000:MCCMSYSN","MCCMCUSLINT","MCCMCUSLINT");  
			System.out.println("Connected to DB");	
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			//step4 execute query  
			ResultSet result=stmt.executeQuery("select * from MCCM_EXTRACT_HISTORY");
			if (result.next()) {
				while (result.next()) {
					// Fetch value of "FILE_NAME" from "result"
				 	String status = result.getString("FILE_NAME");
					// print them on the console
				 	
				  // print them on the console
					 
				 	System.out.println("FILE_NAME Value is :" + status);
				 	
					// Fetch value of "EXTRACT_DATE" from "result"
				 	String status1 = result.getString("EXTRACT_DATE");
					// print them on the console
			 
				 	System.out.println("EXTRACT_DATE Value is :" + status1);
				 	
				 	
				 // Fetch value of "EXTRACT_DATE" from "result"
				 	String status2 = result.getString("EXT_FLAG");
					// print them on the console

				 	System.out.println("EXT_FLAG Value is :" + status2);
				 	
					//step5 test case validation   

			
				 
				 assertEquals(status1,"04-AUG-20");
				 
				 assertEquals(status2,"Y");
				 
				 assertEquals(status,"DPF_MMC_NBA_ONB");
				 
				 
				}
				result.close();
			}

		}catch(Exception e){ System.out.println(e);
		} 

	 

	}

	
}


