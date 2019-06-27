package com.biz.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DbConnection;
import com.biz.jdbc.model.StudentVO;

public class StdServiceImp_01 implements StdService {
	
	private List<StudentVO>	stdList = null;
	
	private Connection dbConn;
//	private String jdbcDriver
//	 	=  "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	private String username = "user5";
//	private String password = "1234";
	
	// dbConnection은 외부에서 실행하지 못하도록 private으로 선언한다.
	// dbConnection이 자주 실행되는 것은 Driver를 계속  On load시키고
	// 통로를 새로 설정하는 과정이 반복되어 문제를 일으킬 수 있기 때문이다.
	public StdServiceImp_01() {
		// 데이터 리스트를 만들어서 외부로 전달하기 위해서 사용하는
		// stdList를 생성자에서 초기화하를 하고 계속 사용을 하면
		// selectAll() 실행할 때마다 리스트가 계속 쌓이게 된다.
		// 리스트를 초기화하는 코드는
		// 리스트를 만들기 직전에 위치해야 한다.
		// stdList = new ArrayList<StudentVO>();
		this.dbConn = DbConnection.getDBConnection();
	}
	
//	private void dbConnection() {
//		try {
//			//1. jdbcDriver On load 시키기
//			Class.forName(jdbcDriver);
//			
//			//2. 연결 통로(port)를 설정하기 
//			dbConn = DriverManager.getConnection(url, username, password);
//			
//			
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println("오라클 드라이버가 없습니다.");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println("오라클에 연결할 수 없습니다.");
//		}
//		
//		
//	}
	
	public List<StudentVO> selectAll() {
		// TODO 여기는 전체 리스트를 select하는 메소드이다.
		String sql = "SELECT * FROM tbl_student";
		
		// String으로 된 sql문장을 DBMS방식으ㅟ 코드로 변환하여
		// DBMS에게 전달하는 역할을 수행한다.
		PreparedStatement pStr = null;
				
		try {
			// sql문을 DBMS코드로 변환(컴파일)하여 잠시 보관중
			pStr = this.dbConn.prepareStatement(sql);
			// query를 실행하고
			// DBMS로 보낸 결과를 ResultSet 데이터 구조로 바꾸어
			// return
			
			//ResultSet 구조의 객체를 선언하여 데이터를 수신한다.
			ResultSet rs = pStr.executeQuery();
			
			/*
			 *  ResultSet :  DBMS가 보낸 데이터를 배열형태로 보관을 하고
			 *  next() 메소드를 실행하면 한 줄씩 데이터를 읽어온다.
			 *  단, 읽는 방향은 일방통행이다.
			 *  처음부터 ~ 끝방향으로
			 */
			
//			if(rs.next()) System.out.println("데이터가 있다.");
//			else System.out.println("데이터가 없다.");
			stdList = new ArrayList<StudentVO>();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				//old 코드
				vo.setSt_no(rs.getString(1));
				vo.setSt_name(rs.getString(2));
				vo.setSt_addr(rs.getString(3));
				vo.setSt_grade(rs.getInt(4));
				vo.setSt_height(rs.getInt(5));
				vo.setSt_weight(rs.getInt(6));
				vo.setSt_nick(rs.getString(7));
				vo.setSt_nick_rem(rs.getString(8));
				vo.setSt_dept(rs.getString(9));
				
				//new 코드
				vo.setSt_no(rs.getString("st_no"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setSt_addr(rs.getString("st_addr"));
				vo.setSt_grade(rs.getInt("st_grade"));
				vo.setSt_height(rs.getInt("st_height"));
				vo.setSt_weight(rs.getInt("st_weight"));
				vo.setSt_nick(rs.getString("st_nick"));
				vo.setSt_nick_rem(rs.getString("st_nick_rem"));
				vo.setSt_dept(rs.getString("st_dept"));

				
				stdList.add(vo);
			}
			
			return stdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		return null;
	}

	public StudentVO findByNum(String st_num) {
		//TODO 학번을 매개변수로 받아 한 학새의 정보를 리턴하느 메소드
		
		// sql문을 작성할 때 따옴표가 시작되는 곳과 끝나는 곳에 스페이스 필수!!
		String sql = "SELECT * FROM tbl_student ";
		sql += " WHERE st_no =" + st_num ;

		PreparedStatement ps = null;
		try {
			ps = dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				StudentVO vo = new StudentVO();
				vo.setSt_no(rs.getString("st_no"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setSt_addr(rs.getString("st_addr"));
				vo.setSt_grade(rs.getInt("st_grade"));
				vo.setSt_height(rs.getInt("st_height"));
				vo.setSt_weight(rs.getInt("st_weight"));
				vo.setSt_nick(rs.getString("st_nick"));
				vo.setSt_nick_rem(rs.getString("st_nick_rem"));
				vo.setSt_dept(rs.getString("st_dept"));
				
				return vo;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
		
		
	}

	public void insert(StudentVO vo) {
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
		sql += " VALUES(?,?,?,?,?,?,?,?,?) ";
		
		PreparedStatement ps = null;

		try {
			ps = this.dbConn.prepareStatement(sql);
			ps.setString(1, vo.getSt_no());
			ps.setString(2, vo.getSt_name());
			ps.setString(3, vo.getSt_addr());
			ps.setInt(4, vo.getSt_grade());
			ps.setInt(5, vo.getSt_height());
			ps.setInt(6, vo.getSt_weight());
			ps.setString(7, vo.getSt_nick());
			ps.setString(8, vo.getSt_nick_rem());
			ps.setString(9, vo.getSt_dept());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	public void update(StudentVO vo) {
		String sql = " UPDATE tbl_student SET  ";
		sql += " ST_NAME = ? , "; //2
		sql += " ST_ADDR = ? , "; //3
		sql += " ST_GRADE = ? , "; //4
		sql += " ST_HEIGHT = ? , "; //5
		sql += " ST_WEIGHT = ? ,"; //6
		sql += " ST_NICK = ? , "; //7
		sql += " ST_NICK_REM = ? , ";  //8
		sql += " ST_DEPT  = ? "; //9
		sql += " WHERE ST_NO = ? "; 	//1

		PreparedStatement ps = null;
		
		try {
			ps = this.dbConn.prepareStatement(sql);
			
			ps.setString(9, vo.getSt_no());
			ps.setString(1, vo.getSt_name());
			ps.setString(2, vo.getSt_addr());
			ps.setInt(3, vo.getSt_grade());
			ps.setInt(4, vo.getSt_height());
			ps.setInt(5, vo.getSt_weight());
			ps.setString(6, vo.getSt_nick());
			ps.setString(7, vo.getSt_nick_rem());
			ps.setString(8, vo.getSt_dept());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void delete(String st_num) {
		String sql = " DELETE FROM tbl_student ";
		sql += " WHERE st_no = " + st_num;
		
		PreparedStatement ps = null;
		
		try {
			ps = this.dbConn.prepareStatement(sql);
			int ret = ps.executeUpdate();
				
			// 삭제가 정상적으로 이루어졌는지 알아보는 방법으로
			// 아래 2가지 코드가 있지만
			// DBMS 서버와 통신(데이터 주고받기)하는 과정에서
			// 레코드가 정상적으로 삭제되면 반드시 0이상의 값을
			// 리턴해서 ret에 담아주지만
			// 레코드에 삭제가 이루어지지 않을 경우
			// 정말 삭제할 리코드가 없는 경우도 있고
			// 이 경우는 0을 return할 것이다.
			
			//하지만
			// 어떤이유로 레코드가 있음에도 삭제가 이루어지지 않았을경우
			// - 미만의 값을 retrun하는 경우도 있다.
			// 이런 경우 2번의 방법에서는
			// 정상적으로 삭제가 이루어졌다는 메시지를 보이게된다.
			
			// 따라서 1번 방법이 안전한 코드 작성법이다.
			
				//1번
				if(ret > 0 ) System.out.println(ret + "레코드 삭제 성공");
				else System.out.println("삭제할 데이터가 없음");
				
				//2
//				if(ret == 0)System.out.println("삭제할 데이터가 없음");
//				else System.out.println(ret + "레코드 삭제 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TODO 여기는 한개의 레코드(데이터)를 삭제하는 메소드이다.
	} //end delete
	
	public String makeStNo() {
		String sql = " SELECT LPAD(MAX(st_no) + 1,3,'0') ";
		sql += " FROM tbl_student ";
		
		PreparedStatement ps = null;
		
		try {
			ps = this.dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String strNum = rs.getString(1);
				return strNum;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
