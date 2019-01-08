package cn.com.yang.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.com.yang.db.JdbcUTils;

public class Testjdbc {
	
	@Test
	public void test1jdbc() throws SQLException{
		Connection connection =JdbcUTils.getConnection();
		System.out.println(connection);
	}
	
}
