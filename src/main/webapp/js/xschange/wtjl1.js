/**
 * 
 */
$().ready(function(){

	getIPPort("IP端口号获取");
	$("#dwd").change(function () {  
        var optiondwd = $(this).children('option:selected').val();  
        if(optiondwd!="请选择"||optiondwd!=""){
   		   $("#dwdinput") .val("");
   		 $("#tlj") .html("<option>请选择</option><option>中国铁路总公司</option>");
        } 
        if(optiondwd=="中国铁路总公司"){
       	 yu("A00");
        }else{
       	  dianwuduan();
        }
   	 	
    });  
	$("#tlj").change(function () {  
        var optiontlj = $(this).children('option:selected').val();  
        if(optiontlj!="请选择"||optiontlj!=""){
   		     $("#tljinput") .val(optiontlj);
        } 
        var optiondwd = $("#dwdinput").val();
        if(optiondwd!="中国铁路总公司"){
             	  keshi();
             }
    
    }); 
	function yu(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryData/queryDataservlect",
			data : {
				"operator1" : operator1
			},//+sql1,//select 名称  from bd_au_单位字典表  ",
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				//请求成功时执行该函数内容，result即为服务器返回的对象
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					if ("请选择" == tljArray[1]) {
						tljSelectStr = tljSelectStr + "<option>"
								+ tljArray[1] + "</option>";
					} else {
						if(i!=1){
							tljSelectStr = tljSelectStr
							+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
							+ "</option>";
						}
					}
				}
				$("#tlj").html(tljSelectStr);
			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				$.alert("请求数据失败，请检查网络设置!");
			}
		});
	}
	
	$("#cj").change(function () {  
        var optioncj = $(this).children('option:selected').val();  
        if(optioncj!="请选择"||optioncj!=""){
        	$("#cjinput") .val(optioncj);
        } 
       renyuan();
    }); 
	
	
	$("#xm").change(function () {  
        var optionxm = $(this).children('option:selected').val();  
        if(optionxm!="请选择"||optionxm!=""){
   		 $("#xminput") .val(optionxm);
   	} 
    }); 
	
	
	//行业
	$("#hy").change(function () {  
        var optionhy = $(this).children('option:selected').val();  
        if(optionhy!="请选择"||optionhy!=""){
        	$("#hyinput") .val(optionhy);
        } 
       zhuanye();
    });		
	//专业
		$("#zy").change(function () {  
        var optionzy = $(this).children('option:selected').val();  
        if(optionzy!="请选择"||optionzy!=""){
   		 $("#zyinput") .val(optionzy);
        }

        getSolfname();
    }); 
	//软件
		$("#rjxt").change(function () {  
	        var optionrjxt = $(this).children('option:selected').val();  
	        if(optionrjxt!="请选择"||optionrjxt!=""){
	   		       $("#rjxtinput") .val(optionrjxt);
	        } 
	        var hy = $("#hy option:selected");
			var zy = $("#zy option:selected"); //获取选中的项
			var rjmc = $("#rjxt option:selected");
			functionquery("功能设置查询", hy.text(), zy.text(), rjmc.text());  
	    }); 
	
	$("#funct").change(function () {  
        var optionfunct = $(this).children('option:selected').val();  
        if(optionfunct!="请选择"||optionfunct!=""){
        	$("#functinput") .val(optionfunct);
        } 
        
    }); 
	$("#cause").change(function () {  
        var optioncause = $(this).children('option:selected').val();  
        if(optioncause!="请选择"||optioncause!=""){
        	$("#causeinput") .val(optioncause);
        } 
        
    }); 

	var thisURL = document.URL;      
	var getval =thisURL.split('?')[1];    
    var showval= getval.split("=")[1]; 
    var pguid=showval;

	 $('#btn1').click(function(){
		 var fslx=$("#fslx").val();
		 var a=document.getElementById("file");
			var len = a.files.length;
			for(var i=0;i<len;i++){
				a=a.files[i].name;
				console.log("++++++++++"+a);		
			}
			 a=$('#file').val();
			 
				console.log(a);
		var uname=$(parent.frames["topFrame"].document).find("#uname").text();
	
		console.log(uname);
		var coun1=$("#tljinput").val();
		var coun3=$("#rjxtinput").val();
		//var coun4=$("#wtlxinput").val();
		var option1=$("#tlj option:selected");
		var coun2=$("#xminput").val();
		var cj=$("#cjinput").val();
		var operator1="修改记录";
		if(coun1 == 0 || coun1 == null || coun1 == undefined || coun1 == "请选择" || coun1 == "无选项"){
			$.alert("请选择单位！");
			$("#tlj").css("border-color","red");
			$("#tljinput").css("border-color","red");
			return false;
		}else if(cj == 0 || cj == null || cj == undefined || cj == "请选择" || cj == "无选项"){
				$.alert("请选择部门！");
		 		$("#cj").css("border-color","red");
		 		$("#cjinput").css("border-color","red");
				return false;
		}else if(coun2 == 0 || coun2 == null || coun2 == undefined || coun2 == "请选择" || coun2 == "无选项"){
		 		$.alert("请选择姓名！");
		 		$("#xm").css("border-color","red");
		 		$("#xminput").css("border-color","red");
				return false;
		}else if($("#lxdh").val() == 0 || $("#lxdh").val() == null || $("#lxdh").val() == undefined ){ 
		 		$.alert("请填写联系方式！");
		 		$("#lxdh").css("border-color","red");
		 	    return false; 			 	 
		}
		//八月五日添加............发生版本
		else if($("#oversion").val() == "请选择" || $("#oversion").val() == null || $("#oversion").val() == undefined ){ 
	 		$.alert("请填写发生版本！");
	 		$("#oversion").css("border-color","red");
	 	    return false; 			 	 
		}
		//八月五日添加............发生版本
		else if($("#functinput").val() == "请选择" || $("#functinput").val() == null || $("#functinput").val() == undefined ){ 
	 		$.alert("请选择功能！");
	 		$("#functinput").css("border-color","red");
	 	    return false; 			 	 
		}
		
		else if(coun3 == 0 || coun3 == null || coun3 == undefined || coun3 == "请选择" || coun3 == "无选项"){	
				$.alert("请选择软件！");
				$("#rjxt").css("border-color","red");
				$("#rjxtinput").css("border-color","red");
				return false;
			}else if($("#wtms").val()==""){
				$.alert("请输入问题描述！");
				$("#wtms").css("border-color","red")
				return false;
			}else{
				$("#wtms").css("border-color","#ccc");
				//return false;
			}
		if(a=="null"||a==""||a==undefined){
			
			$.confirm({
   				title : '确认提交信息吗？',
   				content :'',
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
						        	"tljinput" : $("#tljinput").val(),   //单位
						             "dwdinput":$("#dwdinput").val(),  //上级单位 //原来下级单位八月十一日修改
						             "cjinput":$("#cjinput").val(),  //部门
						             "xminput":$("#xminput").val(), //姓名
						             "lxdh":$("#lxdh").val(),  //联系电话
						             "hyinput":$("#hyinput").val(),//行业
						             "zyinput":$("#zyinput").val(),//专业
						             "rjxtinput":$("#rjxtinput").val(), //软件名称
						             "tjsj":$("#tjsj").val(),  //提交时间
						          //   "wtlxinput":$("#wtlxinput").val(),//问题类型   
						             "wtms":$("#wtms").val(),   //描述
						             "uname":uname,
						             "operator1":operator1,       //判断修改值
						             "pguid":pguid,    //pguid
						             "scjt":$("#jt").val(),
						             "bz":$("#bz").val(),
						             "fslx":fslx,
						             "oversion" : $("#oversion").val(),   //发生版本
						             "functinput" : $("#functinput").val(),   //功能
						             "causeinput" : $("#causeinput").val(),   //发生原因
						             "pfeedback" : $("#pfeedback").val(),   //程序员判断
						             "compannyop" : $("#compannyop").val(),   //公司意见
						             "modifyplan" : $("#modifyplan").val(),   //修改计划
						             "solution" : $("#solution").val(),   //解决办法
						             
						             
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
					        							if(fslx=="软件问题"){
					        								window.location.href="rjwt.jsp";
					        							}else if(fslx=="用户需求"){
					        								window.location.href="yhxq.jsp";
					        							}else if(fslx=="用户使用"){
					        								window.location.href="yhsy.jsp";
					        							}else if(fslx=="工程安装"){
					        								window.location.href="gcaz.jsp";
					        							}
					        							else if(fslx=="系统运行问题"){
					        								window.location.href="xtyxwt.jsp";
					        							}
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
		}else{
			 var a=document.getElementById("file");
				var len = a.files.length;
				for(var i=0;i<len;i++){
					a=a.files[i].name;
					console.log("++++++++++"+a);		
				}
				
			$.confirm({
   				title : '确认提交信息吗？',
   				content :'',
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
						             "scjt":a,
						             "tljinput" : $("#tljinput").val(),   //单位
						             "dwdinput":$("#dwdinput").val(),  //上级单位 //原来下级单位八月十一日修改
						             "cjinput":$("#cjinput").val(),  //部门
						             "xminput":$("#xminput").val(), //姓名
						             "lxdh":$("#lxdh").val(),  //联系电话
						             "hyinput":$("#hyinput").val(),//行业
						             "zyinput":$("#zyinput").val(),//专业
						             "rjxtinput":$("#rjxtinput").val(), //软件名称
						             "tjsj":$("#tjsj").val(),  //提交时间
						          //   "wtlxinput":$("#wtlxinput").val(),//问题类型   
						             "wtms":$("#wtms").val(),   //描述
						             "uname":uname,
						             "operator1":operator1,       //判断修改值
						             "pguid":pguid,    //pguid
						             "scjt":a,
						             "bz":$("#bz").val(),
						             "fslx":fslx,
						             "oversion" : $("#oversion").val(),   //发生版本
						             "functinput" : $("#functinput").val(),   //功能
						             "causeinput" : $("#causeinput").val(),   //发生原因
						             "pfeedback" : $("#pfeedback").val(),   //程序员判断
						             "compannyop" : $("#compannyop").val(),   //公司意见
						             "modifyplan" : $("#modifyplan").val(),   //修改计划
						             "solution" : $("#solution").val(),   //解决办法
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
					        							if(fslx=="软件问题"){
					        								window.location.href="rjwt.jsp";
					        							}else if(fslx=="用户需求"){
					        								window.location.href="yhxq.jsp";
					        							}else if(fslx=="用户使用"){
					        								window.location.href="yhsy.jsp";
					        							}else if(fslx=="工程安装"){
					        								window.location.href="gcaz.jsp";
					        							}else if(fslx=="系统运行问题"){
					        								window.location.href="xtyxwt.jsp";
					        							}
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
		var  ipPort="",ipPort1="";
		function getIPPort(operator1){
			//获取IP地址和端口号
			$.ajax({
				type : "post",
				async : true,
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataHangye/queryDataServletHangye", 
				data : {
					"operator1" : operator1
				},
				dataType : 'json', //返回数据形式为xml  //timeout:3000,
				success : function(response) {
					ipPort=response[0];
					ipPort1=JSON.stringify(ipPort); 
				},
				error : function(errorMsg) {
				}
			});

		}

	$("#but").click(function(){	
		 /*var Port=ipPort.indexOf(':')+1;//截取开始位置
		 var kPort=ipPort.length-2;//端口号长度
		 var mport=ipPort.substring(Port, kPort);//截取端口号
		var test = window.location.host;
		test = test.substring(0, test.indexOf(":"));*/
		ipPort1=ipPort1.replace("\"", "");
		ipPort1=ipPort1.replace("\"", "");
		//ipPort=ipPort.substring(1,ipPort.length-1);//xinjia
		var ff=$("#jt").val();
		console.log(ff);
		if(ff=="null"||ff==""||ff==undefined){
			$.alert("这条记录没有截图！", "提示");
			return false;
		}else{
			var element = document.getElementById('myimage');
			//element.src = "http://" + test +":"+mport+ "/swsrvphoto/" + ff + "";
			console.log("http://"+ ipPort1+ "/swsrvphoto/" + ff);
			element.src = "http://"+ ipPort1+ "/swsrvphoto/" + ff ;
			openModal();
			return false;
		}
	})
		

	$("#close").click(function(){
			closeModal();
	})

	
	
})

	function openModal() {
	    document.getElementById('myModal').style.display = "block";
	}

	function closeModal() {
	    document.getElementById('myModal').style.display = "none";
	}