$().ready(function() {
	$("#unit").click(function() {
		var unit = $("#unit option:selected").val();
		if (unit == "超级管理员") {
			document.getElementById("name").value = "admin";
		} else {
			document.getElementById("name").value = "";
		}
	})
	$("body").keydown(function(event) {
		if(event.keyCode == "13") { //keyCode=13是回车键
				loginame();
		}
	});
	$("#ukloginbtn").click(function(){
		localStorage.setItem(name, "uk");
		localStorage.name = "uk";
		localStorage;
		window.location.href="jsp/main1.jsp";
	})
	$("#loginbtn").click(function(){
		loginame();
	})
	function loginame() {
		var operator1 = "登录";
		var name = $("#name").val();
		var pwd = $("#pwd").val();
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded",
				url : "/swsrv/queryDataAll/queryDataServlet",
				dataType : "json",
				cache : false,
				data : {
					"operator1" : operator1,
					"name" : name,
					"pwd" : pwd
				},
				success : function(response) {
					tlj = response[0];
					console.log(tlj);
					reg = /^\d{6}$/;
					if (tlj == "用户名不正确") {
						$.alert("此用户没有注册！");
						$("#name").css("border-color", "red");
						return false;
					}else if (!reg.test($("#pwd").val())) {
						$.alert("密码格式不正确，请输入6位数字!");
						$("#pwd").css("border-color", "red");
						return false;
					}else if (tlj == "密码不正确") {
						$.alert("密码填写有误！");
						$("#pwd").css("border-color", "red");
						return false;
					} else {
						name+=","+tlj[5];
						localStorage.setItem(name, name);
						localStorage.name = name;
						localStorage;
						if(tlj[2]=="admin"){
							var url="qx="+tlj[4]+",超级管理员"+tlj[5]; 
						}else{
							var url="qx="+tlj[4]+tlj[5]; 
						}
						console.log(url);
						url=encodeURI(url); //用了2次encodeURI 
						window.location.href = "jsp/main.jsp?"+url;
					}
				},
				error : function(response) {
					$.alert("登录失败！！！", "提示");
				}
			});
		}
	//};

});