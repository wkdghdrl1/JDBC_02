package com.biz.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DbConnection;
import com.biz.jdbc.model.ScoreVO;

/*
 * DB커넥션 연결 
 */
public class ScoreServiceImp_01 implements ScoreService {

	List<ScoreVO> scList = null;
	private Connection dbConn;
//	private String javaDriver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	private String username = "user5";
//	private String password = "1234";

	public ScoreServiceImp_01() {
		this.dbConn = DbConnection.getDBConnection();

	}

//	private void dbConnection() {
//		try {
//			Class.forName(javaDriver);
//
//			dbConn = DriverManager.getConnection(url, username, password);
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public List<ScoreVO> selectALL() {
		// TODO 여기는 전체 성적데이트를 SELECT해서 List로 리턴하는 메서드
		String sql = " SELECT * FROM tbl_score ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rs = pStr.executeQuery();

			scList = new ArrayList<ScoreVO>();

			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
//				SC_SEQ 1
//				SC_DATE 2 
//				SC_ST_NO 3
//				SC_SUBJECT 4
//				SC_SCORE 5
				vo.setSc_seq(rs.getLong("SC_SEQ"));
				vo.setSc_date(rs.getString("SC_DATE"));
				vo.setSc_st_no(rs.getString("SC_ST_NO"));
				vo.setSc_subject(rs.getString("SC_SUBJECT"));
				vo.setSc_score(rs.getInt("SC_SCORE"));
				scList.add(vo);

				
			}
			return scList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

	public ScoreVO findById(long sc_seq) {
		// TODO 여기는 일련번호 값을 매개변수로 받아 성적데이터 1개의 레코드를 리턴
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_seq = " + sc_seq;
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rs = pStr.executeQuery();

			scList = new ArrayList<ScoreVO>();

			if(rs.next()) {
				ScoreVO vo = new ScoreVO();
//				SC_SEQ 1
//				SC_DATE 2 
//				SC_ST_NO 3
//				SC_SUBJECT 4
//				SC_SCORE 5
				vo.setSc_seq(rs.getLong("SC_SEQ"));
				vo.setSc_date(rs.getString("SC_DATE"));
				vo.setSc_st_no(rs.getString("SC_ST_NO"));
				vo.setSc_subject(rs.getString("SC_SUBJECT"));
				vo.setSc_score(rs.getInt("SC_SCORE"));
				scList.add(vo);

				return vo;
			}
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return null;
	}

	public int insert(ScoreVO vo) {
		// TODO 여기는 데이터 추가
		String sql = " INSERT INTO tbl_score ( ";
		sql += " SC_SEQ, ";
		sql += " SC_DATE, ";
		sql += " SC_ST_NO, ";
		sql += " SC_SUBJECT, ";
		sql += " SC_SCORE ) ";
		sql += " VALUES( SEQ_SCORE.NEXTVAL , ?, ?, ?, ?) ";
		return 0;
	}

	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(long sc_seq) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ScoreVO> findById(String st_no) {
		// TODO 여기는 전체 성적데이트를 SELECT해서 List로 리턴하는 메서드
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_st_no = " + st_no;

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rs = pStr.executeQuery();

			scList = new ArrayList<ScoreVO>();

			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
//				SC_SEQ 1
//				SC_DATE 2 
//				SC_ST_NO 3
//				SC_SUBJECT 4
//				SC_SCORE 5
				vo.setSc_seq(rs.getLong("SC_SEQ"));
				vo.setSc_date(rs.getString("SC_DATE"));
				vo.setSc_st_no(rs.getString("SC_ST_NO"));
				vo.setSc_subject(rs.getString("SC_SUBJECT"));
				vo.setSc_score(rs.getInt("SC_SCORE"));
				scList.add(vo);

				
			}
			return scList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

}
