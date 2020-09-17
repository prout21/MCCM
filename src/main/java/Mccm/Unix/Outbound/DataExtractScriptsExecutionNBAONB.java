package Mccm.Unix.Outbound;

import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class DataExtractScriptsExecutionNBAONB  extends general_ReadProperty {
	
	public static String PROJECT_FOLDER_PATH1;
	public static String TEST_ENV1;
	public static String user;
	public static String pass;
	public static String host;
	public static XSSFWorkbook wb;
	
	/**
	 */
	public static void main(Object args) {
// 		String host="localhost";
// 		String user="mccm02";
// 		String password="unix11";
		
	
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

		String command="ksh /opt/SP/mccm/SYSN/Extract/Data_Extract_wrapper.ksh NBA_ONB";
		try{
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session=jsch.getSession(user, host, 9022);
			session.setPassword(pass);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");
			Channel channel=session.openChannel("exec");
			((ChannelExec)channel).setCommand(command);

			channel.setInputStream(null);
			((ChannelExec)channel).setErrStream(System.err);

			InputStream in=channel.getInputStream();
			channel.connect();
			byte[] tmp=new byte[1024];
			while(true){
				while(in.available()>0){
					int i=in.read(tmp, 0, 1024);
					if(i<0)break;
					System.out.print(new String(tmp, 0, i));
				}
				if(channel.isClosed()){
					System.out.println("exit-status: "+channel.getExitStatus());
					break;
				}
				try{Thread.sleep(3000);}catch(Exception ee){}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("DONE");
		}catch(Exception e){
			e.printStackTrace();
		}	    
	}

}


