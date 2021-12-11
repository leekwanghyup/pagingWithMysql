package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DBConnection;


public class InsertData {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로딩 
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp_study",
					"root",
					"1234"
			); 
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("insert into board(subject, content, writer) values(?,?,?)");
			for(int i=1; i<=420 ; i++) {
				pstmt.setString(1, "제목00000000000" + i);
				pstmt.setString(2, "내용00000000000" + i);
				pstmt.setString(3, "작성자"+i);
				pstmt.addBatch();	
			}
			pstmt.executeBatch();
			conn.commit(); 
			System.out.println("Easy");
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			pstmt.close();
			conn.close(); 
		}
		
	}
}
