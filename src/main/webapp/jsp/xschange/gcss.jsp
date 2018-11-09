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
	<script src="../../assets/js/xschange/gcss.js"></script> 
	<link rel="stylesheet" type="text/css" href="../../css/xcConfirm.css"/>
	<link href="../../assets/js/jquery-confirm/jquery-confirm.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../../css/htmleaf-demo.css">
	<link rel="stylesheet" href="../../assets/css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="../../assets/css/custom.css">
	<link rel="stylesheet" href="../../css/xschange.css">
	<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico" type="image/x-icon" />
<style type="text/css">
	.a2{
		background-color:#e0ffff; 
	}
</style>
	<script type="text/javascript">
	//此方法是每次需要行业专业，软件名称的调用方法
	var gethy,getzy,getrjmc;
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
	function funitadd() {
		var option1 = $("#dwjbadd option:selected").text(); 
		gethzunitname();
		//alert(option1);
		if(option1=="总公司"){ 
				var tljSelectStr = "";
		         tljSelectStr = tljSelectStr + "<option></option>";
		         $("#sjdwadd").html(tljSelectStr);
		        // alert("000000...."+tljSelectStr);
			}else{
				funitaddAjax("上级单位",option1,gethy,getzy,getrjmc);
			}
		
		$('#dwjbadd').css({'border-color':'#ccc','focus':'blue'});
	}
	function funitaddAjax(operator1,dwjbadd,hangye,zhuanye,rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", 
			data : {
				"operator1" : operator1,
				"dwjbadd":dwjbadd,
				"hy":hangye,
				"zy":zhuanye,
				"rjmc":rjmc,
			},
			dataType : 'json',
			success : function(response) {
			console.log(response);
				tlj = response;
				if(tlj!=""){
					var tljArray = "";
					var tljSelectStr = "";
					for (var i = 0, len = tlj[0].length; i < len; i++) {
						tljSelectStr = tljSelectStr + "<option >" + tlj[0][i] + "</option>"
					}
					$("#sjdwadd").html(tljSelectStr);	
				}
					
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败，请检查网络设置");
			}
		});
	}

	

	//导出表格	
    function getExplorer() {
		var explorer = window.navigator.userAgent;
		if (explorer.indexOf("MSIE") >= 0 || (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer.indexOf("Trident/7.0;") >= 0) ) {
			return 'ie';
		}
		else if (explorer.indexOf("Firefox") >= 0) {
			return 'Firefox';
		}
		else if (explorer.indexOf("Chrome") >= 0) {
			return 'Chrome';
		}
		else if (explorer.indexOf("Opera") >= 0) {
			return 'Opera';
		}
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
        a.attr("download",'工程实施表');//这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
        document.getElementById("dlink").click();
    }
})();
	</script>
  </head>
  <body>

  	<main id="content-wrapper" class="page-wrapper">
		<!--中部右侧 -->
		<div id="right">
			<!--工程实施-->
			<div class="xschange" id="gcss">
				 <form  method="POST"  class="form-horizontal"  role="form" name="form" id="form">
				 	<div id="toolbox" style="font-weight:700;">
						<div class="selc">
							<span id="slelecthead">单位:</span>
							<span style="margin-right:25px;">
								<select id="dwmc" class="selectway" name="dwmc"  >
									<option>请选择</option>
								</select>
							</span>
						</div>
				 	</div>				 	
				 </form> 
				 <!-- 查询按钮 -->
				 <div id="btns" style="margin-top:-50px;">
				 	<input type="button" class="btn btn-primary btn-sm" id="selectadd" value="添加"/>
				 	<input type="button" class="btn btn-primary btn-sm" id="selectde" value="删除"/>
				 	<input type="button" class="btn btn-primary btn-sm" id="selectcg" value="修改"/>
				 	<input type="button" class="btn btn-primary btn-sm" id="btnExport" value="导出"/>
				</div>
				<div id="tab5">
					<table id="tab">
						<thead style="background:#ADD8E6;">
							<tr>
								<th width="2%"><input type="checkbox" id="checkall"/></th>
								<th width="3%">序号</th>
								<th width="12%">单位名称</th>
								<th width="21%">施工时间计划</th>
								<th width="10%">联系人</th>
								<th width="11%">中北公司联系人</th>
								<th width="21%">备注</th>
							</tr>
						</thead>
						 <tbody id="tbody1">							
						</tbody>
					</table>
					 <form id="barcon" style="margin-top:30px;margin-bottom:20px;" >
         				   
					</form>
				</div>
			</div>			
		</div>
	</main>
	<div class="modal" id="modal3">
            <div class="modal-dialog">
            <div class="close" id="close1">×</div>
            
                <div class="modal-content">
                    <h4 align="center" style="margin-bottom:20px;">工程信息录入</h4>
                   <form  method="POST"  class="form-horizontal"  role="form" name="form" id="form" enctype="multipart/form-data">
					<div id="row1" class="row">
						<div id="gcssl" class="col-sm-4">
							<div class="form-group">
								<label for="" class="col-sm-6 control-label">单位名称:</label>
								<div class="col-sm-6">
									<input name="dwmcadd" id="dwmcadd" class="form-control" onchange="$('#dwmcadd').css({'border-color':'#ccc','focus':'blue'});"/>
									<span id="span">*</span>					
								</div>
							</div>
						</div>
						<div id="gcssc" class="col-sm-4">
							<div class="form-group">
								<label for="" class="col-sm-6 control-label">单位级别:</label>
								<div class="col-sm-6">
									
									 <select id="dwjbadd" class="form-control" name="dwjbadd"  onchange='funitadd();'>
										<option>请选择</option>
										<option>铁总</option>
										<option>局</option>
										<option>段</option>
									</select>
									<span id="span">*</span> 				
								</div>
							</div>
							
						</div>
						<div id="gcssr" class="col-sm-4">
							<div class="form-group">
								<label for="sjdwadd" class="col-sm-6 control-label">上级单位:</label>
								<div class="col-sm-6">
									<select id="sjdwadd" class="form-control" name="sjdwadd">
									<!-- 	<option>请选择</option>
										<option>铁总</option>
										<option>路局</option>
										<option>电务段</option>
										<option>工区</option> -->
									</select> 
									<span id="span" class="span" style="display:none">*</span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">施工时间计划:</label>
						<div class="col-sm-9">
							<textarea class="form-control" rows="6" name="sgsjadd" id="sgsjadd" ></textarea>
							<!-- <span id="span">*</span> -->					
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">联系人:</label>
						<div class="col-sm-9">
							<textarea class="form-control" rows="6" name="lxradd" id="lxradd" ></textarea>
							<!-- <span id="span">*</span> -->					
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">中北公司联系人:</label>
						<div class="col-sm-9">
							<textarea class="form-control" rows="6" name="zblxradd" id="zblxradd" ></textarea>
							<!-- <span id="span">*</span> -->					
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">备注:</label>
						<div class="col-sm-9">
							<textarea class="form-control" rows="6" name="bzadd" id="bzadd" ></textarea>
							<!-- <span id="span">*</span> -->					
						</div>
					</div>
					<button id="btn2" type="button" class="btn btn-primary btn-sm">提交</button>
					<!-- <button id="btn3" type="button" class="btn btn-primary btn-sm" style="display:none">修改提交</button> -->
				 </form>
                </div>
            </div>
        </div>
        <div class="modal" id="modal4">
            <div class="modal-dialog">
            <!-- <div class="close" id="close1">×</div> -->
            <div class="close" id="close2">×</div>
                <div class="modal-content">
                    <h4 align="center" style="margin-bottom:20px;">工程信息修改</h4>
                   <form  method="POST"  class="form-horizontal"  role="form" name="form" id="form" enctype="multipart/form-data">
					<div id="row2" class="row">
						<div id="gcssl" class="col-sm-4">
							<div class="form-group">
								<label for="" class="col-sm-6 control-label">单位名称:</label>
								<div class="col-sm-6">
									<input name="adwmcxg" id="adwmcxg" class="form-control" type="hidden"/>
									<input name="dwmcxg" id="dwmcxg" class="form-control" onchange="$('#dwmcadd').css({'border-color':'#ccc','focus':'blue'});"/>
									<span id="span">*</span>					
								</div>
							</div>
						</div>
						<div id="gcssc" class="col-sm-4">
							<div class="form-group">
								<label for="" class="col-sm-6 control-label">单位级别:</label>
								<div class="col-sm-6">
									 <select id="dwjbxg" class="form-control" name="dwjbxg">
										<option>请选择</option>
										<!-- <option>铁总</option>
										<option>局</option>
										<option>段</option> -->
									</select>
									<span id="span">*</span> 				
								</div>
							</div>
						</div>
						<div id="gcssr" class="col-sm-4">
							<div class="form-group">
								<label for="sjdwadd" class="col-sm-6 control-label">上级单位:</label>
								<div class="col-sm-6">
									<select id="sjdwxg" class="form-control" name="sjdwxg" onchange="$('#sjdwxg').css({'border-color':'#ccc','focus':'blue'});">
									<!-- 	<option>请选择</option>
										<option>铁总</option>
										<option>路局</option>
										<option>电务段</option>
										<option>工区</option>  -->
									</select> 
									<span id="span" class="span" style="display:none">*</span> 
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">施工时间计划:</label>
						<div class="col-sm-9" id="sgsjgb">
							<textarea class="form-control" rows="6" name="sgsjxg" id="sgsjxg" ></textarea>
							<!-- <span id="span">*</span> -->					
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">联系人:</label>
						<div class="col-sm-9" id="lxrgb">
							<textarea class="form-control" rows="6" name="lxrxg" id="lxrxg" ></textarea>
							<!-- <span id="span">*</span>  -->					
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">中北公司联系人:</label>
						<div class="col-sm-9" id="zblxrgb">
							<textarea class="form-control" rows="6" name="zblxrxg" id="zblxrxg" ></textarea>
							<!-- <span id="span">*</span>  -->					
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">备注:</label>
						<div class="col-sm-9" id="bzgb">
							<!-- <textarea class="form-control" rows="6" name="bzxg" id="bzxg" ></textarea> -->
							<!-- <span id="span">*</span> -->				
						</div>
					</div>
					<!-- <button id="btn2" type="button" class="btn btn-primary btn-sm">提交</button> -->
					<button id="btn3" type="button" class="btn btn-primary btn-sm">修改提交</button>
				 </form>
                </div>
            </div>
        </div>
  </body>
</html>
