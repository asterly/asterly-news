
$().ready(function(){
	$("#btnrn").click(function(){
		window.location.href="azjl.jsp";
	})
	if(window.parent.right.rows == "70,*"){  
        top.right.rows = "0,*";  
    } 
	var thisURL = document.URL;      
	var getval =thisURL.split('?')[1];    
    var showval= getval.split("=")[1];  
     var pguid=showval;
     
	var operator1="安装修改";
	//这几个变量是判断，修改前后  重复数据的判断是否执行
	var  pdhy,pdzy,pdrjmc,pddwmcinput,pdbbh;
	$.ajax({
        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
        type : "post", 		      
        contentType: "application/x-www-form-urlencoded",
        //servlet文件名为Calculator，需要提前在web.xml里面注册
        url : "/swsrv/queryDataAll/queryDataServlet", 
        dataType : "json",  //数据类型，可以为json，xml等等，自己百度
        cache: false,
        data :{
             "pguid" :pguid,         
             "operator1" : operator1
        },        
        success : function(response)
        {
        		tlj = response; 
        		//行业
   		        var tljSelectStr = "";
   		         tljSelectStr = tljSelectStr + "<option id='"+tlj[1]+"'>"+tlj[13]+"</option>";
   		      pdhy=tlj[13];
 		        $("#hy").html(tljSelectStr);				
				//专业
   		        var tljSelectStr = "";
  		         tljSelectStr = tljSelectStr + "<option id='"+tlj[1]+"'>"+tlj[14]+"</option>";
  		       pdzy=tlj[14];
		        $("#zy").html(tljSelectStr);				
				//软件名称
        		var tljSelectStr = "";
 		         tljSelectStr = tljSelectStr + "<option id='"+tlj[1]+"'>"+tlj[5]+"</option>";
 		        pdrjmc=tlj[5];
		        $("#rjmc").html(tljSelectStr);				
				//版本号				
				$("#bbh").val(tlj[6]);	
				pdbbh=tlj[6];
				//单位名称
				$("#dwmcinput").val(tlj[2]);
				pddwmcinput=tlj[2];
				//单位级别
				/*var tljSelectStr = "";
		         tljSelectStr = tljSelectStr + "<option id='"+tlj[1]+"' value='"+tlj[1]+"'>"+tlj[3]+"</option>";
		        $("#dwjb").html(tljSelectStr);	*/
		        $("#dwjbinput").val(tlj[3]);	
				//上级单位
				$("#sjdwinput").val(tlj[4]); 				
				//服务器IP
				$("#fwip").val(tlj[7]); 				
				//服务端口
				$("#fwdk").val(tlj[8]);				
				//安装路径
				$("#azlj").val(tlj[9]);				
				//安装日期
				$("#azrq").val(tlj[10]);				
				//安装人
				$("#azr").val(tlj[11]);				
				//备注
				var a = document.getElementById('bz');				
				a.innerHTML = tlj[12]; 
        },
        error : function(result)       
        {	
        	$.alert("提交失败！！！","提示");
        }
    });
$("#hy").bind("click", function() {
    $(this).unbind("click");
    queryDataHy("查询行业","H0000");      
});
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

$("#hy").change(function(){
	var option1 = $("#hy option:selected"); //获取选中的项
	zhuanye();
	$("#hy").css({"border-color":"#ccc","focus":"blue"})
	$("#zy").val("请选择");
	$("#rjmc").val("请选择");
	$("#dwjb").val("请选择");
})
function zhuanye() {
		var option1 = $("#hy option:selected"); //获取选中的项
		zhuanyeAjax("查询专业",option1.attr("id"));
		$("#zy").val("请选择");
		
	}
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
				//alert(tlj);
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
$("#zy").bind("click", function() {
	$(this).unbind("click");
    var option1 = $("#zy option:selected"); //获取选中的项
	var option2 = $("#hy option:selected");
	zhuanyeAjax(option2.attr("id"),option2.text());
	getSolfnameAjax("软件名称", option2.text(), option1.text());   
	
	
});
$("#zy").change(function(){
	var option1 = $("#zy option:selected"); //获取选中的项
	var option2 = $("#hy option:selected");
	getSolfnameAjax("软件名称", option2.text(), option1.text());
	$("#zy").css({"border-color":"#ccc","focus":"blue"})
})

	function getSolfnameAjax(operator1, hangye, zhuanye) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hangye" : hangye,
				"zhuanye" : zhuanye
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
				$("#rjmc").html(tljSelectStr);
			},
			error : function(errorMsg) {
				/* alert("请求zzzzzz数据失败!" + errorMsg); */
			}
		});
	}
function queryduanlb(operator1,hy,zy,rjmc){
	$.ajax({
		type : "post",
		async : true,
		contentType : "application/x-www-form-urlencoded",
		url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
		data : {
			"operator1" : operator1,
			"hy":hy,
			"zy":zy,
			"rjmc":rjmc
		},
		dataType : 'json', //返回数据形式为xml  //timeout:3000,
		success : function(response) {
			tlj = response;
			  if(tlj=="1"){
				$('#azljs').css("display","block");
			}else if(tlj=="0"){
				$('#azljs').css("display","none");
			}
		},
		error : function(errorMsg) {
			 $.alert("请求数据失败!请检查网络设置"); 
		}
	});	
}
$("#rjmc").bind("click", function() {
    $(this).unbind("click");
    var option1 = $("#hy option:selected"); //获取选中的项
	var option2 = $("#zy option:selected");
	var option3 = $("#rjmc option:selected");
	getSolfnameAjax(option2.attr("id"), option1.text(), option2.text());
//	queryduanlb("端类别",option1.text(),option2.text(),option3.text());   
	querydlb("端类别", option1.text(), option2.text(), option3.text());
});	 
	$('#rjmc').change(function(){
		$('#dwjb').val(""); 
		if(tlj=="0"){
			$('#azljs').css("display","block");
		}else if(tlj=="1"){
			$('#azljs').css("display","none");
		}
		var option1 = $("#hy option:selected"); //获取选中的项
		var option2 = $("#zy option:selected");
		var option3 = $("#rjmc option:selected");

		queryduanlb("端类别",option1.text(),option2.text(),option3.text());
		$("#rjmc").css({"border-color":"#ccc","focus":"blue"})
	});	
	$('#sjdw').change(function(){
		$('#dwmcinput').val('');
		var option1 = $("#sjdw option:selected"); //获取选中的项
		$('#sjdwinput').val(option1.text());
		if(option1.text()=="中国铁路总公司"){
			yu("A00");
		}else{
			dianwuduan();
		}
		
	});
$('#dwmc').change(function(){
	
	var option1 = $("#dwmc option:selected"); //获取选中的项
	$('#dwmcinput').val(option1.text());
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
					tljSelectStr = tljSelectStr + "<option value='0'>"
							+ tljArray[1] + "</option>";
				} else {
					if(i!=1){
						tljSelectStr = tljSelectStr
						+ "<option id='"+tljArray[0]+"'>" + tljArray[1]
						+ "</option>";
					}
					
				}
			}
			$("#dwmc").html(tljSelectStr);
		},
		error : function(errorMsg) {
			//请求失败时执行该函数
			$.alert("请求数据失败，请检查网络设置!");
		}
	});
}
function  dianwuduan(){	
  	 var option1=$("#sjdw option:selected");  //获取选中的项
		$("#sjdw").css({"border-color":"#ccc","focus":"blue"});
		$('#sjdwinput').css({'border-color':'#ccc','focus':'blue'});
		
		if(option1.text()=="中国铁路总公司"){
			yuu(option1.text());
		 	
		}else{
			 yuu(option1.attr("id"),option1.text());
		}
		$("#dwd").empty();
		$("#cj").empty();
		$("#xm").empty();
		
   } 
   
   function yuu(operator1,luju){   //根据上级单位
			 $.ajax({
	    		 type: "post",
	    		    async: true, 
	    		    contentType: "application/x-www-form-urlencoded",
	    		    //http://192.168.10.250:199/SignalBigDataService.asmx/（指定网络不能联网）或者192.168.1.100:199（可以联网）  
	    		    url: "/swsrv/queryData/queryDataservlect",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
	    		    data: { "operator1" : operator1 ,
	    		    		"luju":luju	
	    		    },//+sql1,//select 名称  from bd_au_单位字典表  ",
	    		    dataType: 'json',        //返回数据形式为xml  //timeout:3000,
	    		  	 success: function (response) { 
	    		        //请求成功时执行该函数内容，result即为服务器返回的对象
	    		       // alert("ceshi "+response);
	    		        dwd=response[0];
	    		       var tljArray = "";
	    		       var tljSelectStr = "";
	    		      var option1=$("#tlj option:selected");  //获取选中的项
	    		  if(option1.text()=="中国铁路总公司"){
	    		        for(var i=0,len=dwd.length;i<len;i++){
	    		        	  tljArray = dwd[i];
	 	    		            tljSelectStr = tljSelectStr + "<option id='"+tljArray[0]+"'>"+tljArray[1]+"</option>";
	    		        }
   		 		}else{
   		 			for(var i=0,len=dwd.length;i<len;i++){
	    		           if(i!=1){
	    		        	  tljArray = dwd[i];
	 	    		            tljSelectStr = tljSelectStr + "<option id='"+tljArray[0]+"'>"+tljArray[1]+"</option>";
	    		           }
	    		        }
   		 		}
	    		       $("#dwmc").html(tljSelectStr);
	    		       
	    		      cj=response[1];
	    		        var tljArray2 = "";
	    		        var tljSelectStr2 = "";
	    		        for(var i=0,len=cj.length;i<len;i++){
	    		            tljArray2 = cj[i];
	    		            tljSelectStr2 = tljSelectStr2 + "<option id='"+tljArray2[0]+"'>"+tljArray2[1]+"</option>";
	    		        }
	    		       $("#cj").html(tljSelectStr2);
	    		    },
	    		    error: function (errorMsg) {
	    		        //请求失败时执行该函数
	    		        //$.alert("请求数据失败，请检查网络设置"); 
	    		    }
	    	 });   
		    }		 
		 
	$("#dwjb").bind("click", function() {
		$(this).unbind("click");
		$(this).empty();
		var option1 = $("#zy option:selected"); //获取选中的项
		var option2 = $("#hy option:selected");
		var option3 = $("#rjmc option:selected");
		//这里调用了工程实施同样的方法，是根据当前页面的行业专业、软件名称，查询注册时的单位使用级别
		unitlevel("工程实施单位级别查询", option2.text(), option1.text(),option3.text());
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
				$("#dwjb").html(tljSelectStr);		
			},
			error : function(errorMsg) {
				//$.alert("请求数据失败，请检查网络设置");
			}
		});
	}
	$('#dwjb').change(function(){
		var option1 = $("#dwjb option:selected"); //获取选中的项
		if(($('#dwjb').val() != "1") && ($('#dwjb').val() != "")){
			$('#sjdws').css("display","block");
		}else{
			$('#sjdws').css("display","none");
			$('#sjdw').css({'border-color':'#ccc','focus':'blue'});
		}
		$('#dwjbinput').val(option1.text());
	});
	
	
	
	
	//端类别
	var duanleibie;
	function querydlb(operator1, hy, zy, rjmc) {
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataHangye/queryDataServletHangye", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				tlj = response;
				duanleibie=response;
				//$.alert("端类别"+tlj);
				//服务端 是0， 客户端是 1  数据库也是 0  1
				if (tlj == "1") {
					$('#azljs').css("display", "block");
				} else if (tlj == "0") {
					$('#azljs').css("display", "none");
				}
			},
			error : function(errorMsg) {
				$.alert("请求数据失败!请检查网络设置");
			}
		});

	}
	
	
	
	  //c查询当前单位是否已实施,软件管理页面添加时判断是否重复添加
	var  UnitIsSS;
	   function QueryUnitIsSS(operator1,hy,zy,rjmc,dwmcinput,bbh){   //根据上级单位
				 $.ajax({
		    		 type: "post",
		    		    async: false, 
		    		    contentType: "application/x-www-form-urlencoded",
		    		    url: "/swsrv/queryDataHangye/queryDataServletHangye",//"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
		    		    data: { "operator1" : operator1 ,
		    		    		"hy":hy,
		    		    		"zy":zy,
		    		    		"rjmc":rjmc,
		    		    		"dwmcinput":dwmcinput,
		    		    		"bbh":bbh,
		    		    		
		    		    },
		    		    dataType: 'json',        //返回数据形式为xml  //timeout:3000,
		    		  	 success: function (response) { 
		    		  		if(response[0]>=1){
		    		  			$.alert("当前单位已施工，请勿重复输入"); 
		    		  			
		    		  		}
		    		  		UnitIsSS="";
		    		  		UnitIsSS=response[0];
		    		    },
		    		    error: function (errorMsg) {
		    		        //请求失败时执行该函数
		    		        //$.alert("请求数据失败，请检查网络设置"); 
		    		    }
		    	 });   
			    }		 
			 
	
		 
	$('#btn0').click(function(){
		var operator1="修改安装记录";
		var reg;
		reg = /^\d{1}\.\d{2}\.\d{2}$/;		
		if($('#hy').val() == "请选择"){
			$.alert("请填写行业");
			$("#hy").css("border-color","red");
			return false;
		}		
		if($('#zy').val()=="请选择"){
			$.alert("请填写专业");
			$("#zy").css("border-color","red");
			return false;
		}
		if($('#rjmc').val()=="请选择"){
			$("#rjmc").css("border-color","red");
			$.alert("请填写软件名称");
			return false;
		}
		if($('#rjmc').val()=="无选项"){
			$.alert("所选专业内没有已注册软件，请先行注册，或重新选择");
			$("#rjmc").css("border-color","red");
			return false;
		}
		if($('#bbh').val()== ""){
			$("#bbh").css("border-color","red");
			$.alert("请填写版本号");
			return false;
		}
		if(!reg.test($('#bbh').val())){
			$.alert("请填写正确模式的版本号");
			$("#bbh").css("border-color","red");
			return false;
		}
		if($('#dwmcinput').val()== ""){
			
			$.alert("请填写单位名称");
			$("#dwmc").css("border-color","red");
			$("#dwmcinput").css("border-color","red");
			return false;
		}else if($('#dwjbinput').val()==""||$('#dwjbinput').text()== "请选择"){
			//debugger;
			$.alert("请填写单位级别");
			$("#dwjb").css("border-color","red");
			$("#dwjbinput").css("border-color","red");
			return false;
		}else if(($('#dwjb').val()!="1") && ($('#sjdw').val()== "")){
			
			$.alert("请填写上级单位");
			$("#sjdw").css("border-color","red");
			
			return false;
		}
		
		var reg2=/^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([0-9]|([0-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([0-9]|([0-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/;
		
if(duanleibie=="0"){
			
			if($('#fwip').val()==""){
				
				$.alert("请填写服务器IP地址");
				$("#fwip").css("border-color","red");
				return false;
			}
			if(!reg2.test($("#fwip").val())){
				$.alert("请填写正确的服务器IP地址");
				$("#fwip").css("border-color","red");
				return false;
			}
			
			
			if($('#fwdk').val()==""){
				$.alert("请填写服务器端口号");
				$("#fwdk").css("border-color","red");
				return false;
			}
			var reg1=/^\d+$/;
			if(!reg1.test($("#fwdk").val())){
				$.alert("请填写正确的服务器端口号");
				$("#fwdk").css("border-color","red");
				return false;
			}
		}
		
		if((tlj!="1") && ($('#azlj').val()!="")){
			var reglj=/[a-zA-Z]:([\\|//][\u4e00-\u9fa5\w]+)+/;
			
			if(!reglj.test($('#azlj').val())){
				$.alert("请填写正确格式的路径");
				$("#azlj").css("border-color","red");
				return false;
			}
		}
		if($('#azrq').val()== ""){
			$.alert("请填写安装日期");
			$("#azrq").css("border-color","red");
			return false;
		}
		/*var dwjbnum=0;
		var dwjbtext=$("#dwjbinput").val();
		var arr=["铁总","路局","段","车间","工区","个人","其他"];
		*/
		var dwjbnum=0;
		var dwjbtext=$("#dwjbinput").val();
		var arr;
		if($('#zy').val()=="信号"){
			  arr =["总公司","路局","电务段","车间","班组","个人"];
		}
		if($('#zy').val()=="通信"){
			  arr=["总公司","路局","通信段","车间","班组","个人"];
		}
		for(var i =0;i<arr.length;i++){
			if(arr[i]==dwjbtext){
				dwjbnum=i+1;
			}
		}
		
		
		if(!(pdhy==$('#hy').val()&&pdzy==$('#zy').val()&&pdrjmc==$('#rjmc').val()&&pddwmcinput==$('#dwmcinput').val()&&pdbbh==$('#bbh').val())){
			QueryUnitIsSS("软件管理判断重复",$('#hy').val(),$('#zy').val(),$('#rjmc').val(),$('#dwmcinput').val() ,$('#bbh').val());
			if(UnitIsSS>=1){
				return false;
			}
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
					        dataType : "json",   
					        cache: false,
					        data :
					        {
					        	"hangye" :$("#hy option:selected").val(),        //操作数 
					             "zhuanye":$("#zy option:selected").val(),     //操作符
					             "rjmc":$("#rjmc option:selected").val(),            //操作数 
					             "bbh":$("#bbh").val(),
					             "dwmc":$("#dwmcinput").val(),  
					             "dwjb":dwjbnum,   
					             "sjdw":$("#sjdwinput").val(), 
					             "fwip":$("#fwip").val(), 
					             "fwdk":$("#fwdk").val(),
					             "azlj":$("#azlj").val(),
					             "azrq":$("#azrq").val(),
					             "azr":$("#azr").val(),
					             "bz":$("#bz").val(),
					             "pguid" :pguid,
					             "operator1":operator1,
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
				        							window.location.href="azjl.jsp";
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
		
	});
});