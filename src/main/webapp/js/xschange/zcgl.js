
$().ready(function() {
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		document.getElementById('add').disabled=true;
		document.getElementById('update').disabled=true;
		document.getElementById('delete').disabled=true;
	}
	//初始化加载表格数据
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
	 $(function() {// 初始化内容
		 gethzunitname();	
		 
			chaxun("注册记录查询", gethy, getzy, getrjmc);
			//var option1 = $("#zy option:selected"); //获取选中的项
			//var option2 = $("#hy option:selected");
			//getSolfnameAjax("软件名称",gethy ,getzy );
			 //$('#zy').css({'border-color':'#ccc','focus':'blue'});
	    });  
	/* function getSolfnameAjax(operator1, hangye, zhuanye) {
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
					$(window.parent.frames["middleTopFrame"].document).find(
					"#rjmc").html(tljSelectStr);
				},
				error : function(errorMsg) {
					 alert("请求zzzzzz数据失败!" + errorMsg); 
				}
			});
		}*/
	
	//QueryDataRegister("注册查询");
	function QueryDataRegister(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody0');
				var TabJsonResult = "";
					 //添加删除键后，传id值到前台
					for (var i = 0; i < tlj[0].length; i++) {
					for (var j = 0; j < tlj.length; j++) {
						if(j==0){
							TabJsonResult += "<tr  id=\""+tlj[0][i]+"\"><td id=\"state\" ><input type=\"checkbox\" guid='"+tlj[0][i]+"' class=\"checkchoose\"/></td>"; 
						}else{
							TabJsonResult += "<td>" + tlj[j][i] + "</td>"; 
						}
					}
					TabJsonResult += "</tr>"; 
				} 
				a.innerHTML = TabJsonResult;
				goPage(1);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}
	
	//得到父页面的软件名称的onchange事件
	$(window.parent.frames["middleTopFrame"].document).find("#rjmc").change(function(){
		gethzunitname();
		chaxun("注册记录查询", gethy, getzy, getrjmc);
	});		
	
	function chaxun(operator1, hangye, zhuanye, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", 
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc
			},
			dataType : 'json', 
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody0');
				var TabJsonResult = "";
				if (tlj == "") {
					a.innerHTML = TabJsonResult;
					$.alert("查询内容为空");
				} else {
					for (var i = 0; i < tlj[0].length; i++) {
					for (var j = 0; j < tlj.length; j++) {
						if(j==0){
							TabJsonResult += "<tr  id=\""+tlj[0][i]+"\"><td id=\"state\" ><input type=\"checkbox\" guid='"+tlj[0][i]+"' class=\"checkchoose\"/></td>"; 
						}else{
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
				alert("请求数据失败!请检查网络设置");
			}
		});
	}
	
	//软件注册
	$("#add").click(function(){
		alert("添加按钮")
		//debugger
		var itemDom =$(window.parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btrjzc =$(window.parent.frames["leftFrame"].document).find("#btrjzc");
		var zcgl =$(window.parent.frames["leftFrame"].document).find("#zcgl");		
		zcgl.find('.sidebar-submenu').css("display","block");
		btrjzc.parent().addClass("active1");
		btrjzc.parent().siblings().removeClass("active1");
		btrjzc.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="jsp/xschange/rjzc.jsp";
//		jsp/xschange/rjzc.jsp
	})
	
	
	//点击删除数据
	$('#delete').click(function(){
		var id = new Array();
		var count = 0;
		$('table input').each(function(){
			if($(this).prop("checked")==true){
				id.push($(this).attr("guid"));
				count++;
			}
		});
				var pguid=id.toString();
				var operator1="注册记录删除";
				$.confirm({
					title:'选择操作',
					content: '确定要删除这些记录？',
					buttons: {
				        确定: {
				        	btnClass : 'btn-blue',
							action : function() {
								$.ajax({
							        type : "post", 
							        contentType: "application/x-www-form-urlencoded",
							        url : "/swsrv/queryDataAll/queryDataServlet", 
							        dataType : "json",   
							        cache: false,
							        data :
							        {
							        	"pguid":pguid,
							        	"operator1":operator1
							        },
							        success : function(result)
							        {
									        	tlj = result;	
												var a = document.getElementById('tbody0');
												var TabJsonResult = "";
												if(tlj==""){
													a.innerHTML = TabJsonResult;
												}else{
													for (var i = 0; i < tlj[0].length; i++) {
														
														for (var j = 0; j < tlj.length; j++) {
															if(j==0){
																TabJsonResult += "<tr  id=\""+tlj[0][i]+"\"><td id=\"state\" ><input type=\"checkbox\" guid='"+tlj[0][i]+"' class=\"checkchoose\"/></td>";
															}else{
																TabJsonResult += "<td>" + tlj[j][i] + "</td>";
															}
														}
														TabJsonResult += "</tr>"; 
													}
													a.innerHTML = TabJsonResult;
													goPage(1);
												}		        	
							        },
							        error : function(result)
							        {	
							        	
							        	$.alert("删除失败！！！","提示");
							        }
							    });
							}
						},
				        取消: function () {
				            
				        }
				 }
		});
	});
	//修改表格内容
	$("#update").click(function(){
		var id = new Array();
		var count = 0;
		$('.checkchoose').each(function() {
			if ($(this).prop("checked") == true) {
				id.push($(this).attr("guid"));
				count++;
			}
		});
		var ids = id.toString();
		if (count != 1) {
			$.alert("请选择一条记录进行修改");
			return false;
		}
		$.confirm({
			title:'选择操作',
			content: '确定要修改这条记录？',
			buttons: {
		        确定: {
		        		btnClass : 'btn-blue',
						action : function() {
							var id1 = ids;
							var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
							itemDom.css('display','none');
							var btrjzc =$(parent.frames["leftFrame"].document).find("#btrjzc");
							var zcgl =$(parent.frames["leftFrame"].document).find("#zcgl");		
							zcgl.find('.sidebar-submenu').css("display","block");
							btrjzc.parent().addClass("active1");
							btrjzc.parent().siblings().removeClass("active1");
							btrjzc.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
							window.location.href="rjzc1.jsp?pguid="+id1;
						}
			        },
					取消:{}
			      }
			});
	})
	
//全选删除
	$("#checkall").prop("checked",false);
	$("#checkall").click(function(){
		var id=new Array();
		if($("#checkall").prop("checked")==true){
			$("input:checkbox").each(function(){
				$(this).prop("checked",true);
			});
		}
		if($("#checkall").prop("checked")==false){
			$("input:checkbox").each(function(){
				$(this).prop("checked",false);
			});
		}
	});
	
	$("input:checkbox").each(function(){
		$(this).click(function(){
			if($(this).prop("checked")==false){
				$("#checkall").prop("checked",false);
			}
		});
	});
	
//	---------------------------------------------------------------------------------
	function goPage(pno){
	    var itable = document.getElementById("tbody0");
	    var num = itable.rows.length;//表格所有行数(所有记录数)
	    console.log(num);
	    var totalPage = 0;//总页数
	    var pageSize = 10;//每页显示行数
	    //总共分几页
	    if(num/pageSize > parseInt(num/pageSize)){
	        totalPage=parseInt(num/pageSize)+1;
	    }else{
	        totalPage=parseInt(num/pageSize);
	    }
	    var currentPage = pno;//当前页数
	    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31
	    var endRow = currentPage * pageSize;//结束显示的行   40
	    endRow = (endRow > num)? num : endRow;    //40
	    console.log(endRow);
	    //遍历显示数据实现分页
	    for(var i=1;i<(num+1);i++){
	        var irow = itable.rows[i-1];
	        if(i>=startRow && i<=endRow){
	            irow.style.display = "table-row";
	        }else{
	            irow.style.display = "none";
	        }
	    }
	    var pageEnd = document.getElementById("pageEnd");
	    var tempStr = "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>共"+totalPage+"页</span>";
	 
	    if(currentPage>1){
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("+(1)+")\">首页</span>";
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("+(currentPage-1)+")\">上一页</span>"
	    }else{
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>首页</span>";
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>上一页</span>";
	    }
	 
	    for(var pageIndex= 1;pageIndex<totalPage+1;pageIndex++){
	        tempStr += "<a onclick=\"goPage("+pageIndex+")\"><span style=\"margin-right:3px;\">"+ pageIndex +"</span></a>";
	    }
	 
	    if(currentPage<totalPage){
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("+(currentPage+1)+")\">下一页</span>";
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary' href=\"#\" onClick=\"goPage("+(totalPage)+")\">尾页</span>";
	    }else{
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>下一页</span>";
	        tempStr += "<span style=\"margin:0 10px;\" class='btn btn-sm btn-primary'>尾页</span>";
	    }
	 
	    document.getElementById("barcon").innerHTML = tempStr;
	 
	}
	
	
	//导出表格	
    function getExplorer() {
		var explorer = window.navigator.userAgent;
		if (explorer.indexOf("MSIE") >= 0 || (explorer.indexOf("Windows NT 6.1;") >= 0 && explorer.indexOf("Trident/7.0;") >= 0) ) {
			alert("识别你是IE浏览器1111======");
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
   //表格数据处理方法
    function exportToExcel(tableid,filename,sheetname){  
	    if(getExplorer()=='ie'){
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
	        tableToExcel(tableid,filename,sheetname)  
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
    				var a = $('<a id="dlink" href="javascript:;" style="display:none;"/>');
       					$(document.body).append(a);
        				if (!table.nodeType) 
        					table = document.getElementById('tableid');
        			var ctx = { 
        					worksheet: sheetname || 'Worksheet', table: table.innerHTML 
        				}
        			var exuri=uri + base64(format(template, ctx));
        			a.attr("href",exuri);
       				a.attr("download",'注册管理');//这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
        			document.getElementById("dlink").click();
   			 }
    })();
	//表格导出
	function educe(){
		var gethy=$(window.parent.frames["middleTopFrame"].document).find("#hy option:selected").text();
		var getzy=$(window.parent.frames["middleTopFrame"].document).find("#zy option:selected").text();
		var getrjmc=$(window.parent.frames["middleTopFrame"].document).find("#rjmc option:selected").text();
		gethy=gethy.replace(/\s+/g,"");
		getzy=getzy.replace(/\s+/g,"");
		getrjmc=getrjmc.replace(/\s+/g,"");
		chaxun2("注册记录查询", gethy, getzy, getrjmc);
		var c=document.getElementById("dlink");//此处是对表格导出方法中，append（标签的判断），如果存在，则进行移除，
		if(c!=null){
			c=	c.remove();
		}
		exportToExcel('tableid','注册管理','注册管理表');
		chaxun1("注册记录查询", gethy, getzy, getrjmc);
	}
	function chaxun1(operator1, hangye, zhuanye, rjmc) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", 
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc
			},
			dataType : 'json', 
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody0');
				var TabJsonResult = "";
				if (tlj == "") {
					a.innerHTML = TabJsonResult;
					$.alert("查询内容为空");
				} else {
					for (var i = 0; i < tlj[0].length; i++) {
					for (var j = 0; j < tlj.length; j++) {
						if(j==0){
							TabJsonResult += "<tr  id=\""+tlj[0][i]+"\"><td id=\"state\" ><input type=\"checkbox\" guid='"+tlj[0][i]+"' class=\"checkchoose\"/></td>"; 
						}else{
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
				alert("请求数据失败!请检查网络设置");
			}
		});
	}
	function chaxun2(operator1, hangye, zhuanye, rjmc) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", 
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc" : rjmc
			},
			dataType : 'json', 
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody0');
				var TabJsonResult = "";
				if (tlj == "") {
					a.innerHTML = TabJsonResult;
					$.alert("查询内容为空");
				} else {
					for (var i = 0; i < tlj[0].length; i++) {
					for (var j = 0; j < tlj.length; j++) {
						if(j==0){
							TabJsonResult += "<tr  id=\""+tlj[0][i]+"\"><td id=\"state\" ><input type=\"checkbox\" guid='"+tlj[0][i]+"' class=\"checkchoose\"/></td>"; 
						}else{
							TabJsonResult += "<td>" + tlj[j][i] + "</td>"; 
						}
					}
					TabJsonResult += "</tr>"; 
				} 
					a.innerHTML = TabJsonResult;
					//alert(TabJsonResult);
					
				}
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}
	
}); 



