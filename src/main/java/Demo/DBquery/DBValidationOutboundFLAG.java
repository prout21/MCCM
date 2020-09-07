package Demo.DBquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.testng.Assert.assertEquals;

import java.sql.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DBValidationOutboundFLAG {

	@Test
	

	public void VerifyDBValidationOutboundSuccessfully() throws InterruptedException {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			System.out.println("Driver loaded");			  
			//step2 create  the connection object  
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:10000:MCCMSYSN","MCCMEXTMKTINT","MCCMEXTMKTINT");  
			System.out.println("Connected to DB");	
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			//step4 execute query  
			ResultSet result=stmt.executeQuery("select * from MCCM_NBACAMPAIGN_FLAGS");
			if (result.next()) {
				while (result.next()) {
					// Fetch value of "STATUS" from "result"
					String status = result.getString("DATA_EXP_CMPLTD_KIASEPOS");
					
				 
					// print them on the console

					System.out.println("DATA_EXP_CMPLTD_KIASEPOS Value is :" + status);
					//step5 test case validation   

					assertEquals(status,"Y");
					
					String status1 = result.getString("DATA_EXP_CMPLTD_DMP");
					// print them on the console

					System.out.println("DATA_EXP_CMPLTD_DMP Value is :" + status);
					//step5 test case validation   

					assertEquals(status,"Y");
					
					String status2 = result.getString("DATA_EXP_CMPLTD_OS");
					// print them on the console

					System.out.println("DATA_EXP_CMPLTD_OS Value is :" + status);
					//step5 test case validation   

					assertEquals(status,"Y");
					
				}
				result.close();
			}

		}catch(Exception e){ System.out.println(e);
		} 

		// Waiting for updated the database to change the status value in DB 

//		for(int i=0;i<50;i++){
//
//			Thread.sleep(6000);
//		}


	}
	 
	
}


