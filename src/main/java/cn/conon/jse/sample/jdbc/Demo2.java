package cn.conon.jse.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

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
		System.out.println(conn);
		// 3.创建用于向数据库发送sql的statement对象
		Statement st = conn.createStatement();

		// 4.向数据库发送sql语句
		String sql = "select id,name,password,email,birthday from user";
		ResultSet rs = st.executeQuery(sql);

		// 5.通过代表执行结果的resultset，获取数据库的数据
		while (rs.next()) {
			User user = new User();
			// System.out.println("id=" + rs.getObject("id"));
			// System.out.println("name=" + rs.getObject("name"));
			// System.out.println("password=" + rs.getObject("password"));
			// System.out.println("email=" + rs.getObject("email"));
			// System.out.println("birthday=" + rs.getObject("birthday"));

			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));

			System.out.println(user.toString());
		}

		// 6.释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
