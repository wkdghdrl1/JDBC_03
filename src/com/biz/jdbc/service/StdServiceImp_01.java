package com.biz.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.StudentVO;

public class StdServiceImp_01 implements StdService {

	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		String  sql = " SELECT * FROM tbl_student ";
		
		PreparedStatement ps= null;
		
		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<StudentVO> stdList = new ArrayList<StudentVO>();

			while(rs.next()) {
				StudentVO vo = new StudentVO(
						rs.getString("st_no"),
						rs.getString("st_name"),
						rs.getString("st_addr"),
						rs.getInt("st_grade"),
						rs.getInt("st_height"),
						rs.getInt("st_weight"),
						rs.getString("st_nick"),
						rs.getString("st_nick_rem"),
						rs.getString("st_dept")
						);
					stdList.add(vo);
			}
			return stdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public StudentVO findByNum(String stNo) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_student ";
			sql += " Where st_num = " + stNo; 
			
			try {
				PreparedStatement ps = DBConnection.dbConn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
				StudentVO vo = new StudentVO(
				rs.getString("ST_NO"),
				rs.getString("ST_NAME"),
				rs.getString("ST_ADDR"),
				rs.getInt("ST_GRADE"),
				rs.getInt("ST_HEIGHT"),
				rs.getInt("ST_WEIGHT"),
				rs.getString("ST_NICK"),
				rs.getString("ST_NICK_REM"),
				rs.getString("ST_DEPT")
				);
				return vo;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		return null;
	}

	@Override
	public List<StudentVO> findByName(String stName) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_student ";
		sql += " Where st_num = " + stName; 
		
		try {
			PreparedStatement ps = DBConnection.dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<StudentVO> stdList = new ArrayList<StudentVO>();
		
			while(rs.next()){
		
			StudentVO vo = new StudentVO(
					rs.getString("st_no"),
					rs.getString("st_name"),
					rs.getString("st_addr"),
					rs.getInt("st_grade"),
					rs.getInt("st_height"),
					rs.getInt("st_weight"),
					rs.getString("st_nick"),
					rs.getString("st_nick_rem"),
					rs.getString("st_dept")
					);
				stdList.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO 여기는 학생정보추가 메소드
		String sql = " INSERT INTO tbl_student ( ";
		sql += " ST_NO, ";
		sql += " ST_NAME, ";
		sql += " ST_ADDR, ";
		sql += " ST_GRADE, ";
		sql += " ST_HEIGHT, ";
		sql += " ST_WEIGHT, ";
		sql += " ST_NICK, ";
		sql += " ST_NICK_REM, ";
		sql += " ST_DEPT ) ";
		sql += " VALUES( ?,?,?,?,?,?,?,?,? ) ";

		PreparedStatement ps = null;

		try {

			/*
			 * DBMS와 연결되는 Connection정보를 Service 클래스에 변수로 등록하고 변수를 사용해서 query를 사용하는 방법이 아닌
			 * 
			 * 필요할때마다 DBConnection 클래스의 dbConn 객체변수를 직접 사용하여 query를 실행하는 방법을 사용한다.
			 * 
			 * Service 클래스에 변수를 선언, 생성하는 절차가 필요없이 필요할때마다 dbConn 변수를 직업 사용하므로서
			 * 
			 * Service 클래스에 불 필요한 변수 생성 코드를 작성하지 않아도 되고 혹시 모를 변수 생성이 되지 않아 발생할 수 있는 runtime
			 * exception을 예방할 수 있다.
			 */
			ps = DBConnection.dbConn.prepareStatement(sql);

			ps.setString(1, vo.getSt_no());
			ps.setString(2, vo.getSt_name());
			ps.setString(3, vo.getSt_addr());
			ps.setInt(4, vo.getSt_grade());
			ps.setInt(5, vo.getSt_height());
			ps.setInt(6, vo.getSt_weight());
			ps.setString(7, vo.getSt_nick());
			ps.setString(8, vo.getSt_nick_rem());
			ps.setString(9, vo.getSt_dept());

			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String stNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String makeStNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
