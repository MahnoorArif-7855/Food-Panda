package AllPages;

import java.sql.ResultSet;


public class idIdentifierCustomer {
	
	public static String ID;
	
	
	String getName(String id) {   // pass the sql query when seller logins 
			
		try {
			 conn c = new conn();
			 String str = id;
			 
			 ResultSet rs =c.s.executeQuery(str);
			 
			 if(rs.next()) {
				 
				  ID = rs.getString("eMail");
				  return ID;
			 }
			 
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ID;	 
		
		}
	
	public String get() {
		return ID;
	}
	

}
