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
    	<h1>员工表</h1>
    	<a href="showInsert.action">添加</a>
    	<form action="selectByLike.action" method="post">
   			编号<input type="text" name="empno">
   			姓名<input type="text" name="ename">
   			岗位<input type="text" name="job">
   			上级<input type="text" name="mgr">
   			日期<input type="text" name="hiredate">
   			月薪<input type="text" name="sal">
   			奖金<input type="text" name="comm">
   			部门<input type="text" name="deptno">
   			<input type="submit" value="查询">
    	</form>
    	<table border="1">
    		<tr>
    			<td>编号</td>
    			<td>姓名</td>
    			<td>岗位</td>
    			<td>老板编号</td>
    			<td>入职日期</td>
    			<td>月薪</td>
    			<td>补助</td>
    			<td>所属部门编号</td>
    			<td>操作</td>
    		</tr>
    		<c:forEach items="${employees}" var="employee">
    			<tr>
    				<td>${employee.empno}</td>
	    			<td>${employee.ename}</td>
	    			<td>${employee.job}</td>
	    			<td>${employee.mgr}</td>
	    			<td>${employee.hiredate}</td>
	    			<td>${employee.sal}</td>
	    			<td>${employee.comm}</td>
	    			<td>${employee.deptno}</td>
	    			<td><a href="showUpdate.action?empno=${employee.empno}">[修改]</a><a href="delete.action?empno=${employee.empno}">[删除]</a></td>
    			</tr>
    		</c:forEach>
    	</table>
    </div>
  </body>
</html>
