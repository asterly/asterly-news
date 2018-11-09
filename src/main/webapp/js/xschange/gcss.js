$().ready(function() {
	//she设置是否编辑按钮的状态
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		document.getElementById('selectadd').disabled=true;
		document.getElementById('selectcg').disabled=true;
		document.getElementById('selectde').disabled=true;
	}
	
	
	//此方法是每次需要行业专业，软件名称的调用方法
	var gethy,getzy,getrjmc;
	function gethzunitname() {
		 gethy=$(window.parent.frames["middleTopFrame"].document).find("#hy option:selected").text();
		 getzy=$(window.parent.frames["middleTopFrame"].document).find("#zy option:selected").text();
		 getrjmc=$(window.parent.frames["middleTopFrame"].document).find("#rjmc option:selected").text();
		gethy=gethy.replace(/\s+/g,"");
		getzy=getzy.replace(/\s+/g,"");
		getrjmc=getrjmc.replace(/\s+/g,"");
	//	var tljSelectStr = "";
		/*var dwmc="请选择";
		tljSelectStr = tljSelectStr + "<option >" + dwmc + "</option>"
		$("#dwmc").html(tljSelectStr);*/
	}
	gethzunitname();
	
	//如果行业专业软件名称存在值直接刷新
	var tljSelectStr = "";
	var dwmc="请选择";
	tljSelectStr = tljSelectStr + "<option >" + dwmc + "</option>"
	$("#dwmc").html(tljSelectStr);
	
	if(getrjmc!=""||getrjmc!="请选择"||getrjmc!="无选项"){
		getinputSolfnameAjax("获取input单位",gethy, getzy,getrjmc);
		var option4 = $("#dwmc option:selected");
		softshishiQuery("工程实施查询数据",gethy, getzy,getrjmc, option4.text());
		/*var tljSelectStr = "";
		var dwmc="请选择";
		tljSelectStr = tljSelectStr + "<option >" + dwmc + "</option>"
		$("#dwmc").html(tljSelectStr);*/     // 7月1日  注释  非自己添加反角没用
		unitlevel("工程实施单位级别查询",gethy,getzy,getrjmc);
	}
	
	//得到父页面的软件名称的onchange事件
	$(window.parent.frames["middleTopFrame"].document).find("#rjmc").change(function(){
		gethzunitname();
		
		getinputSolfnameAjax("获取input单位",gethy, getzy,getrjmc);
		softshishiQuery("工程实施查询数据",gethy, getzy,getrjmc, "请选择");
		/*var tljSelectStr = "";
		var dwmc="请选择";
		tljSelectStr = tljSelectStr + "<option >" + dwmc + "</option>";
		$("#dwmc").html(tljSelectStr);*/   // 7月1日  注释  非自己添加反角没用 
		if(getrjmc!="请选择"){
			unitlevel("工程实施单位级别查询",gethy,getzy,getrjmc);
		}
		
	});
	//单位级别，按照注册时的使用级别查询而来
	function unitlevel(operator1,hangye,zhuanye,rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", 
			data : {
				"operator1" : operator1,
				"hangye":hangye,
				"zhuanye":zhuanye,
				"rjmc":rjmc, 
			},
			dataType : 'json',
			success : function(response) {
			console.log(response);
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				if(tlj!=""){
					for (var i = 0, len = tlj.length; i < len; i++) {
						tljSelectStr = tljSelectStr + "<option >" + tlj[i] + "</option>"
					}
				}
				
				$("#dwjbadd").html(tljSelectStr);		
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败，请检查网络设置");
			}
		});
	}
	
	
	
	
	
function dwmccxjz(){
	gethzunitname();
	
	getinputSolfnameAjax("获取input单位",gethy, getzy,getrjmc);
}
	
	
function getinputSolfnameAjax(operator1,hangye, zhuanye,rjmc) {
	$.ajax({
		type : "post",
		async : true,
		contentType : "application/x-www-form-urlencoded",
		url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
		data : {
			"operator1" : operator1	,
			"hangye" : hangye,
			"zhuanye" : zhuanye,
			"rjmc":rjmc			
		},
		dataType : 'json', //返回数据形式为xml  //timeout:3000,
		success : function(response) {
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				if(tlj==""){
					var tljSelectStr = "";
					var dwmc="请选择";
					tljSelectStr = tljSelectStr + "<option >" + dwmc + "</option>"
					$("#dwmc").html(tljSelectStr);
				}else{
				for (var i = 0, len = tlj[0].length; i < len; i++) {
					tljSelectStr = tljSelectStr + "<option >" + tlj[0][i] + "</option>"
				}
				$("#dwmc").html(tljSelectStr);
				}
		},
		error : function(errorMsg) {
			/* alert("请求zzzzzz数据失败!" + errorMsg); */
		}
	});
}
//gaiian改变单位名称查询数据
$("#dwmc").change(function(){
	gethzunitname();
	var option4 = $("#dwmc option:selected");
	softshishiQuery("工程实施查询数据",gethy, getzy,getrjmc, option4.text());
	asoftshishiQuery();
});

function getUpUnitName(operator1,sa) {
	$.ajax({
		type : "post",
		async : true,
		contentType : "application/x-www-form-urlencoded",
		url : "/swsrv/queryDataHangye/queryDataServletHangye",   
		data : {
			"operator1" : operator1,
			"sa":sa
			
		},
		dataType : 'json',
		success : function(response) {
		console.log(response);
		var tljSelectStr = "";
         tljSelectStr = tljSelectStr + "<option>"+response[0]+"</option>";//根据Pguid查询上级单位名称
        $("#sjdwxg").html(tljSelectStr);
		},
		error : function(errorMsg) {
			//$.alert("请求数据失败，请检查网络设置");
		}
	});
}


	/*//查询按钮
	$("#selectform").click(function(){
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
	})*/
	//添加按钮
	$("#selectadd").click(function(){
		gethzunitname();
		$("#close1").unbind();
		$("#close2").unbind();
		$("#close1").click(function(){
			closeModal();
		})
		if(gethy=="请选择"||gethy==""||gethy==undefined||gethy==null){
			$.alert("请选择行业！");
			$(window.parent.frames["middleTopFrame"].document).find("#hy").css("border","1px solid red");
			return false;
		}else if(getzy=="请选择"||getzy==""||getzy==undefined||getzy==null){
			$.alert("请选择专业！");
			$(window.parent.frames["middleTopFrame"].document).find("#zy").css("border","1px solid red");
			return false;
		}else if(getrjmc=="请选择"||getrjmc==""||getrjmc==undefined||getrjmc==null){
			$.alert("请选择软件！");
			$(window.parent.frames["middleTopFrame"].document).find("#rjmc").css("border","1px solid red");
			return false;
		}else{
			$("#modal3").css("display","block");
			$("#modal4").css("display","none");
			$("#btn2").unbind();
			$("#btn3").unbind();
				//提交按钮
				$("#btn2").click(function(){
					var operator1 ="工程实施数据插入";
					var dwjbadd=$("#dwjbadd").val();
					var sjdwadd=$("#sjdwadd").val();
					var dwmcadd=$("#dwmcadd").val();
					var sgsjadd=$("#sgsjadd").val();
					var lxradd=$("#lxradd").val();
					var  lxradd=lxradd.replace(/\r\n/g,",")    
				        lxradd=lxradd.replace(/\n/g,",");
					while(lxradd.indexOf(",,")>=0){
						lxradd =lxradd.replace(",,",",");
					}
					if(lxradd.substring(0, 1)==","){
						lxradd=lxradd.substring(1,lxradd.length);
					}
					var zblxradd=$("#zblxradd").val();
					var  zblxradd=zblxradd.replace(/\r\n/g,",")    
			        zblxradd=zblxradd.replace(/\n/g,",");
					while(zblxradd.indexOf(",,")>=0){
						zblxradd =zblxradd.replace(",,",",");
					}
					if(zblxradd.substring(0, 1)==","){
						zblxradd=zblxradd.substring(1,zblxradd.length);
					}
					var bzadd=$("#bzadd").val();
					if(dwmcadd == 0 || dwmcadd == null || dwmcadd == undefined || dwmcadd == "请选择"){
						$.alert("请输入单位名称！");
						$("#dwmcadd").css("border-color","red");
						return false;
					}else if(dwjbadd == 0 || dwjbadd == null || dwjbadd == undefined || dwjbadd == "请选择"){
						$.alert("请选择单位级别！");
						$("#dwjbadd").css("border-color","red");
						return false;
					}/*else if(sjdwadd=="请选择"){
						$(".span").css("display","block");
						$.alert("请选择上级单位！");
						$("#sjdwadd").css("border-color","red");
					}*/else{
						 $.confirm({
				   				title : '确认提交信息吗？',
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
										             "hyadd" :gethy,       
										             "zyadd":getzy,     
										             "rjxtadd":getrjmc,   //软件名称           
										             "dwmcadd":dwmcadd,
										             "sjdwadd" : sjdwadd,
										             "sgsjadd":sgsjadd,  
										             "lxradd":lxradd,   
										             "zblxradd":zblxradd, 
										  
										             "bzadd":bzadd,
										             "dwjbadd":dwjbadd,
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
									        							
									        							asoftshishiQuery();
									        							dwmccxjz();
									        						}
									        					},
									        					继续添加:{
									        					}
									        				}
									        			});
										        		
										        	}else if(result == "2"){
										        		$.alert("单位名称已存在,请勿重复添加");
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
			
			
		}
		
	})
	//删除按钮
	$("#selectde").click(function(){
		gethzunitname();
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
		var operator1 = "工程实施删除记录";
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
								"dwmc":$("#dwmc option:selected").text(),
								"hangye":gethy,
								"zhuanye":getzy,
								"rjmc":getrjmc

							},
							success : function(response) {
	
								var a = document.getElementById('tbody1');
								if(response==""){
									tlj = [""];
								
									tlj1=[""];
								}else{
									tlj = response[0];
								
									tlj1=response[1];
								}
								var TabJsonResult = "";

								for (var i = 0; i < tlj[0].length; i++) {
									for (var j = 0; j < tlj.length; j++) {
										if (j == 0) {
											var style="a"+tlj1[0][i];
											TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\" class='"+style+"'><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class =\"checkchoose\"/></td>"; //tr
										}else {
											TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
										}
									}
									TabJsonResult += " </tr>"; //tr
								}
								
								a.innerHTML = TabJsonResult;
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
	//修改工程实施内容
	$("#selectcg").click(function() {
		 gethzunitname();
		$("#close1").unbind();
		$("#close2").unbind();
		$("#close2").click(function(){
			$("#modal4").css("display","none");
		})
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
						
						var operator1 = "工程实施修改";
						$("#modal4").css("display","block");//弹出添加窗口
						$("#modal3").css("display","none");
						$.ajax({
					        type : "post", 		      
					        contentType: "application/x-www-form-urlencoded",
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
									$("#dwmcxg").val(tlj[2]);
									$("#adwmcxg").val(tlj[2]);
									//上级单位
									var ceshi=tlj[8];
									ceshi=ceshi.join("");
										getUpUnitName("根据Pguid查询上级单位名称",ceshi);
										
										
									//单位级别-------------------------------6月29日进行了修改-------------------------------------
							        console.log("单位级别"+tlj[7]);
							        var  arr =["总公司","路局","电务段","车间","班组","个人"];
									var  arr2=["总公司","路局","通信段","车间","班组","个人"];
									var unitGread = 0;
									if(tlj[7]!=""){
												var tljSelectStr = "";
												if(getzy=="信号"){
													 tljSelectStr = tljSelectStr + "<option>"+arr[tlj[7]-1]+"</option>";
												}else{
													 tljSelectStr = tljSelectStr + "<option>"+arr2[tlj[7]-1]+"</option>";
												}
										         $("#dwjbxg").html(tljSelectStr); 
									}else{
										var tljSelectStr = "";
								         tljSelectStr = tljSelectStr + "<option></option>";
								         $("#dwjbxg").html(tljSelectStr); 
									}
									
									
							        $("#sgsjgb").html("<textarea class='form-control' rows='6' name='sgsjxg' id='sgsjxg' >"+ tlj[3] +"</textarea>");
									//联系人
							        $("#lxrgb").html("<textarea class='form-control' rows='6' name='lxrxg' id='lxrxg' >"+ tlj[4] +"</textarea>");		
									//中北公司联系人
									$("#zblxrgb").html("<textarea class='form-control' rows='6' name='zblxrxg' id='zblxrxg' >"+ tlj[5] +"</textarea>");
									//备注
									$("#bzgb").html("<textarea class='form-control' rows='6' name='bzxg' id='bzxg' >"+ tlj[6] +"</textarea>");
					        
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
		var xgunit="";
		function xgunitaddxg() {
			xgunit=$("#adwmcxg").val();
			axgunit=$("#dwmcxg").val();
			gethzunitname();
			xgunitxgAjax("修改单位名称",xgunit,axgunit,gethy,getzy,getrjmc);
		}
		function xgunitxgAjax(operator1,xgunit,axgunit,gethy,getzy,getrjmc) {
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
				data : {
					"operator1" : operator1,
					"xgunit":xgunit,
					"axgunit":axgunit,
					"hy":gethy,
					"zy":getzy,
					"rjxt":getrjmc,
				},
				dataType : 'json',
				success : function(response) {
				console.log(response);

				},
				error : function(errorMsg) {
					//$.alert("请求数据失败，请检查网络设置");
				}
			});
		}

		$("#dwjbxg").bind("click", function() {
			$(this).unbind("click");
			$(this).empty();
			gethzunitname();
			unitlevelxg("工程实施单位级别查询",gethy,getzy,getrjmc);
			/*$(this).append("<option>请选择</option>");
			$(this).append("<option>总公司</option>");
			$(this).append("<option>路局</option>");
			$(this).append("<option>电务段</option>");
			$(this).append("<option>车间</option>");
			$(this).append("<option>班组</option>");
			$(this).append("<option>个人</option>");*/
		});
	//修改时进行单位级别的查询
		function unitlevelxg(operator1,hangye,zhuanye,rjmc) {
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataHangye/queryDataServletHangye", 
				data : {
					"operator1" : operator1,
					"hangye":hangye,
					"zhuanye":zhuanye,
					"rjmc":rjmc, 
				},
				dataType : 'json',
				success : function(response) {
				console.log(response);
					tlj = response;
					var tljArray = "";
					var tljSelectStr = "";
					if(tlj!=""){
						for (var i = 0, len = tlj.length; i < len; i++) {
							tljSelectStr = tljSelectStr + "<option >" + tlj[i] + "</option>"
						}
					}
					
					$("#dwjbxg").html(tljSelectStr);		
				},
				error : function(errorMsg) {
					//$.alert("请求数据失败，请检查网络设置");
				}
			});
		}
		
		
		//.............
		function funitaddxg() {
			var option1 = $("#dwjbxg").val(); 
			gethzunitname();
			if(option1=="总公司"){
				var tljSelectStr = "";
		         tljSelectStr = tljSelectStr + "<option></option>";
		         $("#sjdwxg").html(tljSelectStr);
			}else{
				funitxgAjax("上级单位",option1,gethy,getzy,getrjmc);
			}
			
			
			$('#dwjbxg').css({'border-color':'#ccc','focus':'blue'});
		}
		function funitxgAjax(operator1,dwjbxg,gethy,getzy,getrjmc) {
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
				data : {
					"operator1" : operator1,
					"dwjbadd":dwjbxg,
					"hy":gethy,
					"zy":getzy,
					"rjmc":getrjmc,
					
				},
				dataType : 'json',
				success : function(response) {
				console.log(response);
					tlj = response;
					var tljArray = "";
					var tljSelectStr = "";
					for (var i = 0, len = tlj[0].length; i < len; i++) {
						tljSelectStr = tljSelectStr + "<option >" + tlj[0][i] + "</option>"
					}
					$("#sjdwxg").html(tljSelectStr);		
				},
				error : function(errorMsg) {
					//$.alert("请求数据失败，请检查网络设置");
				}
			});
		}
		$("#dwmcxg").change(function(){
			xgunitaddxg();
			
		});
		$("#dwjbxg").change(function(){
			funitaddxg();
		});
			//修改提交按钮
				$("#btn2").unbind();
				$("#btn3").unbind();
				$("#btn3").click(function(){
					var operator1 ="工程实施修改提交";
					gethzunitname();
					var rjxtadd=$("#rjxt").val();
					var dwjbadd=$("#dwjbxg").val();
					var sjdwadd=$("#sjdwxg").val();
					var dwmcadd=$("#dwmcxg").val();
					var sgsjadd=$("#sgsjxg").val();
					var lxradd=$("#lxrxg").val();
					var  lxradd=lxradd.replace(/\r\n/g,",")    
				        lxradd=lxradd.replace(/\n/g,",");
					while(lxradd.indexOf(",,")>=0){
						lxradd =lxradd.replace(",,",",");
					}
					
					if(lxradd.substring(0, 1)==","){
						lxradd=lxradd.substring(1,lxradd.length);
					}
					var zblxradd=$("#zblxrxg").val();
					var  zblxradd=zblxradd.replace(/\r\n/g,",")    
			        zblxradd=zblxradd.replace(/\n/g,",");
					while(zblxradd.indexOf(",,")>=0){
						zblxradd =zblxradd.replace(",,",",");
					}
					if(zblxradd.substring(0, 1)==","){
						zblxradd=zblxradd.substring(1,zblxradd.length);
					}
					var bzadd=$("#bzxg").val();
					if(dwmcadd == 0 || dwmcadd == null || dwmcadd == undefined || dwmcadd == "请选择"){
						$.alert("请输入单位名称！");
						$("#dwmcxg").css("border-color","red");
						return false;
					}else if(dwjbadd == 0 || dwjbadd == null || dwjbadd == undefined || dwjbadd == "请选择"){
						$.alert("请选择单位级别！");
						$("#dwjbxg").css("border-color","red");
						return false;
					}else if(sjdwadd=="请选择"){
						$(".span").css("display","block");
						$.alert("请选择上级单位！");
						$("#sjdwxg").css("border-color","red");
					}else{
						 $.confirm({
				   				title : '确认提交修改信息吗？',
				   				content : /*'<img style="float:center" src="../../assets/img/ok1.png"/>',*/'',
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
										        	"pguid":pguid,
										             "hyadd" :gethy,        //操作数 
										             "zyadd":getzy,     //操作符
										             "rjxtadd":getrjmc,             
										             "dwmcadd":dwmcadd,
										             "sjdwadd" : sjdwadd,
										             "sgsjadd":sgsjadd,  
										             "lxradd":lxradd,   
										             "zblxradd":zblxradd, 
										             "bzadd":bzadd,
										             "dwjbadd":dwjbadd,
										        },
										        
										        success : function(result)
										        {
										        	console.log(result)
										        	if(result == "1"){
										        		$.confirm({
									        				title : '信息提交成功！',
									        				content :'',
									        				buttons : {
									        					查看记录:{
									        						btnClass : 'btn-blue',
									        						action : function() {
									        							$("#modal4").css("display","none");
												        				
																         asoftshishiQuery();
																         dwmccxjz();
									        						}
									        					},
									        					继续添加:{
									        					}
									        				}
									        			});
										        		
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
			
			
	
	});


	function closeModal(){
		asoftshishiQuery();
		$("#modal3").css("display","none");
		$("#modal4").css("display","none");
		$("#dwmcadd").val("");
		$("#dwjbadd").val("");
		$("#sjdwadd").val("");
		$("#sgsjadd").val("");
		$("#lxradd").val("");
		$("#zblxradd").val("");
		$("#bzadd").val("");		
	}

	function asoftshishiQuery(){
		gethzunitname();
		var option4 = $("#dwmc option:selected");	
		softshishiQuery("工程实施查询数据",gethy, getzy,getrjmc, option4.text());
	}

	function  softshishiQuery(operator1,hangye,zhuanye,rjmc,dwmc){
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1	,
				"hangye" : hangye,
				"zhuanye" : zhuanye,
				"rjmc":rjmc	,
				"dwmc":dwmc,	
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
					var a = document.getElementById('tbody1');
					var TabJsonResult = "";
					if(response==""){
						a.innerHTML = TabJsonResult;
					}else{
						tlj = response[0];
						tlj1=response[1];
						for (var i = 0; i < tlj[0].length; i++) {
							for (var j = 0; j < tlj.length; j++) {
								if (j == 0) {
									var style="a"+tlj1[0][i];
									TabJsonResult += "<tr  id=\"" + tlj[0][i] + "\" class='"+style+"'><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' class =\"checkchoose\"/></td>"; //tr
								}else {
									TabJsonResult += "<td>" + tlj[j][i] + "</td>"; //td	
								}
							}
							TabJsonResult += " </tr>"; //tr
						}
						a.innerHTML = TabJsonResult;
					}
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
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
				//gethzunitname();
				//var option4 = $("#dwmc option:selected");
				//alert(option4.text());
				//softshishiQuery("工程实施查询数据",gethy, getzy,getrjmc, option4.text());
				exportToExcel('tab','工程实施','工程实施表');
				var c=document.getElementById("dlink");//此处是对表格导出方法中，append（标签的判断），如果存在，则进行移除，
				if(c!=null){
					c=	c.remove();
				}
			});
})