<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div align="center">
    	<h1>修改员工表</h1>
    	<form action="update.action">
    		<p>
    			<input type="hidden" name="empno" value="${employee.empno}">
    		</p>
    		<p>
    			姓名<input type="text" name="ename" value="${employee.ename}">
    		</p>
    		<p>
    			岗位<input type="text" name="job" value="${employee.job}">
    		</p>
    		<p>
    			上级<input type="text" name="mgr" value="${employee.mgr}">
    		</p>
    		<p>
    			日期<input type="text" name="hiredate" value="${employee.hiredate}">
    		</p>
    		<p>
    			月薪<input type="text" name="sal" value="${employee.sal}">
    		</p>
    		<p>
    			奖金<input type="text" name="comm" value="${employee.comm}">
    		</p>
    		<p>
    			部门<input type="text" name="deptno" value="${employee.deptno}">
    		</p>
    		<p>
    			<input type="submit" value="修改">
    		</p>
    	</form>
    </div>
  </body>
</html>
