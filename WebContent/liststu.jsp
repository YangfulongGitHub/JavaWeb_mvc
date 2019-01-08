<%@page import="cn.com.yang.utils.Student"%>
<%@page import="java.util.List"%>
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
		List<Student>allStu=(List)request.getAttribute("allStudent");
	%>
	<center>
		<h2>学生信息</h2>
		<table border="1" cellpadding="10" cellspacing="1">
			<tr>
				<td>studentno</td>
				<td>studentname</td>
				<td>loginpwd</td>
				<td>majorid</td>
				<td>电话</td>
				<td>邮箱</td>
				<td>日期</td>
				<td>Delete/Update</td>
			</tr>
		<%
			for(Student student:allStu){
				%>
					<tr>
						<td><%=student.getStudentno() %></td>
						<td><%=student.getStudentname() %></td>
						<td><%=student.getLoginpwd() %></td>
						<td><%=student.getMajorid() %></td>
						<td><%=student.getPhone() %></td>
						<td><%=student.getEmail() %></td>
						<td><%=student.getBorndate() %></td>
						<td><a href="Deletestu.do?studentno=<%=student.getStudentno() %>" name="deletestu" >删除</a></td>
						<td><a href="Updatestu.do?studentno=<%=student.getStudentno() %>">修改信息</a></td>
					</tr>
				<%
			}
		%>
		
		</table>
	</center>
	<script>
	
	</script>
</body>
</html>