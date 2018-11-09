<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath %>">
<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="assets/layui/css/layui.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jdsz.css">
<link rel="shortcut icon" href="assets/img/bitbug_favicon.ico"
	type="image/x-icon" />

<script type="text/javascript">

	window.onload = queryDataHy("查询行业", "H0000");
	function queryDataHy(operator1, hangye) {
		//行业
		var hangye = "H0000";
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {

				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					tljSelectStr = tljSelectStr + "<option id='" + tljArray[0] + "'>" + tljArray[1] + "</option>"
				}
				$("#hy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}
	function zhuanye() {
		var option1 = $("#hy option:selected"); //获取选中的项
		zhuanyeAjax("查询专业", option1.attr("id"));
		$("#zy").val("请选择");
		$("#rjmc").val("请选择");
		$('#hy').css({
			'border-color' : '#ccc',
			'focus' : 'blue'
		});
	}
	function zhuanyeAjax(operator1, zhuanye) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"zhuanye" : zhuanye
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					tljSelectStr = tljSelectStr + "<option id='" + tljArray[0] + "'>" + tljArray[1] + "</option>"
				}
				$("#zy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}

	function getSolfname() {
		var option1 = $("#hy option:selected");
		var option2 = $("#zy option:selected"); //获取选中的项
		$('#zy').css({
			'border-color' : '#ccc',
			'focus' : 'blue'
		});
		getSolfnameAjax("软件名称", option1.text(), option2.text());
	}
	function getSolfnameAjax(operator1, hangye, zhuanye) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					tljSelectStr = tljSelectStr + "<option id='" + tljArray[0] + "'>" + tljArray[1] + "</option>"
				}
				$("#rjxt").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}
	//阶段进度开始
	function jieduanAddClick() {
		var jdmc = $("#jdmc").val();
		var gcjd = document.getElementById('gcjd').value;
		var fzr = $("#fzr").val();
		var hy = $("#hy option:selected");
		var zy = $("#zy option:selected"); //获取选中的项

		var rjxt = $("#rjxt option:selected");
		if ($("#hy").val() == "请选择" || $("#hy").val() == "" || $("#hy").val() == undefined || $("#hy").val() == null) {
			$.alert("请选择行业！");
			$("#hy").css("border", "1px solid red");
			return false;
		} else if ($("#zy").val() == "请选择" || $("#zy").val() == "" || $("#zy").val() == undefined || $("#zy").val() == null) {
			$.alert("请选择专业！");
			$("#zy").css("border", "1px solid red");
			return false;
		} else if ($("#rjxt").val() == "请选择" || $("#rjxt").val() == "" || $("#rjxt").val() == undefined || $("#rjxt").val() == null) {
			$.alert("请选择软件！");
			$("#rjxt").css("border", "1px solid red");
			return false;
		} else {
			if (jdmc == "" || jdmc == 0 || jdmc == undefined || jdmc == null) {
				if (gcjd = "" || gcjd == null || gcjd == 0 || gcjd == undefined || gcjd == "请选择") {
					$.alert("请选择工程阶段!");
					$("#gcjd").css("border", "1px solid red");
				} else {
					$.alert("请输入阶段名称!");
					$("#jdmc").css("border", "1px solid red");

				}

			} else {
				jieduanAdd("软件安装阶段添加", gcjd, jdmc, fzr, hy.text(), zy.text(), rjxt.text());

				jieduanquery("软件安装阶段查询", hy.text(), zy.text(), rjxt.text());

			}
		}

	}
	function jieduanAdd(operator1, gcjd, jdmc, fzr, hangye, zhuanye, rjxt) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"gcjd" : gcjd,
				"jdmc" : jdmc,
				"fzr" : fzr,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjxt" : rjxt
			},
			dataType : 'json',
			success : function(response) {
				if (response == "1") {
					  $("#fzr").val("");
					  $("#jdmc").val("");
					$.alert("添加成功");
					
					var hy = $("#hy option:selected");
					var zy = $("#zy option:selected"); //获取选中的项
					var rjxt = $("#rjxt option:selected");

					jieduanquery("软件安装阶段查询", hy.text(), zy.text(), rjxt.text());
				} else if (response == "2") {
					$.alert("当前选项不能添加！");
				} else {
					$.alert("添加失败");
				}
			//需要加判断结果	
			},
			error : function(errorMsg) {
				/* alert("请求数据失败!" + errorMsg); */
			}
		});
	}


	function jieduanquery(operator1, hangye, zhuanye, rjxt) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjxt" : rjxt
			},
			dataType : 'json',
			success : function(response) {

				tlj = response;
				var a = document.getElementById('tbody2');
				var TabJsonResult = "";
				if (tlj == "") {
					a.innerHTML = TabJsonResult;
				} else {
					for (var i = 0; i < tlj[0].length; i++) {

						for (var j = 0; j < tlj.length; j++) {
							if (j == 0) {
								TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class=\"checkchoose\"/></td>";
							} else {
								TabJsonResult += "<td>" + tlj[j][i] + "</td>";
							}
						}
						TabJsonResult += "</tr>";
					}

					a.innerHTML = TabJsonResult;

				}
			},
			error : function(errorMsg) {
				/* alert("请求数据失败!" + errorMsg); */
			}
		});
	}


	function getunitTable() {
		var hy = $("#hy option:selected");

		var zy = $("#zy option:selected"); //获取选中的项
		var rjxt = $("#rjxt option:selected");
		jieduanquery("软件安装阶段查询", hy.text(), zy.text(), rjxt.text());
		$('#rjxt').css({
			'border-color' : '#ccc',
			'focus' : 'blue'
		});
	}


	function nwbtn() {
		$("#jdmc").val("");
		$("#fzr").val("");
	}
</script>
</head>

<body>

	<div id="all" class="container">

		<div class="title">工程进度名称管理</div>
		<div id="toolbox">
			<div class="selc">
				<span id="slelecthead">行业:</span> <span> <select id="hy"
					class="selectway" name="hy" onchange="zhuanye()">
						<option>请选择</option>
				</select> <span
					style="display:inline-block; width:2px; height:2px; margin-right:25px">*</span>
				</span>
			</div>
			<div class="selc">
				<span id="slelecthead">专业:</span> <span> <select id="zy"
					class="selectway" name="zy" onchange="getSolfname()">
						<option>请选择</option>
				</select> <span
					style="display:inline-block; width:2px; height:2px; margin-right:25px">*</span>
				</span>
			</div>
			<div class="selc">
				<span id="slelecthead">软件:</span> <span style="margin-right:25px;">
					<select id="rjxt" class="selectway" name="rjxt"
					onchange="getunitTable()">
						<option>请选择</option>
				</select> <span
					style="display:inline-block; width:2px; height:2px;">*</span>
				</span>
			</div>
			
			<span id="jj11" style="margin-right:10px;"><input
				type="button" class="btn btn-primary btn-sm" id="selectcg"
				value="修改" /></span>
			<span id="jj11"><input
				type="button" class="btn btn-danger btn-sm" id="selectde"
				value="删除" /></span>
		</div>
		
		<div id="tab" class="tab">
			<table class="table table-bordered table-hover">
				<thead style="background:#ADD8E6;">
					<tr>
						<th id="state" ><input type="checkbox"
							id="checkall" /></th>
						<th >序号</th>
						<th >工程阶段</th>
						<th >工程阶段名称</th>
						<th >负责人</th>
					</tr>
				</thead>
				<tbody id="tbody">
					<tr>
						<td id="jieduan1"><input type="checkbox" id="checkbox" lay-skin="primary" /></td>
						<td>1</td>
						<td>第一阶段</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td id="jieduan2"><input type="checkbox" id="checkbox" lay-skin="primary"/></td>
						<td>2</td>
						<td>第二阶段</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td id="jieduan3"><input type="checkbox" id="checkbox" lay-skin="primary"/></td>
						<td>3</td>
						<td>第三阶段</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td id="jieduan4"><input type="checkbox" id="checkbox" /></td>
						<td>4</td>
						<td>第四阶段</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td id="jieduan5"><input type="checkbox" id="checkbox" /></td>
						<td>5</td>
						<td>第五阶段</td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>

		
		<div id="loginarea">
			<form class="form-horizontal" action="" method="post" id="form">

				<div class="form-group">
					<label for="" class="col-sm-3 control-label">工程阶段:</label>
					<div class="col-sm-7">
						<select class="form-control" id="gcjd" name="gcjd"
							onchange="$('#gcjd').css({'border-color':'#ccc','focus':'blue'});">
							<option value="0">请选择</option>
							<option value="1">第一阶段</option>
							<option value="2">第二阶段</option>
							<option value="3">第三阶段</option>
							<option value="4">第四阶段</option>
							<option value="5">第五阶段</option>
							<option value="6">第六阶段</option>
							<option value="7">第七阶段</option>
							<option value="8">第八阶段</option>
							<option value="9">第九阶段</option>
							<option value="10">第十阶段</option>
						</select>
						<span id="span">*</span>
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-sm-3 control-label">工程阶段名称:</label>
					<div class="col-sm-7">
						<input id="jdmc" class="form-control" name="jdmc"
							onchange="$('#jdmc').css({'border-color':'#ccc','focus':'blue'});" />
						<span id="span">*</span>
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-sm-3 control-label">负责人:</label>
					<div class="col-sm-7">
						<input id="fzr" class="form-control" name="fzr" />

					</div>
				</div>
			</form>


			<div class="form-group" id="login">
				<input style="margin-right:60px" class="btn btn-primary btn-sm"
					id="ywbtn" type="button" value="确认" onclick="jieduanAddClick()" />
				<input style="margin-right:0px" class="btn btn-danger btn-sm"
					id="nwbtn" type="button" value="取消" onclick="nwbtn()" />
			</div>
		</div>
	</div>
	<div class="modal" id="modal" style="display:none">
		<div class="modal-dialog">
			<div class="close">×</div>
			<div class="modal-content">
				<h4 align="center" style="margin: 20px;">修改进度名称</h4>
				<form method="POST" class="form-horizontal" role="form" name="form"
					id="form" enctype="multipart/form-data">

					<div class="form-group">
						<label for="" class="col-sm-3 control-label">工程阶段:</label>
						<div class="col-sm-7">
							<select class="form-control" id="gcjdxg" name="gcjdxg"
								onchange="$('#gcjdxg').css({'border-color':'#ccc','focus':'blue'});">
								<!-- <option value="0">请选择</option>
									<option value="1">第一阶段</option>
									<option value="2">第二阶段</option>
									<option value="3">第三阶段</option>
									<option value="4">第四阶段</option>
									<option value="5">第五阶段</option>
									<option value="6">第六阶段</option>
									<option value="7">第七阶段</option>
									<option value="8">第八阶段</option>
									<option value="9">第九阶段</option>
									<option value="10">第十阶段</option> -->
							</select>
							<span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">工程阶段名称:</label>
						<div class="col-sm-7">
							<input id="jdmcxg" class="form-control" name="jdmcxg"
								onchange="$('#jdmcxg').css({'border-color':'#ccc','focus':'blue'});" />
							<span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">负责人:</label>
						<div class="col-sm-7">
							<input id="fzrxg" class="form-control" name="fzrxg" />

						</div>
					</div>
					<button id="btn4" type="button" class="btn btn-primary btn-sm">修改提交</button>

				</form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="assets/layui/layui.js"></script>
<script type="text/javascript" src="assets/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="assets/js/xschange/jdsz.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-confirm/jquery-confirm.min.js"></script>
</body>
</html>
