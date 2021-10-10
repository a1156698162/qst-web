<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<base href="<%= basePath%>">
<html>
<head>
<meta charset="UTF-8">
<title>企业列表</title>
<link href="<%= basePath%>/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="<%= basePath%>/images/t01.png" /></span><a href="userAdd.jsp">添加</a></li>
      <li class="click"><span><img src="<%= basePath%>/images/t02.png" /></span><a href="userAdd.html">修改</a></li>
      <li><span><img src="<%= basePath%>/images/t03.png" /></span><a href="userDelete.html">删除</a></li>
    </ul>
    <iframe src="<%= basePath%>/manage/userSearch.html" scrolling="no" frameborder="0" width="400" height="42"></iframe>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>用户登录名</th>
        <!-- <th>用户真实姓名</th> -->
        <th>用户Email</th>
        <th>用户角色</th>
        <th>用户状态</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${userPage.items}" var="user">
	      <tr height="50px">
	        <td ><input name="" type="checkbox" value="" /></td>
	        <td>${user.username}</td>
	        <!-- <td>青软实训</td> -->
	        <td>user.email</td>
	        <c:choose>
	        	<c:when test="${user.userRole == 1}">
	        	  <td>系统管理员</td>
	        	</c:when>
	        	<c:when test="${user.userRole == 2}">
	        	  <td>企业管理员</td>
	        	</c:when>
	        	<c:when test="${user.userRole == 3}">
	        	  <td>普通用户</td>
	        	</c:when>
	        </c:choose>
	        <c:choose>
	        	<c:when test="${user.userState == 1}">
	        		<td>启用</td>
	        	</c:when>
	        	<c:when test="${user.userState == 2}">
	        		<td>禁用</td>
	        	</c:when>
	        </c:choose>
	        <td ><a href="userAdd.html" class="tablelink">修改</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
	      </tr>
    	</c:forEach>
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">共<i class="blue">${userPage.pageTotal}</i>页，当前显示第&nbsp;<i class="blue">${userPage.pageNo}&nbsp;</i>页</div>
    <ul class="paginList">
     <c:if test="${userPage.pageNo != 1}">
      <li class="paginItem"><a href="<%= basePath%>/userServlet?method=page&pn=1">首页</a></li>
      <li class="paginItem"><a href="<%= basePath%>/userServlet?method=page&pn=${userPage.pageNo - 1}">上一页<span class="pagepre"></span></a></li>
     </c:if>
     <c:if test="${userPage.pageNo != userPage.pageTotal}">
       <li class="paginItem"><a href="<%= basePath%>/userServlet?method=page&pn=${userPage.pageNo + 1}">下一页<span class="pagenxt"></span></a></li>
       <li class="paginItem"><a href="<%= basePath%>/userServlet?method=page&pn=${userPage.pageTotal}">尾页</a></li>
     </c:if>
    </ul>
  </div>
</div>
</body>
</html>