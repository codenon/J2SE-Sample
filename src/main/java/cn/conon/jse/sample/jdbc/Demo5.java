package cn.conon.jse.sample.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {

	/**
	 * 使用jdbc完成对数据库的增删改查
	 */
	// 1.如果上层程序不能处理这个异常，就抛运行时异常
	// 2.如果开发人员想把异常当作一个返回值的话，这时就应该抛编译时异常
	// dao
	public void insert() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into user(name,password,email,birthday) values('aaa','123','a@sina.com','1980-09-09')";
			int num = st.executeUpdate(sql);
			if (num > 0) {
				System.out.println("插入成功！！");
			}
		} catch (SQLException e) { //
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, st, conn);
		}
	}

	public void delete() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from user where id=4";

			int num = st.executeUpdate(sql);
			if (num > 0) {
				System.out.println("删除成功！！");
			}
		} catch (SQLException e) { //
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, st, conn);
		}
	}

	public void update() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "update user set email='wuwang@sina.com' where id=3";

			int num = st.executeUpdate(sql);
			if (num > 0) {
				System.out.println("更新成功！！");
			}
		} catch (SQLException e) { //
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, st, conn);
		}
	}

	public void find() {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from user where id=2";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}

		} catch (SQLException e) { //
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, st, conn);
		}
	}
}
