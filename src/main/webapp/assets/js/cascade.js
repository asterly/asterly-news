		var json = [
				{
					id:100,
					name:'铁路',
					professional:['信号','通信','...']
				},
				{
					id:101,
					name:'...',
					professional:['xinhao','tongxin','...','...']
				}
			];
		//1.将json的数据初始状态显示在selector
		/*
			①将所有的hy初始化 
			②将河北的zy显示在 
		*/
		function init(){
			//①将所有的省初始化prov
			for(var i=0;i<json.length;i++){
				var industry = json[i].name;
				//创建option
				var op = $('<option>'+industry+'</option>');
				$('select[name=hy]').append(op);
			}
			//②将河北的市显示在city
			var professional = json[0].professional;
			for(var j=0;j<professional.length;j++){
				var opj = $('<option>'+professional[j]+'</option>');
				$('select[name=zy]').append(opj);
			}
		}
		//文档加载完毕之后运行
		$(function(){
			init();
			//对prov下拉列表添加onchange事件
			$('select[name=hy]').change(chg);
		})
		//onchange事件的函数
		function chg(){
			//清空当前city下拉列表
			$('select[name=zy]').empty();
			//先获得选项的下标---json中省份下标
			var index = $('select[name=hy]').get(0).selectedIndex;
			console.log(index);
			var professional = json[index].professional;
			//将cities添加在select：city
			for(var i=0;i<professional.length;i++){
				var op = $('<option>'+professional[i]+'</option>');
				$('select[name=zy]').append(op);
			}
		} 