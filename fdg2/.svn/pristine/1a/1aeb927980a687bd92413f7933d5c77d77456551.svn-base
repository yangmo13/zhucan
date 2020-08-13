$.post('#(base)/menu/findById', {
	id : '#(menu.pid)'
}, function(data) {
	if (data.code == 20000 && data.data) {
		$('#parentName').text(data.data.title);
	} else {
		$('#parentName').text('无');
	}
}, 'json');
var functiondatas = [];
#for(item : functions)
functiondatas.push({
	name : '#(item.name)',
	permission : '#(item.permission)'
});
#end
layui.use('table', function() {
	var table = layui.table;
	table.render({
		elem : '#functionTable',
		height : 'full-230',
		limit : 1000,
		cols : [ [ // 标题栏
		{
			field : 'SEQ',
			title : '序号',
			width : 80,
			align : 'center',
			templet : '#indexTpl'
		}, {
			field : 'name',
			title : '功能名称',
			align : 'center',
			width : 250
		}, {
			field : 'permission',
			title : '权限路径',
			align : 'center',
			width : 250
		} ] ],
		data : functiondatas,
		even : true
	});
});