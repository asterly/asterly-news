/**
 * 
 */
$().ready(function(){
	getIPPort("IP端口号获取");
	$("#btnrn").click(function(){
		window.location.href="gcaz.jsp";
	})
	$("#tlj").change(function () {  
        var optiontlj = $(this).children('option:selected').val();  
        if(optiontlj!="请选择"||optiontlj!=""){
   		   $("#tljinput") .val(optiontlj);
        } 
       dianwuduan();
   	 	$("#dwdinput").val("请选择");
		$("#cjinput").val("请选择");
		$("#xminput").val("请选择"); 
    });  
	$("#dwd").change(function () {  
        var optiondwd = $(this).children('option:selected').val();  
        if(optiondwd!="请选择"||optiondwd!=""){
   		 $("#dwdinput") .val(optiondwd);
        } 
      keshi();
      $("#cjinput").val("请选择");
      $("#xminput").val("请选择"); 
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
	    }); 
	
	//问题类型
	
	$("#wtlx").change(function () {  
        var optionwtlx = $(this).children('option:selected').val();  
        if(optionwtlx!="请选择"||optionwtlx!=""){
   		 $("#wtlxinput") .val(optionwtlx);
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
		var coun1=$("#tljinput").val();
		var coun3=$("#rjxtinput").val();
		var coun4=$("#wtlxinput").val();
		var option1=$("#tlj option:selected");
		var coun2=$("#xminput").val();
		var cj=$("#cj").val();
		var operator1="修改记录";
		if(coun1 == 0 || coun1 == null || coun1 == undefined || coun1 == "请选择" || coun1 == "无选项"){
			$.alert("请选择单位！");
			$("#tlj").css("border-color","red");
			$("#tljinput").css("border-color","red");
			return false;
		}else if(coun3 == 0 || coun3 == null || coun3 == undefined || coun3 == "请选择" || coun3 == "无选项"){	
				$.alert("请选择软件！");
				$("#rjxt").css("border-color","red");
				$("#rjxtinput").css("border-color","red");
				return false;
			}else if(coun4 == 0 || coun4 == null || coun4 == undefined || coun4 == "请选择" || coun4 == "无选项"){
				$.alert("请选择问题类型！");
				$("#wtlx").css("border-color","red");
				$("#wtlxinput").css("border-color","red");
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
						             "dwdinput":$("#dwdinput").val(),  //上级单位   //原来下级单位八月十一日修改
						             "cjinput":$("#cj").val(),  //部门
						             "xminput":$("#xm").val(), //姓名
						             "lxdh":$("#lxdh").val(),  //联系电话
						             "hyinput":$("#hyinput").val(),//行业
						             "zyinput":$("#zyinput").val(),//专业
						             "rjxtinput":$("#rjxtinput").val(), //软件名称
						             "tjsj":$("#tjsj").val(),  //提交时间
						             "wtlxinput":$("#wtlxinput").val(),//问题类型   
						             "wtms":$("#wtms").val(),   //描述
						             "uname":uname,
						             "operator1":operator1,       //判断修改值
						             "pguid":pguid,    //pguid
						             "scjt":$("#jt").val(),
						             "bz":$("#bz").val(),
						             "fslx":fslx
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
					        							window.location.href="gcaz.jsp";
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
						        	"tljinput" : $("#tljinput").val(),   //单位
						             "dwdinput":$("#dwdinput").val(),  //下级单位
						             "cjinput":$("#cj").val(),  //部门
						             "xminput":$("#xminput").val(), //姓名
						             "lxdh":$("#lxdh").val(),  //联系电话
						             "hyinput":$("#hyinput").val(),//行业
						             "zyinput":$("#zyinput").val(),//专业
						             "rjxtinput":$("#rjxtinput").val(), //软件名称
						             "tjsj":$("#tjsj").val(),  //提交时间
						             "wtlxinput":$("#wtlxinput").val(),//问题类型   
						             "wtms":$("#wtms").val(),   //描述
						             "uname":uname,
						             "operator1":operator1,       //判断修改值
						             "pguid":pguid,    //pguid
						             "scjt":a,
						             "bz":$("#bz").val(),
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
					        							window.location.href="gcaz.jsp";
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

	var  ipPort="";
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
					ipPort=JSON.stringify(ipPort); 
				},
				error : function(errorMsg) {
				}
			});

		}
		$("#but").click(function(){	
			 var Port=ipPort.indexOf(':')+1;//截取开始位置
			 var kPort=ipPort.length-2;//端口号长度
			 var mport=ipPort.substring(Port, kPort);//截取端口号
			 var test = window.location.host;
			 test = test.substring(0, test.indexOf(":"));
			var ff=$("#jt").val();
			console.log(ff);
			if(ff=="null"||ff==""||ff==undefined){
				$.alert("这条记录没有截图！", "提示");
				return false;
			}else{
				/*var element = document.getElementById('myimage');
				element.src = "http://" + test +":"+mport+ "/swsrvphoto/" + ff + "";*/
				ipPort=ipPort.replace("\"", "");
				ipPort=ipPort.replace("\"", "");
				
				//ipPort=ipPort.substring(1,ipPort.length-1);
				var element = document.getElementById('myimage');
				//element.src = "http://" + test +":"+mport+ "/swsrvphoto/" + ff + "";
				element.src = "http://"+ ipPort+ "/swsrvphoto/" + ff ;
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