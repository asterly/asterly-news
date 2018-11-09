$().ready(function(){

	/*导航栏显示与隐藏*/
	+function(){		
		var div1=$('#wtjl');                          //获得id为wtjl为div显示
		div1.css('display','block');                  //div1.style.display="block";
		var xss=$('#right .xschange');                //获得id为right下的所有class为xschange的div
		var lis=$('.sidebar-submenu li.flstyle');	  //获得所有在class为sidebar-submenu的div下的li
		for(var i=0;i<lis.length;i++){
			lis[i].onclick=toggle;
		}
		function toggle(){
			var li=this;
			for (var i=0;i<xss.length ;i++ ) {        //遍历xss中的每个xschange,清除其display属性
				$(xss[i]).css("display","none").removeClass("active1");
			}
			for(var i=0;i<lis.length;i++){            //遍历lis中每个li，和当前li比较，获得当前li的下标
				if(lis[i]==li)                        //i就是li的下标
				break;
			}
			$(xss[i]).css("display","block").addClass("active1");	//设置divs中i位置的div显示
		}
		$("#toggle-sidebar").click(function(){
			var itemDom =$(".sidebar-submenu");        //$(parent.frames["leftFrame"].document).find(".sidebar-submenu");
			if(itemDom.css('display','block')){
				itemDom.css('display','none');
				$(".flstyle").removeClass("active1");
			}else{
			}
		})
		/*$("#xtsz").click(function(){
			debugger;
			this.css("border-bottom","none");
		})*/
	}();
	
});
