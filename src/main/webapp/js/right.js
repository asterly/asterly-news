/**
 * 
 */
$().ready(function(){
	//软件注册
	$("#btrjzc").click(function(){
		//debugger
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btrjzc =$(parent.frames["leftFrame"].document).find("#btrjzc");
		var zcgl =$(parent.frames["leftFrame"].document).find("#zcgl");		
		zcgl.find('.sidebar-submenu').css("display","block");
		btrjzc.parent().addClass("active1");
		btrjzc.parent().siblings().removeClass("active1");
		btrjzc.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/rjzc.jsp";
	})
	//注册管理
	$("#btzcgl").click(function(){
		//debugger
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btzcgl =$(parent.frames["leftFrame"].document).find("#btzcgl");
		var zcgl =$(parent.frames["leftFrame"].document).find("#zcgl");		
		zcgl.find('.sidebar-submenu').css("display","block");
		btzcgl.parent().addClass("active1");
		btzcgl.parent().siblings().removeClass("active1");
		btzcgl.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/zcgl.jsp";
	})
	//软件安装
	$("#btrjaz").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btrjaz =$(parent.frames["leftFrame"].document).find("#btrjaz");
		var zcgl =$(parent.frames["leftFrame"].document).find("#zcgl");		
		zcgl.find('.sidebar-submenu').css("display","block");
		btrjaz.parent().addClass("active1");
		btrjaz.parent().siblings().removeClass("active1");
		btrjaz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/rjaz.jsp";
	})
	//安装管理
	$("#btazjl").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btazjl =$(parent.frames["leftFrame"].document).find("#btazjl");
		var zcgl =$(parent.frames["leftFrame"].document).find("#zcgl");
		console.log(btazjl);
		console.log(btazjl.text());		
		zcgl.find('.sidebar-submenu').css("display","block");
		btazjl.parent().addClass("active1");
		btazjl.parent().siblings().removeClass("active1");
		btazjl.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		//debugger;
		window.location.href="../xschange/azjl.jsp";
		//debugger;
	})
		//工程实施
	$("#btgcss").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btgcss =$(parent.frames["leftFrame"].document).find("#btgcss");
		var gcfw =$(parent.frames["leftFrame"].document).find("#gcfw");
		console.log(btgcss);
		console.log(btgcss.text());		
		gcfw.find('.sidebar-submenu').css("display","block");
		btgcss.parent().addClass("active1");
		btgcss.parent().siblings().removeClass("active1");
		btgcss.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		//debugger;
		window.location.href="../xschange/gcss.jsp";
		//debugger;
	})
		//工程进度
	$("#btgcjd").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btgcjd =$(parent.frames["leftFrame"].document).find("#btgcjd");
		var gcfw =$(parent.frames["leftFrame"].document).find("#gcfw");
		console.log(btgcjd);
		console.log(btgcjd.text());		
		gcfw.find('.sidebar-submenu').css("display","block");
		btgcjd.parent().addClass("active1");
		btgcjd.parent().siblings().removeClass("active1");
		btgcjd.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		//debugger;
		window.location.href="../xschange/gcjd.jsp";
		//debugger;
	})
	//软件问题
	$("#btrjwt").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btrjwt =$(parent.frames["leftFrame"].document).find("#btrjwt");
		var wtfk =$(parent.frames["leftFrame"].document).find("#wtfk");	
		wtfk.find('.sidebar-submenu').css("display","block");
		btrjwt.parent().addClass("active1");
		btrjwt.parent().siblings().removeClass("active1");
		btrjwt.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/rjwt.jsp";
	})
	//用户需求
	$("#btyhxq").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btyhxq =$(parent.frames["leftFrame"].document).find("#btyhxq");
		var wtfk =$(parent.frames["leftFrame"].document).find("#wtfk");	
		wtfk.find('.sidebar-submenu').css("display","block");
		btyhxq.parent().addClass("active1");
		btyhxq.parent().siblings().removeClass("active1");
		btyhxq.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");		
		window.location.href="../xschange/yhxq.jsp";
	})
	//用户使用
	$("#btyhsy").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btyhsy =$(parent.frames["leftFrame"].document).find("#btyhsy");
		var wtfk =$(parent.frames["leftFrame"].document).find("#wtfk");	
		wtfk.find('.sidebar-submenu').css("display","block");
		btyhsy.parent().addClass("active1");
		btyhsy.parent().siblings().removeClass("active1");
		btyhsy.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/yhsy.jsp";
	})
	//工程安装
	$("#btgcaz").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btgcaz =$(parent.frames["leftFrame"].document).find("#btgcaz");
		var wtfk =$(parent.frames["leftFrame"].document).find("#wtfk");	
		wtfk.find('.sidebar-submenu').css("display","block");
		btgcaz.parent().addClass("active1");
		btgcaz.parent().siblings().removeClass("active1");
		btgcaz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/gcaz.jsp";
	})
	//密码设置
	$("#btmmsz").click(function(){
		var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
		itemDom.css('display','none');
		var btmmsz =$(parent.frames["leftFrame"].document).find("#btmmsz");
		var xtsz =$(parent.frames["leftFrame"].document).find("#xtsz");	
		//console.log(btmmsz);
		//console.log(xtsz);
		xtsz.find('.sidebar-submenu').css("display","block");
		btmmsz.parent().addClass("active1");
		btmmsz.parent().siblings().removeClass("active1");
		btmmsz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
		window.location.href="../xschange/mmsz.jsp";
	})
	//问题类型
		$("#btwtsz").click(function(){
			var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
			itemDom.css('display','none');
			var btwtsz =$(parent.frames["leftFrame"].document).find("#btwtsz");
			var xtsz =$(parent.frames["leftFrame"].document).find("#xtsz");	
			xtsz.find('.sidebar-submenu').css("display","block");
			btwtsz.parent().addClass("active1");
			btwtsz.parent().siblings().removeClass("active1");
			btwtsz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
			window.location.href="../xschange/wtlx.jsp";
		})
			//进度设置
		$("#btjdsz").click(function(){
			var itemDom =$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
			itemDom.css('display','none');
			var btjdsz =$(parent.frames["leftFrame"].document).find("#btjdsz");
			var xtsz =$(parent.frames["leftFrame"].document).find("#xtsz");	
			xtsz.find('.sidebar-submenu').css("display","block");
			btjdsz.parent().addClass("active1");
			btjdsz.parent().siblings().removeClass("active1");
			btjdsz.parent().parent().parent().parent().siblings().children().children().children().removeClass("active1");
			window.location.href="../xschange/jdsz.jsp";
		})
})

