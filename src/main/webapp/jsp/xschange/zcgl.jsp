<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath %>>">
    <title>注册记录</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="assets/js/jquery-3.2.1.min.js"></script>
	<script src="assets/js/jquery-3.2.1.js"></script>
  	<script src="assets/js/xschange/zcgl.js"></script> 	
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/xschange.js"></script>
	<script src="js/xschange/zcgl.js"></script>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="assets/css/custom.css">
	<link rel="stylesheet" href="css/xschange.css">
	<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico" type="image/x-icon" />
<style type="text/css">
 .gljlr{
	width:90%; 
	float:right;
	position:relative;
	top:-15px;
}
</style>
<script type="text/javascript">
if(window.parent.right.rows == "0,*"){  
    top.right.rows = "70,*";  
}	

</script>
</head>
  <body>
       	<main id="content-wrapper" class="page-wrapper">
			<!--中部右侧 -->
			<div id="right">
				<!--注册管理记录-->
				<div class="xschange" id="rjgl">
					<form   class="form-horizontal"  role="form" action="" method="POST">
						<div id="toolbox1">
							<div class="gljlr">
								<div id="btns">
										<input type="button" class="btn btn-primary btn-sm" id="add" value="添加" />
										<input type="button" class="btn btn-primary btn-sm" id="update" value="修改"/>
										<input type="button" class="btn btn-primary btn-sm" id="delete" value="删除"/>
										<input type="button" class="btn btn-primary btn-sm" id="btnExport" onclick="educe()" value="导出"/>
										
								</div>	
							</div>			
						</div>
					</form>
					<!-- 表格#b9b9b9 -->
					<div id="tab0">
						<form   class="form-horizontal"  role="form" action="" method="POST">
							<table id="tableid">
							<thead bgcolor="#ADD8E6">
								<tr>
									<th id="state" width="2%"><input type="checkbox" id="checkall" checked=""/></th>
									<th width="4%">序号</th>
									<th width="8%">行业</th>
									<th width="8%">专业</th>
									<th width="20%">软件名称</th>
									<th width="10%">使用级别</th>
									<th width="10%">端类别</th>
									<th width="15%">项目名</th>
									<th width="25%">软件说明</th>
								</tr>
							</thead>
							<tbody id="tbody0"></tbody>
						</table>
						</form>
						<form id="barcon" style="margin-top:30px;margin-bottom:20px;" >
						</form>
					</div>		
				</div>
			</div>
		</main>
  </body>
</html>
