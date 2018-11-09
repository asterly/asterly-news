<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件安装</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/jquery-3.2.1.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/xschange/rjaz.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>
<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
<link rel="stylesheet"
	href="../../assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="../../assets/css/custom.css">
<link rel="stylesheet" href="../../css/xschange.css">
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico"
	type="image/x-icon" />

<script type="text/javascript">
window.onload = yu("A00");//上级单位查询
	function yu(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryData/queryDataservlect",
			data : {
				"operator1" : operator1
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					if ("请选择" == tljArray[1]) {
						tljSelectStr = tljSelectStr + "<option value='0'>"
								+ tljArray[1] + "</option>";
					} else {
						tljSelectStr = tljSelectStr
								+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
								+ "</option>";
					}
				}
				$("#sjdw").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
	}
		 //...............................................................................................................................
	function queryduanlba() {
		var option1 = $("#hy option:selected"); //获取选中的项
		var option2 = $("#zy option:selected");
		var option3 = $("#rjmc option:selected");
		queryduanlb("端类别", option1.text(), option2.text(), option3.text());
		$("#rjmc").css({
			"border-color" : "#ccc",
			"focus" : "blue"
		})
	}

	function queryduanlb(operator1, hy, zy, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				if (tlj == "1") {  //服务端 是0， 客户端是 1  数据库也是 0  1
					$('#azljs').css("display", "block");
				} else if (tlj == "0") {
					$('#azljs').css("display", "none");
				}
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});

	}
</script>
</head>

<body>
	<main id="content-wrapper" class="page-wrapper"> <!--中部右侧 -->
	<div id="right">
		<!--软件安装-->
		<div class="xschange" id="rjzc">
			<form id="fbody" name="fbody" class="form-horizontal" role="form"
				method="POST">
				<div class="row">
					<div id="rjzcl" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">行业:</label>
							<div class="col-sm-7">
								<select id="hy" name="hy" class="form-control" required
									onchange="$('#hy').css({'border-color':'#ccc','focus':'blue'})">
									<option value="">请选择</option>
								</select>
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>
					<div id="rjzcr" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">专业:</label>
							<div class="col-sm-7">
								<select id="zy" name="zy" class="form-control" required
									onchange="$('#zy').css({'border-color':'#ccc','focus':'blue'})">
									<option value="">请选择</option>

								</select>
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="" class="col-sm-2 control-label">软件名称:</label>
					<div class="col-sm-9">
						<select id="rjmc" name="rjmc" class="form-control"  required>
							<option value="">请选择</option>
						</select>
					</div>
					<span style="color: gray">*</span>
				</div>

				<div class="form-group">
					<label for="" class="col-sm-2 control-label">版本号:</label>
					<div class="col-sm-9">
						<input id="bbh" name="bbh" class="form-control" required
							placeholder="如：1.00.00"
							onchange="$('#bbh').css({'border-color':'#ccc','focus':'blue'})">
					</div>
					<span style="color: gray">*</span>
				</div>

				<div class="form-group">
					<label for="" class="col-sm-2 control-label">上级单位:</label>
					<div class="col-sm-9">
						<input type="text" id="sjdwinput" name="sjdwinput" class="form-control"/>
						<select id="sjdw" class="form-control" name="sjdw">
							<option value="0">请选择</option>
						</select>

					</div>
					<!-- <span id="sjdws" style="color: gray; display: none">*</span> -->
				</div>
				<div class="row">
					<div id="rjzcl" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">单位名称:</label>
							<div class="col-sm-7">
								<input id="dwmcinput" name="dwmcinput" class="form-control" required onclick="$('#dwmcinput').css({'border-color':'#ccc','focus':'blue'});$('#dwmc').css({'border-color':'#ccc','focus':'blue'});" />
								<select id="dwmc" class="form-control" name="dwmc" onclick="$('#dwmcinput').css({'border-color':'#ccc','focus':'blue'});$('#dwmc').css({'border-color':'#ccc','focus':'blue'});">
									<option value="0">请选择</option>
									<option >中国铁路总公司</option>
								</select>
								<!-- <input name="tljinput" id="tljinput"  onclick="$('#tljinput').css({'border-color':'#ccc','focus':'blue'});$('#tlj').css({'border-color':'#ccc','focus':'blue'});"/>
								<select id="tlj" class="form-control" name="tlj" >
									<option value="0">请选择</option>
								</select> -->
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>

					<div id="rjzcr" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">单位级别:</label>
							<div class="col-sm-7">
								<input type="text" id="dwjbinput" name="dwjbinput" class="form-control"/>
								<select id="dwjb" name="dwjb" class="form-control"
									onchange="$('#dwjb').css({'border-color':'#ccc','focus':'blue'})">
									<option value="0">请选择</option>
									<!-- <option value="1">铁总</option>
									<option value="2">路局</option>
									<option value="3">段</option>
									<option value="4">车间</option>
									<option value="5">工区</option>
									<option value="6">个人</option>
									<option value="7">其他</option> -->
								</select>
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div id="rjzcl" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">服务器IP:</label>
							<div class="col-sm-7">
								<input id="fwip" name="fwip" class="form-control"
									onchange="$('#fwip').css({'border-color':'#ccc','focus':'blue'})">
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>

					<div id="rjzcr" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">服务端口:</label>
							<div class="col-sm-7">
								<input id="fwdk" name="fwdk" class="form-control"
									placeholder="请填写数字"
									onchange="$('#fwdk').css({'border-color':'#ccc','focus':'blue'})">
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>

				</div>

				<div class="form-group">
					<label for="" class="col-sm-2 control-label">安装路径:</label>
					<div class="col-sm-9">
						<input id="azlj" name="azlj" class="form-control" required
							placeholder="请填写绝对路径,格式如: C:\Program Files\works"
							onchange="$('#azlj').css({'border-color':'#ccc','focus':'blue'})">
					</div>
					<span id="azljs" style="color: gray; display: none">*</span>
				</div>

				<div class="row">
					<div id="rjzcl" class="col-sm-6">
						<div class="form-group">
							<label for="" class="col-sm-3 control-label">安装日期:</label>
							<div class="col-sm-7">
								<input name="azrq" id="azrq" class="form-control" type="date"
									required
									onchange="$('#azrq').css({'border-color':'#ccc','focus':'blue'})">
							</div>
							<span style="color: gray">*</span>
						</div>
					</div>

					<div id="rjzcr" class="col-sm-6">
						<div class="form-group" sm>
							<label for="" class="col-sm-3 control-label">安装人:</label>
							<div class="col-sm-7">
								<input id="azr" name="azr" type="text" class="form-control">
							</div>
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="" class="col-sm-2 control-label">备注:</label>
					<div class="col-sm-9">
						<textarea id="bz" name="bz" class="form-control" rows="6"
							placeholder="请保证字数不超过1000字"></textarea>
					</div>
				</div>

				<button id="btn0" type="button" class="btn btn-primary btn-sm">提交</button>
				<button id="btnrn" type="button" class="btn btn-primary btn-sm" style="float:left;margin:30px 10%">返回上一页</button>
			</form>
		</div>
		<!--隐藏域 提交成功-->
	</div>
	</main>
</body>
</html>
