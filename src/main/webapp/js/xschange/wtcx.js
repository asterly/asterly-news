

$().ready(function() {
	getIPPort("IP端口号获取");
	//点击删除数据
	$('#selectde').click(function() {
		var id = new Array();
		var count = 0;
		$('table input').each(function() {
			if ($(this).prop("checked") == true) {
				id.push($(this).attr("guid"));
				count++;
			//alert("qqqqqqqqqqqqq"+$(this).attr("guid"));
			}
		});
		if (count == 0) {
			$.alert("请至少选择一条记录删除");
			return false;
		}
		var ids = id.toString();
		var qude = "问题删除记录";
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
							url : "/swsrv/Hello/HelloForm",
							dataType : "json",
							cache : false,
							data : {
								"ids" : ids,
								"qude" : qude
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
											} else {
												TabJsonResult += "<td>" + tlj[j][i] + "</td>";
											}
										}
										TabJsonResult += " <td><button id='but' class='btn btn-sm btn-primary'>显示</button></td></tr>"; //tr
									}
									a.innerHTML = TabJsonResult;
									goPage(1);
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
		var ids = id.toString();
		var quso = "问题解决";
		jPrompt('请输入解决时间','',function(event,val){
			//alert(val);
			var sotime=val;
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
								url : "/swsrv/Hello/HelloForm",
								dataType : "json",
								cache : false,
								data : {
									"ids" : ids,
									"quso" : quso,
									"sotime" :sotime,
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
												} else {
													TabJsonResult += "<td>" + tlj[j][i] + "</td>";
												}
											}
											TabJsonResult += " <td><button id='but' class='btn btn-sm btn-primary'>显示</button></td></tr>"; //tr
										}
										a.innerHTML = TabJsonResult;
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

		},"解决时间");
	});
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
						var itemDom = $(parent.frames["leftFrame"].document).find(".sidebar-submenu");
						itemDom.css('display', 'none');
						var btwtjl = $(parent.frames["leftFrame"].document).find("#btwtjl");
						var wtfk = $(parent.frames["leftFrame"].document).find("#wtfk");
						wtfk.find('.sidebar-submenu').css("display", "block");
						btwtjl.parent().addClass("active1");
						btwtjl.parent().siblings().removeClass("active1");
						btwtjl.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
						window.location.href = "wtjl1.jsp?pguid="+id1;

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


	//表格导出
	$('#btnExport').click(function() {
		exportToExcel('tab', '问题反馈表', '问题反馈表');

	});
	  function openModal() {
		    document.getElementById('myModal').style.display = "block";
		}

		function closeModal() {
		    document.getElementById('myModal').style.display = "none";
		}
		
		var  ipPort="";
		function getIPPort(operator1){
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
					ipPort=response;
				},
				error : function(errorMsg) {
				}
			});

		}
		
		
		
		 $("#tab").on("click","#but",function(){
			var ff=$(this).parent().prev().html();
			console.log(ff);	
			if(ff=="null"||ff==""||ff==undefined){
				$.alert("当前数据没有截图！！！", "提示");
				return false;
			}else{
				var element = document.getElementById('myimage');
				element.src = "http://"+ipPort+"/swsrvphoto/"+ff+"";
				openModal();
				return false;
			}
			
		});
			
		$("#close").click(function(){
			closeModal();
		})
})