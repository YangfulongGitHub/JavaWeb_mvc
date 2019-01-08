package cn.com.yang.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import javax.lang.model.element.Parameterizable;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.com.yang.db.JdbcUTils;


public class Dao<T> {
	
	private QueryRunner  queryRunner = new QueryRunner();
	private Class<T> clazz;
	
	public Dao(){
		Type superClass = getClass().getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType =(ParameterizedType)superClass;
			Type [] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs !=null && typeArgs.length>0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>)typeArgs[0];
				}
			}
		}
	}
	/**
	 * 返回某个字段的值：例如返回某条记录的 一个属性，或返会表中的多少条记录等；
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql,Object ...args){
		Connection connection =null;
		try {
			connection=JdbcUTils.getConnection();
			return (E)queryRunner.query(connection,sql,new ScalarHandler(),args);
		} catch (Exception e) {
			// TODO: handle exception
			JdbcUTils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 返回T对应的List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object ...args){
		Connection connection = null;
		try {
			connection=JdbcUTils.getConnection();
			return queryRunner.query(connection,sql, new BeanListHandler<>(clazz),args);
		} catch (Exception e) {
			// TODO: handle exception
			JdbcUTils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * 返回对应的T的一个实体类的对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args){
		Connection connection = null;
		try {
			connection=JdbcUTils.getConnection();
			return queryRunner.query(connection, sql,new BeanHandler<>(clazz), args);
		} catch (Exception e) {
			JdbcUTils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 该方法封装了insert delete update 操作;
	 * @param sql 语句
	 * @param args 填充SQL语句的站位符
	 */
	public void update(String sql,Object ...args){
		Connection connection=null;
		try {
			connection=JdbcUTils.getConnection();
			queryRunner.update(connection,sql,args);
		} catch (Exception e) {
			// TODO: handle exception
			JdbcUTils.releaseConnection(connection);
		}
	}
}
