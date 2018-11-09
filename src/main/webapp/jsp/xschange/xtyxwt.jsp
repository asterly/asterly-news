<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>系统运行问题</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/jquery-3.2.1.js"></script>
<script src="../../js/jquery.dialog.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>
<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/xschange/xtyxwt.js"></script>
<script type="text/javascript" src="../../js/echarts.js"></script>
<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="../../css/jquery.dialog.css">
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
<link rel="stylesheet"
	href="../../assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="../../assets/css/custom.css">
<link rel="stylesheet" href="../../css/xschange.css">
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico"
	type="image/x-icon" />
<style type="text/css">
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
.close1, .close2 {
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
#btns {
	bottom: -35px;
}
</style>
<script type="text/javascript">
	var numBarAndPie;//饼状图和柱状图数据，软件管理下面四个字页面，各个页面的数据总统计，（'软件问题','用户需求','用户使用','系统运行问题'）
	var nameBarAndPie;// 此处查询没有按照括号的顺序 （'软件问题','用户需求','用户使用','系统运行问题'）
	var getrjmc1;//shuzu数组形式
	var getrjmc;//字符串形式
	window.onload = function() {
		cause("原因设置查询");
		if (window.parent.right.rows == "0,*") {
			top.right.rows = "70,*";
		}
		gethzunitname();
		dwcx("问题管理子页面单位查询", gethy, getzy, getrjmc, "系统运行问题");
		var option4 = $("#wtcause option:selected");
		var option5 = $(".active").find("a").text().substring(0, 3);
		var option6 = $("#dwcx option:selected");
		var fslx = "系统运行问题";
		wentiquery("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5,
				option6.text(), fslx);
	};
	//此方法是每次需要行业专业，软件名称的调用方法
	var gethy, getzy, getrjmc;
	function gethzunitname() {
		gethy = $(window.parent.frames["middleTopFrame"].document).find(
				"#hy option:selected").text();
		getzy = $(window.parent.frames["middleTopFrame"].document).find(
				"#zy option:selected").text();
		getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
				"#rjmc option:selected").text();
		gethy = gethy.replace(/\s+/g, "");
		getzy = getzy.replace(/\s+/g, "");
		getrjmc = getrjmc.replace(/\s+/g, "");
	}

	//得到父页面的软件名称的onchange事件
	$(window.parent.frames["middleTopFrame"].document).find("#rjmc").change(
					function() {
						if (getrjmc != "请选择") {
							gethzunitname();
							getrjmc1 = [ getrjmc ];
							if (getrjmc == "请选择") {
								title = '总体统计';
								titlepie = '按软件名称统计';
								titlepie1 = '按问题类型统计';
							} else {
								title = getrjmc;
								titlepie = '按单位统计';
								titlepie1 = getrjmc;
							}
							queryDataBarAndPie("软件问题图表数据查询", gethy, getzy,
									getrjmc, "系统运行问题");
							barshow();
							queryDataBarAndPie("子页面图表数据查询pie1", gethy, getzy,
									getrjmc, "系统运行问题");
							pieshow1();
							queryDataBarAndPie("子页面图表数据查询pie", gethy, getzy,
									getrjmc, "系统运行问题");
							pieshow();
						} else {
							gethzunitname();
							getrjmc1 = [ getrjmc ];
							title = getrjmc;
							titlepie = getrjmc;
							titlepie1 = getrjmc;
							if (getrjmc != "请选择") {
								getrjmc1 = [ getrjmc ];
								if (getrjmc == "请选择") {
									title = '总体统计';
									titlepie = '按软件名称统计';
									titlepie1 = '按问题类型统计';
								} else {
									title = getrjmc;
									titlepie = '按单位统计';
									titlepie1 = getrjmc;
								}
							} else {
								getrjmc1 = [ getrjmc ];
								if (getrjmc == "请选择") {
									title = '总体统计';
									titlepie = '按软件名称统计';
									titlepie1 = '按问题类型统计';
								} else {
									title = getrjmc;
									titlepie = '按单位统计';
									titlepie1 = getrjmc;
								}
							}
							queryDataBarAndPie("软件问题图表数据查询", gethy, getzy,getrjmc, "系统运行问题");
							barshow();
							queryDataBarAndPie("子页面图表数据查询pie1", gethy,getzy, getrjmc, "系统运行问题");
							pieshow1();
							queryDataBarAndPie("子页面图表数据查询pie", gethy,getzy, getrjmc, "系统运行问题");
							pieshow();
						}
						cause("原因设置查询");
						dwcx("问题管理子页面单位查询", gethy, getzy, getrjmc, "用户需求");
						gethzunitname();
						var option4 = $("#wtcause option:selected");
						var option5 = $(".active").find("a").text().substring(0, 3);
						var option6 = $("#dwcx option:selected");
						wentiquery("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5, option6.text(), "系统运行问题");
					});
	//表格数据加载分页
	function wentiquery(wentiquery, hy, zy, rjxt, wtcause, sfjj, dwcx, fslx) {
		$.ajax({
					type : "post",
					async : false,
					contentType : "application/x-www-form-urlencoded",
					url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
					data : {
						"wentiquery" : wentiquery,
						"hy" : hy,
						"zy" : zy,
						"rjxt" : rjxt,
						"wtcause" : wtcause,
						"sfjj" : sfjj,
						"dwcx" : dwcx,
						"fslx" : fslx,
					},
					dataType : 'json',
					success : function(response) {
						tlj = response;
						var a = document.getElementById('tbody1');
						var TabJsonResult = "";
						if (tlj == "") {
							a.innerHTML = TabJsonResult;
							$.alert("查询内容为空！");
						} else {
							for (var i = 0; i < tlj[0].length; i++) {

								for (var j = 0; j < tlj.length; j++) {
									if (j == 0) {
										TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\"  guid='" + tlj[0][i] + "' class=\"checkchoose\"/></td>"; //tr
									} else if (j == 1) {
										TabJsonResult += "<td id='all' guid=\"" + tlj[0][i] + "\"><a href='#'>"
												+ tlj[1][i] + "</a></td> ";
									} else {
										TabJsonResult += "<td>" + tlj[j][i]
												+ "</td>"; //td	
									}
								}
								TabJsonResult += "</tr>"; //tr
							}
							a.innerHTML = TabJsonResult;
							goPage(1);
						}
					},
					error : function(errorMsg) {
						$.alert("请求数据失败，请检查网络设置");
					}
				});
	}

	function dwcx(operator1, hy, zy, rjmc, fslx) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet",
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc,
				"fslx" : fslx
			},
			dataType : 'json',
			success : function(response) {
				//请求成功时执行该函数内容，result即为服务器返回的对象
				tlj = response[0];
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljSelectStr += "<option id='" + tlj[i] + "'>" + tlj[i]
							+ "</option>";
				}
				$("#dwcx").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
	}
	function cause(operator1) {  //问题原因查询加载的方法
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
				var causearr=response[2];
				var CauseSelect = "<option >请选择</option>";
				for (var i = 0, len = causearr.length; i < len; i++) {
					CauseSelect += "<option >" + causearr[i] + "</option>";
				}
				$("#wtcause").html(CauseSelect);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	}


	function qusolveclick() {
		var option1 = $(".active").find("a").text().substring(0, 3); //获取选中的项
		qusolve("问题是否解决", option1);
	}
	function qusolve(wentiquery, sfjj) {
		$.ajax({
					type : "post",
					async : true,
					contentType : "application/x-www-form-urlencoded",
					url : "/swsrv/queryDataI/queryDataIntall", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
					data : {
						"wentiquery" : wentiquery,
						"sfjj" : sfjj,
					},
					dataType : 'json',
					success : function(response) {
						tlj = response;
						var a = document.getElementById('tbody1');
						var TabJsonResult = "";
						if (tlj == "") {
							a.innerHTML = TabJsonResult;
							$.alert("查询内容为空");
						} else {
							for (var i = 0; i < tlj[0].length; i++) {

								for (var j = 0; j < tlj.length; j++) {
									if (j == 0) {
										TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class=\"checkchoose\"/></td>"; //tr
									} else if (j == 1) {
										TabJsonResult += "<td id='all' guid=\"" + tlj[0][i] + "\"><a href='#'>"
												+ tlj[1][i] + "</a></td> ";
									} else {
										TabJsonResult += "<td>" + tlj[j][i]
												+ "</td>"; //td	
									}
								}
								TabJsonResult += "</tr>"; //tr
							}
							a.innerHTML = TabJsonResult;
							goPage(1);
						}
					},
					error : function(errorMsg) {
						$.alert("请求数据失败，请检查网络设置");
					}
				});
	}

	

	function goPage(pno) {
		var itable = document.getElementById("tbody1");
		var num = itable.rows.length; //表格所有行数(所有记录数)
		console.log(num);
		var totalPage = 0; //总页数
		var pageSize = 10; //每页显示行数
		//总共分几页
		if (num / pageSize > parseInt(num / pageSize)) {
			totalPage = parseInt(num / pageSize) + 1;
		} else {
			totalPage = parseInt(num / pageSize);
		}
		var currentPage = pno; //当前页数
		var startRow = (currentPage - 1) * pageSize + 1; //开始显示的行  31
		var endRow = currentPage * pageSize; //结束显示的行   40
		endRow = (endRow > num) ? num : endRow; //40
		console.log(endRow);
		//遍历显示数据实现分页
		for (var i = 1; i < (num + 1); i++) {
			var irow = itable.rows[i - 1];
			if (i >= startRow && i <= endRow) {
				irow.style.display = "table-row";
			} else {
				irow.style.display = "none";
			}
		}
		var pageEnd = document.getElementById("pageEnd");
		var tempStr = "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>共"
				+ totalPage + "页</span>";

		if (currentPage > 1) {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("
					+ (1) + ")\">首页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("
					+ (currentPage - 1) + ")\">上一页</span>"
		} else {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>首页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>上一页</span>";
		}

		for (var pageIndex = 1; pageIndex < totalPage + 1; pageIndex++) {
			tempStr += "<a onclick=\"goPage(" + pageIndex
					+ ")\"><span style=\"margin-right:3px;\">" + pageIndex
					+ "</span></a>";
		}

		if (currentPage < totalPage) {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("
					+ (currentPage + 1) + ")\">下一页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("
					+ (totalPage) + ")\">尾页</span>";
		} else {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>下一页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>尾页</span>";
		}
		document.getElementById("SoftQbarcon").innerHTML = tempStr;
	}

	//导出表格	
	function getExplorer() {
		var explorer = window.navigator.userAgent;
		if (explorer.indexOf("MSIE") >= 0
				|| (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer
						.indexOf("Trident/7.0;") >= 0)) {
			return 'ie';
		} else if (explorer.indexOf("Firefox") >= 0) {
			return 'Firefox';
		} else if (explorer.indexOf("Chrome") >= 0) {
			return 'Chrome';
		} else if (explorer.indexOf("Opera") >= 0) {
			return 'Opera';
		} else if (explorer.indexOf("Safari") >= 0) {
			return 'Safari';
		}
	}
	function exportToExcel(tab, filename, sheetname) {
		if (getExplorer() == 'ie') {
			var curTbl = document.getElementById(tab);
			var oXL = new ActiveXObject("Excel.Application");
			var oWB = oXL.Workbooks.Add();
			var xlsheet = oWB.Worksheets(1);
			var sel = document.body.createTextRange();
			sel.moveToElementText(curTbl);
			sel.select();
			sel.execCommand("Copy");
			xlsheet.Paste();
			oXL.Visible = true;
			try {
				var fname = oXL.Application.GetSaveAsFilename(filename,
						"Excel Spreadsheets (*.xls), *.xls");
			} catch (e) {
				print("Nested catch caught " + e);
			} finally {
				oWB.SaveAs(fname);
				oWB.Close(savechanges = false);
				oXL.Quit();
				oXL = null;
				idTmr = window.setInterval("Cleanup();", 1);
			}
		} else {
			tableToExcel(tab, filename, sheetname)
		}
	}

	function Cleanup() {
		window.clearInterval(idTmr);
		CollectGarbage();
	}

	var tableToExcel = (function() {
		var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><meta charset="UTF-8"><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
				s) {
			return window.btoa(unescape(encodeURIComponent(s)));
		}, format = function(s, c) {
			return s.replace(/{(\w+)}/g, function(m, p) {
				return c[p];
			});
		};
		return function(table, filename, sheetname) {
			//这里创建一个<a/>标记利用a标记的download属性来自定义Excel文件名,解决button按钮触发下载无法自定义Excel文件名的问题
			var a = $('<a id="dlink" style="display:none;"/>');
			$(document.body).append(a);
			if (!table.nodeType)
				table = document.getElementById('tab');
			var ctx = {
				worksheet : sheetname || 'Worksheet',
				table : table.innerHTML
			}
			a.attr("href", uri + base64(format(template, ctx)));
			a.attr("download", '系统运行问题表'); //这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
			document.getElementById("dlink").click();
		}
	})();

	//表格导出
	function educe() {
		gethzunitname();
		var option4 = $("#wtcause option:selected");
		var option5 = $(".active").find("a").text().substring(0, 3);
		var option6 = $("#dwcx option:selected");
		var fslx = "系统运行问题";
		wentiquery1("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5,
				option6.text(), fslx);
		var c = document.getElementById("dlink");//此处是对表格导出方法中，append（标签的判断），如果存在，则进行移除，
		if (c != null) {
			c = c.remove();
		}
		exportToExcel('tab', '问题反馈表', '问题反馈表');
		wentiquery("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5,
				option6.text(), fslx);
		//dwcx("问题管理子页面单位查询",gethy,getzy,getrjmc,"系统运行问题");
	}
	//导出表格时进行查询，不分页
	function wentiquery1(wentiquery, hy, zy, rjxt, wtcause, sfjj, dwcx, fslx) {
		$
				.ajax({
					type : "post",
					async : false,
					contentType : "application/x-www-form-urlencoded",
					url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
					data : {
						"wentiquery" : wentiquery,
						"hy" : hy,
						"zy" : zy,
						"rjxt" : rjxt,
						"wtcause" : wtcause,
						"sfjj" : sfjj,
						"dwcx" : dwcx,
						"fslx" : fslx,
					},
					dataType : 'json',
					success : function(response) {
						tlj = response;
						var a = document.getElementById('tbody1');
						var TabJsonResult = "";
						if (tlj == "") {
							a.innerHTML = TabJsonResult;
							$.alert("查询内容为空");
						} else {
							for (var i = 0; i < tlj[0].length; i++) {

								for (var j = 0; j < tlj.length; j++) {
									if (j == 0) {
										TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\"  guid='" + tlj[0][i] + "' class=\"checkchoose\"/></td>"; //tr
									} else if (j == 1) {
										TabJsonResult += "<td id='all' guid=\"" + tlj[0][i] + "\"><a href='#'>"
												+ tlj[1][i] + "</a></td> ";
									} else {
										TabJsonResult += "<td>" + tlj[j][i]
												+ "</td>"; //td	
									}
								}
								TabJsonResult += "</tr>"; //tr
							}
							a.innerHTML = TabJsonResult;
						}
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
		<div id="Modal1" class="modal">
			<span id="close1" class="close2 cursor">&times;</span>
			<div class="modal-content">
				<div id="tab3">
					<table id="tab2">
						<thead style="background: #ADD8E6;">
							<tr>
								<th width="4%;">序号</th>
								<th width="7%;">上级单位</th>
								<th width="5%;">单位名称</th>
								<th width="5%;">部门</th>
								<th width="5%;">反馈人</th>
								<th width="5%;">联系电话</th>
								<th width="7%;">软件</th>
								<th width="5%;">提交时间</th>
								<th width="5%;">问题类型</th>
								<th width="5%;">是否解决</th>
								<th width="5%;">解决时间</th>
								<th width="20%">问题描述</th>
								<th width="20%">备注</th>
								<th width="6%;">截图</th>
								<th width="6%;">显示截图</th>
								

							</tr>
						</thead>
						<tbody id="tbody2">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="myModal" class="modal">
			<span id="close2" class="close1 cursor">&times;</span>
			<div class="modal-content1">
				<img id="myimage" src="" style="width: 100%">
			</div>
		</div>
		<!--问题查询-->
		<div class="xschange" id="wtcx">
			<form method="POST" class="form-horizontal" role="form" name="form"
				id="form">
				<div id="toolbox" style="display: block; margin-top: -20px;">
					<div class="selc">
						<span id="slelecthead">问题发生原因:</span> <span
							style="margin-right: 25px;"> <select id="wtcause"
							class="selectway" name="wtcause">
								<option>请选择</option>
						</select>
						</span>
					</div>

					<div class="selc">
						<span id="slelecthead">单位:</span> <span
							style="margin-right: 25px;"> <select id="dwcx"
							class="selectway" name="dwcx">
								<option>请选择</option>
								<option>中国铁路总公司</option>
								<option>武汉铁路局</option>
						</select>
						</span>

					</div>
				</div>


			</form>
			<div id="btns" style="display: block">
				<input type="button" class="btn btn-primary btn-sm" id="selectadd"
					value="添加" /> <input type="button" class="btn btn-primary btn-sm"
					id="selectcg" value="修改" /> <input type="button"
					class="btn btn-primary btn-sm" id="selectde" value="删除" /> <input
					type="button" class="btn btn-primary btn-sm" id="selectso"
					value="已解决" /> <input type="button" class="btn btn-primary btn-sm"
					id="btnExport" onclick="educe();" value="导出" />
			</div>

			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#nsolve" data-toggle="tab" id="nso">未解决</a>
				</li>
				<li><a href="#nsolve" data-toggle="tab" id="yso">已解决</a></li>
				<!-- +++++++++++++++++ -->
				<li><a href="#zsolve" data-toggle="tab" id="zso">统计分析</a></li>
				<!-- +++++++++++++++++++ -->
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="nsolve">
					<div id="tab1" style="top: 130px">
						<table id="tab">
							<thead style="background: #ADD8E6;">
								<tr>
									<th id="state" width="4%"><input type="checkbox"
										id="checkall" /></th>
									<th width="4%;">序号</th>
									<th width="10%;">问题编号</th>
									<th width="16%;">上级单位</th>
									<th width="10%;">单位名称</th>
									<th width="10%;">部门</th>
									<th width="8%;">提出人</th>
									<th width="10%;">发生时间</th>
									<th width="8%;">发生版本</th>
									<th width="10%;">解决时间</th>
									<th width="8%;">解决版本</th>
									<th width="8%;">分类</th>
									<th width="8%;">功能</th>
									<th width="15%">问题描述</th>
									<th width="15%;">发生原因</th>
									<th width="15%;">程序员反馈</th>
									<th width="15%;">公司意见</th>
									<th width="10%;">预计完成时间</th>
									<th width="15%">解决办法</th>
									<th width="12%;">联系电话</th>
									<th width="15%;">备注</th>
								</tr>
							</thead>
							<tbody id="tbody1">
							</tbody>
						</table>
						<form id="SoftQbarcon" style="margin-top: 30px; margin-bottom: 20px;">

						</form>
					</div>
				</div>
				<div class="tab-pane fade in" id="zsolve">
					<ul id="myTabData" class="nav nav-tabs" style="display: none">
						<li class="active"><a href="#allpo" data-toggle="tab"
							id="allsoft">总体分析</a></li>
						<li><a href="#qupo" data-toggle="tab" id="qsoft">按问题类型</a></li>
						<li><a href="#unpo" data-toggle="tab" id="usoft">按单位名称</a></li>
					</ul>
					<div id="myTabContent1" class="tab-content">
						<!-- 默认全部的数据 -->
						<div class="tab-pane fade in active" id="allpo">
							<div id="datatj" style="width: 100%; margin-top: 40px;">
								<div id="barshow" style="width: 100%">
									<div id="allchartmain" style="width: 1000px; height: 450px;"></div>
								</div>
								<div id="pieshow1" style="width: 50%; margin-top: 30px;">
									<div id="bchartmain1" style="width: 600px; height: 550px;"></div>
								</div>
								<div id="pieshow" style="width: 50%; margin-top: 30px;">
									<div id="bchartmain" style="width: 600px; height: 550px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	</main>
	<script>
		$(function() {
			$('#myTab li:eq(0) a').tab('show');
		});
		$(function() {
			$('#myTabData li:eq(0) a').tab('show');
		});
	</script>
</body>
<script type="text/javascript">
	$("#allsoft").click(function() {
		//queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "系统运行问题");
	});

	$("#zso").click(
			function() {
				$("#toolbox").css("display", "none");
				$("#btns").css("display", "none");
				if (getrjmc != "请选择") {
					//$("#myTabData").css("display", "block");
					gethzunitname();
					getrjmc1 = [ getrjmc ];
					if (getrjmc == "请选择") {
						title = '总体统计';
						titlepie = '按软件名称统计';
						titlepie1 = '按问题类型统计';
					} else {
						title = getrjmc;
						titlepie = '按单位统计';
						titlepie1 = getrjmc;
					}
					queryDataBarAndPie("软件问题图表数据查询", gethy, getzy, getrjmc,
							"系统运行问题");
					barshow();
					queryDataBarAndPie("子页面图表数据查询pie1", gethy, getzy, getrjmc,
							"系统运行问题");
					pieshow1();
					queryDataBarAndPie("子页面图表数据查询pie", gethy, getzy, getrjmc,
							"系统运行问题");
					pieshow();
				} else {
					//$("#myTabData").css("display", "none");
					gethzunitname();
					getrjmc1 = [ getrjmc ];
					if (getrjmc == "请选择") {
						title = '总体统计';
						titlepie = '按软件名称统计';
						titlepie1 = '按问题类型统计';
					} else {
						title = getrjmc;
						titlepie = '按单位统计';
						titlepie1 = getrjmc;
					}
					queryDataBarAndPie("软件问题图表数据查询", gethy, getzy, getrjmc,
							"系统运行问题");
					barshow();
					queryDataBarAndPie("子页面图表数据查询pie1", gethy, getzy, getrjmc,
							"系统运行问题");
					pieshow1();
					queryDataBarAndPie("子页面图表数据查询pie", gethy, getzy, getrjmc,
							"系统运行问题");
					pieshow();
				}

			})
	//按问题类型分析
	/* $("#qsoft").click(function() {
		alert ("按问题类型分析");
		$("#toolbox").css("display", "none");
		$("#btns").css("display", "none");
			$("#myTabData").css("display", "block");
			gethzunitname();
			getrjmc1 = [ getrjmc ];
			title = getrjmc;
		    titlepie = getrjmc;
			titlepie1 = getrjmc;
			queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "系统运行问题");
			barshow();
			queryDataBarAndPie("图表数据查询pie1", gethy, getzy, getrjmc, "系统运行问题");
			pieshow1();
			queryDataBarAndPie("图表数据查询pie", gethy, getzy, getrjmc, "系统运行问题");
			pieshow();
	}) */

	function queryDataBarAndPie(operator1, hy, zy, rjmc, fslx) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc,
				"fslx" : fslx
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				bToObj = response;
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}
	function barshow() {
		var option = {
			title : {
				text : '总体统计',
				subtext : '',
				x : 'center',
				y : 'top',
				textAlign : 'left'
			},
			tooltip : {
				trigger : 'axis'
			},

			legend : {
				data : [],
				orient : 'vertical',
				x : 'left',
			},
			xAxis : [ {
				axisLabel : {
					interval : 0,
					rotate : 40
				},
				type : 'category',
				data : []
			} ],
			grid : { // 控制图的大小，调整下面这些值就可以，
				left : '150px',//距离左边距
				x : 80,
				x2 : 100,
				y2 : 125
			// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
			},
			yAxis : [ {
				type : 'value',
				minInterval : 1,
				splitArea : {
					show : true
				}
			} ],
			series : []
		};
		myChart = echarts.init(document.getElementById('allchartmain'));
		myChart.setOption(option, true);
		options = myChart.getOption();
		if (bToObj) {
			options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].series;
			var aToStr = JSON.stringify(bToObj);
			var panduan = aToStr.indexOf("xAxisdata");
			if (panduan > 0) {
				options.xAxis[0].data = bToObj[0].xAxisdata;
			} else {
				options.xAxis[0].data = getrjmc1;
			}
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}
	function pieshow() {
		//饼状图指定图标的配置和数据
		var option = {
			title : {
				text : titlepie,
				subtext : '',
				x : "center"
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				data : []
			},
			series : []
		};
		myChart = echarts.init(document.getElementById('bchartmain'));
		myChart.setOption(option, true);

		options = myChart.getOption();
		if (bToObj) {
			options.series = bToObj[0].pieseries;
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}

	function pieshow1() {
		//饼状图指定图标的配置和数据
		var option = {
			title : {
				text : '按问题类型统计',
				subtext : '',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				/* orient : 'vertical',
				left : 'left', */
				data : []
			},
			series : []
		};
		myChart = echarts.init(document.getElementById('bchartmain1'));
		myChart.setOption(option, true);

		options = myChart.getOption();
		if (bToObj) {
			//options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].pieseries;
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}
</script>
</html>
