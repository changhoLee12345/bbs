package co.micol.board.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class DAO {

//	final static String DB_URL = "jdbc:oracle:thin:@db202106021127_medium?TNS_ADMIN=/Users/winnie/test/Wallet_DB202106021127/";
//	final static String DB_USER = "admin";
//	final static String DB_PASSWORD = "Qwertyuiop12";

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@adb.ap-seoul-1.oraclecloud.com:1522:g85f14961bb7927_db202106021127_medium.adb.oraclecloud.com";
	private String user = "admin"; // 자신계정
	private String password = ""; // 이계정의 패스워드

	public Connection conn; // db 연결객체
//	OracleConnection conn;

	public DAO() {
//		Properties info = new Properties();
//		info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
//		info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
//		info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

//		OracleDataSource ods;
//		try {
//			ods = new OracleDataSource();
//			ods.setURL(DB_URL);
//			ods.setConnectionProperties(info);
//			conn = (OracleConnection) ods.getConnection();
//			DatabaseMetaData dbmd = conn.getMetaData();
//			System.out.println("Driver Name: " + dbmd.getDriverName());
//			System.out.println("Driver Version: " + dbmd.getDriverVersion());
//			// Print some connection properties
//			System.out.println("Default Row Prefetch Value is: " + conn.getDefaultRowPrefetch());
//			System.out.println("Database Username is: " + conn.getUserName());
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}

		try {
			Class.forName(driver); // 드라이버 로드
			conn = DriverManager.getConnection(url, user, password); // 연결
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
