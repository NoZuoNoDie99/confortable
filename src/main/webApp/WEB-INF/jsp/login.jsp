<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/31
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登陆页面</title>
</head>
<body>
<form action="/login.action" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="userPassword"></td>
        </tr>
        <tr>
            <td><button><a href="/addUser.action">注册</a></button></td>
            <td><button><a href="/toLogin.action">登陆</a></button></td>
        </tr>
    </table>
    <span>${error}</span>
    <span>${success}</span>
</form>
</body>
</html>
