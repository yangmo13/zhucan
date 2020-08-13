var treeTable;
function goEdit(id) {
	openWindow('修改', '#(base)/dept/goAddOrEdit?id=' + id, '400px', '200px',
			function() {
				treeTable.reload();
			});
}
function move(id, direct) {
	$.post('#(base)/dept/move', {
		id : id,
		direct : direct
	}, function(d) {
		if (d.code == 20000) {
			treeTable.reload();
		}
	}, 'json');
}
function doDel(id) {
	top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
		$.post('#(base)/dept/del', {
			id : id
		}, function(d) {
			if (d.code == 20000) {
				layui.treeGrid.reload('treeTable');
			} else if (d.code == 301) {
				top.layer.msg('请先删除下级单位后再删除该单位！');
			} else {
				top.layer.msg('删除失败：' + d.msg);
			}
		}, 'json');
		top.layer.close(index);
	});
}
function goAdd(pid) {
	openWindow('添加单位', '#(base)/dept/goAddOrEdit?pid='+pid, '400px', '200px', function() {
		treeTable.reload();
	});
}
layui.config({
	base : '#(base)/static/js/'
}).use([ 'treeGrid' ], function() {
	var treeGrid = layui.treeGrid; // 很重要
	treeTable = treeGrid.render({
		elem : '#treeTable',
		url : '#(base)/dept/findAll',
		cellMinWidth : 100,
		treeId : 'id',// 树形id字段名称
		treeUpId : 'pid',// 树形父id字段名称
		treeShowName : 'title',// 以树形式显示的字段
		toolbar : '#toolbarTpl',
		defaultToolbar : [],
		cols : [ [ 
		{type: 'numbers',title : '序号',width : 60,align : 'center'},
		{field : 'title',width : '600',title : '名称'},
		{field : 'opt',width : '150',title : '操作',align : 'center',templet : '#optTpl'}
		]],
		page : false
	});
});