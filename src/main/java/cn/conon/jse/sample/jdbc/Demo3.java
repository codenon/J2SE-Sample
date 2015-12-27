package cn.conon.jse.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {

	/**
	 * @throws ClassNotFoundException
	 * 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql:///test_db01";
		String username = "root";
		String password = "root";

		// 1.注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2.获取与数据库的链接 //jdbc
		Connection conn = DriverManager.getConnection(url, username, password); // connection

		// 3.创建用于向数据库发送sql的statement对象
		Statement st = conn.createStatement();

		// 4.向数据库发送sql语句
		String sql = "select id,name,password,email,birthday from user";
		ResultSet rs = st.executeQuery(sql);

		rs.next();
		System.out.println(rs.getString("name"));

		rs.next();
		rs.previous();
		System.out.println(rs.getString("name"));

		rs.absolute(2);
		System.out.println(rs.getString("name"));

		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getString("name"));

		// 6.释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
