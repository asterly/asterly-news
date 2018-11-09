











$().ready(function() {
	
	$("#btn-submit").click(function(){
		alert("确定提交吗！")
	})
	
	
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		document.getElementById('selectadd').disabled=true;
		document.getElementById('selectxg').disabled=true;
		document.getElementById('selectde').disabled=true;
	}

	
	$("#chooseid").click(function(){
		$("#chooseid").css("border","1px solid #ccc");
	})
	$("#chooseidxg").click(function(){
		$("#chooseidxg").css("border","1px solid #ccc");
	})
	//添加按钮
	$("#selectadd").click(function(){
			$("#modal2").css("display","none");
			$("#modal1").css("display","block");
				//提交按钮
			//queryDataDepartment("查询部门名称信息");
	
			$("#btn4").click(function(){
				 obj = document.getElementsByName("tion");
				    check_val = [];
				    for(k in obj){
				        if(obj[k].checked)
				            check_val.push(obj[k].value);
				    }
				  
					if($("#bmadd").val()=="请选择"||$("#bmadd").val()==""||$("#bmadd").val()==undefined||$("#bmadd").val()==null){
						$.alert("请选择部门！");
						$("#bmadd").css("border","1px solid red");
						return false;
					}else if($("#xmadd").val()==""||$("#xmadd").val()==undefined||$("#xmadd").val()==null){
						$.alert("请选择姓名！");
						$("#xmadd").css("border","1px solid red");
						return false;
					}else if(check_val==""){
						$.alert("请选择权限！");
						$("#chooseid").css("border","1px solid red");
						return false;
					}else{
						var  operator1="人员注册";
						var  bmadd=$("#bmadd").val();
						var  username=$("#xmadd").val();
						var  quanxian="";
						for(var x = 0;x<check_val.length;x++){
							quanxian+=check_val[x]+",";
						}
						 $.confirm({
				   				title : '确认提交信息吗？',
				   				content : '',
				   				buttons : {
				   					确定 : {
				   						btnClass : 'btn-blue',
				   						action : function() {
				   							$.ajax({
										        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
										        type : "post", 		      
										        contentType: "application/x-www-form-urlencoded",
										        url : "/swsrv/queryDataAll/queryDataServlet", 
										        dataType : "json",  //数据类型，可以为json，xml等等，自己百度
										        cache: false,
										        data :
										        {
										        	"operator1":operator1,
										            "bmadd": bmadd,
										            "username": username,
										            "quanxian":quanxian
										        },
										        
										        success : function(result)
										        {
										        	if(result == "1"){
										        		$.confirm({
									        				title : '信息提交成功！',
									        				content :'',
									        				buttons : {
									        					查看记录:{
									        						btnClass : 'btn-blue',
									        						action : function() {
									        							
									        							window.location.href="userregister.jsp";
									        							queryData("查询注册用户信息");
									        						}
									        					},
									        					继续添加:{
									        					}
									        				}
									        			})
										        		
										        	}else if(result == "2"){
									        			$.alert("对不起用户已存在","提示");
									        			return false;
									        		}else{
										        		$.alert("对不起提交失败","提示");
										        	}							        		        	
										        },
										        error : function(result)							        
										        {	
										        	$.alert("提交失败！！！","提示");
										        }
										    });
				   						},
				   					},
				   					取消 : {}
				   				}
				   	        });
						
					}
			})
	})
	
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++//
	function queryDataDepartmentxg(operator1){
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
				tlj = response[2];
				var a = document.getElementById('bmxg');
				var TabJsonResult = "";

				for (var i = 0; i < tlj.length; i++) {
							TabJsonResult += "<option>" + tlj[i] + "</option>"; //td	
					}
					TabJsonResult += " </tr>"; //tr
				a.innerHTML = TabJsonResult;
				goPage(1);
			},
			error : function(errorMsg) {
				alert("请求数据失败，请检查网络设置");
			}
		});
	}
/*	$("#bmxg").click(function(){
		$(this).unbind();
		queryDataDepartmentxg("查询部门名称信息");
	})*/
	$("#bmxg").click(function(){
		$(this).unbind();
		$(this).empty();
		$(this).append("<option>请选择</option>");
		$(this).append("<option>管理人员</option>");
		$(this).append("<option>工程服务</option>");
		$(this).append("<option>其他</option>");
	})
//修改按钮
	$("#selectxg").click(function(){

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
		var pguid = ids;
		$.confirm({
			title : '选择操作',
			content : '确定要修改这条记录？',
			buttons : {
				确定 : {
					btnClass : 'btn-blue',
					action : function() {
						
						var operator1 = "用户信息修改";
						$("#modal1").css("display","none");
						$("#modal2").css("display","block");
						$.ajax({
					        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
					        type : "post", 		      
					        contentType: "application/x-www-form-urlencoded",
					        //servlet文件名为Calculator，需要提前在web.xml里面注册
					        url : "/swsrv/queryDataAll/queryDataServlet", 
					        dataType : "json",  //数据类型，可以为json，xml等等，自己百度
					        cache: false,
					        data :
					        {
					             "pguid" :pguid,         
					             "operator1" : operator1,
					        },        
					        success : function(response)
					        {
					        		tlj = response;					       
									//部门
					        		  var tljSelectStr = "";
					   		         tljSelectStr = tljSelectStr + "<option>"+tlj[0][1]+"</option>";
					 		        $("#bmxg").html(tljSelectStr);
									//姓名		
									$("#xmxg").val(tlj[0][2]);
									
					        },
					        error : function(result)       
					        {	
					        	$.alert("提交失败！！！","提示");
					        }
					    });

					}
				},
				取消 : {}
			}
		})
		$("#btn3").click(function(){
			
				 obj = document.getElementsByName("tion");
				    check_val = [];
				    for(k in obj){
				        if(obj[k].checked)
				            check_val.push(obj[k].value);
				    }
				  
					if($("#bmxg").val()=="请选择"||$("#bmxg").val()==""||$("#bmxg").val()==undefined||$("#bmxg").val()==null){
						$.alert("请选择部门！");
						$("#bmxg").css("border","1px solid red");
						return false;
					}else if($("#xmxg").val()==""||$("#xmxg").val()==undefined||$("#xmxg").val()==null){
						$.alert("请选择姓名！");
						$("#xmxg").css("border","1px solid red");
						return false;
					}else if(check_val==""){
						$.alert("请选择权限！");
						$("#chooseidxg").css("border","1px solid red");
						return false;
					}else{
						var  operator1="人员注册修改";
						var  bmadd=$("#bmxg").val();
						var  username=$("#xmxg").val();
						var  quanxian="";
						for(var x = 0;x<check_val.length;x++){
							quanxian+=check_val[x]+",";
						}
						 $.confirm({
				   				title : '确认提交信息吗？',
				   				content : /*'<img style="float:center" src="../../assets/img/ok1.png"/>',*/'',
				   				buttons : {
				   					确定 : {
				   						btnClass : 'btn-blue',
				   						action : function() {
				   							$.ajax({
										        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
										        type : "post", 		      
										        contentType: "application/x-www-form-urlencoded",
										        url : "/swsrv/queryDataAll/queryDataServlet", 
										        dataType : "json",  //数据类型，可以为json，xml等等，自己百度
										        cache: false,
										        data :
										        {
										        	"operator1":operator1,
										        	"pguid": pguid,
										            "bmadd": bmadd,
										            "username": username,
										            "quanxian":quanxian
										        },
										        
										        success : function(result)
										        {
										        	if(result == "1"){
										        		$.confirm({
									        				title : '信息提交成功！',
									        				content :'',
									        				buttons : {
									        					查看记录:{
									        						btnClass : 'btn-blue',
									        						action : function() {									        							
									        							window.location.href="userregister.jsp";
									        							queryData("查询注册用户信息");
									        						}
									        					},
									        					继续添加:{
									        					}
									        				}
									        			})
										        	}else{
										        		$.alert("对不起提交失败","提示");
										        	}							        		        	
										        },
										        error : function(result)							        
										        {	
										        	$.alert("提交失败！！！","提示");
										        }
										    });
				   						},
				   					},
				   					取消 : {}
				   				}
				   	        });
						
					}
			})
	})	
//++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//删除按钮
	$("#selectde").click(function(){
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
		var operator1 = "注册用户删除记录";
		
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
								goPage(1);
							},
							error : function(errorMsg) {
								/* alert("请求zzzzzz数据失败!" + errorMsg); */
							}
						});

					}
				},
				取消 : function() {}
			}
		});

	})
	
	$(".close").click(function(){
		window.location.href="userregister.jsp";
	})
	function closeModal(){
		
		$("#modal1").css("display","none");

		
	}
	
	
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
			$('#btnExport').click(function(){
				 
				exportToExcel('tab','用户注册','用户注册表');
			});
})