
$().ready(function(){
	$('#rjxt').change(function(){
		$('#wtlx').val("请选择");
	});
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
	
	$("#cj").change(function () {  
        var optioncj = $(this).children('option:selected').val();  
        if(optioncj!="请选择"||optioncj!=""){
        	$("#cjinput").val(optioncj);
        } 
       renyuan();
    }); 
	
	$("#xm").change(function () {  
        var optionxm = $(this).children('option:selected').val();  
        if(optionxm!="请选择"||optionxm!=""){
   		 $("#xminput") .val(optionxm);
   	} 
    }); 
	 $('#btn1').click(function(){
		 var operator1="添加";
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
				var coun3=$("#rjxt").val();
				var coun4=$("#wtlx").val();
				var option1=$("#tlj option:selected");
				var coun2=$("#xminput").val();
				var cj=$("#cjinput").val();
				var coun5=$("#fslx").val();
				/*var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; */
				if(coun1 == 0 || coun1 == null || coun1 == undefined || coun1 == "请选择" ){
					$.alert("请选择单位！");
					$("#tlj").css("border-color","red");
					$("#tljinput").css("border-color","red");
					return false;
				}else if(cj == 0 || cj == null || cj == undefined || cj == "请选择"){
						$.alert("请选择部门！");
				 		$("#cj").css("border-color","red");
				 		$("#cjinput").css("border-color","red");
						return false;
					}else if(coun2 == 0 || coun2 == null || coun2 == undefined || coun2 == "请选择"){
				 		$.alert("请选择姓名！");
				 		$("#xm").css("border-color","red");
				 		$("#xminput").css("border-color","red");
						return false;
					}else if($("#lxdh").val() == 0 || $("#lxdh").val() == null || $("#lxdh").val() == undefined ){ 
					 		$.alert("请填写联系方式！");
					 		$("#lxdh").css("border-color","red");
					 	    return false; 			 	 
					}else if(coun3 == 0 || coun3 == null || coun3 == undefined || coun3 == "请选择"){	
						$.alert("请选择软件！");
						$("#rjxt").css("border-color","red");
						return false;
					}else if(coun5 == 0 || coun5 == null || coun5 == undefined || coun5 == "请选择"){
						$.alert("请选择问题类型分属类型！");
						$("#fslx").css("border-color","red");
						return false;
					}else if(coun4 == 0 || coun4 == null || coun4 == undefined || coun4 == "请选择"){
						$.alert("请选择问题类型！");
						$("#wtlx").css("border-color","red");
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
							        	"operator1": operator1,
							             "tlj" :$("#tljinput").val(),        
							             "wtlx":$("#wtlx option:selected").val(),    
							             "wtms":$("#wtms").val(),           
							             "scjt":a,  
							             "dwd":$("#dwdinput").val(),  
							             "cj":$("#cjinput").val(),  
							             "fslx":$("#fslx").val(),  
							             //"gq":$("#gq option:selected").val(),  
							             "xm":$("#xminput").val(), 
							             "lxdh":$("#lxdh").val(),  
							             "username":$("#username").val(),   
							             "rjxt":$("#rjxt option:selected").val(), 
							             "hy":$("#hy option:selected").val(),
							             "zy":$("#zy option:selected").val(),
							             "uname":uname,
							             "tjsj":$("#tjsj").val(),
							             "bz":$("#bz").val(),
							        },
							        
							        success : function(result)
							        {
							        	if(result == "1"){
							        		
							        		$.confirm({
						        				title : '信息提交成功！',
						        				content :'点击确定继续添加记录，点击取消退出系统！',
						        				buttons : {
						        					确定:{
						        						btnClass : 'btn-blue',
						        						action : function() {						        				
						        							window.location.href="ukwtjl.jsp";					        													        							
						        						}
						        					},
						        					取消:{
						        						action : function() {						        				
						        							window.parent.location.href='../../index.jsp';					        													        							
						        						}
						        					}
						        				}
						        			});
							        		//$.alert("提交成功","提示");	
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
							        	"operator1": operator1,
							             "tlj" :$("#tljinput").val(),        //操作数 
							             "wtlx":$("#wtlx option:selected").val(),     //操作符
							             "wtms":$("#wtms").val(),            //
							             "scjt":a,  
							             "dwd":$("#dwdinput").val(),  
							             "cj":$("#cjinput").val(),  
							             "fslx":$("#fslx").val(),   							             
							             "xm":$("#xminput").val(), 
							             "lxdh":$("#lxdh").val(),  
							             "username":$("#username").val(),   
							             "rjxt":$("#rjxt option:selected").val(), 
							             "hy":$("#hy option:selected").val(),
							             "zy":$("#zy option:selected").val(),
							             "uname":uname,
							             "tjsj":$("#tjsj").val(),
							             "bz":$("#bz").val(),
							        },
							        
							        success : function(result)
							        {
							        	if(result == "1"){
							        		
							        		$.confirm({
						        				title : '信息提交成功！',
						        				content :'点击确定继续添加记录，点击取消退出系统！',
						        				buttons : {
						        					确定:{
						        						btnClass : 'btn-blue',
						        						action : function() {						        				
						        							window.location.href="ukwtjl.jsp";					        													        							
						        						}
						        					},
						        					取消:{
						        						action : function() {						        				
						        							window.parent.location.href='../../index.jsp';					        													        							
						        						}
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
})