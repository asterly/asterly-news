<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath %>>">
    <title>My JSP 'top.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery/jquery-3.2.1.js"></script>	
	<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="assets/css/custom.css">
	
	<!-- <script src="../../bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script src="../../js/jquery/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="../../js/custom.js"></script>
	<script src="../../js/xschange.js"></script> -->
	<!-- <link rel="stylesheet" href="../../css/font-awesome.min.css"> -->
	<!-- <link rel="stylesheet" href="../../assets/css/jquery.mCustomScrollbar.min.css" /> -->
	<!-- <link rel="stylesheet" href="../../css/xschange.css"> -->
  </head>
  <!-- <script language = javascript>
	$("#zx").click(function(){
		window.parent.location.href='../../jsp/index.jsp';
	})
		window.onload=function(){
			f1();
			startTime();
		}
	 	function f1(){
			localStorage.getItem(name);
			console.log(name);
			var arrname=localStorage.name;
			arrname=arrname.split(",")
			if(localStorage.name==undefined){
				document.getElementById("uname").innerHTML="admin";
			}else if(localStorage.name=="uk"){
				document.getElementById("uname").innerHTML="游客";
			}else{
				document.getElementById("uname").innerHTML=arrname[0];
			}
			document.getElementById("editYesOrNo").innerHTML=arrname[1];
			
		}
 function startTime()   
            {   
                var today=new Date();//定义日期对象   
                var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年    
                var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年    
                var dd = today.getDate();//通过日期对象的getDate()方法返回年     
                var hh=today.getHours();//通过日期对象的getHours方法返回小时   
                var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟   
                var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒   
                // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09   
                MM=checkTime(MM);
                dd=checkTime(dd);
                mm=checkTime(mm);   
                ss=checkTime(ss);    
                var day; //用于保存星期（getDay()方法得到星期编号）
                if(today.getDay()==0)   day   =   "星期日 " 
                if(today.getDay()==1)   day   =   "星期一 " 
                if(today.getDay()==2)   day   =   "星期二 " 
                if(today.getDay()==3)   day   =   "星期三 " 
                if(today.getDay()==4)   day   =   "星期四 " 
                if(today.getDay()==5)   day   =   "星期五 " 
                if(today.getDay()==6)   day   =   "星期六 " 
                document.getElementById('systime').innerHTML=yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;   
                setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法 

            }   
             
            function checkTime(i){   
                if (i<10){
                    i="0" + i;
                }   
                  return i;
            }
		
	</script> -->
  <body>
  <div id="top">
			<div id="block"></div>
			<h1 id="title">铁路信息化服务管理系统</h1>
			<div class="topright">
				<font color="#EB5849" style="margin-right:10px;"><span class="info" id="systime"></span></font>
				<span class="info" id="username">欢迎您，<span id="uname">${name}</span> <a href="jsp/index.jsp" id="zx">注销</a></span>	
			</div>
			<span id="editYesOrNo" style="color:transparent;"></span>
		</div>
 </body>
</html>
