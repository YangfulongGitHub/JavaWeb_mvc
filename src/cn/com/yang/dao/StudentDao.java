package cn.com.yang.dao;

import java.util.List;

import com.mysql.jdbc.UpdatableResultSet;

import cn.com.yang.utils.Student;

public interface StudentDao {
	public List<Student> getAll();
	
	public void save(Student student);
	
	public Student get(Integer id);

	public Student get(String studentno);
	public void delete(String id);
	
	public void updatestu(Student student);
	
	/**
	 * ���غ�name ��ȵļ�¼��
	 * @param studentno
	 * @return
	 */
	public long getCountWithstudentno(String studentno);
}
