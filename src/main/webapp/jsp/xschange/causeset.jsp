<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
	<base href="<%=basePath %>">
    <title>原因设置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="assets/css/custom.css">
	<script src="assets/js/jquery-3.2.1.min.js"></script>
	<script src="assets/js/jquery-3.2.1.js"></script>
  	<script src="assets/js/xschange/cause.js"></script> 	
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery-confirm/jquery-confirm.min.js"></script>
	

	<link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css" />	
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<link rel="stylesheet" href="css/causeset.css">

	<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico" type="image/x-icon" />
		<style>
		#span{
			position:absolute;
			right:-20px;
			top:5px;
		}
	</style>
<script type="text/javascript">
	window.onload = causequery();
	function causequery() {
		cause("原因设置查询");
	}
	function cause(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
			},
			dataType : 'json',
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody2');
				var TabJsonResult = "";
				for (var i = 0; i < tlj[0].length; i++) {
					for (var j = 0; j < tlj.length; j++) {
						if (j == 0) {
							TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' id =\"checkchoose\"/></td>"; //tr
						} else {
							TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
						}
					}
					TabJsonResult += "</tr>"; //tr
				}
				a.innerHTML = TabJsonResult;
			},
			error : function(errorMsg) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	}

	function causecharu() {
		var causetj = $("#causetj").val();
		 if(causetj =="" || causetj == undefined){
			$.alert("请输入原因类型！");
			$("#causetj").css("border","1px solid red");
			return false;
		}else {
			var option1 = $('#causetj').val();
			causecr("原因类型添加", option1);
		}
	}
	function causecr(operator1, causetj) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"causetj" : causetj,
			},
			dataType : 'json',
			success : function(response) {
				
				if (response == "插入不成功") {
					$.alert("添加失败，请重新添加！", "提示");
				} else if (response == "已存在") {
					$.alert("当前原因类型已存在，请重新添加！", "提示");
				} else {
					
			        $("#causetj").val("");
			        $.alert("添加成功", "提示");
					tlj = response;
					var a = document.getElementById('tbody2');
					var TabJsonResult = "";
					for (var i = 0; i < tlj[0].length; i++) {
						for (var j = 0; j < tlj.length; j++) {
							if (j == 0) {
								TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' id =\"checkchoose\"/></td>"; //tr
							} else {
								TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
							}
						}
						TabJsonResult += "</tr>"; //tr
					}
					a.innerHTML = TabJsonResult;
					
				}

			},
			error : function(response) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	}
</script>
</head>
  <body>
     <div id="all">
  		<div class="title">软件问题原因添加</div>
  			<!-- <span id="jj11" style="margin-right:10px;"><input
				type="button" class="btn btn-primary btn-sm" id="selectcg"
				value="修改" /></span>
			<span id="jj11"><input
				type="button" class="btn btn-primary btn-sm" id="selectde"
				value="删除" /></span> -->
				
				
  		
  		<br/>
  		
  		<div id="cause-table" class="cause-table">
			<table id="tab" class="">
				 <thead style="background:#ADD8E6;">
					<tr>
						<th id="state" width="5%" height="10px"><input type="checkbox" id="checkall"/></th>
						<th width="10%;">序号</th>								  
						<th width="40%;">原因</th>
						<th width="10%;">编辑</th>
					</tr>
				</thead>
				<tbody id="tbody2">
					<tr>
						<td>
							<input type="checkbox" id="checkids"/>
						</td>
					
						<td>lallal</td>
						<td>llalallal</td>
						<td>
							<div >
								<input type="button" class="btn btn-primary btn-sm" id="selectcg" value="修改" />
								<input type="button" class="btn btn-danger btn-sm" id="causede" value="删除"/>
							</div>
						</td>
					</tr>
				</tbody>
  			</table>
  		</div>
  		<div id="loginarea">
	    	<form class="form-horizontal" action="" method="post" id="form">
	    		<div class="form-group">
	    			<label class="col-sm-3 control-label" for="cause">原因类型：</label>
	    			<div class="col-sm-9">
	    				<input placeholder="" class="form-control" id="causetj" name="causetj" type="text">
	    				<span id="span">*</span>
	    			</div>	    			
	    		</div>
	    		
	    		<div class="form-group" id="login">
	    			<input style="margin-right:40px" class="btn btn-primary btn-sm" id="ywbtn" type="button" onclick="causecharu()" value="确认"/>
	    			<input class="btn btn-primary btn-sm" id="nwbtn" type="button" value="取消"/>
	    		</div>
	    	</form>
	    </div>
    </div>
  </body>
</html>
