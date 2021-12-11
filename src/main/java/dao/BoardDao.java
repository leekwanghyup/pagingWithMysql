package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;
import dto.BoardDto;

public class BoardDao {
	
	public static final int PER_PAGE = 10; 
	
	public BoardDao() {}
	
	public List<BoardDto> boardList(String curPage){
		List<BoardDto> list = new ArrayList<>(); 

		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			conn=DBConnection.dbConn();
			
			String sql = "select * from board limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PER_PAGE * (Integer.parseInt(curPage)-1)); // 0
			pstmt.setInt(2, PER_PAGE); // 10 
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setBno(rs.getInt("bno"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs!=null) rs.close();}
			catch (SQLException e) { e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close();}
			catch (SQLException e) { e.printStackTrace();}
			try { if(conn!=null) conn.close();}
			catch (SQLException e) { e.printStackTrace();}
		} 
		return list;
	}

	// 총 게시물 수 반환 
	public int totalCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		int total = 0; 
		try {
			conn = DBConnection.dbConn();
			String sql = "select count(*) as num from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs!=null) rs.close();}
			catch (SQLException e) { e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close();}
			catch (SQLException e) { e.printStackTrace();}
			try { if(conn!=null) conn.close();}
			catch (SQLException e) { e.printStackTrace();}
		}
		return total;
	} 
}
