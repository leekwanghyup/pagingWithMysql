package common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	
	public static Connection dbConn() {
		Connection conn = null;
		DataSource ds = null;
		try {
			Context ctx = new InitialContext(); 
			ds = (DataSource) ctx.lookup("java:comp/env/mysqlDB");
			conn = ds.getConnection(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; 
	}
}
