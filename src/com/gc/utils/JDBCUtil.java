package com.gc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class JDBCUtil {
	
public static int addCreatorJDBC(String email) throws SQLException, ClassNotFoundException {
	int creatorID = 0;
	int keys = 0;
	
	Connection con = getDBConnection();
	PreparedStatement ps = con.prepareStatement("insert into creator(email)" + "values(?)", Statement.RETURN_GENERATED_KEYS);
	ps.setString(1, email);
	System.out.println(ps);
	ps.executeUpdate();
	ResultSet rs = ps.getGeneratedKeys();
	if (rs.next()) {
	  int newId = rs.getInt(1);
	  creatorID = newId;
	}
	con.close();

	return creatorID;
}

public static String getQuestCodeFromTask(int taskID) throws SQLException, ClassNotFoundException {
	String questCode = null;
	
	Connection con = getDBConnection();
	PreparedStatement ps = con.prepareStatement("select questCode from ZabavaDB.Quest where questID = (SELECT questID from ZabavaDB.task where taskID = ?)", Statement.RETURN_GENERATED_KEYS);
	ps.setInt(1, taskID);
	System.out.println(ps);
	ps.executeUpdate();
	ResultSet rs = ps.getGeneratedKeys();
	if (rs.next()) {
	  String newCode = rs.getString(0);
	  questCode = newCode;
	}
	con.close();
	
	
	
	return questCode;
}

private static Connection getDBConnection() throws ClassNotFoundException, SQLException {
	
	MySQLCred jdbc = new MySQLCred();
	String url = "jdbc:mysql://zabavadb.cghpmpef5e7u.us-east-1.rds.amazonaws.com/ZabavaDB";
	String userName = jdbc.CLIENT_ID;
	String password = jdbc.CLIENT_SECRET;

	// Step #2: Load and Register Driver
	Class.forName("com.mysql.jdbc.Driver");

	// Step #3: Create Connection
	Connection con = DriverManager.getConnection(url, userName, password);
	return con;
}

}
