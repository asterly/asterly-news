<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件记录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="../../assets/css/custom.css">
<script src="../../assets/js/jquery.min.js"></script>
<!-- <script src="../../assets/js/jquery-3.2.1.js"></script> -->
<script src="../../assets/js/xschange/wtjl1.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/ajaxfileupload.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>

<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../../assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
<link rel="stylesheet" href="../../css/xschange.css">
<link href="../../css/common.css" type="text/css" rel="stylesheet" />
<link href="../../css/index.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico"
	type="image/x-icon" />
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

.modal {
	display: none;
	margin: 0 auto;
	margin-top: 1%;
	z-index: 1;
	padding-top: 4%;
	left: 0;
	top: 0;
	width: 50%;
	height: 80%;
	overflow: auto;
	background-color: #ddd;
}

/* Modal Content */
.modal-content1 {
	position: relative;
	background-color: #333;
	margin: auto;
	padding: 0;
	width: 80%;
	max-width: 1200px;
}

/* The Close Button */
.close {
	color: #999;
	position: absolute;
	top: 10px;
	right: 25px;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	if (window.parent.right.rows == "70,*") {
		top.right.rows = "0,*";
	}
	$(window).on('load', function() {
		yu("A00");
		getIPPort("IP端口号获取")
	});
	function yu(operator1) {
		var thisURL = document.URL;
		var getval = thisURL.split('?')[1];
		var showval = getval.split("=")[1];
		console.log(showval);
		var changesj = showval;
		var quch = "问题修改前数据查询加载";
		$.ajax({
			async : true,
			type : "post",
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet",
			dataType : "json", //数据类型，可以为json，xml等等，自己百度
			cache : false,
			data : {
				"changesj" : changesj, //操作数 
				"quch" : quch,
			},

			success : function(response) {
				tlj = response;
				$("#tljinput").val(tlj[3]);//单位
				$("#dwdinput").val(tlj[2]);//上级单位 //原来下级单位八月十一日修改  
				$("#cjinput").val(tlj[4]);//部门
				$("#xminput").val(tlj[5]);//姓名
				$("#lxdh").val(tlj[6]);//联系电话	
				$("#hyinput").val(tlj[10]);//行业
				$("#zyinput").val(tlj[11]);//专业
				$("#rjxtinput").val(tlj[7]);//软件
				$("#tjsj").val(tlj[8]);//提交时间
				//$("#wtlxinput").val(tlj[9]);	//问题类型
				var a = document.getElementById('wtms');//问题描述
				a.innerHTML = tlj[9];
				var a = document.getElementById('bz');//备注
				a.innerHTML = tlj[13];
				$("#jt").val(tlj[12]);//上传截图
				$("#fslx").val(tlj[14]);//页面加载之后初始化当前数据的级联查询
				$("#oversion").val(tlj[15]);//发生版本//八月五号添加
				$("#functinput").val(tlj[16]);//功能
				$("#causeinput").val(tlj[17]);//发生原因
				$("#pfeedback").val(tlj[18]);//程序员判断
				$("#compannyop").val(tlj[19]);//公司意见
				$("#modifyplan").val(tlj[20]); //预计完成时间
				$("#solution").val(tlj[21]); //解决办法
				dianwuduan();
				keshi();
				// renyuan();
				zhuanye();
				getSolfname();
				functionquery("功能设置查询",  $("#hyinput").val(),  $("#zyinput").val(),  $("#rjxtinput").val()); 
				cause("原因设置查询");
				//记录人				
				//var uname=$(parent.frames["topFrame"].document).find("#uname").text();
				//var tljSelectStr = "";
				//document.getElementById("uname").innerHTML=tlj[10];
				//$("#uname").html(tljSelectStr)
			},
			error : function(result) {
				//window.location.href="../error.jsp";
				//$.alert("提交失败！！！","提示");
			}
		});

		//---------A00-----
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryData/queryDataservlect",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
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
				$("#dwd").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
		queryDataHy("查询行业", "H0000");
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
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				dwd = response[0];
				var tljArray = "";
				var tljSelectStr = "";
				var option1 = $("#tlj option:selected"); //获取选中的项
				if (option1.text() == "中国铁路总公司") {
					for (var i = 0, len = dwd.length; i < len; i++) {
						tljArray = dwd[i];
						tljSelectStr = tljSelectStr
								+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
								+ "</option>";
					}
				} else {
					for (var i = 0, len = dwd.length; i < len; i++) {
						if (i != 1) {
							tljArray = dwd[i];
							tljSelectStr = tljSelectStr
									+ "<option id='"+tljArray[0]+"'>"
									+ tljArray[1] + "</option>";
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

	}

	function yuuu(operator1) {
		if ($("#tljinput").val() == "中国铁路总公司") {
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataPerson/queryDataServletPerson", 
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
					//请求失败时执行该函数
					//$.alert("请求数据失败，请检查网络设置");
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
					//请求失败时执行该函数
					// $.alert("请求数据失败，请检查网络设置");
				}
			});
		}
	}

	function renyuan() {
		var option1 = $("#cj option:selected"); //获取选中的项
		var option4 = $("#dwd option:selected"); //获取选中的项
		var option3 = $("#tlj option:selected");
		yuuuu(option1.attr("id"), option3.text(), option4.text());
		$("#xm").val("请选择");
		$("#cj").css({
			"border-color" : "#ccc",
			"focus" : "blue"
		})
	}
	function yuuuu(operator1, duan, tlj) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataPerson/queryDataServletPerson",
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
						tljSelectStr = tljSelectStr + "<option value='0'>"
								+ tljArray[1] + "</option>";
					} else {
						tljSelectStr = tljSelectStr
								+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
								+ "</option>";
					}
				}
				$("#xm").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				// $.alert("请求数据失败，请检查网络设置");
			}
		});
	}

	function zhuanye() {
		zhuanyeAjax("修改问题记录操作", $("#hyinput").val());
		$("#zy").val("请选择");
		$("#rjxt").val("请选择");
	}

	function zhuanyeAjax(operator1, zhuanyetext) {

		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"zhuanyetext" : zhuanyetext
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
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
				$("#zy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				// $.alert("请求数据失败，请检查网络设置"); 
			}
		});
	}
	function getSolfname() {

		var option1 = $("#zy option:selected"); //获取选中的项
		var option2 = $("#hy option:selected");
		getSolfnameAjax("软件名称", $("#hyinput").val(), $("#zyinput").val());
		
		
			
		 
	}
	function getSolfnameAjax(operator1, hangye, zhuanye) {

		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
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
					tljSelectStr = tljSelectStr
							+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
							+ "</option>";
				}
				$("#rjxt").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败，请检查网络设置");
			}
		});
	}

	var ipPort = "";
	function getIPPort(operator1) {
		//获取IP地址和端口号
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				ipPort = response[0];
				ipPort1=JSON.stringify(ipPort);
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
			console.log("++++++++++" + a);
		}
			/* 	var Port=ipPort1.indexOf(':')+1;//截取开始位置
				var kPort=ipPort1.length-2;//端口号长度
				var mport=ipPort1.substring(Port, kPort);//截取端口号
				var test = window.location.host;
				test = test.substring(0, test.indexOf(":"));
				 */
				//ipPort1=ipPort1.substring(1,ipPort1.length-1);//xinjia
				ipPort1=ipPort1.replace("\"", "");
				ipPort1=ipPort1.replace("\"", "");
		var dir = "swsrvphoto&filename=" + a;
		console.log("+++++......+++++" +  "http://" +ipPort1+ "/swsrvphoto/" + a + "");
		$.ajaxFileUpload({
			type : "POST",
			url : "http://" + ipPort1+ "/WebForm1.aspx?dir=" + dir,
			secureuri : false, //是否需要安全协议，一般设置为false
			fileElementId : 'file', //文件上传域的ID
			dataType : 'json', //返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{				
			 		 
				var element = document.getElementById('pic');
				console.log("http://"+ ipPort1+ "/swsrvphoto/" + a);
				element.src = "http://" +ipPort1+ "/swsrvphoto/" + a + "";
			},
			error : function(data, status, e) //服务器响应失败处理函数
			{
				//alert("456");					
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

	//查询功能
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
				tlj = response[2];
				var tljSelectStr = "<option>请选择</option>";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljSelectStr += "<option>" + tlj[i]+ "</option>";
				}
				$("#funct").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求数据失败!" + errorMsg); */
			}
		});
	}
</script>
<body>
	<main id="content-wrapper" class="page-wrapper"> <!--中部右侧 -->
	<div id="right">
		<div id="myModal" class="modal">
			<span id="close" class="close cursor">&times;</span>
			<div class="modal-content1">
				<img id="myimage" src=""
					style="width: 100%">
			</div>
		</div>
		<!--问题记录-->
		<div class="xschange" id="wtjl">
			<form method="POST" class="form-horizontal" role="form" name="form"
				id="form" enctype="multipart/form-data">
				<div id="rightleft">
				<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="xjdw">上级单位:</label>
						<div class="col-sm-7">
							<input name="dwdinput" id="dwdinput"  readonly="readonly"
								onclick="$('#dwdinput').css({'border-color':'#ccc','focus':'blue'});$('#dwd').css({'border-color':'#ccc','focus':'blue'})" />

							<select id="dwd" class="form-control" name="dwd" 
								onchange="$('#dwdinput').css({'border-color':'#ccc','focus':'blue'});$('#dwd').css({'border-color':'#ccc','focus':'blue'})">
								<option>请选择</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">单位名称:</label>
						<div class="col-sm-7">
							<input name="tljinput" id="tljinput" readonly="readonly"
								onclick="$('#tljinput').css({'border-color':'#ccc','focus':'blue'});$('#tlj').css({'border-color':'#ccc','focus':'blue'})" />
							<select id="tlj" class="form-control" name="tlj"
								onchange="$('#tljinput').css({'border-color':'#ccc','focus':'blue'});$('#tlj').css({'border-color':'#ccc','focus':'blue'})">
								<option>请选择</option>
								<option>中国铁路总公司</option>
							</select> <span id="span">*</span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="bm">部门:</label>
						<div class="col-sm-7">
							<input name="cjinput" id="cjinput"
								onclick="$('#cjinput').css({'border-color':'#ccc','focus':'blue'});$('#cj').css({'border-color':'#ccc','focus':'blue'})">
							<select id="cj" class="form-control" name="cj"
								onchange="$('#cjinput').css({'border-color':'#ccc','focus':'blue'});$('#cj').css({'border-color':'#ccc','focus':'blue'})">
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
								<option value="0">请选择</option>

							</select> <span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">联系方式:</label>
						<div class="col-sm-7">
							<input id="lxdh" class="form-control" name="lxdh"
								onchange="$('#lxdh').css({'border-color':'#ccc','focus':'blue'})" />
						</div>
						<span id="span1">*</span>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="hy1">行业:</label>
						<div class="col-sm-7">
							<input name="hyinput" id="hyinput" readonly="readonly"
								onclick="$('#hyinput').css({'border-color':'#ccc','focus':'blue'});$('#hy').css({'border-color':'#ccc','focus':'blue'})" />

							<select id="hy" class="form-control" name="hy">
								<option value="0">请选择</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label" id="zy1">专业:</label>
						<div class="col-sm-7">
							<input name="zyinput" id="zyinput" readonly="readonly"
								onclick="$('#zyinput').css({'border-color':'#ccc','focus':'blue'});$('#zy').css({'border-color':'#ccc','focus':'blue'})"/>

							<select id="zy" class="form-control" name="zy">
								<option value="0">请选择</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">软件:</label>
						<div class="col-sm-7">
							<input name="rjxtinput" id="rjxtinput" readonly="readonly"
								onclick="$('#rjxtinput').css({'border-color':'#ccc','focus':'blue'});$('#rjxt').css({'border-color':'#ccc','focus':'blue'})" />

							<select id="rjxt" class="form-control" name="rjxt"
								onchange="$('#rjxtinput').css({'border-color':'#ccc','focus':'blue'});$('#rjxt').css({'border-color':'#ccc','focus':'blue'})">
								<option value="0">请选择</option>
							</select> <span id="span">*</span>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">发生时间:</label>
						<div class="col-sm-7">
							<input name="tjsj" id="tjsj" class="form-control" type="date"
								required>
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
						<input name="functinput" id="functinput"  readonly="readonly"
								onclick="$('#functinput').css({'border-color':'#ccc','focus':'blue'});$('#funct').css({'border-color':'#ccc','focus':'blue'})">
							<select id="funct" class="form-control" name="funct">
								<option value="0">请选择</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="wtms" class="col-sm-3 control-label">问题描述:</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="6" name="wtms" id="wtms"
								onchange="$('#wtms').css({'border-color':'#ccc','focus':'blue'})"></textarea>
						</div>
						<span class="wtmsspan"
							style="display:blcok; position: relative; right: 6px">*</span>
					</div>
					<!-- 七月28日     发生原因    需要添加页面，设置发生原因-->
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">发生原因:</label>
						<div class="col-sm-7">
							<input name="causeinput" id="causeinput"  readonly="readonly"
								onclick="$('#causeinput').css({'border-color':'#ccc','focus':'blue'});$('#cause').css({'border-color':'#ccc','focus':'blue'})">
					
							<select id="cause" class="form-control" name="cause">
								<option value="0">请选择</option>
							</select>
						</div>
					</div>
					
					<div class="form-group" style="display: none">
						<label for="" class="col-sm-3 control-label">分属类型:</label>
						<div class="col-sm-7">
							<input id="fslx" class="form-control" name="fslx" />

						</div>
						<span id="span1">*</span>
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
							<textarea class="form-control" rows="6" name="bz" id="bz"></textarea>
						</div>

					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">上传截图:</label>
						<div class="col-sm-6">
							<input name="jt" id="jt" class="form-control" required>
						</div>
						<button style="padding: 1px; margin-top: 6px; width: 50px"
							id="but" class="col-sm-1 btn btn-primary btn-sm">显示</button>
					</div>
					<div class="form-group">
						<label for="file" class="col-sm-3 control-label">更改截图:</label>
						<div class="col-sm-7">

							<input type="file" id="file" name="file"
								style="position: absolute; clip: rect(0, 0, 0, 0);"
								onchange="inputFileOnChange();">
							<div id="xian"
								style="width: 100%; height: 150px; border: 1px solid #ccc;">
								<label for="file" style="width: 100%; height: 150px;"> <img
									id="pic" alt="" src="../../assets/img/a11.png"
									style="width: 100%; height: 150px;">
								</label>
							</div>
						</div>

					</div>
					<button id="btn1" type="button" class="btn btn-primary btn-sm">提交</button>
					
				</div>
				<input	id="btnrn"  class="btn btn-primary btn-sm" style="float:left;margin:180px 7%" type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
				
			</form>
		</div>

	</div>

	</main>
</body>
<script>
	
</script>

<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/imgUp.js"></script>

</html>
