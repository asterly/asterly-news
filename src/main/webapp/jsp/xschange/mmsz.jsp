<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
	<base href="<%=basePath %>">
    <title>My JSP 'sy.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="assets/css/custom.css">
	<link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css" />	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/mmsz.css">
	<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico" type="image/x-icon" />

  </head>
  
  <body>
     <div id="all">
  		<div id="loginarea">
  			
	    	<form class="form-horizontal" action="" method="post" id="form">
	    		<div class="page-header">
				  <h1>修改用户密码 <small>请确认输入</small></h1>
				</div>
	    		<div class="form-group">
	    			<label class="col-sm-3 control-label" for="name">旧密码：</label>
	    			<div class="col-sm-9"><input placeholder="请输入旧密码(6位数字)" class="form-control" id="opwd" name="opwd" type="text" ></div>
	    		</div>
	    		<div class="form-group">
	    			<label class="col-sm-3 control-label" for="pwd">新密码：</label>
	    			<div class="col-sm-9"><input placeholder="请输入新密码(6位数字)" class="form-control" id="npwd" name="npwd" type="password" ></div>
	    		</div>
	    		<div class="form-group">
	    			<label class="col-sm-3 control-label" for="pwd">再次输入：</label>
	    			<div class="col-sm-9"><input placeholder="请输入新密码(6位数字)" class="form-control" id="zpwd" name="zpwd" type="password" ></div>
	    		</div>
	    		<div class="form-group" id="login">
	    			<input style="margin-right:20px" class="btn btn-primary btn-sm" id="ybtn" type="button" value="确认"/>
	    			<input class="btn btn-danger btn-sm" id="nbtn" type="button" value="取消"/>
	    		</div>
	    	</form>
    </div>
 	</div>
	<script type="text/javascript" src="assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="assets/layer/layer.js"></script>
	<script type="text/javascript" src="js/xschange/mmsz.js"></script>
	<script type="text/javascript">
	</script> 
  </body>
</html>
