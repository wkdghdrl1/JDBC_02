package com.biz.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	// * static :
	// 	 static가 붙은 변수, 메서드는
	//   프로젝트가 실행되는 순간 생성되어
	//	 누군가 사용하든 안 하든 메모리에 존재하게 된다.
	// 	 static 변수, 메소드는 이미 생성된 상태가 되고
	//	 static 변수와 메소드를 감싸고 있는 클래스도
	// 	 자동으로 static 클래스가 되어 프로젝트 시작과 동시에 생성된다.
	// 
	//   따라서 외무에서 사용하고자 할 때는
	//   별도로 객체로 생성하지 않고
	//   클래스.변수, 클래스.메소드()형식으로 사용한다.
	private static Connection dbConn = null;
	
	static//static만 있음 > 무명 메소드
	/*
	 *  static {}
	 *  보통 무명메소드라고도 하며
	 *  static 클래스의 생성자 역할을 한다.
	 *  
	 *  즉, 자동으로 코드들이 실행되어
	 *  static 변수들을 초기화하는 코드가 작성된다.
	 */
		{

		String javaDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String username = "user5";
		String password = "1234";

		try {
			Class.forName(javaDriver);
			dbConn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // end static

	public static Connection getDBConnection() {
		return dbConn;
	}
}
