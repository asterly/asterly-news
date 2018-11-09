
$().ready(function(){
	
	$("#btnrn").click(function(){
		var thisURL = document.URL;      
		var getval =thisURL.split('?')[1];    
        var showval= getval.split("=")[1]; 
        console.log(showval);
          var fslx=showval;
          if(fslx=="rjwt"){
          	fslx="软件问题";
          	window.location.href="rjwt.jsp";
          }else if(fslx=="yhxq"){
          	fslx="用户需求";
          	window.location.href="yhxq.jsp";
          }else if(fslx=="yhsy"){
          	fslx="用户使用";
          	window.location.href="yhsy.jsp";
          }
	})
	$('#rjxt').change(function(){
		var hy = $("#hy option:selected");
		var zy = $("#zy option:selected"); //获取选中的项
		var rjmc = $("#rjxt option:selected");
		functionquery("功能设置查询", hy.text(), zy.text(), rjmc.text());  
	});
	$("#tlj").change(function () {  
        var optiontlj = $(this).children('option:selected').val();  
        if(optiontlj!="请选择"||optiontlj!=""){
   		   $("#tljinput") .val(optiontlj);
        } 
        var optiondwd = $("#dwdinput").val();
        if(optiondwd!="中国铁路总公司"){
       /* 	dianwuduan();
        }else{*/
        	  keshi();
        }
		$("#cjinput").val("请选择");
		$("#xminput").val("请选择"); 
    });  
	$("#dwd").change(function () {  
        var optiondwd = $(this).children('option:selected').val();  
        if(optiondwd!="请选择"||optiondwd!=""){
   		 $("#dwdinput") .val(optiondwd);
        } 
     if(optiondwd=="中国铁路总公司"){
    	 yu("A00");
     }else{
    	  dianwuduan();
     }
 	$("#tljinput").val("请选择");
      $("#cjinput").val("请选择");
      $("#xminput").val("请选择"); 
    }); 
	function yu(operator1) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryData/queryDataservlect",
			data : {
				"operator1" : operator1
			},
			dataType : 'json', 
			success : function(response) {
				//请求成功时执行该函数内容，result即为服务器返回的对象
				tlj = response;
				var tljArray = "";
				var tljSelectStr = "";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljArray = tlj[i];
					if ("请选择" == tljArray[1]) {
						tljSelectStr = tljSelectStr + "<option >"
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
        	$("#cjinput").val(optioncj);
        } 
        var optiondwd = $("#dwdinput").val();
        if(optiondwd!="中国铁路总公司"){
       /* 	dianwuduan();
        }else{*/
        	 renyuan();
        }
      
    }); 
	
	$("#xm").change(function () {  
        var optionxm = $(this).children('option:selected').val();  
        if(optionxm!="请选择"||optionxm!=""){
   		 $("#xminput") .val(optionxm);
   	} 
    }); 
	//查询功能
	function functionquery(operator1, hy, zy, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc
			},
			dataType : 'json',
			success : function(response) {
				tlj = response[2];
				var tljSelectStr = "<option>请选择</option>";
				for (var i = 0, len = tlj.length; i < len; i++) {
					tljSelectStr += "<option>" + tlj[i]+ "</option>";
				}
				$("#funct").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求数据失败!" + errorMsg); */
			}
		});
	}
	 $('#btn1').click(function(){
			var thisURL = document.URL;      
  			var getval =thisURL.split('?')[1];    
            var showval= getval.split("=")[1]; 
            var operator1="添加";
            console.log(showval);
              var fslx=showval;
              if(fslx=="rjwt"){
              	fslx="软件问题";
              	operator1=fslx+operator1;
              }else if(fslx=="yhxq"){
              	fslx="用户需求";
            	operator1=fslx+operator1;
              }else if(fslx=="yhsy"){
              	fslx="用户使用";
            	operator1=fslx+operator1;
              }else if(fslx=="gcaz"){
              	fslx="工程安装";
            	operator1=fslx+operator1;
              }
              else if(fslx=="xtyxwt"){
                	fslx="系统运行问题";
              	operator1=fslx+operator1;
               }
			 var a=document.getElementById("file");
				var len = a.files.length;
				for(var i=0;i<len;i++){
					a=a.files[i].name;
				}
				console.log(a); 
			 a=$('#file').val();
			 console.log(a.indexOf("\\") != -1 );  // true
				if(a.indexOf("\\") != -1 ){
					a=a.substring(a.lastIndexOf("\\")+1,a.length);
				}
			 console.log("图片名称"+a);
			 if(a=="null"||a==""||a==undefined){
					a="";
				}
				var uname=$(parent.frames["topFrame"].document).find("#uname").text();
				console.log(uname);
				var coun1=$("#tljinput").val();
				var coun3=$("#rjxt").val();
				var option1=$("#tlj option:selected");
				var coun2=$("#xminput").val();
				var cj=$("#cjinput").val();
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
					}else if(coun3 == 0 || coun3 == null || coun3 == undefined || coun3 == "请选择"){	
						$.alert("请选择软件！");
						$("#rjxt").css("border-color","red");
						return false;
					}else if($("#tjsj").val() == 0 || $("#tjsj").val() == null || $("#tjsj").val() == undefined ){ 
				 		$.alert("请选择提交时间！");
				 		$("#tjsj").css("border-color","red");
				 	    return false; 			 	 
				}else if($("#wtms").val()==""){
						$.alert("请输入问题描述！");
						$("#wtms").css("border-color","red")
						return false;
					}else{
						$("#wtms").css("border-color","#ccc");
						//return false;
					}
				var funct=$("#funct option:selected").val();
				if(funct=="请选择"){
					funct="";
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
							             "tlj" :$("#tljinput").val(),  //局
							             "dwd":$("#dwdinput").val(),  //电务段
							             "cj":$("#cjinput").val(), //部门
							             "xm":$("#xminput").val(), //姓名
							             "lxdh":$("#lxdh").val(),  //联系电话
							             "hy":$("#hy option:selected").val(),//行业
							             "zy":$("#zy option:selected").val(),//专业
							             "rjxt":$("#rjxt option:selected").val(), //软件系统
							             "tjsj":$("#tjsj").val(),//f发生时间
							             "oversion":$("#oversion").val(),//发生版本
							             "funct":funct,//功能
							             "wtms":$("#wtms").val(),  //问题描述    
							             "cause":$("#cause").val(),  //f发生原因
							             "pfeedback":$("#pfeedback").val(),  //程序员反馈
							             "compannyop":$("#compannyop").val(),  //公司意见
							             "modifyplan":$("#modifyplan").val(),  //修改计划
							             "solution":$("#solution").val(),  //解决办法
							             "scjt":a,  
							             "fslx":fslx,  
							             "username":$("#username").val(),  //记录人       这个好像没用
							             "uname":uname,//记录人 
							             "bz":$("#bz").val(),//备注
							        },
							        
							        success : function(result) {
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
						        					继续添加:{ }
						        				}
						        			});
							        	}else{
							        		$.alert("对不起提交失败","提示");
							        	}
							        },
							        error : function(result) {	
							        	$.alert("提交失败！！！","提示");
							        }
							    });
	   						},
	   					},
	   					取消 : {}
	   				}
	   	        });
	})
})