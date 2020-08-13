var treeTable;
function goEdit(id) {
	openWindow('修改菜单', '#(base)/menu/goAddOrEdit?id=' + id, '800px', '600px',
			function() {
				treeTable.reload();
			});
}
function goView(id) {
	openWindow('查看菜单', '#(base)/menu/goView?id=' + id, '800px', '600px');
}
function move(id, direct) {
	$.post('#(base)/menu/move', {
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
		$.post('#(base)/menu/del', {
			id : id
		}, function(d) {
			if (d.code == 20000) {
				layui.treeGrid.reload('treeTable');
			} else if (d.code == 30001) {
				top.layer.msg('请先删除子菜单后再删除该菜单！');
			} else {
				top.layer.msg('删除失败！');
			}
		}, 'json');
		top.layer.close(index);
	});
}
function goAdd() {
	openWindow('添加菜单', '#(base)/menu/goAddOrEdit', '800px', '600px', function() {
		treeTable.reload();
	});
}
layui.config({
	base : '#(base)/static/js/'
}).use([ 'treeGrid' ], function() {
	var treeGrid = layui.treeGrid; // 很重要
	treeTable = treeGrid.render({
		elem : '#treeTable',
		url : '#(base)/menu/findAll',
		cellMinWidth : 100,
		treeId : 'id',// 树形id字段名称
		treeUpId : 'pid',// 树形父id字段名称
		treeShowName : 'title',// 以树形式显示的字段
		toolbar : '#toolbarTpl',
		defaultToolbar : [],
		cols : [ [ 
		{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
		{
			field : 'icon',
			width : '80',
			title : '图标',
			align : 'center',
			templet : '#iconTpl'
		}, {
			field : 'title',
			width : '400',
			title : '菜单名称'
		}, {
			field : 'path',
			width : '100',
			title : '路径'
		}, {
			field : 'opt',
			width : '100',
			title : '操作',
			align : 'center',
			templet : '#optTpl'
		} ] ],
		page : false
	});
});