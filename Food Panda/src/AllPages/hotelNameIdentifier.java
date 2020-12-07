package AllPages;

import java.sql.ResultSet;

public class hotelNameIdentifier {
	
	public static String hotelName;
	
	void setName(String name) {  //pizzaHut
		
		hotelName = name;
		
	}
		
	void getName(String name) { 
		try {
			 conn c = new conn();
			 
			 String str = hotelName;
			 
			 
			 ResultSet rs =c.s.executeQuery(str);
			 
			 if(rs.next()) {
				 
				  hotelName = rs.getString("HotelName");
				  
			 }
			 
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
