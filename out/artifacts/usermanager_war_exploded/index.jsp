<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <title>用户管理-登陆</title>
</head>
<body>
<form action = "LoginUserServlet" method = "POST">
  用户名:<input type = "text" name = "username"><br>
  密码:<input type = "password" name = "userpass"><br>
  <input type = "submit" value = "登陆">&nbsp&nbsp
  <a href="reg.jsp">注册</a>&nbsp&nbsp<a href="qry.jsp">用户查询</a>
</form>
</body>
</html>