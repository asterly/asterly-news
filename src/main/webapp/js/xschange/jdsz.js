$().ready(function() {
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		//document.getElementById('selectadd').disabled=true;
		document.getElementById('selectcg').disabled=true;
		document.getElementById('selectde').disabled=true;
	}
	//查询按钮
	function yaz(){
		if($("#hy").val()=="请选择"||$("#hy").val()==""||$("#hy").val()==undefined||$("#hy").val()==null){
			$.alert("请选择行业！");
			$("#hy").css("border","1px solid red");
			return false;
		}else if($("#zy").val()=="请选择"||$("#zy").val()==""||$("#zy").val()==undefined||$("#zy").val()==null){
			$.alert("请选择专业！");
			$("#zy").css("border","1px solid red");
			return false;
		}else if($("#rjxt").val()=="请选择"||$("#rjxt").val()==""||$("#rjxt").val()==undefined||$("#rjxt").val()==null){
			$.alert("请选择软件！");
			$("#rjxt").css("border","1px solid red");
			return false;
		}
	}
	$("#gcjd").change(function(){
		$("#jdmc").val("");
		$("#fzr").val("");
	})
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
							
							var operator1 = "进度名称修改";
							$("#modal").css("display","block");
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
										//单位名称
										$("#jdmcxg").val(tlj[3]);
										$("#fzrxg").val(tlj[4]);
										//上级单位
										var tljSelectStr = "";
								         tljSelectStr = tljSelectStr + "<option>"+tlj[2]+"</option>";
								        $("#gcjdxg").html(tljSelectStr);											
										//单位级别
								       
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
			//gcjdxg
			$("#gcjdxg").bind("click", function() {
				$(this).unbind("click");
				$(this).empty();
				$(this).append("<option>请选择</option>");
				$(this).append("<option>第一阶段</option>");
				$(this).append("<option>第二阶段</option>");
				$(this).append("<option>第三阶段</option>");
				$(this).append("<option>第四阶段</option>");
				$(this).append("<option>第五阶段</option>");
				$(this).append("<option>第六阶段</option>");
				$(this).append("<option>第七阶段</option>");
				$(this).append("<option>第八阶段</option>");
				$(this).append("<option>第九阶段</option>");
				$(this).append("<option>第十阶段</option>");
			});
			$("#btn4").unbind();
			$("#btn4").click(function(){
				var operator1 = "修改进度名称";
				var gcjdxg=$("#gcjdxg").val();
				var jdmcxg=$("#jdmcxg").val();
				var fzrxg=$("#fzrxg").val();
				if(jdmcxg==""||jdmcxg==0||jdmcxg==undefined||jdmcxg==null){
					if(gcjdxg=""||gcjdxg==null||gcjdxg==0||gcjdxg==undefined||gcjdxg=="请选择"){
						$.alert("请选择工程阶段!");
						$("#gcjdxg").css("border","1px solid red");
					}else{
						$.alert("请输入阶段名称!");
						$("#jdmcxg").css("border","1px solid red");
						
					}
					
				}else{
					$.confirm({
		   				title : '确认提交修改信息吗？',
		   				content : '',
		   				buttons : {
		   					确定 : {
		   						btnClass : 'btn-blue',
		   						action : function() {
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
								        	 "operator1":operator1,
								        	 "gcjdxg":gcjdxg,
								             "jdmcxg" :jdmcxg,        //操作数 
								             "fzrxg":fzrxg,     //操作符
								             "pguid" :pguid,
								        },
								        
								        success : function(response)
								        {
								        	console.log(response)
								        	if(response == "1"){
								        		$.confirm({
							        				title : '信息提交成功！',
							        				content :'',
							        				buttons : {
							        					查看记录:{
							        						btnClass : 'btn-blue',
							        						action : function() {
							        							
							        							 CloseModal();
							        							 var hy = $("#hy option:selected");
							        							 var zy = $("#zy option:selected"); //获取选中的项
							        							 var rjxt = $("#rjxt option:selected");
							        							 jieduanquery("软件安装阶段查询",hy.text(),zy.text(),rjxt.text());
							        							
							        						}
							        					},
							        					继续添加:{
							        					}
							        				}
							        			})
								        		
								        		
								        	}else if(response=="2"){
												$.alert("当前选项不能添加！");
												$("#gcjdxg").css("border","1px solid red");
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
			$("#gcjdxg").val("");
			$("#jdmcxg").val("");
			$("#fzrxg").val("");
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
			var operator1 = "工程进度名称删除";
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
	        							 var rjxt = $("#rjxt option:selected");
	        							 jieduanquery("软件安装阶段查询",hy.text(),zy.text(),rjxt.text());								
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