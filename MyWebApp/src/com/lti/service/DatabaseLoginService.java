package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Before we run the DB version, we need to ensure that we have the Driver jar file ready
 * After locating the same (derbyclient.jar OR ojbc6/7/8.jar)
 * Copy the same in the Project's WebContent/WEB-INF/lib folder
 * Then only run the application
 */
public class DatabaseLoginService {

	public boolean authenticate(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/trainingdb", "mj", "mj");
			//can you tell me what should the select query look like?
			String sql = "SELECT COUNT(user_id) FROM tbl_users WHERE user_name = ? AND user_pass = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1)
					return true;
			}
			return false;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //we should rather throw an user defined exception
			return false;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
