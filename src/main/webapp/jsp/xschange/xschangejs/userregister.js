$(function(){
//	表单确认
		$("#btn-submit").click(function(){
			layer.confirm('确定提交吗！', {icon: 3, title:'提示'}, function(index){
				  
				  layer.msg("开始提交数据");
				});
			layer.alert("确定提交吗！")
		})
		
//		表单不为空验证
		$("form").bootstrapValidator({
			feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
			},
	        fields: {
	        	userid: {
	                message: '用户ID不能为空',
	                validators: {
	                    notEmpty: {
	                        message: '用户ID不能为空'
	                    },
                        stringLength: {
                            min: 4,
                            max: 10,
                            message: '用户id长度必须在4到10位之间'
                        },
                        regexp: {
                            regexp: /[0-9]/,
                            message: '用户id只能是数字'
                        }
	                }
	        	},
	        	username: {
	                validators: {
	                    notEmpty: {
	                        message: '用户id不为空'
	                    }
	                },
                    stringLength: {
                        min: 5,
                        max: 60,
                        message: '用户名长度必须在5到60位之间'
                    },
                    regexp: {
                        regexp:  /^[0-9a-zA-Z]*$/,
                        message: '用户名只能为数字下划线和字母组成'
                    }
	            },
//	            email: {
//	                validators: {
//	                    notEmpty: {
//	                        message: '邮箱地址不能为空'
//	                    }
//	                },
//                    stringLength: {
//                        min: 5,
//                        max: 60,
//                        message: '邮箱长度必须在5到60位之间'
//                    },
//                    threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
//                    remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
//                        url: 'user/validEmail',//验证地址
//                        message: '邮件已存在',//提示消息
//                        delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
//                        type: 'POST'//请求方式
//                    },
//                    regexp: {
//                        regexp: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"/,
//                        message: '邮箱地址不正确'
//                    }
//	            },
//	            tel: {
//	                validators: {
//	                    notEmpty: {
//	                        message: '电话号码不能为空'
//	                    },
//                        stringLength: {
//                            min: 11,
//                            max: 16,
//                            message: '电话号码在11-16位之间'
//                        },
//                        threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
//                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
//                            url: 'user/validTel',//验证地址
//                            message: '用户已存在',//提示消息
//                            delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
//                            type: 'POST'//请求方式
//                        },
//                        regexp: {
//                            regexp: /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/,
//                            message: '电话号码格式错误'
//                        }
//	                }
//	            },
	        	password: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },
                        stringLength: {
                            min: 6,
                            max: 6,
                            message: '智能为六位数密码'
                        },
                        regexp: {
                            regexp: /^\d{6}$/,
                            message: '用户名只能包含大写、小写、数字和下划线'
                        }
	                }
	            }
	        }
	    });
		
		$.ajax({
			type:"GET",
			url:"user/queryAll",
			dataType:"json",
			async:true,
			succes:function(data){
				layer.alert(data)
			},
			error:function(){
				layer.alert("服务器错误")
			}
		})

})