<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath %>>">
    <title>中北信号软件服务系统</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="assets/js/jquery-3.2.1.min.js"></script>
	<script src="assets/js/jquery-3.2.1.js"></script>	
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="js/right.js"></script>
	<link rel="stylesheet" href="css/ui/right.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="assets/css/custom.css">
	<link rel="stylesheet" href="css/xschange.css">
	<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico" type="image/x-icon" />
	<style>
		.active1{
		font-size:40px}
	</style>
	
	<script type="text/javascript">
	window.onload=Hide();
	function Hide(){     
	    if(window.parent.right.rows == "70,*"){  
	        top.right.rows = "0,*";  
	    }/* else{  
	        top.bottom.cols = "70,*";  
	    }  */ 
	}
	</script>
  </head>
  
  <body>
  	<main id="content-wrapper" class="page-wrapper">
			<!--中部右侧 -->
			<div id="right">
				<div id="syright" class="bg1">
					<div class="sytop">
						<img style="width:50px;height:50px;" alt="" src="assets/img/fry.png">
						<!-- <h1>欢迎进入服务系统</h1> -->
					</div>
					<!-- <div>
						<ul class="ubtn">
							
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btrjzc">软件注册</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btzcgl">注册管理</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btrjaz">软件安装</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btazjl">安装管理</button></a></li>
							
							
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btgcss">工程实施</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btgcjd">实施进度</button></a></li>
							 

							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btrjwt">软件问题</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btyhxq">用户需求</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btyhsy">用户使用</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btgcaz">工程安装</button></a></li>
							
							
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btmmsz">密码设置</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btwtsz">问题类型</button></a></li>
							<li><a href="#"><button type="button" class="btn btn-primary btn-lg" id="btjdsz">进度设置</button></a></li>
						 </ul>
					</div> -->
					<div>
					
					</div>
				</div>
				
			</div>
    </main>
  </body>
</html>
