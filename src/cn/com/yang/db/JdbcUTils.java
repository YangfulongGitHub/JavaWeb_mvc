package cn.com.yang.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * JDBC 操作的工具类
 * 
 */
public class JdbcUTils {
	/**
	 * 释放Connection 链接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static DataSource dateSource = null;
	
	static{
		dateSource=new ComboPooledDataSource("mvcapp");
	}
	/**
	 * 返回数据源的一个Connection对象
	 * @return
	 * @throws SQLException
	 *  
	 */
	public static Connection getConnection() throws SQLException{
		return dateSource.getConnection();
	}
}
