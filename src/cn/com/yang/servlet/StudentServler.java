package cn.com.yang.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.And;

import cn.com.yang.dao.StudentDao;
import cn.com.yang.dao.impl.StudentDaoImpl;
import cn.com.yang.utils.Student;

/**
 * Servlet implementation class StudentServler
 */
@WebServlet("/StudentServler")
public class StudentServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao=new StudentDaoImpl();
    public StudentServler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		String stringName=path.substring(1);
		stringName =stringName.substring(0, stringName.length()-3);
		//System.out.println(stringName);
		try {
			java.lang.reflect.Method method = getClass().getDeclaredMethod(stringName,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	//�鿴�û���������Ϣ(liststu.jsp)
	private void ListStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Student>allStudent=studentDao.getAll();
		request.setAttribute("allStudent", allStudent);
		request.getRequestDispatcher("liststu.jsp").forward(request,response);	
	}
	//ɾ��ѧ������Ϣ
	private void Deletestu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//�õ���������studentno����
		String studentno=request.getParameter("studentno");
		if(studentno !=null){
			studentDao.delete(studentno);
			
		}
		request.getRequestDispatcher("succeed.jsp").forward(request, response);
	}
	//���ѧ����Ϣ
	private void save(HttpServletRequest request,HttpServletResponse response) throws ParseException, ServletException, IOException{
		String studentno=request.getParameter("stuno");
		String studentname=request.getParameter("stuname");
		String loginpwd =request.getParameter("stuinpwd");
		String ma=request.getParameter("stumajorid");
		int majorid=Integer.parseInt(ma);
		String phone=request.getParameter("stuphone");
		String email=request.getParameter("stuemail");
		
		Date borndate = new Date();
		String borndate1=request.getParameter("stuborndate");
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		borndate=sdf.parse(borndate1);
		int count= (int)studentDao.getCountWithstudentno(studentno);
		if(count>0){
			request.setAttribute("massage", studentno+"�Ѿ��������������");
			request.getRequestDispatcher("addstu.jsp").forward(request, response);
		}else{
			Student student =new Student(studentno, studentname, loginpwd, majorid, phone, email, borndate);
			studentDao.save(student);
			request.getRequestDispatcher("succeed.jsp").forward(request, response);
		}	
	}
	
	//��ȡ�޸�ѧ����Ϣ
	public void Updatestu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String studentno=request.getParameter("studentno");
		Student student =studentDao.get(studentno);
		request.setAttribute("student",student);
		request.getRequestDispatcher("updatestu.jsp").forward(request, response);
	}
	//�޸ķ���
	public void updatefun(HttpServletRequest request,HttpServletResponse response) throws ParseException, ServletException, IOException{
		//�õ����޸ĵ�����ֵ
		String studentno=request.getParameter("stuno");
		String studentname=request.getParameter("stuname");
		String loginpwd =request.getParameter("stulogpwd");
		String ma=request.getParameter("stumaj");
		int majorid=Integer.parseInt(ma);
		String phone=request.getParameter("stuphone");
		String email=request.getParameter("stueemail");

		Date borndate = new Date();
		String borndate1=request.getParameter("stuborndate");
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		borndate=sdf.parse(borndate1);
		
		Student student = new Student(studentname, loginpwd, majorid, phone, email, borndate);
		student.setStudentno(studentno);
		
		 if(studentname!=""){
			studentDao.updatestu(student);
			request.getRequestDispatcher("succeed.jsp").forward(request, response);
		 }else{
			 request.setAttribute("massage", "�������ܿ�");
			 //request.getRequestDispatcher("updatestu.jsp").forward(request, response);
			// response.sendRedirect("updatestu.jsp");
		 }
		
		
		//studentDao.updatestu(student);
		//System.out.println("ִ������");
	}
	
}
