<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>问题查询</title>

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
	
	<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../../css/jquery.dialog.css">
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
	<link rel="stylesheet" href="../../assets/css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="../../assets/css/custom.css">
	<link rel="stylesheet" href="../../css/xschange.css">
	<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico" type="image/x-icon" />
	<style type="text/css">
.model {
  display: none;
  margin:0 auto;
  margin-top:1%;
  z-index: 1;
  padding-top: 4%;
  left: 0;
  top: 0;
  width: 50%;
  height:80%;
  overflow: auto;
  background-color: #ddd;
}

/* Model Content */
.model-content1 {
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

.close:hover,
.close:focus {
  color: red;
  text-decoration: none;
  cursor: pointer;
}

</style>
<script type="text/javascript">
	window.onload = yu("问题查询");
	function yu(operator1) {
		y("0");
		dwcx("A00");
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataI/queryDataIntall", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
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
						} else {
							TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
							
						}
					}
					TabJsonResult += " <td><button id='but' class='btn btn-sm btn-primary'>显示</button></td></tr>"; //tr
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
	function y(operator1) {
		//行业
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1
			},
			dataType : 'json',
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
				$.alert("请求数据失败，请检查网络设置");
			}
		});
		wtlxquery();
	}

	function zhuanye() {
		var option1 = $("#hy option:selected"); //获取选中的项
		zhuanyeAjax(option1.attr("id"));
		$("#zy").val("请选择");
		$("#rjxt").val("请选择");
		$("#wtlx").val("请选择");
		
	}
	function zhuanyeAjax(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1
			},
			dataType : 'json',
			success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					tljSelectStr = tljSelectStr + "<option id='" + tljArray[0] + "'>" + tljArray[1] + "</option>";
				}
				$("#zy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败，请检查网络设置");
			}
		});
	}

	function getSolfname() {
		var option1 = $("#zy option:selected"); //获取选中的项
		var option2 = $("#hy option:selected");
		getSolfnameAjax(option1.attr("id"), option2.text(), option1.text());
		$("#rjlx").val("请选择");
		$("#wtlx").val("请选择");
	}
	function getSolfnameAjax(operator1, hangye, zhuanye) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataSName/queryDataSoftName", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye
			},
			dataType : 'json',
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
				/* alert("请求数据失败!" + errorMsg); */
			}
		});
	}

	function wentiqueryclick() {
		var option1 = $("#hy option:selected"); //获取选中的项
		var option2 = $("#zy option:selected");
		var option3 = $("#rjxt option:selected");
		var option4 = $("#wtlx option:selected");
		var option5 = $("#sfjj option:selected");
		var option6 = $("#dwcx option:selected");
		wentiquery("问题查询按钮", option1.text(), option2.text(), option3.text(), option4.text(), option5.text(), option6.text());
	}


	function wentiquery(wentiquery, hy, zy, rjxt, wtlx, sfjj,dwcx) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataI/queryDataIntall", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"wentiquery" : wentiquery,
				"hy" : hy,
				"zy" : zy,
				"rjxt" : rjxt,
				"wtlx" : wtlx,
				"sfjj" : sfjj,
				"dwcx" : dwcx,
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
							} else {
								TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
							}
						}
						TabJsonResult += " <td><button id='but' class='btn btn-sm btn-primary'>显示</button></td></tr>"; //tr
					}
					a.innerHTML = TabJsonResult;
				}


			},
			error : function(errorMsg) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	}



		function dwcx(operator1){
		 $.ajax({
   		 type: "post",
   		    async: true, 
   		    contentType: "application/x-www-form-urlencoded",
   		    //http://192.168.10.250:199/SignalBigDataService.asmx/（指定网络不能联网）或者192.168.1.100:199（可以联网）  
   		    url: "/swsrv/queryData/queryDataservlect",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
   		    data: { "operator1" : operator1  },//+sql1,//select 名称  from bd_au_单位字典表  ",
   		    dataType: 'json',        //返回数据形式为xml  //timeout:3000,
   		    success: function (response) { 
   		        //请求成功时执行该函数内容，result即为服务器返回的对象
   		        tlj=response;
   		        var tljArray = "";
   		        var tljSelectStr = "";
   		        for(var i=0,len=tlj.length;i<len;i++){
   		            tljArray = tlj[i];
   		            if("请选择"==tljArray[1]){
   		            tljSelectStr = tljSelectStr + "<option value='0'>"+tljArray[1]+"</option>";
   		            }else{
   		            tljSelectStr = tljSelectStr + "<option id='"+tljArray[0]+"'>"+tljArray[1]+"</option>";
   		            }
   		            
   		        }
   		        $("#dwcx").html(tljSelectStr);
   		    },
   		    error: function (errorMsg) {
   		        //请求失败时执行该函数
   		       $.alert("请求数据失败，请检查网络设置!");
   		    }
   		  
   		  }); 
		}
	function qusolveclick() {
		var option1 = $("#sfjj option:selected"); //获取选中的项
		qusolve("问题是否解决", option1.text());
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
							} else {
								TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
							}
						}
						TabJsonResult += "<td><button id='but' class='btn btn-sm btn-primary'>显示</button></td></tr>"; //tr
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


	
	function wtlxquery() {
		wtlx("问题类型查询");
	}
	function wtlx(wtlxcanshu) {
		
		//查询问题类型
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"wtlxcanshu" : wtlxcanshu,
				
			},
			dataType : 'json',
			success : function(response) {
				tlj = response[2];

				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljSelectStr = tljSelectStr + "<option >" + tlj[i] + "</option>";
				}
				$("#wtlx").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败!请检查网络设置");
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
		// ie
		if (explorer.indexOf("MSIE") >= 0 || (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer.indexOf("Trident/7.0;") >= 0) ) {
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
    function exportToExcel(tab,filename,sheetname){  
	    if(getExplorer()=='ie'){
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
	        try{  
	            var fname = oXL.Application.GetSaveAsFilename(filename, "Excel Spreadsheets (*.xls), *.xls");  
	        } catch (e){  
	            print("Nested catch caught " + e);  
	        } finally {  
	            oWB.SaveAs(fname);  
	            oWB.Close(savechanges = false);  
	            oXL.Quit();  
	            oXL = null;  
	            idTmr = window.setInterval("Cleanup();", 1);  
	        }  
	
	    }else{ 
	        tableToExcel(tab,filename,sheetname)  
	    }  
    } 


	function Cleanup(){  
	    window.clearInterval(idTmr);  
	    CollectGarbage();  
	} 

	var tableToExcel = (function (){ 
    var uri = 'data:application/vnd.ms-excel;base64,',
    template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><meta charset="UTF-8"><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
    base64 = function (s) {
    return window.btoa(unescape(encodeURIComponent(s)));
    }, 
    format = function (s, c){
    return s.replace(/{(\w+)}/g, function (m, p) { return c[p]; }); 
    };
    return function (table,filename,sheetname){
    	
	//这里创建一个<a/>标记利用a标记的download属性来自定义Excel文件名,解决button按钮触发下载无法自定义Excel文件名的问题
    	var a = $('<a id="dlink" style="display:none;"/>');
        $(document.body).append(a);
        if (!table.nodeType) table = document.getElementById('tab');
        var ctx = { worksheet: sheetname || 'Worksheet', table: table.innerHTML }
        a.attr("href",uri + base64(format(template, ctx)));
        a.attr("download",'问题反馈表');//这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
        document.getElementById("dlink").click();
    }
})();
</script>

<body>
		<main id="content-wrapper" class="page-wrapper">
			<!--中部右侧 -->
			<div id="right" style="width:2000px">
				<div id="myModal" class="modal">
				    <span id="close" class="close cursor">&times;</span>
				    <div class="modal-content1">
				        <img id="myimage" src="http://192.168.0.211:190/swsrvphoto/1.jpg" style="width: 100%">
				    </div>
				</div>
				<!--问题查询-->
				<div class="xschange" id="wtcx">
					<form  method="POST"  class="form-horizontal"  role="form" name="form" id="form">
						<div id="toolbox">
							
							<div class="selc">
								<span id="slelecthead">行业:</span>
								<span>
									<select id="hy" class="selectway" name="hy" onchange="zhuanye()">
										  <option>请选择</option>
									</select>
									<span style="display:inline-block; width:2px; height:2px; margin-right:25px"></span>
								</span>
							</div>
							
							<div class="selc">
								<span id="slelecthead">专业:</span>
								<span>
									<select id="zy" class="selectway" name="zy" onchange="getSolfname()">
										  <option>请选择</option>
	
									</select>
									<span style="display:inline-block; width:2px; height:2px; margin-right:25px"></span>
								</span>	
							</div>
							
							<div class="selc">
								<span id="slelecthead">软件:</span>
								<span style="margin-right:25px;">
									
									<select id="rjxt" class="selectway" name="rjxt">
										  <option>请选择</option>
									</select>
								</span>
							</div>					
							
							<div class="selc">
								<span id="slelecthead">问题类型:</span>
								<span style="margin-right:25px;">
									<select id="wtlx" class="selectway" name="wtlx">
										  <option >请选择</option>
									</select>
								</span>
							</div>
							
							<div class="selc">
								<span id="slelecthead">单位:</span>
								<span style="margin-right:25px;">
									<select id="dwcx" class="selectway" name="dwcx" >
										  <option>请选择</option>
										  <option>中国铁路总公司</option>
										  <option>武汉铁路局</option>										  
									</select>
								</span>
							
							</div> 
							
							<div class="selc">
								<span id="slelecthead">是否解决:</span>
								<span style="margin-right:25px;">
									<select id="sfjj" class="selectway" name="sfjj" >
										  <option>请选择</option>
										  <option>未解决</option>
										  <option>已解决</option>
										  <option>全部</option>
									</select>
								</span>
							
							</div> 
														
						</div>
							
								
						</form>
						<div id="btns">
							<span id="cx11" style="margin-right:10px;"><input type="button" class="btn btn-primary btn-sm" id="selectform" value="查询" onclick="wentiqueryclick()"/></span>
							<span id="xg11" style="margin-right:10px;"><input type="button" class="btn btn-primary btn-sm" id="selectcg" value="修改"/></span>
							<span id="sc11" style="margin-right:10px;"><input type="button" class="btn btn-primary btn-sm" id="selectde" value="删除"/></span>
							<span id="jj11" style="margin-right:10px;"><input type="button" class="btn btn-primary btn-sm" id="selectso" value="已解决"/></span>
							<span><input type="button" class="btn btn-primary btn-sm" id="btnExport" value="导出"/></span>
							<!-- <button id="but">chaxun</button> -->
						</div>
							
					<div id="tab1">
						<table id="tab">
							  <thead style="background:#ADD8E6;">
								<tr>
								  <th id="state" width="2%"><input type="checkbox" id="checkall"/></th>
								  <th width="4%;">序号</th>								  
								  <th width="7%;">单位</th>
								  <th width="5%;">下级单位</th>
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
								  <th width="5%;">截图</th>
								  <th width="5%;">显示截图</th>
								  					
								</tr>
							  </thead>
							  <tbody id="tbody1">
								<!-- <tr>
									<td><input type="checkbox"/></td>
									<td>1</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td><input type="checkbox"/></td>
									<td>2</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>1.jpg</td>
									<td><button id="but">显示</button></td>
								</tr> -->
							  </tbody>
						</table>

						 <form id="barcon" style="margin-top:30px;margin-bottom:20px;" >
         				   
						 </form> 
					</div>
				</div>
			
			</div>

		</main>
 </body>
	<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="../../assets/js/custom.js"></script>
	<script src="../../assets/js/xschange.js"></script>

	<script src="../../assets/js/xschange/wtcx.js"></script> 
</html>
