<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" href="../../assets/css/custom.css">
<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/jquery-3.2.1.js"></script>
<script src="../../assets/js/xschange/functionset.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>
<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../../assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
<link rel="stylesheet" href="../../css/jdsz.css">
<link href="../../css/common.css" type="text/css" rel="stylesheet" />
<link href="../../css/index.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico"
	type="image/x-icon" />
	<link href="../../css/functionset.css" type="text/css" rel="stylesheet" />


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
				$("#rjmc").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}
	
	//
	function functionClick() {
		var function1 = $("#function1").val();//功能 的名字
		var hy = $("#hy option:selected");
		var zy = $("#zy option:selected"); //获取选中的项
		var rjmc = $("#rjmc option:selected");
		if ($("#hy").val() == "请选择" || $("#hy").val() == "" || $("#hy").val() == undefined || $("#hy").val() == null) {
			$.alert("请选择行业！");
			$("#hy").css("border", "1px solid red");
			return false;
		} else if ($("#zy").val() == "请选择" || $("#zy").val() == "" || $("#zy").val() == undefined || $("#zy").val() == null) {
			$.alert("请选择专业！");
			$("#zy").css("border", "1px solid red");
			return false;
		} else if ($("#rjmc").val() == "请选择" || $("#rjmc").val() == "" || $("#rjmc").val() == undefined || $("#rjmc").val() == null) {
			$.alert("请选择软件！");
			$("#rjmc").css("border", "1px solid red");
			return false;
		} else if (function1 == "" || function1 == undefined || function1 == null) {
				$.alert("请选择输入功能！");

		} else{
			functionAdd("功能设置添加",function1,hy.val(),zy.val(),rjmc.val());
			//functionquery("功能设置查询", hy.text(), zy.text(), rjmc.text());
		}
	}
	
	function functionAdd(operator1, function1,  hy, zy, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", 
			data : {
				"operator1" : operator1,
				"function1" : function1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc
			},
			dataType : 'json',
			success : function(response) {
				
				if (response == "添加失败") {
					$.alert("添加失败，请重新添加");	
				} else if (response == "已存在") {
					$.alert("当前选项已存在，请勿重复添加！");
				} else {
					 $("#function1").val("");
					 $.alert("添加成功");
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
				}
			},
			error : function(errorMsg) {
				/* alert("请求数据失败!" + errorMsg); */
			}
		});
	}


	function functionquery(operator1, hy, zy, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc
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
		var rjmc = $("#rjmc option:selected");
		functionquery("功能设置查询", hy.text(), zy.text(), rjmc.text());
		$('#rjmc').css({
			'border-color' : '#ccc',
			'focus' : 'blue'
		});
	}
	function nwbtn() {
		$("#function").val("");
	}
</script>
</head>
<body>
	<div id="all">
		<div class="title">软件功能设置</div>
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
					<select id="rjmc" class="selectway" name="rjmc"
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
				type="button" class="btn btn-primary btn-sm" id="selectde"
				value="删除" /></span>
			<!-- <div id="btns">
				<input type="button" class="btn btn-primary btn-sm" id="selectcg" value="修改" />
				<input type="button" class="btn btn-primary btn-sm" id="selectde" value="删除" />
			</div> -->
		</div>
		<div id="tab1">
			<table id="tab">
				<thead style="background:#ADD8E6;">
					<tr>
						<th id="state" width="2%"><input type="checkbox"
							id="checkall" /></th>
						<th width="2%;">序号</th>
						<th width="15%;">功能</th>
					</tr>
				</thead>
				<tbody id="tbody2">
					<tr>
						<td id="jieduan1"><input type="checkbox" id="checkbox" /></td><td>1</td><td> </td>
					</tr>
					<tr>
						<td id="jieduan2"><input type="checkbox" id="checkbox" /></td><td>2</td><td> </td>
					</tr>
					<tr>
						<td id="jieduan3"><input type="checkbox" id="checkbox" /></td><td>3</td><td> </td>
					</tr>
					<tr>
						<td id="jieduan4"><input type="checkbox" id="checkbox" /></td><td>4</td><td> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="loginarea">
			<form class="form-horizontal" action="" method="post" id="form">
				<div class="form-group">
					<label for="" class="col-sm-3 control-label">功能:</label>
					<div class="col-sm-7">
						<input id="function1" class="form-control" name="function1"
							onchange="$('#function1').css({'border-color':'#ccc','focus':'blue'});" />
						<span id="span">*</span>
					</div>
				</div>
			</form>


			<div class="form-group" id="login">
				<input style="margin-right:60px" class="btn btn-primary btn-sm" id="ywbtn" type="button" value="添加" onclick="functionClick();" />
				<input style="margin-right:0px" class="btn btn-primary btn-sm" id="nwbtn" type="button" value="取消" onclick="nwbtn();" />
			</div>
		</div>
	</div>
	<div class="modal" id="modal" style="display:none">
		<div class="modal-dialog">
			<div class="close">×</div>
			<div class="modal-content">
				<h4 align="center" style="margin: 20px;">修改功能名称</h4>
				<form method="POST" class="form-horizontal" role="form" name="form"
					id="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">功能:</label>
						<div class="col-sm-7">
							<input id="functionxg" class="form-control" name="functionxg"
								onchange="$('#functionxg').css({'border-color':'#ccc','focus':'blue'});" />
							<span id="span">*</span>
						</div>
					</div>
					<button id="btn4" type="button" class="btn btn-primary btn-sm">修改提交</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
