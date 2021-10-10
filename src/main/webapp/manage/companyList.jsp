<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssp.bean.Company" %>
<%@ page import="java.util.List" %>
<%
	String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%= basePath%>">
<meta charset="UTF-8">
<title>企业列表</title>
<link href="<%= basePath%>/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">企业列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="<%= basePath%>/images/t01.png" /></span><a href="manage/companyAdd.jsp">添加</a></li>
      <li><span><img src="<%= basePath%>/images/t03.png" /></span><a href="#">删除</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>企业名称</th>
        <th>企业所在地</th>
        <th>企业规模</th>
        <th>企业性质</th>
        <th>招聘状态</th>
        <th>显示排序</th>
        <th>浏览数</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    <%
    	List<Company> companyList =	(List<Company>)request.getAttribute("companyList");
    	for(Company company : companyList){    
    %>
      <tr height="50px">
        <td ><input name="" type="checkbox" value="<%=company.getCompanyId()%>" /></td>
        <td><%=company.getCompanyName()%></td>
        <td><%=company.getCompanyArea()%></td>
        <td><%=company.getCompanySize()%></td>
        <td><%=company.getCompanyType()%></td>
     <%
     	if(company.getCompanyState() == 1){	
     %>
    	<td>招聘中</td>
     <%
     	}else if(company.getCompanyState() == 2){
     %>
        <td>已暂停</td>
     <% 
    	 }else{
     %>
    	<td>已结束</td>
     <% 
     	}
     %>
        <td><%=company.getCompanySort()%></td>
        <td><%=company.getCompanyViewnum()%></td>
        <td ><a href="<%= basePath%>companyServlet?method=edit&id=<%=company.getCompanyId()%>" class="tablelink">修改</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
      </tr>
      <%
    	}
      %>
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
      <li class="paginItem"><a href="javascript:;">1</a></li>
      <li class="paginItem current"><a href="javascript:;">2</a></li>
      <li class="paginItem"><a href="javascript:;">3</a></li>
      <li class="paginItem"><a href="javascript:;">4</a></li>
      <li class="paginItem"><a href="javascript:;">5</a></li>
      <li class="paginItem more"><a href="javascript:;">...</a></li>
      <li class="paginItem"><a href="javascript:;">10</a></li>
      <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
  </div>
</div>
</body>
</html>