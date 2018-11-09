
$().ready(function(){
	$("#btnrn").click(function(){
		window.location.href="gcaz.jsp";
	})
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
	 $('#btn1').click(function(){
		 	var operator1="添加";
		 	var fslx="工程安装";
		 	operator1=fslx+operator1;
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
				if(coun1 == 0 || coun1 == null || coun1 == undefined || coun1 == "请选择" ){
					$.alert("请选择单位！");
					$("#tlj").css("border-color","red");
					$("#tljinput").css("border-color","red");
					return false;
				}else if(coun3 == 0 || coun3 == null || coun3 == undefined || coun3 == "请选择"){	
						$.alert("请选择软件！");
						$("#rjxt").css("border-color","red");
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
							        	"operator1": operator1,
							             "tlj" :$("#tljinput").val(),        //操作数 
							             "wtlx":$("#wtlx option:selected").val(),     //操作符
							             "wtms":$("#wtms").val(),            //
							             "scjt":a,  
							             "dwd":$("#dwdinput").val(),  
							             "cj":$("#cj").val(),  
							             "fslx":fslx, 						            
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
							        	"operator1": operator1,
							             "tlj" :$("#tljinput").val(),        //操作数 
							             "wtlx":$("#wtlx option:selected").val(),     //操作符
							             "wtms":$("#wtms").val(),            //
							             "scjt":a,  
							             "dwd":$("#dwdinput").val(),  
							             "cj":$("#cj").val(),  
							             "fslx":fslx,   
							             
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
})