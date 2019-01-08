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
	 * ����ĳ���ֶε�ֵ�����緵��ĳ����¼�� һ�����ԣ��򷵻���еĶ�������¼�ȣ�
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
	 * ����T��Ӧ��List
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
	 * ���ض�Ӧ��T��һ��ʵ����Ķ���
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
	 * �÷�����װ��insert delete update ����;
	 * @param sql ���
	 * @param args ���SQL����վλ��
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
