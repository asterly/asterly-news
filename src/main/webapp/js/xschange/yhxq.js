

$().ready(function() {
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		document.getElementById('selectadd').disabled=true;
		document.getElementById('selectcg').disabled=true;
		document.getElementById('selectde').disabled=true;
		document.getElementById('selectso').disabled=true;
	}
	getIPPort("IP端口号获取");
	$("#wtcause").change(function() {
		gethzunitname();
		var option4 = $("#wtcause option:selected");
		var option5 = $(".active").find("a").text().substring(0,3);
		var option6 = $("#dwcx option:selected");
		var fslx = "用户需求";
		wentiquery("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5, option6.text(), fslx);
	});
	$("#dwcx").change(function() {
		gethzunitname();
		var option4 = $("#wtcause option:selected");
		var option5 = $(".active").find("a").text().substring(0,3);
		var option6 = $("#dwcx option:selected");
		var fslx = "用户需求";
		wentiquery("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5, option6.text(), fslx);
	});

	//点击删除数据
	$('#selectde').click(function() {
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
		var operator1 = "问题删除记录";
		var fslx = "用户需求";
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
								"operator1" : operator1,
								"fslx" : fslx,
							},
							success : function(result) {
								tlj = result;
								var a = document.getElementById('tbody1');
								var TabJsonResult = "";
								if (tlj == "") {
									a.innerHTML = TabJsonResult;
								} else {
									for (var i = 0; i < tlj[0].length; i++) {

										for (var j = 0; j < tlj.length; j++) {
											if (j == 0) {
												TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class=\"checkchoose\"/></td>"; //tr
											} else if (j == 1) {
												TabJsonResult += "<td id='all' guid=\"" + tlj[0][i] + "\"><a href='#'>" + tlj[1][i] + "</a></td> ";
											} else {
												TabJsonResult += "<td>" + tlj[j][i] + "</td>";
											}
										}
										TabJsonResult += "</tr>"; //tr
									}
									a.innerHTML = TabJsonResult;
									goPage(1);
									wentiqueryclick();
								}

							},
							error : function(result) {

								$.alert("删除失败！！！", "提示");
							}
						});

					}
				},
				取消 : function() {}
			}
		});


	});






	//已解决		
	$('#selectso').click(function() {

		var id = new Array();
		var count = 0;
		$('table input').each(function() {
			if ($(this).prop("checked") == true) {
				id.push($(this).attr("guid"));
				count++;

			}
		});
		if (count == 0) {
			$.alert("请至少选择一条记录");
			return false;
		}
		if (count > 1) {
			$.alert("一次最多只能选择一条记录进行修改");
			return false;
		}
		var pguid = id.toString();
		var operator1 = "问题解决";
		var fslx = "用户需求";
		jPrompt('请输入解决时间', '请输入解决版本号', function(event, val,version) {
			var sotime = val;
			$.confirm({
				title : '选择操作',
				content : '是否继续此操作？',
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
									"operator1" : operator1,
									"sotime" : sotime,
									"version":version,
									"fslx" : fslx,
								},
								success : function(result) {
									tlj = result;
									var a = document.getElementById('tbody1');
									var TabJsonResult = "";
									if (tlj == "") {
										a.innerHTML = TabJsonResult;
									} else {
										for (var i = 0; i < tlj[0].length; i++) {

											for (var j = 0; j < tlj.length; j++) {
												if (j == 0) {
													TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class =\"checkchoose\"/></td>"; //tr
												} else if (j == 1) {
													TabJsonResult += "<td id='all' guid=\"" + tlj[0][i] + "\"><a href='#'>" + tlj[1][i] + "</a></td> ";
												} else {
													TabJsonResult += "<td>" + tlj[j][i] + "</td>";
												}
											}
											TabJsonResult += "</tr>"; //tr
										}
										a.innerHTML = TabJsonResult;
										goPage(1);
									}
									wentiqueryclick();
								},
								error : function(result) {

									$.alert("删除失败！！！", "提示");
								}
							});

						}
					},
					取消 : function() {}
				}
			});

		}, "解决时间");

	});
	$("#nso").click(function(){
		$("#toolbox").css("display","block");
		$("#btns").css("display","block");
		gethzunitname();
		var option4 = $("#wtcause option:selected");
		var option5 = "未解决";
		var option6 = $("#dwcx option:selected");
		var fslx="用户需求";
		wentiquery("问题查询按钮1", gethy,getzy, getrjmc, option4.text(), option5, option6.text(),fslx);
	})
	$("#yso").click(function(){
		$("#toolbox").css("display","block");
		$("#btns").css("display","block");
		gethzunitname();
		var option4 = $("#wtcause option:selected");
		var option5 = "已解决";
		var option6 = $("#dwcx option:selected");
		var fslx="用户需求";
		wentiquery("问题查询按钮1", gethy,getzy, getrjmc, option4.text(), option5, option6.text(),fslx);
	})
	function wentiqueryclick() {
		gethzunitname();
		var option4 = $("#wtcause option:selected");
		var option5 = $(".active").find("a").text().substring(0,3);
		var option6 = $("#dwcx option:selected");
		var fslx = "用户需求";
		wentiquery("问题查询按钮1", gethy, getzy, getrjmc, option4.text(), option5, option6.text(), fslx);
	}

	var fslx="用户需求";
	function wentiquery(wentiquery, hy, zy, rjxt, wtcause, sfjj, dwcx, fslx) {
		$.ajax({
			type : "post",
			async : true,
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
								TabJsonResult += "<td id='all' guid=\"" + tlj[0][i] + "\"><a href='#'>" + tlj[1][i] + "</a></td> ";
							} else {
								TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
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
	//修改表格内容
	$("#selectcg").click(function() {
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
		var quso = "问题解决";
		$.confirm({
			title : '选择操作',
			content : '确定要修改这条记录？',
			buttons : {
				确定 : {
					btnClass : 'btn-blue',
					action : function() {

						var id1 = ids;
						window.location.href = "wtjl1.jsp?pguid=" + id1;

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


	function openModal() {
		document.getElementById('myModal').style.display = "block";
	}

	function closeModal() {
		document.getElementById('myModal').style.display = "none";
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
				ipPort=JSON.stringify(ipPort);
			},
			error : function(errorMsg) {}
		});

	}



	$("#tab2").on("click", "#but", function() {
		 var Port=ipPort.indexOf(':')+1;//截取开始位置
		 var kPort=ipPort.length-2;//端口号长度
		 var mport=ipPort.substring(Port, kPort);//截取端口号
		 var test = window.location.host;
		 test = test.substring(0, test.indexOf(":"));
		var ff = $(this).parent().prev().html();
		console.log(ff);
		if (ff == "null" || ff == "" || ff == undefined) {
			$.alert("这条记录没有截图！", "提示");
			return false;
		} else {
			/*var element = document.getElementById('myimage');
			element.src = "http://" + test +":"+mport+ "/swsrvphoto/" + ff + "";*/
			ipPort=ipPort.replace("\"", "");
			ipPort=ipPort.replace("\"", "");
			var element = document.getElementById('myimage');
			//element.src = "http://" + test +":"+mport+ "/swsrvphoto/" + ff + "";
			element.src = "http://"+ ipPort+ "/swsrvphoto/" + ff ;
			openModal();
			return false;
		}

	});
	//显示全部信息
	$("#tab").on("click", "#all", function() {
		var allcs = $(this).attr("guid");
		var operator1 = "查询全部参数";
		console.log(allcs);
		$("#Modal1").css("display", "block");
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"allcs" : allcs,
			},
			dataType : 'json',
			success : function(response) {
				tlj = response;
				var a = document.getElementById('tbody2');
				var TabJsonResult = "";

				for (var i = 0; i < tlj[0].length; i++) {
					for (var j = 0; j < tlj.length; j++) {
						if (j == 0) {
							TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\">"; //tr
						} else {
							TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	

						}
					}
					TabJsonResult += " <td><button id='but' class='btn btn-sm btn-primary'>显示</button></td></tr>"; //tr
				}

				a.innerHTML = TabJsonResult;

			},
			error : function(errorMsg) {
				$.alert("请求数据失败，请检查网络设置");
			}
		});
	});
	$("#close1").click(function() {
		$("#Modal1").css("display", "none");
		closeModal();
	})

	$("#close2").click(function() {
		closeModal();
	})

	$("#selectadd").click(function() {
		var fslx = "yhxq";
		window.location.href = "wtjl.jsp?fslx=" + fslx;
		console.log("fslx");
	})
})