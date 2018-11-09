
$().ready(function(){
	var ce=$(parent.frames["topFrame"].document).find("#editYesOrNo").text();
	if(ce=="不可编辑"){
		//document.getElementById('selectadd').disabled=true;
		//document.getElementById('update').disabled=true;
		document.getElementById('wtlxde').disabled=true;
	}
	$('#wtlxde').click(function(){
		
		var id = new Array();
		var count = 0;
		$('table input').each(function(){
			if($(this).prop("checked")==true){
				id.push($(this).attr("guid"));
				count++;
				console.log(this);
				//alert($(this).attr("guid"));
			}
		});
		if(count==0){
			$.alert("请至少选择一条记录删除");
			return false;
		}
		var pguid=id.toString();
		var operator1="问题类型删除";
		$.confirm({
			title:'选择操作',
			content: '确定要删除这些数据？',
			buttons: {
		        确定: {
		        	btnClass : 'btn-blue',
					action : function() {
						$.ajax({
					        type : "post", 
					        contentType: "application/x-www-form-urlencoded",
					        url : "/swsrv/queryDataAll/queryDataServlet", 
					        dataType : "json",   
					        cache: false,
					        data :
					        {
					        	"pguid":pguid,
					        	"operator1":operator1
					        },
					        success : function(result)
					        {
					        	tlj = result;	
								var a = document.getElementById('tbody2');
								var TabJsonResult = "";
								if(tlj==""){
									a.innerHTML = TabJsonResult;
								}else{
									for (var i = 1; i < tlj[0].length; i++) {
										
										for (var j = 0; j < tlj.length; j++) {
											if(j==0){
												TabJsonResult += "<tr  id=\""+tlj[0][i]+"\"><td id=\"state\" ><input type=\"checkbox\" guid='" + tlj[0][i] + "' id =\"checkchoose\"/></td>"; //tr
											}else{
												TabJsonResult += "<td>" + tlj[j][i] + "</td>";
											}
										}
										TabJsonResult += "</tr>"; 
									}
									a.innerHTML = TabJsonResult;
								}
					        },
					        error : function(result)
					        {	
					        	
					        	$.alert("删除失败！！！","提示");
					        }
					    });
						
					}
				},
		        取消: function () {
		            
		        }
		 }
		});
		
		
	});
	
	$("#nwbtn").click(function(){
		window.location.href="wtlx.jsp";
	});

	//全选删除
			$("#checkall").prop("checked",false);
			$("#checkall").click(function(){
				var id=new Array();
				if($("#checkall").prop("checked")==true){
					$("input:checkbox").each(function(){
						$(this).prop("checked",true);
					});
				}
				if($("#checkall").prop("checked")==false){
					$("input:checkbox").each(function(){
						$(this).prop("checked",false);
					});
				}
			});
			$("input:checkbox").each(function(){
				$(this).click(function(){
					if($(this).prop("checked")==false){
						$("#checkall").prop("checked",false);
					}
				});
			});
			
})