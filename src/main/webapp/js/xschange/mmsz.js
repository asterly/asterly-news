/**
 * 
 */
$(function(){
	alert("lalal")
	/**
	 * 对表单进行验证
	 */
	$("#form").bootstrapValidator({
		feedbackIcons:{
			valid:'glyphicon glyphicon-ok',
			invalid:'glyphicon glyphicon-remove',
			validating:'glyphicon glyphicon-refresh'
		},
		fields:{
			opwd:{
				message: '旧密码不能为空',
				validators: {
                    notEmpty: {
                        message: '旧密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 6,
                        message: '密码长度为6位'
                    },
                    regexp: {
                        regexp: /[0-9]/,
                        message: '密码id只能是数字'
                    }
                }
				
			},
			npwd:{
				message: '旧密码不能为空',
				validators: {
                    notEmpty: {
                        message: '旧密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 6,
                        message: '密码长度为6位'
                    },
                    regexp: {
                        regexp: /[0-9]/,
                        message: '密码id只能是数字'
                    }
                }
				
			},
			zpwd:{
				message: '确认密码不能为空',
				validators: {
                    notEmpty: {
                        message: '确认密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 6,
                        message: '密码长度为6位'
                    },
                    identical: {//相同
    			        field: 'npwd', //需要进行比较的input name值
    			        message: '两次密码不一致'
    			    },
                    regexp: {
                        regexp: /[0-9]/,
                        message: '密码只能是数字'
                    }
                }
			}
			
		}
	});
	
	

	//确定按钮绑定事件
	$("#ybtn").click(function(){
		
		var uname=$(parent.frames["topFrame"].document).find("#uname").text();//登录人
		
		var npwd=$("#npwd").val();//新密码
		
		layer.confirm('你确定要修改你当前的密码吗？', {
			  btn: ['确定','算了吧'] //按钮
			}, function(){
				$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded",
					url : "user/",
					dataType : "json",
					cache : false,
					data : {			
						"uname" : uname,
						"opwd" : opwd,
					},
					success : function(response) {
						layer.alert("提交表单")
						
					},
					error : function(response) {

						layer.alert("密码修改失败！！！");
					}
				});	

//				test();
//			  layer.msg('的确很重要', {icon: 1});
			}, function(){
				
			  layer.msg('你选择了取消修改密码', {
			    time: 20000, //20s后自动关闭
			    
			  });
			});
		})
		function test(){
		
			$.ajax({
					type : "post",
					contentType : "application/x-www-form-urlencoded",
					url : "user/",
					dataType : "json",
					cache : false,
					data : {			
						"uname" : uname,
						"opwd" : opwd,
					},
					success : function(response) {
						layer.alert("提交表单")
						
					},
					error : function(response) {

						layer.alert("密码修改失败！！！");
					}
				});	
	}
		
		$("#nbtn").click(function(){
			//debugger;
			window.location.href="mmsz.jsp";
		})
})