package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

public class Statdao {
 	
	public static int GetCount (String sql) {
		int res=0;
	 			 ResultSet rs = null;
	 			 try { 		  
					   Connection conn = null;
					   Statement stmt = null;
				       conn = ConnectionDb.getConnection();
   			           stmt = conn.createStatement();
					   rs = stmt.executeQuery(sql);
				    if(rs.next()){
				    	res=Integer.parseInt(rs.getString(0));
					   }
				   
				   } catch (SQLException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
				   }

		
		
		
		
		return res;
	}
	  public static ResultSet getResultSet(String sql){
		   
		   ResultSet rs = null;
		    
		  try { 		  
			     Connection conn = null;
			   Statement stmt = null;
		  
			      conn = ConnectionDb.getConnection();
			      stmt = conn.createStatement();
			 
			      
			    
				  rs = stmt.executeQuery(sql);
		   
		   
		   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   }

		  //Résultat du retour
		  return rs;

		  } 

	
}
