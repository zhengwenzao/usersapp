<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"         "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <title>����û�ҳ��</title>
</head>
<body>
<form action = "AddUserServlet" method = "POST">
  �û���:<input type = "text" name = "username"><br>
  ����:<input type = "password" name = "userpass"><br>
  ����:<input type = "text" name = "name"><br>
  �Ա�:<input type = "text" name = "sex"><br>
  ����:<input type = "text" name = "age"><br>
  <input type = "submit" value = "ע��">
  <input type = "reset" value = "����"><a href="index.jsp">������ҳ</a>
</form>
</body>
</html>