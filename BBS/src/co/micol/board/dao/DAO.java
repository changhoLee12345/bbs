package co.micol.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";  //자신계정
	private String password = "hr";  //이계정의 패스워드
	
	public Connection conn;  //db 연결객체
	
	public DAO() {
		try {
			Class.forName(driver);  //드라이버 로드
			conn = DriverManager.getConnection(url, user, password);  //연결
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
