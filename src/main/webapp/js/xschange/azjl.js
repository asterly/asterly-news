
$().ready(function() {
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		document.getElementById('add').disabled=true;
		document.getElementById('update').disabled=true;
		document.getElementById('delete').disabled=true;
	}
	//if($("#sjdw").val()=="请选择"){
	window.onload=sjdw("上级单位查询");
//	}
	
	
	
	//QIntall("软件管理查询");
	//得到父页面的软件名称的onchange事件
	$(window.parent.frames["middleTopFrame"].document).find("#rjmc").change(function() {
		gethzunitname();
		var sjdw = $("#sjdw option:selected").text();
		var dwmc = $("#dwmc option:selected").text();
		//alert("父页面的软件名称的onchange事件");
		QueryDataSoftManager("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);
	});
	
	function QIntall(operator1) {
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
				var a = document.getElementById('tbody');
				var TabJsonResult = "";
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
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}

	//上级单位jsp页面加载
	function sjdw(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1
			}, //+sql1,//select 名称  from bd_au_单位字典表  ",
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				//请求成功时执行该函数内容，result即为服务器返回的对象
				tlj = response[4];
				var arr=new Array();
				for(var i=0;i<tlj.length+1;i++){
					if(i==0){
						arr[i]="请选择";
					}else{
						arr[i]=tlj[i-1];
					}
				}
				
				var tljSelectStr = "";
				for (var j = 0; j < arr.length; j++) {
					tljSelectStr = tljSelectStr + "<option>" + arr[j] + "</option>";
				}
				$("#sjdw").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				//$.alert("请求数据失败，请检查网络设置!");
			}
		});
	}
//单位名称jsp页面加载
	function dwmcajax(operator1,sjdw) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"sjdw" : sjdw,
			}, 
			dataType : 'json',
			success : function(response) {
				tlj = response[2];
				var arr=new Array();
				for(var i=0;i<tlj.length+1;i++){
					if(i==0){
						arr[i]="请选择";
					}else{
						arr[i]=tlj[i-1];
					}
				}
				
				var tljSelectStr = "";
				for (var j = 0; j < arr.length; j++) {
					tljSelectStr = tljSelectStr + "<option>" + arr[j] + "</option>";
				}
				$("#dwmc").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败，请检查网络设置!");
			}
		});
	};

	//上级单位查询
	$("#sjdw").change(function() {
		gethzunitname();
		var sjdw = $("#sjdw option:selected").text();
		dwmcajax("单位名称查询",sjdw);
		var dwmc = "请选择";
		QueryDataSoftManager("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);
	});
	//单位名称查询
$("#dwmc").change(function() {
	gethzunitname();
		var sjdw = $("#sjdw option:selected").text();
		var dwmc = $("#dwmc option:selected").text();
		QueryDataSoftManager("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);
	});

	
	//添加按钮 软件安装
	$("#add").click(function() {
		var itemDom = $(window.parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display', 'none');
		var btrjaz = $(window.parent.frames["leftFrame"].document).find("#btrjaz");
		var zcgl = $(window.parent.frames["leftFrame"].document).find("#zcgl");
		zcgl.find('.sidebar-submenu').css("display", "block");
		btrjaz.parent().addClass("active1");
		btrjaz.parent().siblings().removeClass("active1");
		btrjaz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href = "../xschange/rjaz.jsp";
	});

	
	function QueryDataSoftManager(operator1, hangye, zhuanye, rjmc,sjdw,dwmc) {
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
	//点击删除数据
	$('#delete').click(function() {
		var id = new Array();
		var count = 0;
		$('table input').each(function() {
			if ($(this).prop("checked") == true) {
				id.push($(this).attr("guid"));
				count++;
			}
		});
		if (count == 0) {
			$.alert("请至少选择一条记录删除");
			return false;
		}
		var pguid = id.toString();
		var operator1 = "安装删除记录";
		$.confirm({
			title : '选择操作',
			content : '确定要删除这些记录？',
			buttons : {
				确定 : {
					btnClass : 'btn-blue',
					action : function() {
						$.ajax({
							type : "post",
							contentType : "application/x-www-form-urlencoded",
							url : "/swsrv/queryDataAll/queryDataServlet",
							dataType : "json",
							cache : false,
							data : {
								"pguid" : pguid,
								"operator1" : operator1
							},
							success : function(response) {
								if(response[0]<=0){
									$.alert("删除失败！！！", "提示");
								}
								
								//7.9 注释
								/*tlj = response;
								var a = document.getElementById('tbody');
								var TabJsonResult = "";
								if (tlj == "") {
									a.innerHTML = TabJsonResult;
								} else {
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
									goPage(1);*/
									//alert("ceshi");
									gethzunitname();
									var sjdw = $("#sjdw option:selected").text();
									var dwmc = $("#dwmc option:selected").text();
									//alert("父页面的软件名称的onchange事件");
									QueryDataSoftManager("安装记录查询1", gethy, getzy, getrjmc,sjdw,dwmc);
   								//}
							},
							error : function(response) {

								$.alert("删除失败！！！", "提示");
							}
						});
					}
				},
				取消 : function() {}
			}
		});
	});

	//修改表格内容
	$("#update").click(function() {
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
			title : '选择操作',
			content : '确定要修改这条记录？',
			buttons : {
				确定 : {
					btnClass : 'btn-blue',
					action : function() {
						var id1 = ids;
						var itemDom = $(window.parent.frames["leftFrame"].document).find(".sidebar-submenu");
						itemDom.css('display', 'none');
						var btrjaz = $(window.parent.frames["leftFrame"].document).find("#btrjaz");
						var zcgl = $(window.parent.frames["leftFrame"].document).find("#zcgl");
						zcgl.find('.sidebar-submenu').css("display", "block");
						btrjaz.parent().addClass("active1");
						btrjaz.parent().siblings().removeClass("active1");
						btrjaz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
						window.location.href = "rjaz1.jsp?pguid=" + id1;
					}
				},
				取消 : {}
			}
		});


	});

	//全选删除
	$("#checkall").prop("checked", false);
	$("#checkall").click(function() {
		var id = new Array();
		if ($("#checkall").prop("checked") == true) {
			$("input:checkbox").each(function() {
				$(this).prop("checked", true);
			});
		}
		if ($("#checkall").prop("checked") == false) {
			$("input:checkbox").each(function() {
				$(this).prop("checked", false);
			});
		}
	});
	$("input:checkbox").each(function() {
		$(this).click(function() {
			if ($(this).prop("checked") == false) {
				$("#checkall").prop("checked", false);
			}
		});
	});



});