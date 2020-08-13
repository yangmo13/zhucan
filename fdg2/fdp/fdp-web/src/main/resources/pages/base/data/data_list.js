function goAdd() {
	openWindow('添加', '#(base)/data/goAddOrEdit', '500px', '260px', submitForm);
}
var table = layui.table;
// 展示已知数据
table.render({
	elem : '#dataTable',
	height : 'full-150',
	url : '#(base)/data/find',
	method: 'post',
	toolbar : '#toolbarTpl',
	defaultToolbar : [],
	cols : [ [ // 标题栏
	{type: 'numbers',title : '序号',width : 60,align : 'center'}, 
	{
		field : 'name',
		title : '名称',
		align : 'center',
		width : 250
	}, {
		field : 'code',
		title : '标识',
		align : 'center',
		width : 150
	}, {
		field : 'enableAuth',
		title : '是否启用数据权限',
		align : 'center',
		templet : #widget("global.yesno",name="enableAuth",type="render"),
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
table.on('tool(dataTable)', function(obj) {
	var data = obj.data; // 获得当前行数据
	var layEvent = obj.event;
	if (layEvent === 'del') { // 删除
		top.layer.confirm('确定删除您所选择的数据吗?', function(index) {
			$.post('#(base)/data/del', {
				id : data.id
			}, function(d) {
				if (d.code == 20000) {
					submitForm();
				} else {
					top.layer.msg('删除失败！');
				}
			}, 'json');
			top.layer.close(index);
		});
	} else if (layEvent === 'edit') {
		openWindow('修改', '#(base)/data/goAddOrEdit?id=' + data.id, '500px', '260px', submitForm);
	}
});
var form = layui.form;
form.render('select');
function submitForm() {
	table.reload('dataTable', {
		where : $('#search-form').serializeJson()
	})
}