<%@page pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<title>中北信号软件服务系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-confirm/jquery-confirm.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/bootstrap-3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"   href="<%=basePath%>/css/ui/login.css" />
<link type="text/css" href="<%=basePath%>js/jquery/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
<link type="image/x-icon" rel="shortcut icon" href="<%=basePath%>/img/bitbug_favicon.ico" />

</head>
<body>
	<div id="all">
		<input type="hidden" flag="${flag}" id="info" />
		<div class="title">铁路信息化服务管理系统
			<h5> 
				<span id="version" >${version}</span>   
			</h5>
		</div>
		<br />
		<div id="loginarea">
			<form class="form-horizontal" action="user/login" method="post" id="form" >
				<div class="form-group">
					<label class="col-sm-2 control-label" for="name">姓名</label>
					<div class="col-sm-10">
						<input placeholder="请输入姓名" class="form-control" id="username" name="username" type="test" onchange="$('#name').css({'border-color':'#ccc','focus':'blue'})">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="pwd">密码</label>
					<div class="col-sm-10">
						<input placeholder="密码为六位数字" class="form-control" id="password" name="password" type="password" onchange="$('#pwd').css({'border-color':'#ccc','focus':'blue'})">
					</div>
				</div>
				<div class="form-group" id="login">
					<input class="btn btn-primary" id="loginbtn" type="button" value="登录" />
				</div>
			</form>
			<div>
				<img class="img-responsive" src="<%=basePath%>img/logo.png" />
			</div>
		</div>
	</div>
</body>
</html>