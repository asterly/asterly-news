$().ready(function(){
	
	//验证表单用户和密码
	$("#loginbtn").click(function(){	
		var name=$("#username").val();
		var pwd=$("#password").val();
		if(name==""){
			$("#name").css("border-color", "red");
			return false;
		}
		if(pwd==""){
			$.alert("密码不能为空");
			$("#password").css("border-color", "red");
			return false;
		}
		reg = /^\d{6}$/;
		if(!reg.test($("#password").val())){
			alert()
			$.alert("密码为六位数字");
			$("#passord").css("border-color", "red");
			return false;
		}
	  	$("#form").submit();
	});
	
});