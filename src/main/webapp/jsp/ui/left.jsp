<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'left.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="../../js/jquery/jquery-3.2.1.js"></script>	
	<script src="../../bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<!-- <script src="../../js/login.js"></script> -->

	<link rel="stylesheet" href="../../bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/font-awesome.min.css">
	<link rel="stylesheet"  href="../../css/htmleaf-demo.css">
	<link rel="stylesheet" href="../../css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="../../css/custom.css">
	<link rel="stylesheet" href="../../css/xschange.css">
	<link rel="shortcut icon" href="../../img/bitbug_favicon.ico" type="image/x-icon" />
	<script type="text/javascript">
	function Hide(){     
	    if(window.parent.right.rows == "70,*"){  
	        top.right.rows = "0,*";  
	    } 
	} 
	function show(){     
	    if(window.parent.right.rows == "0,*"){  
	        top.right.rows = "70,*";  
	    }
	}  
	</script>
  </head>
  <body>
    <nav id="sidebar" class="sidebar-wrapper">
		<div class="sidebar-content">
			 <a href="right.jsp" id="toggle-sidebar" target="rightFrame" >首页</a>
			<div class="sidebar-brand">
				<a href="#"></a>
			</div>
			<div class="sidebar-menu">
				<ul>
					<li><a href="../xschange/zcgl.jsp" target="rightFrame" id="btzcgl" onclick="show()">注册管理</a></li>
					<li><a href="../xschange/azjl.jsp" target="rightFrame" id="btazjl" onclick="show()">软件管理</a></li>
					<li class="sidebar-dropdown" id="gcfw"><a href="#" id="gcfwchild"><span>工程服务</span></a>
						<div class="sidebar-submenu">
							<ul>
								<li class="flstyle"><a href="../xschange/gcss.jsp" target="rightFrame" id="btgcss" onclick="show()">工程实施</a></li>
								<li class="flstyle"><a href="../xschange/gcjd.jsp" target="rightFrame" id="btgcjd" onclick="show()">实施进度</a></li>
							</ul>
						</div>
					</li>
					<li class="sidebar-dropdown" id="wtfk"  display="block"><a href="../xschange/gcglcount.jsp" target="rightFrame" id="wtfkchild"><span>问题管理</span></a>
						<div class="sidebar-submenu">
							<ul>
								<li class="flstyle"><a href="../xschange/rjwt.jsp" target="rightFrame" id="btrjwt" onclick="show()">软件问题</a></li>
								<li class="flstyle"><a href="../xschange/yhxq.jsp" target="rightFrame" id="btyhxq" onclick="show()">用户需求</a></li>
								<li class="flstyle"><a href="../xschange/yhsy.jsp" target="rightFrame" id="btyhsy" onclick="show()">用户使用</a></li>
								<li class="flstyle"><a href="../xschange/gcaz.jsp" target="rightFrame" id="btgcaz" onclick="show()">工程安装</a></li>				
								<li class="flstyle"><a href="../xschange/xtyxwt.jsp" target="rightFrame" id="btxtyx" onclick="show()">系统运行问题</a></li>
							</ul>
						</div>
					</li>
					<li class="sidebar-dropdown" id="xtsz"  ><a href="#" id="xt1" id="xtszchild" ><span>系统设置</span></a>
						<div class="sidebar-submenu">
							<ul>
							    <li class="flstyle"><a href="../xschange/userregister.jsp" target="rightFrame" id="userregister"   onclick="Hide()">用户注册</a></li>
								<li class="flstyle"><a href="../xschange/mmsz.jsp" target="rightFrame" id="btmmsz"  onclick="Hide()">密码设置</a></li> 
								<li class="flstyle"><a href="../xschange/jdsz.jsp" target="rightFrame" id="btjdsz"  onclick="Hide()">进度设置</a></li>
								<li class="flstyle"><a href="../xschange/functionset.jsp" target="rightFrame" id="functionset"  onclick="Hide()">功能设置</a></li>
								<li class="flstyle"><a href="../xschange/causeset.jsp" target="rightFrame" id="causeset"  onclick="Hide()">原因设置</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
  </body>
	<script src="../../assets/js//jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="../../assets/js/custom.js"></script>
	<script src="../../assets/js/xschange.js"></script>
		
</html>
