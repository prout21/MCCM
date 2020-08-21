package Demo.DBquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import org.testng.annotations.Test;

import com.mysql.cj.protocol.Resultset;

public class DB2ScaleQuery {
	
	@Test
	
	public void Verify2ScaleDBupdatedSuccessfully() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        System.out.println("Driver loaded");
	        
 	     //   Connection con = DriverManager.getConnection("jdbc:mysql://db.com:3306/core","username","password");  
 	        
 	      Connection con = DriverManager.getConnection("jdbc:mysql://3.120.110.152:10000/MCCMEXTMKTINT","MCCMEXTMKTINT","MCCMEXTMKTINT");
 	       
 	   //   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:10000/MCCMEXTMKTINT","mccm02","unix11");
 	        
 	      
 	      
 	    // 3.120.110.152 for systest  = ip-172.27.2.203 ,  tablespace-TBS_EXTMKT_TAB   , db name -MCCMEXTMKTINT  host name int=-46.190.227.196 , MCCM UPG-SYS EXTMKT
 	       
 	        System.out.println("Connected to DB");
 	       
 	       
             Statement stmt = con.createStatement();
 	    
  	        String sql =  "SELECT Status FROM TwoscalepushAppNotification WHERE Status = NEW";
  //	        Resultset  rs =  stmt.execute(sql);
////	         
//	        con.close();
//	        
//	        System.out.println("Deleting user " + email + " from the Core DB");
	        
	    } catch(Exception e){ System.out.println(e);}
	}

}
