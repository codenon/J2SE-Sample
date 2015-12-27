package cn.conon.jse.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test_db01";
	private static String username = "root";
	private static String password = "root";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	// 获取链接
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public static void release(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
