package cn.conon.jse.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {

	/**
	 * @throws ClassNotFoundException
	 * 
	 */
	public static void main(String[] args) {

		String url = "jdbc:mysql:///test_db01";
		String username = "root";
		String password = "root";

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password); // connection

			st = conn.createStatement();
			String sql = "select id,name,password,email,birthday from user";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {

		} finally {
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

//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} finally {
//					if (st != null) {
//						try {
//							st.close();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} finally {
//							if (conn != null) {
//								try {
//									conn.close();
//								} catch (SQLException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//							}
//						}
//					}
//				}
//			}
		}
	}
}
