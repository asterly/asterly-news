$().ready(function(){
	
	//表格导出
	$('#btnExport').click(function(){
		exportToExcel('tableid','实施进度','实施进度表');
		var c=document.getElementById("dlink");//此处是对表格导出方法中，append（标签的判断），如果存在，则进行移除，
		if(c!=null){
			c=	c.remove();
		}
	});
})