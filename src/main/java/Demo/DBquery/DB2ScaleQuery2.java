package Demo.DBquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.testng.Assert.assertEquals;

import java.sql.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DB2ScaleQuery2 {

	@Test

	public void Verify2ScaleDBupdatedNEWSuccessfully() throws InterruptedException {
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
			ResultSet result=stmt.executeQuery("SELECT  * FROM twoscalepushnotification");
			if (result.next()) {
				while (result.next()) {
					// Fetch value of "STATUS" from "result"
					String status = result.getString("STATUS");
					// print them on the console

					System.out.println("STATUS Value is :" + status);
					//step5 test case validation   

					assertEquals(status,"New");
				}
				result.close();
			}

		}catch(Exception e){ System.out.println(e);
		} 
		
		// Waiting for updated the database to change the status value in DB 
		 
 	 for(int i=0;i<50;i++){
 		 
 		 Thread.sleep(6000);
 	}
 	 
 	 
	}
	public void Verify2ScaleDBupdatedSTQSuccessfully() throws InterruptedException {
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
			ResultSet result=stmt.executeQuery("SELECT  * FROM twoscalepushnotification");
			if (result.next()) {
				while (result.next()) {
					// Fetch value of "STATUS" from "result"
					String status = result.getString("STATUS");
					// print them on the console

					System.out.println("STATUS Value is :" + status);
					//step5 test case validation   

					assertEquals(status,"STQ");
				}
				result.close();
			}

		}catch(Exception e){ System.out.println(e);
		} 
		
		// Waiting for updated the database to change the status value in DB 
		 
 	 for(int i=0;i<50;i++){
 		 
 		 Thread.sleep(6000);
 	}
 	 
 	 
	}
	public void Verify2ScaleDBupdatedSUCSuccessfully() throws InterruptedException {
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
			ResultSet result=stmt.executeQuery("SELECT  * FROM twoscalepushnotification");
			if (result.next()) {
				while (result.next()) {
					// Fetch value of "STATUS" from "result"
					String status = result.getString("STATUS");
					// print them on the console

					System.out.println("STATUS Value is :" + status);
					//step5 test case validation   

					assertEquals(status,"SUC");
				}
				result.close();
			}

		}catch(Exception e){ System.out.println(e);
		} 
		
		// Waiting for updated the database to change the status value in DB 
		 
 	 for(int i=0;i<50;i++){
 		 
 		 Thread.sleep(6000);
 	}
 	 
 	 
	}
}
 

