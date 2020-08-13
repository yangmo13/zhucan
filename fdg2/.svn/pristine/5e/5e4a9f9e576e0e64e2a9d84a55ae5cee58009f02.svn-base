function goAdd() {
	openWindow('添加', '#(base)/dict/goAddOrEdit?pid=#(parent.id??)', '500px', '260px', submitForm);
}
function move(id, direct) {
	$.post('#(base)/dict/move', {
		id : id,
		direct : direct
	}, function(d) {
		if (d.code == 20000) {
			submitForm();
		}
	}, 'json');
}
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#dictTable',
	height : 'full-150',
	url : '#(base)/dict/find?pid=#(parent.id??)',
	method: 'post',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [ // 标题栏
	{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
	{
		field : 'title',
		title : '名称',
		align : 'center',
		width : 250
	}, {
		field : 'code',
		title : '代码',
		align : 'center',
		width : 150
	}, {
		field : 'pname',
		title : '所属字典组',
		align : 'center',
		templet : '#pnameTpl',
		width : 150
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
table.on('tool(dictTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/dict/del', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					submitForm();
				} else if (d.code == 30001) {
					top.layer.msg('请先删除子项后再删除该项！');
				} else {
					top.layer.msg('删除失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	} else if (layEvent === 'edit') {
		var url = '#(base)/dict/goAddOrEdit?id=' + data.id + "&pid=" + (data.pid?data.pid:'');
		openWindow('修改', url, '500px', '260px', submitForm);
	} else if (layEvent === 'view') {
		window.location.href='#(base)/dict?pid=' + data.id;
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('dictTable', {
		where : $('#search-form').serializeJson()
	})
}