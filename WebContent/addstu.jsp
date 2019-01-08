<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加学生信息</title>
</head>
<body>
<%
		String massage=(String)request.getAttribute("massage");
		if(massage!=null){
			out.print(massage);
		}
%>
	<center>
		<h2>添加学生信息</h2>
		
		<form action="save.do" method="get">
			<table border="1" cellspacing="0" cellpadding="10">
				<tr>	
					<td>学生编号</td>
					<td><input type="text" name ="stuno"/></td>
				</tr>
				<tr>	
					<td>学生姓名</td>
					<td><input type="text" name ="stuname"/></td>
				</tr>
				<tr>	
					<td>登录密码</td>
					<td><input type="text" name ="stuinpwd"/></td>
				</tr>
				<tr>	
					<td>专业编号</td>
					<td><input type="text" name ="stumajorid"/></td>
				</tr>
				<tr>	
					<td>电话号码</td>
					<td><input type="text" name ="stuphone"/></td>
				</tr>
				<tr>	
					<td>邮箱</td>
					<td><input type="text" name ="stuemail"/></td>
				</tr>
				<tr>	
					<td>日期</td>
					<td><input type="text" name ="stuborndate"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>