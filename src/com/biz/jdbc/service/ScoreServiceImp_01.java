package com.biz.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.model.StudentVO;

public class ScoreServiceImp_01 implements ScoreService {

	@Override
	public List<ScoreVO> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findBySeq(long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreVO> findByNum(String stNum) {
		
		String sql = " SELECT * FROM tbl_score ";
			sql += " WHERE sc_st_no = " + stNum;
			
			try {
			PreparedStatement ps = null;  
			ps = DBConnection.dbConn.prepareStatement(sql);
				
			ResultSet rs = ps.executeQuery();
			
			List<ScoreVO> scList = new ArrayList<ScoreVO>();
			
			while(rs.next()){
			ScoreVO vo = new ScoreVO(	
					rs.getLong("SC_SEQ"),
					rs.getString("SC_DATE"),
					rs.getString("SC_ST_NO"),
					rs.getString("SC_SUBJECT"),
					rs.getInt("SC_SCORE")
					);
					scList.add(vo);
				
				}
			return scList;
						
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		String sql = " INSERT INTO tbl_score ( ";
		sql += " SC_SEQ, ";
		sql += " SC_DATE, ";
		sql += " SC_ST_NO, ";
		sql += " SC_SUBJECT, ";
		sql += " SC_SCORE ) ";
		sql += " VALUES ( ?,?,?,?,? )";
		
		PreparedStatement ps = null;

		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			ps.setLong(1, vo.getSc_seq());
			ps.setString(2, vo.getSc_date());
			ps.setString(3, vo.getSc_st_no());
			ps.setString(4, vo.getSc_subject());
			ps.setInt(5, vo.getSc_score());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
