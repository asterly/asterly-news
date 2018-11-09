<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath %>">
    <title>软件注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="css/multiselect.css">
	<link href="assets/js/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="assets/css/custom.css">
	<link rel="stylesheet" href="css/xschange.css">
	<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico" type="image/x-icon" />

<script type="text/javascript">
	
	
</script>
</head>
  
  <body>
  	<main id="content-wrapper" class="page-wrapper">
			<!--中部右侧 -->
			<div id="right">
				<!--软件安装-->
				<div class="xschange" id="rjzc">
					<!-- <form   id="form" class="form-horizontal"  role="form" action="/swsrv1/SoftWareService/registerServlet" method="POST"> -->
					<form   id="form"  name="form" class="form-horizontal"  role="form"  method="POST">
						<div class="row">
							<div id="rjzcl" class="col-sm-6">
								<div class="form-group" >
									<label for="" class="col-sm-3 control-label">行业:</label>
									<div class="col-sm-7">
										<select id="hy" name="hy" class="form-control"  required onchange="">
											<option value="">请选择</option>
										</select>
									</div><span style="color:gray">*</span>
								</div>
							</div>
							<div id="rjzcr" class="col-sm-6">
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">专业:</label>
									<div class="col-sm-7">
										<select id="zy" name="zy" class="form-control" required  onchange="$('#zy').css({'border-color':'#ccc','focus':'blue'})">
											<option value="">请选择</option>
										</select>
									</div><span style="color:gray">*</span>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div id="rjzcl" class="col-sm-6">
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">软件名称:</label>
									<div class="col-sm-7" >
										<input type="text" id="rjmc" name="rjmc" class="form-control" required  onchange="$('#rjmc').css({'border-color':'#ccc','focus':'blue'})">
									</div><span style="color:gray">*</span>
								</div>
							</div>
							<div id="rjzcr" class="col-sm-6">
								<div class="form-group">
									<label for="" class="col-sm-3 control-label">使用级别:</label>
									<div class="col-sm-7" >
										<select id="syjb" name="syjb" class="form-control"  multiple="multiple" size="1">
											
										</select>
										
									</div>
								</div>
							</div>

						</div>
						
						<div class="row">
							<div id="rjzcl" class="col-sm-6">
						    	<div class="form-group">
									<label for="" class="col-sm-3 control-label">端类别:</label>
									<div class="col-sm-7">
										<select id="dlb" name="dlb" class="form-control" required  onchange="$('#dlb').css({'border-color':'#ccc','focus':'blue'})">
										    <option value="" selected="selected">请选择</option>
										    <option value="0">服务端</option>
										    <option value="1">客户端</option>
										</select>					
							   		</div><span style="color:gray">*</span>
								</div>
							</div>
							<div id="rjzcr" class="col-sm-6">
						    	<div class="form-group">
									<label for="" class="col-sm-3 control-label">项目名:</label>
									<div class="col-sm-7">
										<input type="text" id="xmm" name="xmm" class="form-control" onchange="$('#xmm').css({'border-color':'#ccc','focus':'blue'})">
									</div><span id="xmmc" style="color:gray;display:none">*</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-sm-2 control-label">软件说明:</label>
							<div class="col-sm-9">
							<textarea id="rjsm" name="rjsm" class="form-control" rows="6" placeholder="请保证字数不超过1000字"></textarea>
							</div>
						</div>
						<button id="btn0" type="button" class="btn btn-primary btn-sm">提交</button>
						<button id="btnrn" type="button" class="btn btn-primary btn-sm" style="float:left;margin:30px 10%">返回上一页</button>
					</form>
					
				</div>
			</div>
		</main>
		
	<script src="assets/js/jquery-3.2.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/xschange/rjzc.js"></script>
	<script src="assets/js/jquery-confirm/jquery-confirm.min.js"></script>
	<script src="assets/js/multiselect.js"></script>
  </body>
</html>
