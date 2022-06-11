package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.User;

public class Userdao {
	
	public User verifierLogin(String l,String p) {
		User res=null;
		// Traitement
		 ResultSet rs = null;
		   
		  try { 		  
			  // Etape 0 : verifier l'ajout du Jar MySQL dans la librairie du projet
			   Connection conn = null;
			   Statement stmt = null;
		 
			      
			    // Solutin 2
			      conn = ConnectionDb.getConnection();

			      //Etape 3: Execute a query
			        stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * from t_user Where login like '%"+ l + "%'";
			    //Etape 4: Lancement d'une requête d'ordre Select
				  rs = stmt.executeQuery(sql);
		    if(rs.next()){
			   User e= new User(  //idUser 
						Integer.parseInt(   rs.getString("idUser") )
		 //nom 
		    ,rs.getString("nom") 
		 //  prenom
		  ,rs.getString("prenom") 
		   // login
		  ,rs.getString("login") 
//password
		   ,rs.getString("password") 
);
		 
			   res=e;
		   }
		   
		   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   }

		  //Résultat du retour
 
		
		
		return res;
		
	}
	 public List<User> getAll(){
		   
		   ResultSet rs = null;
		   List<User> Users= new ArrayList<User>();

		  try { 		  
			  // Etape 0 : verifier l'ajout du Jar MySQL dans la librairie du projet
			   Connection conn = null;
			   Statement stmt = null;
		 
				/*
				 * //Etape 1: Enregistrement JDBC driver Class.forName(JDBC_DRIVER);
				 * 
				 * //Etape 2: Open a connection conn =
				 * DriverManager.getConnection(DB_URL,USER,PASS);
				 */
			      //Etape 3: Execute a query
			   // Solutin 2
			      conn = ConnectionDb.getConnection();
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * from t_user ";
			    //Etape 4: Lancement d'une requête d'ordre Select
				  rs = stmt.executeQuery(sql);
		    while(rs.next()){
			   User e= new User(  //idUser 
						Integer.parseInt(   rs.getString("idUser") )
		 //nom 
		    ,rs.getString("nom") 
		 //  prenom
		  ,rs.getString("prenom") 
		   // login
		  ,rs.getString("login") 
//password
		   ,rs.getString("password") 
);
		 
		   Users.add(e);
		   }
		   
		   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   }

		  //Résultat du retour
		  return Users;

		  } 

	 public ResultSet getResultSet(){
		   
		   ResultSet rs = null;
		   List<User> Users= new ArrayList<User>();

		  try { 		  
			  // Etape 0 : verifier l'ajout du Jar MySQL dans la librairie du projet
			   Connection conn = null;
			   Statement stmt = null;
		 
				/*
				 * //Etape 1: Enregistrement JDBC driver Class.forName(JDBC_DRIVER);
				 * 
				 * //Etape 2: Open a connection conn =
				 * DriverManager.getConnection(DB_URL,USER,PASS);
				 */
			      //Etape 3: Execute a query
			   // Solutin 2
			      conn = ConnectionDb.getConnection();
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * from t_user ";
			    //Etape 4: Lancement d'une requête d'ordre Select
				  rs = stmt.executeQuery(sql);
		    
		   
		   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   }

		  //Résultat du retour
		  return  rs;

		  } 
  
	
	 	 public   void addUser (User obj) {
				
				// Requete SQL
				  
				 try {
					 
					 // Etape 0 : verifier l'ajout du Jar MySQL dans la librairie du projet
					   Connection conn = null;
					   Statement stmt = null;
				 
						/*
						 * //Etape 1: Enregistrement JDBC driver Class.forName(JDBC_DRIVER);
						 * 
						 * //Etape 2: Open a connection conn =
						 * DriverManager.getConnection(DB_URL,USER,PASS);
						 */   // Solutin 2
					      conn = ConnectionDb.getConnection();
					      //Etape 3:  Création d'un objet Statement pour envoyer une requête
					      // Solutin 2
					      conn = ConnectionDb.getConnection();
					      stmt = conn.createStatement();
					      String sql;
					      
					      //Etape 4: Formuler votre requête (Insert)					      
					      sql = "Insert into t_user(idUser,nom,prenom,login,password) Values (";
					      sql += " "  +obj.getIduser()+ " ";
					      sql += ",'" + obj.getNom()+ "'";
					      sql +=  ",'"+obj.getPrenom()+ "'";
					      sql +=  ",'"+obj.getLogin()+ "'" ;
					      sql +=  ",'"+obj.getPassword()+ "'" ;
					     
					      sql += ")";
					      
					      System.out.println(sql);
					      //Etape 5: Lancement d'une requête d'ordre Insert
						  
					      stmt.executeUpdate(sql);
					      
					      PreparedStatement ps= null;
					      
					      ps= conn.prepareStatement(sql);
				
					      
					      // SELECT LAST_INSERT_ID();
					      
					      /*SELECT AUTO_INCREMENT
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = "yourDatabaseName"
AND TABLE_NAME = "yourTableName"*/
					      
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 
				
		
	}
			 public   void deleteUser (int pidUser) {
			 
				 
				 try {
					 // Etape 0 : verifier l'ajout du Jar MySQL dans la librairie du projet
					   Connection conn = null;
					   Statement stmt = null;
				 
						/*
						 * //Etape 1: Register JDBC driver Class.forName(JDBC_DRIVER);
						 * 
						 * //Etape 2: Open a connection conn =
						 * DriverManager.getConnection(DB_URL,USER,PASS);
						 */
					      //Etape 3: Création d'un objet Statement pour envoyer une requête
					   // Solutin 2
					      conn = ConnectionDb.getConnection();
					      stmt = conn.createStatement();
					      String sql;
					    //Etape 4: Formuler votre requête (Delete)
					      
					      sql = "Delete from t_user where idUser= "+pidUser ;
					      System.out.println(sql);
					     
					      //Etape 5: Lancement d'une requête d'ordre Delete
						    
					      stmt.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }

}
