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
    	<h1>添加员工表</h1>
    	<c:forEach items="${errors}" var="error">
    		<h3>${error.defaultMessage}</h3>
    	</c:forEach>
    	<form action="insert.action">
    		<p>
    			部门号<input type="text" name="empno">
    		</p>
    		<p>
    			姓名<input type="text" name="ename">
    		</p>
    		<p>
    			岗位<input type="text" name="job">
    		</p>
    		<p>
    			上级<input type="text" name="mgr">
    		</p>
    		<p>
    			日期<input type="text" name="hiredate">
    		</p>
    		<p>
    			月薪<input type="text" name="sal">
    		</p>
    		<p>
    			奖金<input type="text" name="comm">
    		</p>
    		<p>
    			部门<input type="text" name="deptno">
    		</p>
    		<p>
    			<input type="submit" value="添加">
    		</p>
    	</form>
    </div>
  </body>
</html>
