$().ready(function() {
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		//document.getElementById('selectadd').disabled=true;
		document.getElementById('selectcg').disabled=true;
		document.getElementById('selectde').disabled=true;
	}
	//修改
		$("#selectcg").click(function(){
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
							var operator1 = "功能名称修改查询数据加载";
							$("#modal").css("display","block");
							$.ajax({
						        type : "post", 		      
						        contentType: "application/x-www-form-urlencoded",
						        url : "/swsrv/queryDataAll/queryDataServlet", 
						        dataType : "json",  
						        cache: false,
						        data :
						        {
						             "pguid" :pguid,         
						             "operator1" : operator1,
						        },        
						        success : function(response)
						        {
						        		tlj = response; 
								        $("#functionxg").val(tlj[2][0]);											
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
			});
			
			
			$("#btn4").unbind();
			$("#btn4").click(function(){
				var operator1 = "修改功能提交";
				var functionxg=$("#functionxg").val();
				if(functionxg==""||functionxg==0||functionxg==undefined||functionxg==null){
					alert("请输入功能");
				}else{
					$.confirm({
		   				title : '确认提交修改信息吗？',
		   				content : '',
		   				buttons : {
		   					确定 : {
		   						btnClass : 'btn-blue',
		   						action : function() {
		   							$.ajax({
								        type : "post", 		      
								        contentType: "application/x-www-form-urlencoded",
								        url : "/swsrv/queryDataAll/queryDataServlet", 
								        dataType : "json",  //数据类型，可以为json，xml等等，自己百度
								        cache: false,
								        data :
								        {
								        	 "operator1":operator1,
								             "functionxg" :functionxg,        
								             "pguid" :pguid,
								        },
								        
								        success : function(response)
								        {
								        	if(response == "1"){
								        		$.confirm({
							        				title : '信息提交成功！',
							        				content :'',
							        				buttons : {
							        					查看记录:{
							        						btnClass : 'btn-blue',
							        						action : function() {
							        							 CloseModal();
							        							 functionquery("功能设置查询", $("#hy option:selected").text(), $("#zy option:selected").text(), $("#rjmc option:selected").text());
							        						}
							        					},
							        					重新修改:{
							        						btnClass : 'btn-blue',
							        						action : function() {
							        							 functionquery("功能设置查询", $("#hy option:selected").text(), $("#zy option:selected").text(), $("#rjmc option:selected").text());
							        						}}
							        				}
							        			})
								        	}else if(response=="2"){
												$.alert("修改失败,功能名称已存在！");
												$("#functionxg").css("border","1px solid red");
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
			$(".close").click(function(){
				 CloseModal();
			})
			
		})
		function CloseModal(){
			$("#modal").css("display","none");
			$("#functionxg").val("");
		}
	
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
			var operator1 = "功能设置删除";
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
								},
								success : function(result) {							
									var hy = $("#hy option:selected");
									var zy = $("#zy option:selected"); //获取选中的项
									var rjmc = $("#rjmc option:selected");
									functionquery("功能设置查询", hy.text(), zy.text(), rjmc.text());							
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



})