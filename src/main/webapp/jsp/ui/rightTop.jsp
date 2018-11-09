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

<script src=" assets/js/jquery-3.2.1.min.js"></script>
<script src=" assets/js/jquery-3.2.1.js"></script>
<script src=" assets/js/bootstrap.min.js"></script>
<script src=" js/right.js"></script>
<link rel="stylesheet" href=" css/ui/right.css">
<link rel="stylesheet" href=" css/bootstrap.min.css">
<link rel="stylesheet" href=" css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href=" css/htmleaf-demo.css">
<link rel="stylesheet" href=" assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href=" assets/css/custom.css">
<link rel="stylesheet" href=" css/xschange.css">
<link rel="shortcut icon" href=" assets/img/bitbug_favicon.ico" type="image/x-icon" />
<style>
body {
	overflow-x: hidden;
	overflow-y: hidden;
	/*  display:inline; 
 	text-align:center; */
	border-bottom: 1px solid #ddd;
}

#rightmitop {
	width: 100%;
	color: #333;
	height: 20px;
	margin: 15px 0 0 0;
}
</style>
</head>

<body>
	<main id="" class=""> <!--中部右侧 -->
	<div id="rightmitop">
		<div id="syrightmitop" class="">
			<form method="POST" class="form-horizontal" role="form" name="form"
				id="form">
				<div id="toolbox" style="font-weight: 700;">
					<!-- 行业 -->
					<div id="row1" class="row">
						<div id="togcssl" class="col-sm-4">
							<div class="form-group">
								<label for="" class="col-sm-6 control-label">行业:</label>
								<div class="col-sm-6">
									<select id="hy" class="form-control" name="hy">
										<option>请选择</option>
									</select> <span id="span">*</span>
								</div>
							</div>
						</div>
						<div id="togcssc" class="col-sm-4">
							<div class="form-group">
								<label for="" class="col-sm-6 control-label">专业:</label>
								<div class="col-sm-6">
									<select id="zy" class="form-control" name="zy">
										<option>请选择</option>
									</select> <span id="span">*</span>
								</div>
							</div>
						</div>
						<div id="togcssr" class="col-sm-4">
							<div class="form-group">
								<label for="sjdwadd" class="col-sm-6 control-label">软件名称:</label>
								<div class="col-sm-6">
									<select id="rjmc" class="form-control" name="rjmc">
										<option>请选择</option>
									</select> <span id="span">*</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	</main>
</body>
</html>
