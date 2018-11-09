$().ready(function() {
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		document.getElementById('selectadd').disabled=true;
		//document.getElementById('update').disabled=true;
		document.getElementById('selectde').disabled=true;
	}
	$("#chooseid").click(function(){
		$("#chooseid").css("border","1px solid #ccc");
	})
	//添加按钮
	$("#selectadd").click(function(){
			
			$("#modal").css("display","block");
				//提交按钮
			$("#department").val("");
			$("#btn4").unbind();
			$("#btn4").click(function(){
				 obj = document.getElementsByName("tion");
				    check_val = [];
				    for(k in obj){
				        if(obj[k].checked)
				            check_val.push(obj[k].value);
				    }
				  
					 if($("#department").val()==""||$("#department").val()==undefined||$("#department").val()==null){
						$.alert("请填写部门名称！");
						$("#department").css("border","1px solid red");
						return false;
					}else{
						var  operator1="部门名称添加";
						
						var  department=$("#department").val();
						
						
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
										            "department": department,
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
									        							closeModal();
									        							queryData("查询部门名称信息");
									        						}
									        					},
									        					继续添加:{
									        					}
									        				}
									        			});	
										        	}else{
										        		$.alert("部门名称已存在","提示");
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
		var operator1 = "部门名称删除记录";
		
		$.confirm({
			title : '选择操作',
			content : '是否删除本部门及其部门下所有人员信息？',
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
		closeModal();
	})
	function closeModal(){
		
		$("#modal").css("display","none");
		$("#dwmcadd").val("");
		$("#dwjbadd").val("");
		$("#sjdwadd").val("");
		$("#sgsjadd").val("");
		$("#lxradd").val("");
		$("#zbadd").val("");
		$("#bzadd").val("");
		
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
				 
				exportToExcel('tab','工程实施','工程实施表');
			});
})