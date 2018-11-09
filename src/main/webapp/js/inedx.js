$().ready(function(){

	$.ajax({
		type:"GET",
		url:"version/getVersion",
		async:true,
		dateType:"json",
		success:function(data){
			var version=window.document.getElementById('version');
            version.innerText=data
		},
		error:function(){
			alert('服务器错误')
		}
		
	})

	$("#loginbtn").click(function(){		
	  	$("#form").submit();
	  	
	});
	
});