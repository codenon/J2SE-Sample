package cn.conon.jse.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	/**
	 * 第一个jdbc程序
	 */
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/test_db01";
		String username = "root";
		String password = "root";

		// 1.注册数据库驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		// 2.获取与数据库的链接
		Connection conn = DriverManager.getConnection(url, username, password); // connection

		// 3.创建用于向数据库发送sql的statement对象
		Statement st = conn.createStatement();

		// 4.向数据库发送sql语句
		String sql = "select id,name,password,email,birthday from user";
		ResultSet rs = st.executeQuery(sql);

		// 5.通过代表执行结果的resultset，获取数据库的数据
		while (rs.next()) {
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name=" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
		}

		// 6.释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
