package cn.com.yang.utils;

import java.util.Date;

public class Student {
	private String studentno;
	private String studentname;
	private String loginpwd;
	private int majorid;
	private String phone;
	private String email;
	private Date borndate;
	public String getStudentno() {
		return studentno;
	}
	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


//	public String getBorndate() {
//		return borndate;
//	}
//	public void setBorndate(String borndate) {
//		this.borndate = borndate;
//	}
	public Date getBorndate() {
		return borndate;
	}
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
//	public Student(String studentno, String studentname, String loginpwd, int majorid, String phone,
//			String email, String borndate) {
//		super();
//		this.studentno = studentno;
//		this.studentname = studentname;
//		this.loginpwd = loginpwd;
//		this.majorid = majorid;
//		this.phone = phone;
//		this.email = email;
//		this.borndate = borndate;
//	}
	public Student(String studentno, String studentname, String loginpwd, int majorid, String phone, String email,
			Date borndate) {
		super();
		this.studentno = studentno;
		this.studentname = studentname;
		this.loginpwd = loginpwd;
		this.majorid = majorid;
		this.phone = phone;
		this.email = email;
		this.borndate = borndate;
	}
	public Student(String studentname, String loginpwd, int majorid, String phone, String email,
			Date borndate) {
		super();
		this.studentname = studentname;
		this.loginpwd = loginpwd;
		this.majorid = majorid;
		this.phone = phone;
		this.email = email;
		this.borndate = borndate;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
