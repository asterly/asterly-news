jQuery(function($) {

	$(".sidebar-dropdown > a").click(function() {
		$(".sidebar-submenu").slideUp(250);
		if ($(this).parent().hasClass("active")) {
			$(".sidebar-dropdown").removeClass("active");
			//$(this).css("border-top","1px solid #fff");
			$(this).parent().removeClass("active");
			$("#btzcgl").removeClass("active1");
			$("#btazjl").removeClass("active1");
			$("#wtfkchild").removeClass("active1");
		} else {
			$(".sidebar-dropdown").removeClass("active");
			//$(this).css("border-top","none");
			$(this).next(".sidebar-submenu").slideDown(250);
			$(this).parent().addClass("active");
		}

	});
	$(".sidebar-submenu li.flstyle").click(function(){
	if($(this).css("color","#ccc")){
		$(this).addClass("active1").siblings().removeClass("active1");
		$(this).parent().parent().parent().siblings().children().children().children().removeClass("active1");
		$("#btazjl").removeClass("active1");
		$("#btzcgl").removeClass("active1");
		$("#wtfkchild").removeClass("active1");
	}else{
		$(this).removeClass('active1').siblings().removeClass('active1')
		$(this).parent().parent().parent().siblings().children().children().children().removeClass("active1")
	}
	
})

	$("#toggle-sidebar").click(function() {
		$(".page-wrapper").toggleClass("toggled");
		$("#btazjl").removeClass("active1");
		$("#btzcgl").removeClass("active1");
		$("#wtfkchild").removeClass("active1");
	});

	$("#content-wrapper").click(function() {
		$(".page-wrapper").toggleClass("toggled", false);
		 
	});
	
	if (!/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
		$(".sidebar-content").mCustomScrollbar({
			axis : "y",
			autoHideScrollbar : true,
			scrollInertia : 300
		});
		$(".sidebar-content").addClass("desktop");
		$(".page-wrapper").toggleClass("toggled");
	}


	$("#btzcgl").click(function(){
		$(this).addClass("active1");
		$(".sidebar-submenu li.flstyle").removeClass("active1");
		$("#btazjl").removeClass("active1");
		$("#wtfkchild").removeClass("active1");
		$(".sidebar-submenu").slideUp(250);
		$(".sidebar-dropdown").removeClass("active");
	})
	$("#btazjl").click(function(){
		$(this).addClass("active1");
		$(".sidebar-submenu li.flstyle").removeClass("active1");
		$("#btzcgl").removeClass("active1");
		$("#wtfkchild").removeClass("active1");
		$(".sidebar-submenu").slideUp(250);
		$(".sidebar-dropdown").removeClass("active");
	})
	$("#wtfkchild").click(function(){
		$(this).addClass("active1");
		$(".sidebar-submenu li.flstyle").removeClass("active1");
		$("#btazjl").removeClass("active1");
		$("#btzcgl").removeClass("active1");
	})
});