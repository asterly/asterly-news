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
<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/jquery-3.2.1.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="../../assets/js/jquery-confirm/jquery-confirm.min.js"></script>
<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../../assets/js/custom.js"></script>
<script src="../../assets/js/xschange.js"></script>
<script src="../../assets/js/xschange/departmentSet.js"></script>

<link rel="stylesheet" type="text/css" href="../../css/xcConfirm.css" />
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
<style type="text/css">
.a2 {
	background-color: #e0ffff;
}
#btns{
	left:90%;
	bottom:35px;
}
#modal {
	width: 40%;
	height: 80%;
	display: none;
	margin: 0 auto;
}

#chooseid {
	width: 100%;
	height: 40%;
	border: 1px solid #ccc;
	padding: 5px;
}

#chooseul li {
	float: left:  
		font-size:18px;
	list-style: none;
}

.modal-content {
	height: 92%;
}

input[type=checkbox] {
	margin: 0 10px 0 0;
}

#btn4 {
	margin-left: 67%;
}
</style>
<script type="text/javascript">
window.onload = queryData("查询部门名称信息");
function queryData(operator1){
	$.ajax({
		type : "post",
		async : true,
		contentType : "application/x-www-form-urlencoded",
		url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
		data : {
			"operator1" : operator1
		},
		dataType : 'json',
		success : function(response) {
			tlj = response;
			var a = document.getElementById('tbody1');
			var TabJsonResult = "";

			for (var i = 0; i < tlj[0].length; i++) {
				for (var j = 0; j < tlj.length; j++) {
					if (j == 0) {
						TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class =\"checkchoose\"/></td>"; //tr
					}else if(j==1){
						TabJsonResult +="<td id='all' guid=\"" + tlj[0][i]+"\"><a href='#'>"+ tlj[1][i] +"</a></td> ";
					} else {
						TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
						
					}
				}
				TabJsonResult += " </tr>"; //tr
			}

			a.innerHTML = TabJsonResult;
			//goPage(1,5);
			goPage(1);
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
		document.getElementById("barcon").innerHTML = tempStr;
	}
</script>
</head>

<body>

	<main id="content-wrapper" class="page-wrapper"> <!--中部右侧 -->
	<div id="right">
		<div class="xschange" id="yhzc">
			<div id="btns">
				<input type="button" class="btn btn-primary btn-sm" id="selectadd" value="添加" />
				<input type="button" class="btn btn-primary btn-sm" id="selectde" value="删除" />		
			</div>
			<div id="tab1">
				<table id="tab">
					<thead style="background: #ADD8E6;">
						<tr>
							<th width="2%"><input type="checkbox" id="checkall" /></th>
							<th width="4%">序号</th>
							<th width="15%">部门名称</th>
						</tr>
					</thead>
					<tbody id="tbody1">
					</tbody>
				</table>
				<form id="barcon" style="margin-top: 30px; margin-bottom: 20px;">
				</form>
			</div>
		</div>
	</div>
	</main>
	<div class="modal" id="modal">
		<div class="modal-dialog">
			<div class="close">×</div>
			<div class="modal-content">
				<h4 align="center" style="margin-bottom: 20px;">部门名称添加</h4>
				<form method="POST" class="form-horizontal" role="form" name="form"
					id="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">部门名称:</label>
						<div class="col-sm-6">
							<input name="department" id="department" class="form-control"
								onchange="$('#department').css({'border-color':'#ccc','focus':'blue'});" />
							<span id="span">*</span>
						</div>
					</div>
					
					<button id="btn4" type="button" class="btn btn-primary btn-sm"  >添加</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
