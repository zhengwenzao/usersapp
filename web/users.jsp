<%@ page import="java.util.ArrayList" %>
<%@ page import="user.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");%>
<html>
<head>
    <title>个人明细</title>
</head>
<body>
<% if (list==null){%>
<table border="1" style="border-collapse:collapse">
    <tr style="background-color: yellow">
        <td>用户名</td>
        <td>密码</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
    </tr>
</table>
<%}else {%>
    <table border="1" style="border-collapse:collapse">
        <tr style="background-color: yellow">
            <td>用户名</td>
            <td>密码</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
        </tr>

       <% if (list.size()>0){
           for (User user : list) {

       %>
                <tr style="border: 1px solid #99acb2">
                    <td> <%=user.getUsername()%></td>
                    <td> <%=user.getUserpass()%></td>
                    <td> <%=user.getName()%></td>
                    <td> <%=user.getSex()%></td>
                    <td> <%=user.getAge()%></td>

                </tr>

         <% }
             }
         %>

    </table>
<%}%>
<a href="index.jsp">返回主页</a>
</body>
</html>
