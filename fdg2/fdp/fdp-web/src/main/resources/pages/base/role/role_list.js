function goAdd() {
	openWindow('添加角色', '#(base)/role/goAddOrEdit', '400px', '200px', function() {
		layui.table.reload('roleTable');
	});
}
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#roleTable',
	height : 'full-50',
	url : '#(base)/role/findAll',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [ // 标题栏
	{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
	{
		field : 'code',
		title : '角色标识',
		align : 'center',
		width : 150
	}, {
		field : 'name',
		title : '角色名称',
		align : 'center',
		width : 250
	}, {
		field : 'editable',
		title : '可编辑',
		align : 'center',
		templet : #widget("global.yesno",name="editable",type="render"),
		width : 80
	}, {
		field : 'deletable',
		title : '可删除',
		align : 'center',
		templet : #widget("global.yesno",name="deletable",type="render"),
		width : 80
	}, {
		field : 'createTime',
		title : '创建时间',
		align : 'center',
		hide : true,
		width : 160
	}, {
		field : 'updateTime',
		title : '更新时间',
		align : 'center',
		hide : true,
		width : 160
	}, {
		field : 'opt',
		title : '操作',
		align : 'center',
		width : 120,
		templet : '#optTpl'
	} ] ],
	even : true,
	page : true
});
table.on('tool(roleTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/role/del', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					layui.table.reload('roleTable');
				} else {
					top.layer.msg('删除失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	} else if (layEvent === 'edit') {
		openWindow('修改角色', '#(base)/role/goAddOrEdit?id=' + data.id, '400px','200px', function() {
			layui.table.reload('roleTable');
		});
	} else if (layEvent === 'func_auth') {
		openWindow('设置功能权限', '#(base)/role/goSetFuncAuth?roleId=' + data.id, '800px', '600px');
	} else if (layEvent === 'data_auth') {
		openWindow('设置数据权限', '#(base)/role/goSetDataAuth?roleId=' + data.id, '800px', '600px');
	}
});