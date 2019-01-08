package cn.com.yang.dao.impl;

import java.util.List;

import cn.com.yang.dao.Dao;
import cn.com.yang.dao.StudentDao;
import cn.com.yang.utils.Student;

public class StudentDaoImpl extends Dao<Student> implements StudentDao{

	@Override
	public List<Student> getAll() {
		String sql="select studentno,studentname,loginpwd,majorid,phone,email,borndate from student";
		return getForList(sql);
	}

	@Override
	public void save(Student student){
		// TODO Auto-generated method stub
		String sql ="insert INTO student(studentno,studentname,loginpwd,majorid,phone,email,borndate) VALUE(?,?,?,?,?,?,?)";
		update(sql, student.getStudentno(),student.getStudentname(),student.getLoginpwd(),student.getMajorid(),student.getPhone(),student.getEmail(),student.getBorndate());
	}

	@Override
	public Student get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Student get(String studentno) {
		String sql="SELECT studentno,studentname,loginpwd,majorid,phone,email,borndate from student where studentno=?";
		return get(sql,studentno);
	}
	@Override
	public void delete(String studentno) {
		// TODO Auto-generated method stub
		String sql ="DELETE from student where studentno=?";
		update(sql, studentno);
	}

	@Override
	public long getCountWithstudentno(String studentno) {
		String sql="SELECT count(studentno) from student where studentno =?";
		return getForValue(sql, studentno);
	}

	@Override
	public void updatestu(Student student) {
		String sql = "update student set studentname=?,loginpwd=?,majorid=?,phone =?,email =? ,borndate=? where studentno=?";
		update(sql,student.getStudentname(),student.getLoginpwd(),student.getMajorid(),student.getPhone(),student.getEmail(),student.getBorndate(),student.getStudentno());
	}

	
}
