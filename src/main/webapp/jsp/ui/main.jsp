<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath %>">
<title >中北信号软件服务系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7/css/bootstrap.min.css">
<link href="css/ui/login.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="<%=basePath%>img/bitbug_favicon.ico" type="image/x-icon" />
</head>
<frameset rows="80,*" cols="*" frameborder="no" border="0" framespacing="0">

	<frame src="jsp/ui/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
	
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0" id="middle">
		
		<frame src="jsp/ui/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
		
		<frameset rows="70,*" cols="*" frameborder="no" border="0" framespacing="0" id="right">
			<frame src="jsp/ui/rightTop.jsp" name="middleTopFrame" id="middleTopFrame" title="middleTopFrame" width="980" />
			<frame src="jsp/ui/right.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
		</frameset>
		
	</frameset>
	
</frameset>
<noframes>
</noframes>
<body>
</body>
</html>