<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>问题记录添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="../../assets/css/custom.css">
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/imgUp.js"></script>
<script src="../../assets/js/xschange/wtjl.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/ajaxfileupload.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>

<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
<link rel="stylesheet" href="../../assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
<link rel="stylesheet" href="../../css/xschange.css">
<link href="../../css/common.css" type="text/css" rel="stylesheet" />
<link href="../../css/index.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico" type="image/x-icon" />
<style>
#span1 {
	display: inline-block;
	width: 2px;
	height: 2px;
	float: right;
	position: relative;
	right: 17.5%;
	top: 5px;
}
</style>
<script type="text/javascript">
	$(window).on('load', function() {
		if (window.parent.right.rows == "70,*") {top.right.rows = "0,*";}
		yu("A00");
		getIPPort("IP端口号获取")
		queryDataHy("查询行业", "H0000")	//行业
		cause("原因设置查询");
	});
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
				var tljArray = "", tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					if ("请选择" == tljArray[1]) {
						tljSelectStr += "<option>" + tljArray[1]
								+ "</option>";
					} else {
						tljSelectStr += "<option id='"+tljArray[0]+"'>"
								+ tljArray[1] + "</option>";
					}
				}
				$("#dwd").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
		
	}
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
					tljSelectStr = tljSelectStr
							+ "<option id='" + tljArray[0] + "'>" + tljArray[1]
							+ "</option>"
				}
				$("#hy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}

	function dianwuduan() {
		var option1 = $("#dwd option:selected"); //获取选中的项
		$("#dwd").css({
			"border-color" : "#ccc",
			"focus" : "blue"
		});
		$('#dwdjinput').css({
			'border-color' : '#ccc',
			'focus' : 'blue'
		});
		if (option1.text() == "中国铁路总公司") {
			yuu(option1.text());
		} else {
			yuu(option1.attr("id"), option1.text());
		}
		$("#tlj").empty();
		$("#cj").empty();
		$("#xm").empty();

	}

	function yuu(operator1, luju) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryData/queryDataservlect",
			data : {
				"operator1" : operator1,
				"luju" : luju
			},
			dataType : 'json', //timeout:3000,
			success : function(response) {
				dwd = response[0];
				var tljArray = "";
				var tljSelectStr = "";
				var option1 = $("#dwd option:selected"); //获取选中的项
				if (option1.text() == "中国铁路总公司") {
					for (var i = 0, len = dwd.length; i < len; i++) {
						tljArray = dwd[i];
						tljSelectStr += "<option id='"+tljArray[0]+"'>" + tljArray[1]+ "</option>";
					}
				} else {
					for (var i = 0, len = dwd.length; i < len; i++) {
						if (i != 1) {
							tljArray = dwd[i];
							tljSelectStr += "<option id='"+tljArray[0]+"'>"+ tljArray[1] + "</option>";
						}
					}
				}
				$("#tlj").html(tljSelectStr);
				cj = response[1];
				var tljArray2 = "";
				var tljSelectStr2 = "";
				for (var i = 0, len = cj.length; i < len; i++) {
					tljArray2 = cj[i];
					tljSelectStr2 = tljSelectStr2
							+ "<option id='"+tljArray2[0]+"'>" + tljArray2[1]
							+ "</option>";
				}
				$("#cj").html(tljSelectStr2);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				//$.alert("请求数据失败，请检查网络设置"); 
			}
		});
	}
	function keshi() {
		var option1 = $("#tlj option:selected"); //获取选中的项
		var option2 = $("#dwd option:selected"); //获取选中的项
		if (option2.text() == "中国铁路总公司") {
			yuuu(option1.attr("id"));
		} else {
			yuuu(option1.text());
		}
		$("#xm").empty();
		//$("#tlj").css({"border-color":"#ccc","focus":"blue"});
	}

	function yuuu(operator1) {
		var option2 = $("#dwd option:selected"); //获取选中的项
		if (option2.text() == "中国铁路总公司") {
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataPerson/queryDataServletPerson",
				data : {
					"operator1" : operator1
				},
				dataType : 'json', //timeout:3000,
				success : function(response) {
					cj = response;
					var tljArray = "";
					var tljSelectStr = "";
					for (var i = 0, len = cj.length; i < len; i++) {
						tljArray = cj[i];
						tljSelectStr = tljSelectStr
								+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
								+ "</option>";
					}
					$("#cj").html(tljSelectStr);
				},
				error : function(errorMsg) {
					//请求失败时执行该函数
					$.alert("请求数据失败，请检查网络设置");
				}
			});
		} else {
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataThere/queryDataServlet",
				data : {
					"operator1" : operator1
				},
				dataType : 'json', //返回数据形式为xml  //timeout:3000,
				success : function(response) {
					cj = response;
					var tljArray = "";
					var tljSelectStr = "";
					for (var i = 0, len = cj.length; i < len; i++) {
						tljArray = cj[i];
						tljSelectStr = tljSelectStr
								+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
								+ "</option>";
					}
					$("#cj").html(tljSelectStr);
				},
				error : function(errorMsg) {
					$.alert("请求数据失败，请检查网络设置");
				}
			});
		}
	}

	//查人员名称 
	function renyuan() {
		var option1 = $("#cj option:selected"); //获取选中的项
		var option4 = $("#dwd option:selected"); //获取选中的项
		var option3 = $("#tlj option:selected");
		yuuuu(option1.attr("id"), option3.text(), option4.text());
		$("#xm").empty();
		$("#cj").css({
			"border-color" : "#ccc",
			"focus" : "blue"
		})
		$('#cjinput').css({
			'border-color' : '#ccc',
			'focus' : 'blue'
		});
	}
	//查人员名称 
	function yuuuu(operator1, duan, tlj) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataPerson/queryDataServletPerson",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"duan" : duan,
				"tlj" : tlj
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				cj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = cj.length; i < len; i++) {
					tljArray = cj[i];
					if ("请选择" == tljArray[1]) {
						tljSelectStr +=  "<option >"+ tljArray[1] + "</option>";
					} else {
						tljSelectStr += "<option id='"+tljArray[0]+"'>" + tljArray[1]+ "</option>";
					}
				}
				$("#xm").html(tljSelectStr);
			},
			error : function(errorMsg) {
				// $.alert("请求数据失败，请检查网络设置");
			}
		});
	}
	function zhuanye() {
		var option1 = $("#hy option:selected"); //获取选中的项
		zhuanyeAjax("查询专业", option1.attr("id"));
		$("#zy").val("请选择");
		$("#rjmc").val("请选择");
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
					tljSelectStr = tljSelectStr+ "<option id='" + tljArray[0] + "'>" + tljArray[1]+ "</option>"
				}
				$("#zy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}

	function getSolfname() {
		var option1 = $("#zy option:selected"); //获取选中的项
		var option2 = $("#hy option:selected");
		getSolfnameAjax("软件名称", option2.text(), option1.text());
	}
	function getSolfnameAjax(operator1, hangye, zhuanye) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye",
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye
			},
			dataType : 'json', //timeout:3000,
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					tljSelectStr = tljSelectStr
							+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
							+ "</option>";
				}
				$("#rjxt").html(tljSelectStr);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	}

	//-------------------------------------------------获取IP地址和端口号------------------------------------------------------	
	var ipPort = "";
	function getIPPort(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye",
			data : {
				"operator1" : operator1
			},
			dataType : 'json', 
			success : function(response) {
				ipPort = response[0];
				ipPort1 = JSON.stringify(ipPort);
			},
			error : function(errorMsg) {
			}
		});
	}

	function inputFileOnChange() {
		var a = document.getElementById("file");
		var len = a.files.length;
		for (var i = 0; i < len; i++) {
			a = a.files[i].name;
		}
		ipPort1 = ipPort1.replace("\"", "");
		ipPort1 = ipPort1.replace("\"", "");
		var dir = "swsrvphoto&filename=" + a;
		$.ajaxFileUpload({
			type : "POST",
			url : "http://" + ipPort1 + "/WebForm1.aspx?dir=" + dir,
			secureuri : false, //是否需要安全协议，一般设置为false
			fileElementId : 'file', //文件上传域的ID
			dataType : 'json', //返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{
				var element = document.getElementById('pic');
				element.src = "http://" + ipPort1 + "/swsrvphoto/" + a;
			},
			error : function(data, status, e) //服务器响应失败处理函数
			{
			}
		})
		return false;
	};
	
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
				tlj = response[2];
				var tljSelectStr = "<option>请选择</option>";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljSelectStr += "<option>" + tlj[i]+ "</option>";
				}
				$("#cause").html(tljSelectStr);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	}
</script>
<body>
	<main id="content-wrapper" class="page-wrapper"> <!--中部右侧 -->
	<div id="right">
		<!--问题记录-->
		<div class="xschange" id="wtjl">
			<form method="POST" class="form-horizontal" role="form" name="form"
				id="form" enctype="multipart/form-data">
				<div id="rightleft">
				
				<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="xjdw">上级单位:</label>
						<div class="col-sm-7">
							<input name="dwdinput" id="dwdinput" readonly="readonly"
								onclick="$('#dwdinput').css({'border-color':'#ccc','focus':'blue'});$('#dwd').css({'border-color':'#ccc','focus':'blue'})" />
							<select id="dwd" class="form-control" name="dwd">
								<option >请选择</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">单位名称:</label>
						<div class="col-sm-7">
							<input name="tljinput" id="tljinput"  readonly="readonly"
								onclick="$('#tljinput').css({'border-color':'#ccc','focus':'blue'});$('#tlj').css({'border-color':'#ccc','focus':'blue'});" />
							<select id="tlj" class="form-control" name="tlj">
								<option >请选择</option>
								<option >中国铁路总公司</option>
							</select> <span id="span">*</span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="bm">部门:</label>
						<div class="col-sm-7">
							<input name="cjinput" id="cjinput"
								onclick="$('#cjinput').css({'border-color':'#ccc','focus':'blue'});$('#cj').css({'border-color':'#ccc','focus':'blue'})">
							<select id="cj" class="form-control" name="cj"
								onchange="renyuan()">
								<option>请选择</option>

							</select> <span id="span">*</span>
						</div>
					</div>
					<div class="form-group" id="xmname">
						<label for="" class="col-sm-3 control-label" id="ry">联系人:</label>
						<div class="col-sm-7">
							<input name="xminput" id="xminput"
								onclick="$('#xminput').css({'border-color':'#ccc','focus':'blue'});$('#xm').css({'border-color':'#ccc','focus':'blue'})" />
							<select id="xm" class="form-control" name="xm"
								onchange="$('#xminput').css({'border-color':'#ccc','focus':'blue'});$('#xm').css({'border-color':'#ccc','focus':'blue'})">
								<option >请选择</option>
							</select> 
						</div><span id="span1">*</span>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">联系方式:</label>
						<div class="col-sm-7">
							<input id="lxdh" class="form-control" name="lxdh"
								onchange="$('#lxdh').css({'border-color':'#ccc','focus':'blue'})" />

						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="hy1">行业:</label>
						<div class="col-sm-7">
							<select id="hy" class="form-control" name="hy"
								onchange="zhuanye()">
								<option >请选择</option>
							</select><span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="zy1">专业:</label>
						<div class="col-sm-7">
							<select id="zy" class="form-control" name="zy"
								onchange="getSolfname()">
								<option >请选择</option>
							</select><span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">软件:</label>
						<div class="col-sm-7">
							<select id="rjxt" class="form-control" name="rjxt"
								onchange="$('#rjxt').css({'border-color':'#ccc','focus':'blue'})">
								<option>请选择</option>
							</select> <span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">发生时间:</label>
						<div class="col-sm-7">
							<input name="tjsj" id="tjsj" class="form-control" type="date"
								required><span id="span">*</span>
						</div>
						
					</div>
					<!-- 七月二十九日添加         功能指的是软件的哪一步分，如：登录功能，查询功能等-->
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">发生版本:</label>
						<div class="col-sm-7">
							<input id="oversion" class="form-control" name="oversion" />
						</div>
					</div>
					<!-- 七月二十七日添加         功能指的是软件的哪一步分，如：登录功能，查询功能等-->
					
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">功能:</label>
						<div class="col-sm-7">
							<select id="funct" class="form-control" name="funct">
								<option >请选择</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="wtms" class="col-sm-3 control-label">问题描述:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="4" name="wtms" id="wtms"
								onchange="$('#wtms').css({'border-color':'#ccc','focus':'blue'})"></textarea>
						</div>
						<span class="wtmsspan" style="position: relative; right: 6px">*</span>
					</div>
					<!-- 七月28日     发生原因    需要添加页面，设置发生原因-->
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">发生原因:</label>
						<div class="col-sm-7">
							<select id="cause" class="form-control" name="cause">
								<option >请选择</option>
							</select>
						</div>
					</div>
				</div>
				
				
				
				<div id="rightright">
					<!-- 七月二十七日添加         程序员反馈指得是问题能否解决，需要多久，-->
					<div class="form-group">
						<label for="pfeedback" class="col-sm-3 control-label">程序员反馈:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="4" name="pfeedback"
								id="pfeedback"
								onchange="$('#pfeedback').css({'border-color':'#ccc','focus':'blue'})"></textarea>
						</div>
					</div>
					<!-- 七月二十七日添加         公司意见，-->
					<div class="form-group">
						<label for="compannyop" class="col-sm-3 control-label">公司意见:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="4" name="compannyop"
								id="compannyop"></textarea>
						</div>
					</div>
					<!-- 七月二十七日添加         预计完成时间，-->
					<div class="form-group">
						<label for="modifyplan" class="col-sm-3 control-label">预计完成时间:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="4" name="modifyplan"
								id="modifyplan"></textarea>
						</div>
					</div>
					<!-- 七月二十七日添加        解决办法，-->
					<div class="form-group">
						<label for="solution" class="col-sm-3 control-label">解决办法:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="4" name="solution"
								id="solution"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="bz" class="col-sm-3 control-label">备注:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="4" name="bz" id="bz"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="file" class="col-sm-3 control-label">上传截图:</label>
						<div class="col-sm-7" id="em">
							<input type="file" id="file" name="file"
								style="position: absolute; clip: rect(0, 0, 0, 0);"
								onchange="inputFileOnChange();">
							<div id="xian"
								style="width: 100%; height: 150px; border: 1px solid #ccc;">
								<label for="file" style="width: 100%; height: 150px;" id="dd">
									<img id="pic" alt="" src="../../assets/img/a11.png"
									style="width: 100%; height: 150px;"
									onclick="$('#xian').css({'border-color':'#ccc','focus':'blue'})">
								</label>
							</div>
						</div>
					</div>
				</div>
				<button id="btn1" style="margin-top: 130px; margin-right: 8.5%;"	type="button" class="btn btn-primary btn-sm">提交</button>
				<button id="btnrn" type="button" class="btn btn-primary btn-sm"	style="float: left; margin: 130px 7%">返回上一页</button>
			</form>
		</div>
	</div>
	</main>
</body>



</html>
