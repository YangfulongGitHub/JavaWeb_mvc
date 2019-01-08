<%@page import="cn.com.yang.utils.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 Student student=(Student)request.getAttribute("student");
		String massage =(String) request.getAttribute("massage");
		if(massage!=null){
			out.print(massage);
		}else{
			massage="";
		}
				
	%>
	<center>
		<h2><span style="border-color: red">修改学生的信息</span></h2>
		
		<form action="updatefun.do" method="get">
		<table border="1" cellspacing="0" cellpadding="10">
			
			<input type="hidden" name="stuno" value="<%=student.getStudentno()%>">

			<tr>
			
				<td>学生姓名</td>
				<td><input type="text" name="stuname" value="<%=student.getStudentname()%>"></td>
				
			</tr>
			<tr>
				<td>学生密码</td>
				<td><input type="text" name="stulogpwd" value="<%=student.getLoginpwd()%>"/></td>
			</tr>
			<tr>
				<td>专业编号</td>
				<td><input type="text" name="stumaj" value="<%=student.getMajorid()%>"/></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input type="text" name="stuphone" value="<%=student.getPhone()%>"/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="stueemail" value="<%=student.getEmail()%>"/></td>
			</tr>
				<tr>
				<td>日期</td>
				<td><input type="text" name="stuborndate" value="<%=student.getBorndate()%>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
			
		</table>
		</form>
	</center>
</body>
</html>