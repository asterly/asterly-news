<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>工程进度</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/jquery-3.2.1.js"></script>

<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>
<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css"
	rel="stylesheet">
<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/xschange/gcjd.js"></script>
<script src="../../js/echarts.js"></script>

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
.a2 {
	background-color: #e0ffff;
}

#btnExport {
	float: right;
	position: absolute;
	right: -10%;
	bottom: 0px;
}
input{
	border:0;
	outline:none;
}
</style>
<script type="text/javascript">

	function dwmcchange() {
		///alert("danwei单位单位单位单位单位多单位单位名称改变 ");
		var gethy = $(window.parent.frames["middleTopFrame"].document).find(
			"#hy option:selected").text();
		var getzy = $(window.parent.frames["middleTopFrame"].document).find(
			"#zy option:selected").text();
		var getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
			"#rjmc option:selected").text();
		gethy = gethy.replace(/\s+/g, "");
		getzy = getzy.replace(/\s+/g, "");
		getrjmc = getrjmc.replace(/\s+/g, "");
		var option4 = $("#dwmc option:selected");
		jdcx("进度实施查询", gethy, getzy, getrjmc, option4.text());
		
		
	}
	;
	var echartsunit; //单位名称，echarts的Y轴显示部分
	var echartsStepData; //表头的阶段名称在X轴的显示
	var echartsStepLength; //表头的阶段长度，XAxis的max值
	var unitnum; //计数用
	var unitnums; //suoyoude he 
	var gethy = $(window.parent.frames["middleTopFrame"].document).find(
		"#hy option:selected").text();
	var getzy = $(window.parent.frames["middleTopFrame"].document).find(
		"#zy option:selected").text();
	var getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
		"#rjmc option:selected").text();
	gethy = gethy.replace(/\s+/g, "");
	getzy = getzy.replace(/\s+/g, "");
	getrjmc = getrjmc.replace(/\s+/g, "");
	//如果行业专业软件名称存在值直接刷新
	if (!(getrjmc == "" || getrjmc == "请选择" || getrjmc == "无选项")) {
		//alert("xxxxxxxxxxxxxxxxxxxxxxx");
		var gethy = $(window.parent.frames["middleTopFrame"].document).find(
			"#hy option:selected").text();
		var getzy = $(window.parent.frames["middleTopFrame"].document).find(
			"#zy option:selected").text();
		var getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
			"#rjmc option:selected").text();
		gethy = gethy.replace(/\s+/g, "");
		getzy = getzy.replace(/\s+/g, "");
		getrjmc = getrjmc.replace(/\s+/g, "");
		getinputSolfnameAjax("获取input单位", gethy, getzy, getrjmc);
		//var option4 = $("#dwmc option:selected");
		jdcx("进度实施查询", gethy, getzy, getrjmc, "请选择");

	}

	$(window.parent.frames["middleTopFrame"].document).find("#rjmc").change(
		function() {
			//alert("软件名称改变时间事件");
			var gethy = $(window.parent.frames["middleTopFrame"].document).find(
				"#hy option:selected").text();
			var getzy = $(window.parent.frames["middleTopFrame"].document).find(
				"#zy option:selected").text();
			var getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
				"#rjmc option:selected").text();
			gethy = gethy.replace(/\s+/g, "");
			getzy = getzy.replace(/\s+/g, "");
			getrjmc = getrjmc.replace(/\s+/g, "");
			if (getrjmc == "请选择") {
				$("#dwmc").html("<option>无选项</option>");
				jdcx("进度实施查询", gethy, getzy, getrjmc, "请选择");
				return;
			} else {
				getinputSolfnameAjax("获取input单位", gethy, getzy, getrjmc);
			}

			/* getinputSolfnameAjax("获取input单位", gethy, getzy, getrjmc); */
			jdcx("进度实施查询", gethy, getzy, getrjmc, "请选择");
		});

	//获取input单位名称，实施表获取
	function getinputSolfnameAjax(operator1, hangye, zhuanye, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";

				if (tlj == "") {
					tljSelectStr = "<option >无选项</option>";
				} else {
					for (var i = 0, len = tlj[0].length; i < len; i++) {
						tljSelectStr = tljSelectStr + "<option >" + tlj[0][i]
							+ "</option>";
					}
				}

				$("#dwmc").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}

	var aaaa; //得到pguid，就是表格中行的id值
	function jdcx(operator1, hangye, zhuanye, rjmc, dwmc) {
		$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
				data : {
					"operator1" : operator1,
					"hangye" : hangye,
					"zhuanye" : zhuanye,
					"rjmc" : rjmc,
					"dwmc" : dwmc
				},
				dataType : 'json', //返回数据形式为xml  //timeout:3000,
				success : function(response) {
					tlj = response;
					var TabJsonResult = "";
					var tlj0 = tlj[0]; //表头数据，各阶段的名称
					var tlj1 = tlj[1]; //表格数据
					var tlj2 = tlj[2]; //获取该条数据的单位级别，设置单位级别是2（路局的颜色）
					echartsunit = "";
					echartsStepData = "";
					var tableheader = document
						.getElementById('tableheader');
					if (tlj0 == "") {
						TabJsonResult = "<tr  id=\"ttt\"><th width='4%'>序号</th><th width='10%'>单位名称</th><th width='10%'></th>";
						tableheader.innerHTML = TabJsonResult;
					} else {
						TabJsonResult = "<tr  id=\"ttt\"><th width='4%'>序号</th><th width='10%'>单位名称</th>";
						echartsStepLength = tlj0[0].length; //echarts获取阶段的长度
						for (var i = 0; i < tlj0[0].length; i++) {
							echartsStepData += "\"" + tlj0[0][i] + "\",";
							if(tlj0[1][i]==""){
								TabJsonResult += "<td>" + tlj0[0][i] + "<br/>"+ tlj0[1][i] + "</td>";
							}else{
								TabJsonResult += "<td>" + tlj0[0][i] + "<br/>("+ tlj0[1][i] + ")" + "</td>";
							}
							
						}
						TabJsonResult += " <td>备注</td></tr>";
					}
					tableheader.innerHTML = TabJsonResult;
					var TabJsonResult1 = "";
					var a = document.getElementById('tbody');
					if (tlj1 == "") {
						$.alert("查询内容为空!");
						a.innerHTML = TabJsonResult1;
						unitnum = 0;
						echartsunit = "";
						unitnums = "";
						echartsStepLengt = "";
						echartsStepData = "";
					//ceshi();
					} else {
						//添加删除键后，传id值到前台
						unitnums = "";
						 for (var i = 0; i<tlj1[1].length; i++) {
								unitnum = "";
								for (var j = tlj[1].length-2; j >2; j--) {
										if (!(tlj1[j][i] == ""|| tlj1[j][i] == "null" || tlj1[j][i] == null)){
											unitnum =j-2 ;
											break;
										}else{
											unitnum=0;
										}
								}
								unitnums += unitnum + ",";
							} 
						for (var i = 0; i < tlj1[1].length; i++) {
							for (var j = 0; j < tlj[1].length; j++) {
								if (j == 0) {
									var style = "a" + tlj2[0][i];
									TabJsonResult1 += "<tr class='" + style + "' id=\"" + tlj1[0][i] + "\">";
								} else {
									TabJsonResult1 += "<td>" + tlj1[j][i]
										+ "</td>";
								}
								if (j == 2) {
									echartsunit += "\"" + tlj1[2][i]
										+ "\","; //获取到所有的单位
								}
							}
						}

						TabJsonResult1 += "</tr>";
						a.innerHTML = TabJsonResult1;

						//goPage(1);
						editcell();
						var option4 = $("#dwmc option:selected");
						if(option4.text()=="请选择"){
							$("#graph").css("display", "block");
							$("#graph1").css("display", "none");
							ceshi();
						}else{
							$("#graph1").css("display", "block");
							$("#graph").css("display", "none");
							ceshi1();
						}

					}
				},
				error : function(errorMsg) {
					$.alert("请求数据失败!请检查网络设置");
				}
			});
	}
	function dwmc(operator1) {
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
							+ "<option id='" + tljArray[0] + "'>" + tljArray[1]
							+ "</option>";
					}
				}
				$("#dwmc").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
	}

	/* 	function goPage(pno) {
			var itable = document.getElementById("tbody");
			var num = itable.rows.length; //表格所有行数(所有记录数)
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

			document.getElementById("barcon").innerHTML = tempStr;

		} */

	//导出表格	
	function getExplorer() {
		var explorer = window.navigator.userAgent;
		// ief
		if (explorer.indexOf("MSIE") >= 0
			|| (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer
				.indexOf("Trident/7.0;") >= 0)) {
			//alert("识别你是IE浏览器1111======");
			return 'ie';
		}
		// firefox
		else if (explorer.indexOf("Firefox") >= 0) {
			return 'Firefox';
		}
		// Chrome
		else if (explorer.indexOf("Chrome") >= 0) {
			return 'Chrome';
		}
		// Opera
		else if (explorer.indexOf("Opera") >= 0) {
			return 'Opera';
		}
		// Safari
		else if (explorer.indexOf("Safari") >= 0) {
			return 'Safari';
		}
	}
	function exportToExcel(tableid, filename, sheetname) {
		if (getExplorer() == 'ie') {
			var curTbl = document.getElementById(tableid);
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
			tableToExcel(tableid, filename, sheetname)
		}
	}

	function Cleanup() {
		window.clearInterval(idTmr);
		CollectGarbage();
	}

	var tableToExcel = (function() {
		var uri = 'data:application/vnd.ms-excel;base64,',
			template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><meta charset="UTF-8"><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
			base64 = function(
				s) {
				return window.btoa(unescape(encodeURIComponent(s)));
			},
			format = function(s, c) {
				return s.replace(/{(\w+)}/g, function(m, p) {
					return c[p];
				});
			};
		return function(table, filename, sheetname) {

			//这里创建一个<a/>标记利用a标记的download属性来自定义Excel文件名,解决button按钮触发下载无法自定义Excel文件名的问题
			var a = $('<a id="dlink" style="display:none;"/>');
			$(document.body).append(a);
			if (!table.nodeType)
				table = document.getElementById('tableid');
			var ctx = {
				worksheet : sheetname || 'Worksheet',
				table : table.innerHTML
			}
			a.attr("href", uri + base64(format(template, ctx)));
			a.attr("download", '实施进度表'); //这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
			document.getElementById("dlink").click();
		}
	})();
/* 	function dacuExport() {
		exportToExcel('tableid', '实施进度', '实施进度表');
	} */


	var cellnum; //获取当前点击行的列数，根据列数转换为数据库的列名，cellnum-1=阶段一，以此类推，当最后一列时，列名=备注。
	var oldvalue; //指的是文本框修改前的值，用于判断文本框与修改后的值是否相同，相同不更新
	function editcell() {
		$("td").click(function() {
			aaaa = $(this).parent().attr("id");
		});
		//找到学号这一列的所有单元格 
		//因为学号这一列的单元格在所有td中的位置是偶数（0,2,4,6），所以通过even就可以筛选到td中偶数位的单元格 
		//var numTd = $("tbody td:not(:first-child)");
		var numTd = $("tbody td:nth-child(n+3)");
		//单击这些td时，创建文本框 
		numTd.click(function() {
			cellnum = window.event.srcElement.cellIndex; //得到的是第几列，用于判断数据库的列名
			var row = document.getElementById(aaaa); //只针对 row1这个元素的子节点查找	
			var cells = row.getElementsByTagName("td"); // 找到这个tr下的所有td，不能用childNodes 属性，部分浏览器不兼容
			oldvalue = cells[cellnum].innerHTML; //指的是文本框修改前的值，用于判断文本框与修改后的值是否相同，相同不更新
			//创建文本框对象 
			var inputobj = $("<input type='text'>");
			//获取当前点击的单元格对象 
			var tdobj = $(this);
			//获取单元格中的文本 
			var text = tdobj.html();
			//如果当前单元格中有文本框，就直接跳出方法 
			//注意：一定要在插入文本框前进行判断 
			if (tdobj.children("input").length > 0) {
				return false;
			}
			//清空单元格的文本 
			tdobj.html("");
			inputobj.css("border-width", "0")
				.css("font-size", tdobj.css("font-size")).css(
				"font-family", tdobj.css("font-family")).css(
				"background-color", tdobj.css("background-color"))
				.css("color", "#C75F3E").width(tdobj.width()).val(text)
				.appendTo(tdobj);
			inputobj.get(0).select();
			//阻止文本框的点击事件 
			inputobj.click(function() {
				return false;
			});
			//处理文本框上回车和esc按键的操作 
			//jQuery中某个事件方法的function可以定义一个event参数，jQuery会屏蔽浏览器的差异，传递给我们一个可用的event对象 
			inputobj.blur(function() {
				var inputtext = $(this).val();
				tdobj.html(inputtext);
				tablevalue(); //当失去焦点时进行数据更新----------------------------新加-----------------------------------
			});
		});
	}

	function tablevalue() {
		var sss = 0;
		var value = "";
		var tablepguid = aaaa; //aaa指的是点击行的id值
		var row = document.getElementById(aaaa); //只针对 row1这个元素的子节点查找	
		var cells = row.getElementsByTagName("td"); // 找到这个tr下的所有td，不能用childNodes 属性，部分浏览器不兼容
		//这里的长度应该和数据库定义的阶段列的列数相同，或者更多  i<10
		var a = "";
		var jieduanarr = [ "一阶段", "二阶段", "三阶段", "四阶段", "五阶段", "六阶段", "七阶段", "八阶段", "九阶段", "十阶段" ];
		for (var i = 2; i < cells.length; i++) {
			if (i != cells.length - 1 && i == cellnum) {
				cellnameOracle = jieduanarr[cellnum - 2];
				value = cells[i].innerHTML;
				if (value == oldvalue) {
					return false;
				}
			}
			if (i == cells.length - 1 && i == cellnum) {
				cellnameOracle = "进度备注";
				value = cells[i].innerHTML;
				if (value == oldvalue) {
					return false;
				}
			}

		}
		var operator1 = "阶段进度完成更新";
		//后台传输数据进行阶段的更新
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet",
			data : {
				"operator1" : operator1,
				"value" : value,
				"tablepguid" : tablepguid,
				"cellnameOracle" : cellnameOracle,
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				var gethy = $(window.parent.frames["middleTopFrame"].document).find(
					"#hy option:selected").text();
				var getzy = $(window.parent.frames["middleTopFrame"].document).find(
					"#zy option:selected").text();
				var getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
					"#rjmc option:selected").text();
				gethy = gethy.replace(/\s+/g, "");
				getzy = getzy.replace(/\s+/g, "");
				getrjmc = getrjmc.replace(/\s+/g, "");
				var option4 = $("#dwmc option:selected");
				jdcx("进度实施查询", gethy, getzy, getrjmc, option4.text());
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
		value = "";
	}

	function updategcjd(operator1, hangye, zhuanye, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataSName/queryDataSoftName", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj[0].length; i < len; i++) {
					tljSelectStr = tljSelectStr + "<option >" + tlj[0][i]
						+ "</option>"
				}
				$("#dwmc").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}
</script>

</head>

<body>
	<main id="content-wrapper" class="page-wrapper"> <!--中部右侧 -->
	<div id="right">
		<!--管理记录-->
		<div class="xschange" id="rjgl">
			<form class="form-horizontal" role="form" action="" method="POST">
				<div id="toolbox1">
					<div id="gljl1" class="gljla">
						<span id="slelecthead">单位:</span> <span> <select id="dwmc"
							name="dwmc" class="selectway" onchange="dwmcchange()">
								<option>请选择</option>
						</select>
						</span>
					</div>
					<div class="gljlr" style="display:block;">
						<!-- <span style="margin-right: 20px"><input type="button"
							class="btn btn-primary btn-sm" id="update" value="保存" /></span>  -->
						<span><input type="button" class="btn btn-primary btn-sm"
							id="btnExport" value="导出"/></span>
					</div>
				</div>
			</form>
			<ul id="myTab" class="nav nav-tabs" style="margin-top:0px">
				<li class="active"><a href="#nsolve" data-toggle="tab" id="nso">进度管理</a>
				</li>
				<li><a href="#zsolve" data-toggle="tab" id="zso">进度统计</a></li>			
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="nsolve">
				<!-- 表格#b9b9b9 -->
					<div id="tab0">
						<form class="form-horizontal" role="form" action="" method="POST">
		
							<table id="tableid">
								<thead id="tableheader" bgcolor="#ADD8E6">
								</thead>
								<tbody id="tbody">
								</tbody>
							</table>
						</form>
						<form id="barcon" style="margin-top: 30px; margin-bottom: 20px;">
						</form>
					</div>
				</div>
				<div class="tab-pane fade in" id="zsolve">
					<div id="graph" style="width: 1000px; height: 1800px; margin-top: 10px"></div>
					<div id="graph1" style="width: 1000px; height: 400px; margin-top: 10px"></div>
				</div>
			</div>	
		</div>
	</div>
	</main>
</body>
<script type="text/javascript">
	$(function () {
			$('#myTab li:eq(0) a').tab('show');
		});
	$("#zso").click(function() {	
	$(".gljlr").css("display", "none");
		var option4 = $("#dwmc option:selected").text()
		if(option4=="请选择"){
			$("#graph").css("display", "block");
			$("#graph1").css("display", "none");		
			ceshi();
		}else{
			$("#graph1").css("display", "block");
			$("#graph").css("display", "none");		
			ceshi1();
		}	
	})
	$("#nso").click(function() {
		$(".gljlr").css("display", "block");
	})
	function ceshi() {
		echartsunit = "[" + echartsunit.substring(0, echartsunit.length - 1)
			+ "]";
		echartsStepData = "["
			+ echartsStepData.substring(0, echartsStepData.length - 1)
			+ "]";
		//echartsStepLength="["+echartsStepLength+"]";
		unitnums = "[" + unitnums.substring(0, unitnums.length - 1) + "]";

		echartsunit = JSON.parse(echartsunit);
		echartsStepData = JSON.parse(echartsStepData);
		unitnums = JSON.parse(unitnums);
		echartsStepLengt = echartsStepLength + 1;
		//y轴倒叙显示
		var qwer = 0;
		var echartsunit1;
		var qq = new Array();
		for (var i = echartsunit.length - 1; i >= 0; i--) {
			qq.push(echartsunit[i]);
		}
		//x轴数值
		var qwnum = 0;
		var unitnums1;
		var qqnum = new Array();
		for (var i = unitnums.length - 1; i >= 0; i--) {
			qqnum.push(unitnums[i]);
		}
		var myChart = echarts.init(document.getElementById('graph'));
		var option = {
			title : {
				text : '工程实施进度图示'
			},
			tooltip : {},
			legend : {
				data : [ '工程进度查看' ]
			},
			yAxis : {
				axisLabel: { //xAxis，yAxis，axis都有axisLabel属性对象 
				show: true, //默认为true，设为false后下面都没有意义了 
				interval: 0, //此处关键， 设置文本标签全部显示 				
				},
				data : qq
			},

			xAxis : {
				min : 0,
				max : echartsStepLength,
				interval : 1,
				axisLabel : {
					formatter : function(value) {
						var texts = [];
						if (value == 0) {
							return "0";
						}
						return echartsStepData[value - 1];
					}
				}
			},
			grid : { // 控制图的大小，调整下面这些值就可以，
				x : 200,
				x2 : 40,
			// y2: 150// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
			},
			series : [ {
				name : '完成进度',
				type : 'bar',
				barMaxWidth : 10,//柱图宽度
				itemStyle:{ 
					normal:{ color: ['#3398DB']} //柱状颜色
				},
				data : qqnum
			} ]
		};

		myChart.setOption(option, true);
	}
	;
	function ceshi1() {
		echartsunit = "[" + echartsunit.substring(0, echartsunit.length - 1)
			+ "]";
		echartsStepData = "["
			+ echartsStepData.substring(0, echartsStepData.length - 1)
			+ "]";
		//echartsStepLength="["+echartsStepLength+"]";
		unitnums = "[" + unitnums.substring(0, unitnums.length - 1) + "]";

		echartsunit = JSON.parse(echartsunit);
		echartsStepData = JSON.parse(echartsStepData);
		unitnums = JSON.parse(unitnums);
		echartsStepLengt = echartsStepLength + 1;
		//y轴倒叙显示
		var qwer = 0;
		var echartsunit1;
		var qq = new Array();
		for (var i = echartsunit.length - 1; i >= 0; i--) {
			qq.push(echartsunit[i]);
		}
		//x轴数值
		var qwnum = 0;
		var unitnums1;
		var qqnum = new Array();
		for (var i = unitnums.length - 1; i >= 0; i--) {
			qqnum.push(unitnums[i]);
		}
		var myChart = echarts.init(document.getElementById('graph1'));
		var option = {
			title : {
				text : '工程实施进度图示'
			},
			tooltip : {},
			legend : {
				data : [ '工程进度查看' ]
			},
			yAxis : {
				axisLabel: { //xAxis，yAxis，axis都有axisLabel属性对象 
				show: true, //默认为true，设为false后下面都没有意义了 
				interval: 0, //此处关键， 设置文本标签全部显示 				
				},
				data : qq
			},

			xAxis : {
				min : 0,
				max : echartsStepLength,
				interval : 1,
				axisLabel : {
					formatter : function(value) {
						var texts = [];
						if (value == 0) {
							return "0";
						}
						return echartsStepData[value - 1];
					}
				}
			},
			grid : { // 控制图的大小，调整下面这些值就可以，
				x : 200,
				x2 : 40,
			// y2: 150// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
			},
			series : [ {
				name : '完成进度',
				type : 'bar',
				 barMaxWidth : 10,//柱图宽度
				itemStyle:{ 
					normal:{ color: ['#3398DB']} //柱状颜色
				},
				data : qqnum
			} ]
		};

		myChart.setOption(option, true);
	}
	;
</script>

</html>
