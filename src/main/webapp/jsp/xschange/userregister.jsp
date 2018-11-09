<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath %>">
<title>软件记录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" type="text/css" href="css/xschange.css">
<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico"type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/xtsz/userregister.css">
</head>

<body>

	<div id="right">
		<!--工程实施 -->
		<div class="xschange" id="yhzc">
			<!-- 查询按钮 -->
			<div id="btns">
				<input type="button" class="btn btn-primary btn-sm" id="selectadd" value="添加"  />
				<input type="button" class="btn btn-primary btn-sm" id="selectxg" value="修改" />
				<input type="button" class="btn btn-primary btn-sm" id="selectde" value="删除" />		
			</div>
			
			<div>
			  <!-- Nav tabs -->
			  <ul class="nav nav-tabs" role="tablist">
			    <li role="presentation" class="active"><a href="#userlist" aria-controls="home" role="tab" data-toggle="tab">用户信息</a></li>
			    <li role="presentation"><a href="#adduser" aria-controls="adduser" role="tab" data-toggle="tab">添加用户</a></li>
			    <li role="presentation"><a href="#edituser" aria-controls="messages" role="tab" data-toggle="tab">修改</a></li>
			    
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div role="tabpanel" class="tab-pane active" id="userlist">
			    	<table id="tab" class="table table-bordered table-hover">
					<thead style="background: #ADD8E6;">
						<tr>
							<th width="4%"><input type="checkbox" id="checkall" /></th>
							<th width="6%">序号</th>
							<th width="8%">部门</th>
							<th width="8%">姓名</th>
							<th width="12%">邮箱</th>
							<th width="12%">手机号</th>
							<th width="10%">密码</th>
							<th width="20%">权限</th>
							<th width="20%">是否编辑</th>
						</tr>
					</thead>
					<tbody id="tbody-userlist">
					</tbody>
				</table>
			    </div>
			    
			    <div role="tabpanel" class="tab-pane" id="adduser">
						<h4 align="center">用户信息</h4>
		 				<form method="POST" class="form-horizontal" action="user/adduser" role="form" name="form"id="form" enctype="multipart/form-data">
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">员工编号</label>
								<div class="col-sm-3">
									<input name="userID" id="userid" class="form-control" />
									<span id="span">*</span>
								</div>
								<label for="" class="col-sm-2 control-label">姓名:</label>
								<div class="col-sm-3">
									<input name="username" id="username" class="form-control" />
									<span id="span">*</span>
								</div>
							</div>
							
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">邮箱:</label>
								<div class="col-sm-3">
									<input name="email" id="email" class="form-control"  />
									<span id="span">*</span>
								</div>
								<label for="" class="col-sm-2 control-label">手机号:</label>
								<div class="col-sm-3">
									<input name="tel" id="tel" class="form-control" />
									<span id="span">*</span>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">初始密码:</label>
								<div class="col-sm-3">
									<input name="password" id="password" class="form-control" type="password" />
									<span id="span">*</span>
								</div>
								<label for="" class="col-sm-2 control-label">是否可编辑:</label>
								<div class="col-sm-3">
									<select id="isedit" class="form-control" name="iseidt">
										<option value="1">可编辑</option>
										<option  value="0">不可编辑</option>
									</select> <span id="span">*</span>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">权限:</label>
								<div class="col-sm-3">
									<select id="bmadd" class="form-control" name="power">
										<option value="注册管理">注册管理</option>
										<option  value="软件管理">软件管理</option>
										<option value="工程服务">工程服务</option>
									</select> <span id="span">*</span>
								</div>
								<label for="" class="col-sm-2 control-label">部门:</label>
								<div class="col-sm-3">
									<select id="department" class="form-control" name="department">
										<option>请选择</option>
										<option>领导</option>
										<option>管理人员</option>
										<option>工程服务</option>
										<option>其他</option>
									</select> <span id="span">*</span>
								</div>
							</div>
		
							<div class="col-sm-6 col-sm-offset-3">
								<button id="btn-submit" type="submit" class="btn btn-success  form-control col-md-6">提交</button>
							</div>
						</form>
			    </div>
			    <div role="tabpanel" class="tab-pane" id="edituser">
			    	
			    </div>
			  </div>
			
			</div>
			
		</div>
	</div>
	
	<script type="text/javascript" src="assets/js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/layer/layer.js"></script>
	<script type="text/javascript" src="assets/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="assets/bootstrapvalidator/js/language/zh_CN.js"></script>
	<script type="text/javascript" src="jsp/xschange/xschangejs/userregister.js"></script>
	<script>
		$(function(){
// 			$("#btn-submit").click(function(){
// 				layer.confirm('确定提交吗！', {icon: 3, title:'提示'}, function(index){
// 					  //do something
					  
// 					  layer.msg("开始提交数据");
// 					});
// 			})
	
		})
	</script>
</body>
</html>
