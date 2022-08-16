package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
	BoardDTO boardDTO =null;
	
	//글 삽입
	public int add(BoardDTO boardDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,0)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDTO.getBoardTitle());
		ps.setString(2, boardDTO.getBoardContent());
		ps.setString(3, boardDTO.getUsername());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	//글 리스트
	public ArrayList<BoardDTO> list()throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="SELECT * FROM BOARD ORDER BY BOARDNUM DESC";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<BoardDTO> al = new ArrayList<BoardDTO>();
		while(rs.next()) {
			boardDTO = new BoardDTO();
			
			boardDTO.setBoardNum(rs.getLong("BOARDNUM"));
			boardDTO.setBoardTitle(rs.getString("BOARDTITLE"));
			boardDTO.setBoardContent(rs.getNString("BOARDCONTENT"));
			boardDTO.setUsername(rs.getString("USERNAME"));
			boardDTO.setReporting_date(rs.getDate("REPORTING_DATE"));
			boardDTO.setHit(rs.getLong("HIT"));
			
			al.add(boardDTO);
		}
		System.out.println("dao실행");
		DBConnector.disConnect(rs, ps, con);
		return al;
	}
	
	//글 상세내용
	public BoardDTO detail(BoardDTO boardDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, boardDTO.getBoardNum());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			boardDTO = new BoardDTO();
			
			boardDTO.setBoardNum(rs.getLong("BOARDNUM"));
			boardDTO.setBoardTitle(rs.getString("BOARDTITLE"));
			boardDTO.setBoardContent(rs.getString("BOARDCONTENT"));
			boardDTO.setUsername(rs.getString("USERNAME"));
			boardDTO.setReporting_date(rs.getDate("REPORTING_DATE"));
			boardDTO.setHit(rs.getLong("HIT"));
		}
		
		DBConnector.disConnect(rs, ps, con);
		
		return boardDTO;
		
	}
	
	//글 수정
	public int update(BoardDTO boardDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BOARD SET BOARDTITLE = ?,BOARDCONTENT =? WHERE BOARDNUM = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDTO.getBoardTitle());
		ps.setString(2, boardDTO.getBoardContent());
		ps.setLong(3, boardDTO.getBoardNum());
		System.out.println("numDAO="+boardDTO.getBoardNum());
		if(boardDTO.getBoardNum() ==null) {
			System.out.println("null이요");
		}
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	//글삭제
	public int delete(BoardDTO boardDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql ="DELETE BOARD WHERE BOARDNUM=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, boardDTO.getBoardNum());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	//조회수 증가
	public int hitUpdate(BoardDTO boardDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE BOARDNUM = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, boardDTO.getBoardNum());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
	}
	

}
