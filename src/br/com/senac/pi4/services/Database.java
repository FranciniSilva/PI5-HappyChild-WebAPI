package br.com.senac.pi4.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static Database instance = null;
	
	private Database () {};
	
	public static Database get () {
		if (instance == null)
			instance = new Database();
		return instance;
	}
	
	public Connection conn () throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://192.168.1.32\\SQLEXPRESS;user=sa;password=@admin;database=happy_child";
//		String connectionUrl = "jdbc:sqlserver://josiasveras.database.windows.net;user=jorzias.sveras@josiasveras;password=My0wn4zur3;database=PI4";
		Connection conn = DriverManager.getConnection(connectionUrl);

		return conn;
	}
	
//	public Connection conn () throws Exception {
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String connectionUrl = "jdbc:sqlserver://192.168.157.10:1433;database=facenac;user=sa;password=@dmin123";
//		 Connection conn = DriverManager.getConnection(connectionUrl);
////		Connection conn = DriverManager.getConnection("jdbc:sqlserver://facenac.database.windows.net;database=facenac;user=tsi;password=SistemasInternet123");
//		return conn;
//	}
	
	
	
}
