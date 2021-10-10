<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q_ITOffer锐聘网后台管理系统</title>
<link href="../css/left.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>功能菜单</div>
<dl class="leftmenu">
  <dd>
    <div class="title"> <span><img src="../images/leftico01.png" /></span>企业职位管理</div>
    <ul class="menuson">
      <li><cite></cite><a href="jobApplyList.html" target="rightFrame">职位申请查看</a><i></i></li>
      <li><cite></cite><a href="jobList.html" target="rightFrame">职位管理</a><i></i></li>
      <li><cite></cite><a href="../companyServlet?method=showCompany" target="rightFrame">企业管理</a><i></i></li>
    </ul>
  </dd>
  <dd>
    <div class="title"> <span><img src="../images/leftico02.png" /></span>简历管理</div>
    <ul class="menuson">
      <li><cite></cite><a href="resumeList.html" target="rightFrame">简历查询</a><i></i></li>
    </ul>
  </dd>
  <dd>
    <div class="title"><span><img src="../images/leftico03.png"/></span>用户管理</div>
  	<ul class="menuson">
      <li><cite></cite><a href="../userServlet?method=page&pn=1&pageSize=3" target="rightFrame">用户管理</a><i></i></li>
    </ul>
  </dd>
  <dd>
    <div class="title"><span><img src="../images/leftico04.png" /></span>系统管理</div>
    <ul class="menuson">
      <li><cite></cite><a href="userOnline.html" target="rightFrame">在线用户</a><i></i></li>
    </ul>
  </dd>
  <dd>
    <div class="title"><span><img src="../images/leftico04.png" /></span>密码修改</div>
  </dd>
</dl>
</body>
</html>
