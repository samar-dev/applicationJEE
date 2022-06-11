package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/gestuser";
	static final String USER = "root";
	static final String PASS = "";
	static private Connection connection;
	static {
		try {
			// Etape 1: Enregistrement JDBC driver
			Class.forName(JDBC_DRIVER);

			// Etape 2: Etablir une connection
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
