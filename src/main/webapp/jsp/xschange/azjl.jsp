<%@page pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath %>">
<title>安装记录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/jquery-3.2.1.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>
<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/xschange/azjl.js"></script>

<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
<link rel="stylesheet" href="../../assets/css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="../../assets/css/custom.css">
<link rel="stylesheet" href="../../css/xschange.css">
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico" type="image/x-icon" />
<style type="text/css">
.gljlr {
	width: 60%;
	float: right;
	position: relative;
	top: -20px;
}
</style>
<script type="text/javascript">
	if (window.parent.right.rows == "0,*") {
		top.right.rows = "70,*";
	}//此方法是每次需要行业专业，软件名称的调用方法
	var gethy,getzy,getrjmc;
	function gethzunitname() {
		gethy="";getzy="";getrjmc="";
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
	
	window.onload = function(){
		gethzunitname();
		var sjdw = $("#sjdw option:selected").text();
		var dwmc = $("#dwmc option:selected").text();
		QueryDataSoftManager2("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);
	};
	
	
	
	function goPage(pno) {
		var itable = document.getElementById("tbody");
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
		var tempStr = "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>共" + totalPage + "页</span>";

		if (currentPage > 1) {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage(" + (1) + ")\">首页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage(" + (currentPage - 1) + ")\">上一页</span>"
		} else {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>首页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>上一页</span>";
		}
		for (var pageIndex = 1; pageIndex < totalPage + 1; pageIndex++) {
			tempStr += "<a onclick=\"goPage(" + pageIndex + ")\"><span style=\"margin-right:3px;\">" + pageIndex + "</span></a>";
		}
		if (currentPage < totalPage) {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage(" + (currentPage + 1) + ")\">下一页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage(" + (totalPage) + ")\">尾页</span>";
		} else {
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>下一页</span>";
			tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>尾页</span>";
		}
		document.getElementById("barcon").innerHTML = tempStr;

	}
	//导出表格	
	function getExplorer() {
		var explorer = window.navigator.userAgent;
		if (explorer.indexOf("MSIE") >= 0 || (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer.indexOf("Trident/7.0;") >= 0)) { // ie
			alert("识别你是IE浏览器1111======");
			return 'ie';
		} else if (explorer.indexOf("Firefox") >= 0) { // firefox
			return 'Firefox';
		} else if (explorer.indexOf("Chrome") >= 0) { // Chrome
			return 'Chrome';
		} else if (explorer.indexOf("Opera") >= 0) { // Opera
			return 'Opera';
		} else if (explorer.indexOf("Safari") >= 0) { // Safari
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
				var fname = oXL.Application.GetSaveAsFilename(filename, "Excel Spreadsheets (*.xls), *.xls");
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
			base64 = function(s) {
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
			a.attr("download", '软件管理表'); //这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
			document.getElementById("dlink").click();
		}
	})();
	
		//表格导出
	function qwe() {
		var gethy = $(window.parent.frames["middleTopFrame"].document).find("#hy option:selected").text();
		var getzy = $(window.parent.frames["middleTopFrame"].document).find("#zy option:selected").text();
		var getrjmc = $(window.parent.frames["middleTopFrame"].document).find("#rjmc option:selected").text();
		gethy = gethy.replace(/\s+/g, "");
		getzy = getzy.replace(/\s+/g, "");
		getrjmc = getrjmc.replace(/\s+/g, "");
		var sjdw = $("#sjdw option:selected").text();
		var dwmc = $("#dwmc option:selected").text();
		QueryDataSoftManager2("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);
		var c=document.getElementById("dlink");//此处是对表格导出方法中，append（标签的判断），如果存在，则进行移除，
		if(c!=null){
			c=	c.remove();
		}
		exportToExcel('tableid', '安装管理', '安装管理表');
		QueryDataSoftManager1("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);

	};
	function QueryDataSoftManager1(operator1, hangye, zhuanye, rjmc,sjdw,dwmc) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc,
				"sjdw" : sjdw,
				"dwmc" : dwmc,
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody');
				var TabJsonResult = "";
				if (tlj == "") {
					a.innerHTML = TabJsonResult;
					$.alert("查询内容为空");
				} else {


					//添加删除键后，传id值到前台
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
					goPage(1);
				}
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败!请检查网络设置");
			}
		});
	}
	function QueryDataSoftManager2(operator1, hangye, zhuanye, rjmc,sjdw,dwmc) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc,
				"sjdw" : sjdw,
				"dwmc" : dwmc,
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody');
				var TabJsonResult = "";
				if (tlj == "") {
					a.innerHTML = TabJsonResult;
					$.alert("查询内容为空");
				} else {
					//添加删除键后，传id值到前台
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
				//$.alert("请求数据失败!请检查网络设置");
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
					<div class="selc">
						<span id="slelecthead">上级单位:</span> <span
							style="margin-right:25px;"> <select id="sjdw"
							class="selectway" name="sjdw">
								<option>请选择</option>
							</select>
						</span>
					</div>

					<div class="selc">
						<span id="slelecthead">单位名称:</span> <span style="margin-right:25px;">
							<select id="dwmc" class="selectway" name="dwmc">
								<option>请选择</option>
								
							</select>
						</span>

					</div>
					<div class="gljlr">
						<div id="btns">
								<input type="button" class="btn btn-primary btn-sm" id="add" value="添加" />
								<input type="button" class="btn btn-primary btn-sm" id="update" value="修改"/>
								<input type="button" class="btn btn-primary btn-sm" id="delete" value="删除"/>
								<input type="button" class="btn btn-primary btn-sm" id="btnExport" onclick="qwe()" value="导出"/>
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
									<th width="9%">单位名称</th>
									<th width="7%">单位级别</th>
									<th width="7%">上级单位</th>
									<th width="10%">软件名称</th>
									<th width="6%">版本号</th>
									<th width="11%">服务器IP</th>
									<th width="7%">服务端口</th>
									<th width="12%">安装路径</th>
									<th width="9%">安装日期</th>
									<th width="6%">安装人</th>
									<th width="11%">备注</th>
								</tr>
							</thead>
							<tbody id="tbody">
							</tbody>
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
