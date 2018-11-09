$().ready(function(){
		$("#btnrn").click(function(){
			window.location.href="zcgl.jsp";
		})
		var allLevel="";	
	queryDataHy("查询行业","H0000");
 	Hide();
	function Hide(){     
	    if(window.parent.right.rows == "70,*"){  
	        top.right.rows = "0,*";  
	    } 
	} 
	function queryDataHy(operator1,hangye) {
		//行业
		var hangye="H0000";
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye":hangye
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
				$("#hy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});
	}

	$('#hy').change(function(){
		$('#dlb').val("");
		zhuanye();
	})
	//cah查询专业名称
	function zhuanye() {
		var option1 = $("#hy option:selected"); //获取选中的项
		zhuanyeAjax("查询专业",option1.attr("id"));
		$("#zy").val("请选择");
	}
	//cah查询专业名称
	function zhuanyeAjax(operator1,zhuanye) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"zhuanye" :zhuanye
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
				$("#zy").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}
	
	
	//查询使用级别
	$('#zy').change(function(){
		$('#dlb').val("");
		var option1 = $("#zy option:selected"); //获取选中的项
		queryLevel("查询使用级别",option1.attr("id"));
	})
	function queryLevel1() {
		var option1 = $("#zy option:selected"); //获取选中的项
		queryLevel("查询使用级别",option1.attr("id"));
	}
	function queryLevel(operator1,syjb) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"syjb" :syjb
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				for (var i=0;i<tlj.length;i++){
					allLevel+=tlj[i]+",";//对使用级别返回的结果进行赋值处理全选时的结果显示
				}
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 1, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					tljSelectStr = tljSelectStr + "<option id='" + tljArray[0] + "'>" + tljArray[1] + "</option>"
					
				}
				//$("#syjb").multiselect('refresh');
				$("#syjb").html(tljSelectStr);			
				$('#syjb').multiselect("destroy").multiselect({  
			        nonSelectedText: ' 请选择  ',  
			        buttonWidth:'100%',  
			        includeSelectAllOption: true,  
			        selectAllNumber: false,  
			        selectAllText: '全选',
			        allSelectedText:'全选' 
			        	
			 }); 				
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}
	
	

	
	$('#dlb').change(function(){

		var dlb = $('#dlb').val();
		if(dlb=="0"){
			$('#xmmc').css("display","block");
		}else if(dlb=="1"){
			$('#xmmc').css("display","none");
		}
	});
	
	$('#btn0').click(function(){
		var arrsyjb=$("#syjb").val() ;
		var syjb="";
		for(var i=0;i<arrsyjb.length;i++){
			syjb+=arrsyjb[i]+",";
		}		
		if($('#hy').val()=="请选择"){
			$.alert("请选择行业");
			$("#hy").css("border-color","red");
			return false;
		}else if($('#zy').val()=="请选择"){
			$.alert("请选择专业");
			$("#zy").css("border-color","red");
			return false;
		}else if($('#rjmc').val()== ""){
			$.alert("请填写软件名称");
			$("#rjmc").css("border-color","red");
			return false;
		}else if($('#dlb').val()==""){
			$.alert("请选择端类别");
			$("#dlb").css("border-color","red");
			return false;
		}else if(($('#dlb').val()=="0") && ($('#xmm').val()=="")){
			$.alert("请填写项目名");
			$("#xmm").css("border-color","red");
			return false;
		}else{
			$("#xmm").css("border-color","#ccc");
			//return false;
		}
		$.confirm({
			title : '确认提交信息吗？',
			content : /*'<img style="float:center" src="../../assets/img/ok1.png"/>',*/'',
			buttons : {
				确定 : {
					btnClass : 'btn-blue',
					action : function() {
						
						$.ajax({
					        type : "post", 
					        contentType: "application/x-www-form-urlencoded",
					        url : "/swsrv/SoftWareService/registerServlet", 
					        dataType : "json",   
					        cache: false,
					        data :
					        {
					        	"hy" :$("#hy option:selected").val(),        //操作数 
					             "zy":$("#zy option:selected").val(),     //操作符
					             "rjmc":$("#rjmc").val(),            //操作数 
					             "dlb":$("#dlb option:selected").val(),  
					             "xmm":$("#xmm").val(),   
					             "bbh":$("#bbh").val(),  
					             "rjsm":$("#rjsm").val(),
					             "syjb":syjb
					        },
					        success : function(result)
					        {	
					        	if(result=="a"){
					        		$.alert("该软件名称已存在,请更改");
					        	}else if(result=="b"){
					        		$.alert("该项目名称已存在,请更改");
					        	}else{
					        		if(result == "1"){
					        			$.confirm({
					        				title : '信息提交成功！',
					        				content :'',
					        				buttons : {
					        					查看记录:{
					        						btnClass : 'btn-blue',
					        						action : function() {
					        							window.location.href="zcgl.jsp";
					        						}
					        					},
					        					继续添加:{
					        					}
					        				}
					        			});
						        		//$.alert("提交成功","提示");	
						        	}else{
						        		$.alert("对不起提交失败","提示");
						        	}
					        		
					        	}
					        	       	
					        },
					        error : function(result)
					        {	
					        	
					        	$.alert("提交失败！！！","提示");
					        }
					    });
						
						
					},
				},
				取消 :{}
			}
		});
	});

});


