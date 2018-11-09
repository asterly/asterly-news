<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>问题查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="../../assets/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../assets/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/custom.css">
<link rel="stylesheet" href="../../css/xschange.css">
<link rel="shortcut icon" href="../../assets/img/bitbug_favicon.ico"
	type="image/x-icon" />
<style>
#all,#some{
	height:500px;
	margin:30px auto;
	width:90%;
	color:#333;
}
</style>
<script type="text/javascript" src="../../js/echarts.js"></script>
<script type="text/javascript">
	if (window.parent.right.rows == "0,*") {
		top.right.rows = "70,*";
	}
	var numBarAndPie;//饼状图和柱状图数据，软件管理下面四个字页面，各个页面的数据总统计，（'软件问题','用户需求','用户使用','工程安装'）
	var nameBarAndPie;// 此处查询没有按照括号的顺序 （'软件问题','用户需求','用户使用','工程安装'）
	var gethy, getzy, getrjmc, getrjmc1, options, myChart, bToObj, title, titlepie, titlepie1;
	window.onload = function() {
		gethzunitname();
		getrjmc1 = [ getrjmc ];
		
		if(getrjmc=="请选择"){
			title = '软件问题综合统计';
			titlepie = '按软件名称统计';
			titlepie1 = '按问题类型统计';
			document.getElementById('all').style.display='block';
			document.getElementById('some').style.display='none';
			queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "");
			barshow();
			pieshow();
			pieshow1();
		}else{
			title = getrjmc;
			titlepie = getrjmc;
			titlepie1 = getrjmc;
			document.getElementById('all').style.display='none';
			document.getElementById('some').style.display='block';	
			queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "");
			barshowsome();
			pieshow1some();
		}
	}
	function gethzunitname() {
		gethy = $(window.parent.frames["middleTopFrame"].document).find(
				"#hy option:selected").text();
		getzy = $(window.parent.frames["middleTopFrame"].document).find(
				"#zy option:selected").text();
		getrjmc = $(window.parent.frames["middleTopFrame"].document).find(
				"#rjmc option:selected").text();
		gethy = gethy.replace(/\s+/g, "");
		getzy = getzy.replace(/\s+/g, "");
		getrjmc = getrjmc.replace(/\s+/g, "");
	}
	$(window.parent.frames["middleTopFrame"].document).find("#rjmc").change(
			function() {
				gethzunitname();
				getrjmc1 = [ getrjmc ];
				if(getrjmc=="请选择"){
					title = '总体统计';
					titlepie = '按软件名称统计';
					titlepie1 = '按问题类型统计';
					document.getElementById('all').style.display='block';
					document.getElementById('some').style.display='none';
					queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "");
					barshow();
					pieshow();
					pieshow1();
				}else{
					title = getrjmc;
					titlepie = getrjmc;
					titlepie1 = getrjmc;
					document.getElementById('all').style.display='none';	
					document.getElementById('some').style.display='block';
					queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "");
					barshowsome();
					pieshow1some();
				}
				
				//document.getElementById('pieshow').style.display='none';
				
			});
	function queryDataBarAndPie(operator1, hy, zy, rjmc, fslx) {
		$.ajax({
			type : "post",
			async : false,
			contentType : "application/x-www-form-urlencoded",
			url : "/swsrv/queryDataAll/queryDataServlet", //"http://192.168.10.240:199/SignalBigDataService.asmx/GetDataByNode",    
			data : {
				"operator1" : operator1,
				"hy" : hy,
				"zy" : zy,
				"rjmc" : rjmc,
				"fslx" : fslx
			},
			dataType : 'json', //返回数据形式为xml  //timeout:3000,
			success : function(response) {
				bToObj = response;
			},
			error : function(errorMsg) {
				//alert("请求数据失败!请检查网络设置");
			}
		});
	}
</script>


</head>
<body>
	<main id="content-wrapper" class="page-wrapper"> <!--中部右侧 -->
	<div id="right">
		<div class="xschange" id="all" style="display:block">
			<div id="datatj" style="width: 100%; margin-top: 20px;">
				<div id="barshow" style="width: 100%;">
					<div id="zchartmain" style="width: 1000px; height: 450px;"></div>
				</div>
			</div>
			<div style="width: 100%; margin-top: 30px;">
				<div id="pieshow1" style="width: 50%;">
					<div id="bchartmain1" style="width: 600px; height: 500px;"></div>
				</div>
				<div id="pieshow" style="width: 50%; display=:block ; ">
					<div id="bchartmain" style="width: 600px; height: 500px;"></div>
				</div>

			</div>
		</div>
		<div class="xschange" id="some" style="display:none">
			<div id="datatj" style="width: 50%; margin-top: 20px;">
				<div id="barshow" style="width: 100%;">
					<div id="zchartmainsome" style="width: 600px; height: 450px;"></div>
				</div>
			</div>
			<div style="width: 100%; margin-top: 30px;">
				<div id="pieshow1" style="width: 50%;">
					<div id="bchartmain1some" style="width: 600px; height: 500px;"></div>
				</div>

			</div>
		</div>
	</div>

	</main>
	<script>
		$(function() {
			$('#myTab li:eq(0) a').tab('show');
		});
	</script>
</body>
<script src="../../assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript">
	function barshow() {
		var option = {
			title : {
				text : title,
				subtext : '',
				x:'center',
       			y:'top',
        		textAlign:'left'
			},
			tooltip : {
				trigger : 'axis'
			},
			 grid: { // 控制图的大小，调整下面这些值就可以，
			 	left:'150px',//距离左边距
				x: 80,
				x2: 100,
				y2: 125// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
			},
			legend : {
				data : [],
				orient: 'vertical',
        		x: 'left',
			},
			xAxis : [ {
				axisLabel: {  
					   interval:0,  
					   rotate:40  
				},
				data : []
			} ],
			yAxis : [ {
				type : 'value',
				 minInterval: 1,
				splitArea : {
					show : true
				}
			} ],
			series : []
		};
		myChart = echarts.init(document.getElementById('zchartmain'));
		myChart.setOption(option, true);
		queryDataBarAndPie("图表数据查询", gethy, getzy, getrjmc, "");
		options = myChart.getOption();
		if (bToObj) {
			options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].series;
			var aToStr = JSON.stringify(bToObj);
			var panduan = aToStr.indexOf("xAxisdata");
			if (panduan > 0) {
				options.xAxis[0].data = bToObj[0].xAxisdata;
			} else {
				options.xAxis[0].data = getrjmc1;
			}
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}
	function barshowsome() {
		var option = {
			title : {
				text : title,
				subtext : '',
				x:'center',
       			y:'top',
        		textAlign:'left'
			},
			tooltip : {
				trigger : 'axis'
			},
			 grid: { // 控制图的大小，调整下面这些值就可以，
			 	left:'150px',//距离左边距
				x: 80,
				x2: 100,
				y2: 125// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
			},
			legend : {
				data : [],
				orient: 'vertical',
        		x: 'left',
			},
			xAxis : [ {
				/* axisLabel: {  
					   interval:0,  
					   rotate:40  
				}, */
				data : []
			} ],
			yAxis : [ {
				type : 'value',
				 minInterval: 1,
				splitArea : {
					show : true
				}
			} ],
			series : []
		};
		myChart = echarts.init(document.getElementById('zchartmainsome'));
		myChart.setOption(option, true);
		queryDataBarAndPie("图表数据查询pie1", gethy, getzy, getrjmc, "");
		options = myChart.getOption();
		if (bToObj) {
			options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].series;
			var aToStr = JSON.stringify(bToObj);
			var panduan = aToStr.indexOf("xAxisdata");
			if (panduan > 0) {
				options.xAxis[0].data = bToObj[0].xAxisdata;
			} else {
				options.xAxis[0].data = getrjmc1;
			}
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}
	function pieshow() {
		//饼状图指定图标的配置和数据
		var option = {
			title : {
				text : titlepie,
				subtext : '',
				x : "center"
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				/* orient : 'vertical',
				left : 'left', */
				data : []
			},
			series : []
		};
		myChart = echarts.init(document.getElementById('bchartmain'));
		myChart.setOption(option, true);
		queryDataBarAndPie("图表数据查询pie", gethy, getzy, getrjmc, "");
		options = myChart.getOption();
		if (bToObj) {
			//options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].pieseries;
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}

	function pieshow1() {
		//饼状图指定图标的配置和数据
		var option = {
			title : {
				text : titlepie1,
				subtext : '',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				/* orient : 'vertical',
				left : 'left', */
				data : []
			},
			series : []
		};
		myChart = echarts.init(document.getElementById('bchartmain1'));
		myChart.setOption(option, true);
		queryDataBarAndPie("图表数据查询pie1", gethy, getzy, getrjmc, "");
		options = myChart.getOption();
		if (bToObj) {
			//options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].pieseries;
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}
		function pieshow1some() {
		//饼状图指定图标的配置和数据
		var option = {
			title : {
				text : titlepie1,
				subtext : '',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : []
			},
			series : []
		};
		myChart = echarts.init(document.getElementById('bchartmain1some'));
		myChart.setOption(option, true);
		queryDataBarAndPie("图表数据查询pie1", gethy, getzy, getrjmc, "");
		options = myChart.getOption();
		if (bToObj) {
			//options.legend[0].data = bToObj[0].legend;
			options.series = bToObj[0].pieseries;
			myChart.hideLoading();
			myChart.setOption(options, true);
		}
	}
</script>

</html>
